package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.UploadUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("add")
    public @ResponseBody Map<String,Object> add(Chapter chapter,String album_id,MultipartFile downPath1, HttpServletRequest request){
        Map<String, Object> map= new HashMap<>();
        if(downPath1==null){
            map.put("success",false);
            return map;
        }else{
            //上传文件路径
            try{
                String path = request.getRealPath("/voice");
                //上传文件名
                String filename =downPath1.getOriginalFilename();
                File filepath = new File(path,filename);
                //将上传文件保存到一个目标文件当中
                downPath1.transferTo(new File(path,filename));
                chapter.setAlbum_id(album_id);
                chapter.setDownPath(filename);
                chapter.setSize((float)downPath1.getSize()/1024/1024+"mb");
                chapter.setDuration(UploadUtils.getAudioLength(path+"/"+ filename)/60+"分"+UploadUtils.getAudioLength(path+"/"+ filename)%60+"秒");
                chapterService.save(chapter);
                map.put("success",true);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        map.put("success",false);
        return map;
    }

    @RequestMapping("/download")
    public @ResponseBody void download(String fileName,String openStyle,HttpServletRequest request,HttpServletResponse response) throws Exception{
        UploadUtils.download("/voice/",fileName,openStyle,request,response);
    }


}
