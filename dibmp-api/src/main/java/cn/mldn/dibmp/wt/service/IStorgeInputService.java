package cn.mldn.dibmp.wt.service;
/**
 * 负责实现商品入库处理
 * @author Administrator
 *
 */

import java.util.Map;

public interface IStorgeInputService {

	/**
	 * 根据said 查询当前编号对应的仓库的信息
	 * @param said 仓库编号
	 * @return
	 */
	public Map<String, Object> listInputBcke(Long said);
}
