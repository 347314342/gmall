package com.huki.gmall.manage.mapper;

import com.huki.gmall.bean.PmsBaseAttrInfo;
import com.huki.gmall.bean.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseAttrValueMapper extends Mapper<PmsBaseAttrValue> {

    List<PmsBaseAttrInfo> selectAtteValueListByValueId(@Param("valueIdStr") String valueIdStr);
}
