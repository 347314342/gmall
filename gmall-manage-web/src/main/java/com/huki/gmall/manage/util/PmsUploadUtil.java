package com.huki.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile) throws IOException, MyException {
        String ImgUrl = "http://192.168.1.4";

        //上传图片到服务器

        //配置fdfs全局连接地址
        String file = PmsUploadUtil.class.getResource("/tracker.conf").getFile();
        ClientGlobal.init(file);
        TrackerClient trackerClient=new TrackerClient();
        //获得一个TrackerServer实例
        TrackerServer trackerServer=trackerClient.getConnection();
        //通过tracker获得storage链接客户端
        StorageClient storageClient=new StorageClient(trackerServer,null);

        byte[] bytes= multipartFile.getBytes();

        String orginalFilename=multipartFile.getOriginalFilename();
        int i = orginalFilename.lastIndexOf(".");
        String extname= orginalFilename.substring(i+1);

        String[] uploadInfos = storageClient.upload_file(bytes, extname, null);

        for (String uploadInfo :uploadInfos) {
            ImgUrl += "/"+uploadInfo;

        }
        return ImgUrl;
    }
}
