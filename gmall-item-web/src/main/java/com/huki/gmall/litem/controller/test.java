package com.huki.gmall.litem.controller;

import java.util.HashMap;
//那个面试的题目用用的
public class test {



    public static void main(String[] args) {

//        String hostUrl="www.baidu.com";
//        HashMap<String,String> params= new HashMap<>();
//        params.put("a","1");
//        params.put("b","2");
//        String url = urlencode(hostUrl,params);
//        System.out.println(url);




    }




    static String urlencode(String hostUrl, HashMap<String,String> params){


        String url = hostUrl;
        String map="?";
        String regexp = "\'";
        url.replaceAll(regexp,"");

        for (String key:params.keySet()){

            map += key+"="+params.get(key)+"&";
        }

        url=url+map;
        url=url.substring(0,url.length()-1);
        return url;
    }


}
