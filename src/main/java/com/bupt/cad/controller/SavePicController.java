package com.bupt.cad.controller;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SavePicController {


    @RequestMapping(value = "/uploadPic")
    public Map<String, String> uploadPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(file);
        System.out.println(file.getOriginalFilename());
        Map<String,String> map = new HashMap<String, String>();
        if(savePic(file.getInputStream(),file.getOriginalFilename())!=null){
            map.put("image","/static/"+file.getOriginalFilename());
        }

        return map;
    }
    private String savePic(InputStream inputStream, String fileName) {

        OutputStream os = null;
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        path = path+"static/";
        System.out.println(path);
        File tempFile = new File(path);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        try {
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            os = new FileOutputStream(tempFile.getPath()+File.separator+fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
//            return RealPath;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tempFile.getPath();
    }
}

