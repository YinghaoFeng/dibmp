package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.StorageRecord;
/**
 * @author -- 定义入库记录信息
 */
public interface IStorageRecordDAO {
	/**
	 * 添加已经审核通过的清单数据
	 * @param vo  审核通过的数据
	 * @return 添加成功返回true否则返回false
	 */
	public boolean doCreate(StorageRecord vo);
	/**
	 * 查询所有的审核过的清单数据
	 * @return
	 */
	public List<StorageRecord> findAll();
}
