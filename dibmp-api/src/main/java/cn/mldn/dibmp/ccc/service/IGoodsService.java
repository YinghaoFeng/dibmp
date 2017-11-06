package cn.mldn.dibmp.ccc.service;

import java.util.Map;

import cn.mldn.dibmp.vo.Goods;

public interface IGoodsService {
	/**
	 * 增加新的商品
	 * @param vo 新增商品信息
	 * @param mid 增加商品的人
	 * @return 增加成功返回true
	 */
	public boolean add(Goods vo,String mid);
	public Map<String,Object> list(String column,String keyWord,Long currentPage,Integer lineSize);
}
