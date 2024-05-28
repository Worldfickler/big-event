package com.example.bigevent.controller;

import com.example.bigevent.pojo.Result;
import com.example.bigevent.utils.QiNiuOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //保证文件的名字是唯一的,从而防止文件覆盖
        String filename = "news/" + UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\files\\"+filename));
        String url = QiNiuOssUtil.uploadFile(file.getBytes(), filename);
        return Result.success(url);
    }
}
