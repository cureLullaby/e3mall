package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.EasyUIPageBean;

public interface ItemService {
	public TbItem findItemById(Long itemId);

	public EasyUIPageBean findItemListByPage(Integer page, Integer rows);
}
