package cn.mldn.dibmp.service;


import java.util.Map;

import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.GoodsStorageAndApply;
import cn.mldn.dibmp.vo.GoodsStorageDetails;

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
	
	/**
	 * 根据商品gid查询商品详情
	 * @param gid
	 * @return
	 */
	
	public Map<String,Object> findGoodsDetailsById(Long gid);
	
	
	/**
	 * 根据商品gid查询商品仓库信息
	 * @param gid
	 * @return
	 */
	public GoodsStorageAndApply findGoodsStorageApply(Long gid);
	
	/**
	 * 商品库存详情
	 * @param gid
	 * @return
	 */
	public GoodsStorageDetails findGoodsStorageDetails(Long gid);
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public GoodsStorageDetails findAllGoodsStorageDetails(Long gid);
	
	/**
	 * 通过Redis中取得商品数据和查询商所对应的顾客
	 * @param name 销售人员id
	 * @return
	 */
	public Map<String,Object> findAllUnStorageGoods(String nameId);
}
