package cn.mldn.dibmp.service;

import java.util.Map;

import cn.mldn.dibmp.vo.Goods;

/**
 * 定义销售业务接口
 * @author yaojia
 *
 */
public interface ISaleService {

	/**
	 * 实现商品清单并分页
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public Map<String,Object> list(String column, String keyWord, 
			Long currentPage, Integer lineSize);
	
	/**
	 * 更新商品信息
	 * @param vo
	 * @return
	 */
	public boolean edit(Goods vo);
	
}
