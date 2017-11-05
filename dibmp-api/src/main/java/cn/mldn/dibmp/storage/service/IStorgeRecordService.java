package cn.mldn.dibmp.storage.service;

import cn.mldn.dibmp.vo.StorageRecord;

/**
 * 负责商品审核清单的处理待审核清单
 * @author Administrator
 */
public interface IStorgeRecordService {
	/**
	 * 添加已经通过审核的数据信息
	 * @param vo 已经通过的数据
	 * @return 添加成功返回true否则返回false
	 */
	public boolean add(StorageRecord vo);
}
