package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.util.UploadUtils;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @RequestMapping("/findPage")
    public @ResponseBody Map<String,Object> findPage(Integer page,Integer rows){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Banner> byPage = bannerService.findByPage(page, rows);
        Long total = bannerService.findTotals();
        map.put("total",total);
        map.put("rows",byPage);
        return map;
    }

    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> update(HttpServletRequest request,String id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Banner banner1 = bannerService.queryOne(id);
            UploadUtils.delete(request,banner1.getImgPath());
            bannerService.delete(id);
            map.put("success",true);
        } catch (Exception e) {
            map.put("success",false);
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(HttpServletRequest request,Banner banner,MultipartFile imgPath1){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            String fileName = UploadUtils.uploading(request,imgPath1, "/images/banner/");
            banner.setImgPath(fileName);
            bannerService.save(banner);
            map.put("success",true);
              //获取文件名
//            String imgPathName = imgPath1.getOriginalFilename();
             //把文件路径存入数据库
//            banner.setImgPath("/images/"+imgPathName);
              //获取绝对路径
//            String realPath = request.getRealPath("/images");
             //上传文件到相应的文件夹中
//            imgPath1.transferTo(new File(realPath,imgPath1.getOriginalFilename()));
        } catch (Exception e) {
            map.put("success",false);
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("update")
    public @ResponseBody Map<String,Object> update(Banner banner,MultipartFile imgPath1,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Banner banner1 = bannerService.queryOne(banner.getId());
            UploadUtils.delete(request,banner1.getImgPath());

            String uploading = UploadUtils.uploading(request,imgPath1, "/images/banner/");
            banner.setImgPath(uploading);
            bannerService.update(banner);
            map.put("success",true);
//            Banner banner1 = bannerService.queryOne(banner.getId());
//            System.out.println(!banner1.getImgPath().equals(banner.getImgPath()));
//            if(banner1.getImgPath().equals(banner.getImgPath())){
//                String realPath = request.getSession().getServletContext().getRealPath(banner.getImgPath());
//                new File(realPath).delete();
//                //获取文件名
//                String imgPathName = imgPath1.getOriginalFilename();
//                //把文件路径存入数据库
//                banner.setImgPath("/images/"+imgPathName);
//                //获取绝对路径
//                String realPath1= request.getRealPath("/images");
//                //上传文件到相应的文件夹中
//                imgPath1.transferTo(new File(realPath1,imgPath1.getOriginalFilename()));
//            }



        } catch (Exception e) {
            map.put("success",false);
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Banner  findOne(String id){
        Banner banner = bannerService.queryOne(id);
        return banner;
    }
}
