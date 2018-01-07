package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/**
	 * 需求：页面跳转
	 * 以页面请求作为参数
	 * 首页展示：localhost:8082/index
	 * 商品添加：localhost:80802/item-add
	 * 请求名称页面名称相同
	 * 把请求作为参数，返回参数即可 是否页面名称逻辑视图返回，则可实现一个请求映射匹配所有请求
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
