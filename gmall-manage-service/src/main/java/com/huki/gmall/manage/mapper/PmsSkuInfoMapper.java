package com.huki.gmall.manage.mapper;

import com.huki.gmall.bean.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo>{


    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(String productId);
}
