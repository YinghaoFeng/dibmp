package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.Warehouse;

public interface IWarehouseDAO {
	/**
	 * 根据仓库类型（也是商品类型）找到仓库位置
	 * @param wiid
	 * @return
	 */
	public List<Warehouse> findByWitem(Long wiid);
}
