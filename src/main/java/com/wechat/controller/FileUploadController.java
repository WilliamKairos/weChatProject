package com.wechat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.util.AliOSSUtil;
import com.wechat.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    private AliOSSUtil aliOSSUtil;

    public FileUploadController(AliOSSUtil aliOSSUtil) {
        this.aliOSSUtil = aliOSSUtil;
    }

    @PostMapping("/upload")
    public Result handleFileUpload(@RequestParam("file") List<MultipartFile> files){
        try {
            System.out.println(files);

            if (files != null) {
                List<String> filePaths = new ArrayList<>();
                for (MultipartFile file : files){
    //                String originalFilename = file.getOriginalFilename();
                    String url = aliOSSUtil.upload(file);
                    filePaths.add(url);
                    System.out.println(url);
                }
                ObjectMapper objectMapper = new ObjectMapper();
                String applicationMaterial = objectMapper.writeValueAsString(Map.of("filePaths", filePaths));
                return Result.success(applicationMaterial);
            } else {
                return Result.error("文件为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("上传失败！");

        }
    }
}
