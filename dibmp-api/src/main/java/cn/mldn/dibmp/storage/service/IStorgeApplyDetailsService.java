package cn.mldn.dibmp.storage.service;
import cn.mldn.dibmp.vo.StorageApplyDetails;

/**
 * 负责商品详情清单的显示
 * @author Administrator
 */
public interface IStorgeApplyDetailsService {
	/**
	 * 添加商品的详细信息清单
	 * @param vo  商品详细实现 
	 * @return 添加成功返回true否则返回fasle 
	 */
	public boolean add(StorageApplyDetails vo);
	/**
	 * 根据编号查询当前的商品详细信息
	 * @param sadid 当前商品编号
	 * @return
	 */
	public StorageApplyDetails findBySadid(Long sadid);
}
