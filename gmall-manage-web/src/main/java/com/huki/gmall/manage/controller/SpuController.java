package com.huki.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.huki.gmall.bean.PmsProductImage;
import com.huki.gmall.bean.PmsProductInfo;
import com.huki.gmall.bean.PmsProductSaleAttr;
import com.huki.gmall.manage.util.PmsUploadUtil;
import com.huki.gmall.service.SpuService;
import org.csource.common.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }


    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId){

        List<PmsProductImage> pmsProductImages = spuService.spuImageList(spuId);
        return pmsProductImages;
    }


    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){

        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }


    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public List<PmsProductInfo> saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);

        return null;
    }




    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException, MyException {



        //将图片的存储路径返回(PmsUploadUtil是上传到服务器的工具类)
        String ImgUrl= PmsUploadUtil.uploadImage(multipartFile);
        return ImgUrl;
    }

}
