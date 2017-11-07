package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Warehouse;

public interface IWarehouseDAO {
	public boolean doCerate(Warehouse vo) ;
	public List<Warehouse> findAllSplit(Map<String,Object> params) ;
	public Long getSplitCount(Map<String,Object> params) ;
	/**
	 * 根据仓库类型（也是商品类型）找到仓库位置
	 * @param wiid
	 * @return
	 */
	public List<Warehouse> findByWitem(Long wiid);
}
