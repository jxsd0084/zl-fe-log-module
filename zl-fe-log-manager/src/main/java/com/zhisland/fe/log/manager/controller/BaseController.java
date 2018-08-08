package com.zhisland.fe.log.manager.controller;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by taoli on 17/6/8.
 */
public abstract class BaseController {

    protected Map<String, String> createTypeData(String value, String name){
        Map<String, String> result = Maps.newHashMap();
        result.put("name", name);
        result.put("value", value);
        return result;
    }
}
