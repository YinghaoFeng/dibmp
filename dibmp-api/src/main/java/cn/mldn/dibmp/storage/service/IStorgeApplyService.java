package cn.mldn.dibmp.storage.service;

import java.util.Map;

import cn.mldn.dibmp.vo.StorageApply;

/**
 * 负责商品待审核清单的处理待审核清单
 * @author Administrator
 */
public interface IStorgeApplyService {
	/**
	 * 更新当前待审核清单的状态
	 * 0 - 为待审核  1 - 审核完成
	 * @param said  当前申请编号
	 * @param status 申请状态
	 * @return  申请成功返回true否则返回false
	 */
	public boolean updateStatus(Long said,Integer status); 
	/**
	 *  显示所有的待审核清单的数据显示
	 *
	 * 1.key="allApply" value="当前待审核的所有信息";
	 * 2.key="CountNum" value="当前审核清单的总数量";
	 * 3.key="SumPrice" value="当前审核清单的总价格";
	 * 4.key="addRess" value="仓库的存储地址";
	 * 
	 * 实现清单的模糊查询带分页
	 * @param column  
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public Map<String, Object> listSplitFont(String column,String keyWord,Long currentPage,Integer lineSize);

}
