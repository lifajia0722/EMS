package com.baizhi.util;

import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class UploadUtils {
    //上传
    public static String uploading(HttpServletRequest request,MultipartFile File,String FileName){
        try {
            String file = File.getOriginalFilename();
            String realPath = request.getRealPath(FileName);
            File.transferTo(new File(realPath,File.getOriginalFilename()));
            return FileName+file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //删除
    public static Boolean delete(HttpServletRequest request,String fileName){
        try {
            String realPath = request.getSession().getServletContext().getRealPath(fileName);
            new File(realPath).delete();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
   //音频时长
    public static int getAudioLength(String audioPath) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        File file=new File(audioPath);
        int s=0;
        MP3File f = (MP3File)AudioFileIO.read(file);
        MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
        s =audioHeader.getTrackLength();
        return s;
    }


    //文件大小
    public static String AudioSize(String filename,HttpServletRequest request) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        String realPath = request.getSession().getServletContext().getRealPath(filename);
        File file = new File(realPath);
        long size = file.length();
        long l = size / 1024 ;
        Double aDouble = Double.valueOf(l);
        Double size1 = aDouble/1024;
        Double dou = (double)Math.round(size1*100)/100;
        return dou+"MB";
    }
    //下载
    public static void download(String file,String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws Exception{
        FileInputStream is=null;
        ServletOutputStream os=null;
        try {
            //1.根据接收的文件名去服务中指定目录读取文件
            String realPath = request.getSession().getServletContext().getRealPath(file);
            //2.以文件输入流读取文件
            is = new FileInputStream(new File(realPath,fileName));
            //2.1 设置响应头
            response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
            //3.获取响应输出流
            os = response.getOutputStream();
            //4.使用IOUtils工具类
            IOUtils.copy(is, os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.关流
            IOUtils.closeQuietly(is);//安静关流
            IOUtils.closeQuietly(os);
        }



    }

}
