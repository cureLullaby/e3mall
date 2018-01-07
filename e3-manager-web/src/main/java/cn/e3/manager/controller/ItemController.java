package cn.e3.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.utils.EasyUIPageBean;
@Controller
public class ItemController {
	@Resource
	private ItemService itemService;
	/**
	 * 需求:根据商品id查询商品数据
	 * 参数:Long itemId
	 * 返回值:TbItem
	 */
	@RequestMapping("item/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId){
		TbItem item = itemService.findItemById(itemId);
		return item;
	}
	/**
	 * 需求：分页展示商品信息
	 * 请求：list?page=1&rows=30
	 * 参数：page,rows
	 * 返回值:{"total":2020,rows:[{},{}]}
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIPageBean findItemListByPage(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="20") Integer rows){
		EasyUIPageBean pageBean = new EasyUIPageBean();
		pageBean = itemService.findItemListByPage(page,rows);
		return pageBean;
		
	}
}
