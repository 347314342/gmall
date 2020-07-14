package com.huki.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {

        //配置fdfs全局连接地址
        String file = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getFile();
        ClientGlobal.init(file);
        TrackerClient trackerClient=new TrackerClient();
        //获得一个TrackerServer实例
        TrackerServer trackerServer=trackerClient.getConnection();
        //通过tracker获得storage链接客户端
        StorageClient storageClient=new StorageClient(trackerServer,null);
        String orginalFilename="C://Users//Administrator//Desktop//winteriscoming.jpg";
        String[] uploadInfos = storageClient.upload_file(orginalFilename, "jpg", null);
        StringBuilder url= new StringBuilder("http://192.168.1.4");
        for (String uploadInfo :uploadInfos) {

            url.append(uploadInfo);
        }

    }

}
