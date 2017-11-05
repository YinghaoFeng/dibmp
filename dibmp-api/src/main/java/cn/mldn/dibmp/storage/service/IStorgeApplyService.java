package cn.mldn.dibmp.storage.service;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.StorageApply;

/**
 * 负责商品待审核清单的处理待审核清单
 * @author Administrator
 */
public interface IStorgeApplyService {
	/**
	 * 实现待审核清单的数据添加
	 * @param vo 待审核清单的数据
	 * @return 添加成功 返回true否则返回false
	 */
	public boolean add(StorageApply vo);
	/**
	 * 显示所有的待审核清单的数据显示
	 * @return  数据以list的形式返回
	 */
	public List<StorageApply>saList();
	
	/**
	 * 更新当前待审核清单的状态
	 * 0 - 为待审核  1 - 审核完成
	 * @param said  当前申请编号
	 * @param status 申请状态
	 * @return  申请成功返回true否则返回false
	 */
	public boolean updateStatus(Long said,Integer status); 
	
}
