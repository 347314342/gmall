package com.huki.gmall.searchweb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.huki.gmall.bean.PmsBaseAttrInfo;
import com.huki.gmall.bean.PmsSearchParam;
import com.huki.gmall.bean.PmsSearchSkuInfo;
import com.huki.gmall.bean.PmsSkuAttrValue;
import com.huki.gmall.service.AttrService;
import com.huki.gmall.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SearchController {

    @Reference
    SearchService searchService;

    @Reference
    AttrService attrService;

    @RequestMapping("list.html")
    public String list(PmsSearchParam pmsSearchParam, ModelMap modelMap){


        //调用搜索服务返回搜索结果
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = searchService.list(pmsSearchParam);
        modelMap.put("skuLsInfoList",pmsSearchSkuInfos);


        Set<String> valueIdSet = new HashSet<>();

        //抽取结果中的平台属性集合
        for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfos) {
            List<PmsSkuAttrValue> pmsSkuAttrValues = pmsSearchSkuInfo.getSkuAttrValueList();
            for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValues) {
                String valueId= pmsSkuAttrValue.getValueId();
                valueIdSet.add(valueId);
            }
        }
        //根据属性值的id查询出属性值集合
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.getAttrValueListByValueId(valueIdSet);
        modelMap.put("attrList",pmsBaseAttrInfos);


        return "list";
    }

    @RequestMapping("getUrlParam")
    private String getUrlParam(PmsSearchParam pmsSearchParam){
    String keyword = pmsSearchParam.getKeyword();
    String catalog3Id = pmsSearchParam.getCatalog3Id();
    List<PmsSkuAttrValue> pmsSkuAttrValues = pmsSearchParam.getPmsSkuAttrValueList();

    String urlParam = "";

    if (StringUtils.isNotBlank(keyword)){

        if (StringUtils.isNotBlank(urlParam)){
            urlParam = urlParam+"&";
        }
        urlParam = urlParam+"&keyword"+keyword;
    }
    if(StringUtils.isNotBlank(catalog3Id)){
        if (StringUtils.isNotBlank(urlParam)){
            urlParam = urlParam+"&";
        }
        urlParam = urlParam+"&catalog3Id"+catalog3Id;
    }
    if(pmsSkuAttrValues!=null){
        for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValues) {
            urlParam = urlParam+"&valueId"+pmsSkuAttrValue.getValueId();
        }
    }
        return urlParam;
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }


}
