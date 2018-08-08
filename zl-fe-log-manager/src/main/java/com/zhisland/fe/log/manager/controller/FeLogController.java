package com.zhisland.fe.log.manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jakeChen
 * @Description:
 * @date 08/08/2018
 */
@Slf4j
@RestController
public class FeLogController extends BaseController{

	@RequestMapping("/fe/log")
	public void FeLog(@RequestParam(value = "logInfo") String logInfo){
		log.info("[logInfo]:[{}]", logInfo);
	}

}
