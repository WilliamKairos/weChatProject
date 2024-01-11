package com.wechat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.wechat.util.AliOSSUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServiceImpl {

    private AliOSSUtil aliOSSUtil;

    public List<String> uploadFiles(List<MultipartFile> files) throws IOException {
        List<String> filePaths = new ArrayList<>();
        for (MultipartFile file : files) {
            String url = aliOSSUtil.upload(file);
            filePaths.add(url);
        }
        return filePaths;
    }
}
