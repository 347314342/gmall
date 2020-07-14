package com.huki.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huki.gmall.bean.*;
import com.huki.gmall.manage.mapper.PmsProductInfoMapper;
import com.huki.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.huki.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.huki.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    com.huki.gmall.manage.mapper.pmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;



    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {

        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> pmsProductImages = pmsProductImageMapper.select(pmsProductImage);
        return pmsProductImages;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        //获取属性
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
        //获取熟悉值
        for (PmsProductSaleAttr productSaleAttr : pmsProductSaleAttrs)
        {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());// 销售属性id用的是系统的字典表中id，不是销售属性表的主键
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }



        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String skuid) {
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectSpuSaleAttrListCheckBySku(productId,skuid);
        return pmsProductSaleAttrs;
    }


    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {

        //保存属性
        pmsProductInfoMapper.insertSelective(pmsProductInfo);//insert和insertSelective的区别是前者可以将null值也插入数据库
        //生成商品主键
        String ProductId = pmsProductInfo.getId();
        //保存属性值
        List<PmsProductSaleAttr> pmsProductSaleAttrList =pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrList)
        {
            pmsProductSaleAttr.setProductId(ProductId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for(PmsProductSaleAttrValue pmsProductSaleAttrValue:pmsProductSaleAttrValueList)
            {
                pmsProductSaleAttrValue.setProductId(ProductId);
                pmsProductSaleAttrValue.setSaleAttrId(pmsProductSaleAttr.getSaleAttrId());
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }

        }

        //保存图片
        List<PmsProductImage> pmsProductImageList =pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : pmsProductImageList)
        {
            pmsProductImage.setProductId(ProductId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }
    }




}
