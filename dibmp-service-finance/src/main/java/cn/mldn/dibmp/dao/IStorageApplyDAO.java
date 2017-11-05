package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.StorageApply;
/**
 * @author 定义商品入库申请单
 */
public interface IStorageApplyDAO {
	/**
	 * 实现商品入库申请单的填写
	 * @param vo  添加的vo 对象
	 * @return  成功返回true否则返回false
	 */
	public boolean doCreate(StorageApply vo);
	/**
	 * 修改当前入库申请单的状态
	 * 0为未处理申请，1为处理申请
	 * 根据said 和 status
	 * @param status  状态信息 0 ，1
	 * @return 修改成功返回true否则返回false
	 */
	public boolean doEditStatus(Map<String, Object> map);
	
	/**
	 * 查询所有的待审核清单数据
	 * @return
	 */
	public List<StorageApply> findAll();
}