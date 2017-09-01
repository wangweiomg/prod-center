package com.glorystone.prod.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 批处理返回
 *
 * @author wangwei
 * @version 2017年8月4日09:26:34
 */
public @Data class BatchResponse {

    private List<Long> successIdList = Lists.newArrayList();
    private Map<Long, String> failMap = Maps.newHashMap();


    public void successId(Long id) {
        successIdList.add(id);
    }

    public void failMap(Long id, String message) {
        failMap.put(id, message);
    }


}
