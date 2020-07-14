package com.huki.gmall.service;

import com.huki.gmall.bean.PmsBaseAttrInfo;
import com.huki.gmall.bean.PmsBaseAttrValue;
import com.huki.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
    void saveAttrValue(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
