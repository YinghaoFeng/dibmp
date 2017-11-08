package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

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
	/**
	 * 实现数据的分页模糊查询
	 * @param map  存放的数据值
	 * @return
	 */
	public List<StorageRecord> findSplit(Map<String, Object> map);
	/**
	 * 实现模糊统计数据的数值
	 * @param map 要进行模糊查询统计的数据
	 * @return
	 */
	public Long getCountSplit(Map<String, Object> map);
	

}
