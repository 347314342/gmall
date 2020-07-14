package com.huki.gmall.litem.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.huki.gmall.bean.PmsProductSaleAttr;
import com.huki.gmall.bean.PmsSkuInfo;
import com.huki.gmall.bean.PmsSkuSaleAttrValue;
import com.huki.gmall.service.SkuService;
import com.huki.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class itemController {


    @Reference
    SpuService spuService;
    @Reference
    SkuService skuService;



//    @RequestMapping("{skuId}.html")
//
//        public String item(@PathVariable String skuId, ModelMap modelMap, HttpServletRequest request){
//
//        String remoteAddr = request.getRemoteAddr();
//        //request.getHeader("");//nginx负载均衡
//
//        PmsSkuInfo pmsSkuInfo = skuService.getskubyid(skuId,remoteAddr);
//        //sku对象
//        modelMap.put("skuInfo",pmsSkuInfo);
//        //销售属性
//        List<PmsProductSaleAttr> pmsProductSaleAttrList = spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
//        modelMap.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrList);
//
//
//        // 查询当前sku的spu的其他sku的集合的hash表
//        Map<String, String> skuSaleAttrHash = new HashMap<>();
//        List<PmsSkuInfo> pmsSkuInfos = skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
//
//        for (PmsSkuInfo skuInfo : pmsSkuInfos) {
//            String k = "";
//            String v = skuInfo.getId();
//            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
//            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
//                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";// "239|245"
//            }
//            skuSaleAttrHash.put(k,v);
//        }
//
//        // 将sku的销售属性hash表放到页面
//        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
//        modelMap.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);
//
//        return "item";
//    }

//    @RequestMapping("shangpinxiangqing")
//    //public String item(@PathVariable String skuId){
//    public String shangpinxiangqing(){
//
//        return "shangpinxiangqing";
//    }


    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap map, HttpServletRequest request){

        String remoteAddr = request.getRemoteAddr();

        // request.getHeader("");// nginx负载均衡

        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId,remoteAddr);

        //sku对象
        map.put("skuInfo",pmsSkuInfo);
        //销售属性列表
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
        map.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrs);

        // 查询当前sku的spu的其他sku的集合的hash表
        Map<String, String> skuSaleAttrHash = new HashMap<>();
        List<PmsSkuInfo> pmsSkuInfos = skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());

        for (PmsSkuInfo skuInfo : pmsSkuInfos) {
            StringBuilder k = new StringBuilder();
            String v = skuInfo.getId();
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k.append(pmsSkuSaleAttrValue.getSaleAttrValueId()).append("|");// "239|245"
            }
            skuSaleAttrHash.put(k.toString(),v);
        }

        // 将sku的销售属性hash表放到页面
        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
        map.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);


        return "item";
    }

    @RequestMapping("index")
    public String index(ModelMap modelMap){

        List<String> list = new ArrayList();
        for (int i=0;i<5;i++)
        {
            list.add("list"+i);
        }

        modelMap.put("list",list);
        modelMap.put("hello","hello HUKI");
        return "index";
    }

    @RequestMapping("item")
    public String item(){


        return "item";
    }
}
