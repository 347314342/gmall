package com.huki.gmall.bean;

import java.io.Serializable;
import java.util.List;


//通过dubbo传递的类都要序列化
public class PmsSearchParam implements Serializable{

    private String catalog3Id;

    private String keyword;

    private String[] valueId;

    private List<PmsSkuAttrValue> pmsSkuAttrValueList;

    public List<PmsSkuAttrValue> getPmsSkuAttrValueList() {
        return pmsSkuAttrValueList;
    }

    public void setPmsSkuAttrValueList(List<PmsSkuAttrValue> pmsSkuAttrValueList) {
        this.pmsSkuAttrValueList = pmsSkuAttrValueList;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String[] getValueId() {
        return valueId;
    }

    public void setValueId(String[] valueId) {
        this.valueId = valueId;
    }
}
