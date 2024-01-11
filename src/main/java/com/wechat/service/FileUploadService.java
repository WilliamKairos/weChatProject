package com.wechat.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {
    public List<String> uploadFiles(List<MultipartFile> files);
}
