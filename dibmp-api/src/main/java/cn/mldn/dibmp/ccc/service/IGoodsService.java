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
	/**
	 * 商品列表
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public Map<String,Object> list(String column,String keyWord,Long currentPage,Integer lineSize);
	/**
	 * 修改前的回显
	 * @param gid
	 * @return
	 */
	public Goods editPre(long gid);
	/**
	 * 商品修改
	 * @param vo
	 * @param mid
	 * @return
	 */
	public boolean update(Goods vo,String mid);
	
}
