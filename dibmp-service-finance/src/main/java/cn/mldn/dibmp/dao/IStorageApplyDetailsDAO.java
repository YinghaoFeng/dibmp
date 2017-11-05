package cn.mldn.dibmp.dao;
/**
 * @author  定义入库商品请单详情，
 */

import cn.mldn.dibmp.vo.StorageApplyDetails;

public interface IStorageApplyDetailsDAO {
	/**
	 * 添加商品的详情
	 * @param vo  商品的信息
	 * @return 添加成功返回true否则返回false
	 */
	public boolean doCreate(StorageApplyDetails vo);
	/**
	 * 根据 storageApply中的said的值查询出当前用户所入库的商品信息
	 * @param sadid   storage_apply.said = storage_apply_details.sadid
	 * @return
	 */
	public StorageApplyDetails findBySadid(Long sadid);
}
