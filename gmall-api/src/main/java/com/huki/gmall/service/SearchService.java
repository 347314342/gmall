package com.huki.gmall.service;

import com.huki.gmall.bean.PmsSearchParam;
import com.huki.gmall.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
