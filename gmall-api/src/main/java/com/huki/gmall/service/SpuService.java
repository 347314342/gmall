package com.huki.gmall.service;

import com.huki.gmall.bean.PmsProductImage;
import com.huki.gmall.bean.PmsProductInfo;
import com.huki.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);


    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String skuid);
}
