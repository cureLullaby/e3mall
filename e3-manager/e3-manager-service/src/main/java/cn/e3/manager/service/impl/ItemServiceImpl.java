package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Array;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.EasyUIPageBean;
@Service
public class ItemServiceImpl implements ItemService {
	@Resource
	private TbItemMapper itemMapper;
	
	/**
	 * 需求:根据商品id查询商品数据
	 * 参数:Long itemId
	 * 返回值:TbItem
	 */
	public TbItem findItemById(Long itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}
	
	/**
	 * 需求：分页展示商品信息
	 * 请求：list?page=1&rows=30
	 * 参数：page,rows
	 * 返回值:{"total":2020,rows:[{},{}]}
	 */
	public EasyUIPageBean findItemListByPage(Integer page, Integer rows) {
		//创建example对象
		TbItemExample example = new TbItemExample();
		//设置分页条件 pageNum,pageSize
		PageHelper.startPage(page,rows);
		//获得总记录集合
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建pageInfo对象 获得总记录数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		//创建分页包装类对象,封装分页数据
		EasyUIPageBean pagebean = new EasyUIPageBean();
		//总记录
		pagebean.setRows(list);
		//总记录数
		pagebean.setTotal(pageInfo.getTotal());
		
		return pagebean;
	}

}
