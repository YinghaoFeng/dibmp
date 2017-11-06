package cn.mldn.dibmp.yaojia.service;

import java.util.Map;

import cn.mldn.dibmp.vo.Customer;
import cn.mldn.dibmp.vo.Goods;

/**
 * 定义销售业务接口
 * @author yaojia
 *
 */
public interface ISaleService {
	/**
	 * 实现商品清单并分页
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public Map<String,Object> list(String column, String keyWord, 
			Long currentPage, Integer lineSize);
	
	/**
	 * 更新商品信息
	 * @param vo
	 * @return
	 */
	public boolean edit(Goods vo);
	
	/**
	 * jdk
	 * 客户增加详情
	 * @param map 
	 * @return
	 */
	public boolean add(Customer vo);
	/**
	 * jdk
	 * 客户增加前的信息查询，该方法执行如下操作:<br>
	 * @return 返回一下数据类型<br>
	 * key = allCitys,value = 全部城市信息<br/>
	 * key = allProvince,value = 全部省份信息<br/>
	 * key = allCsource,value = 全部客户来源<br/>
	 * key = allCitem,value = 全部的客户等级信息<br/>
	 */
	public Map<String,Object> getAddPre();
	/**
	 * 进行顾客信息数据列表显示处理，执行如下操作：<br>
	 * 1.调用CitemMapper.findAll()取的全部的顾客等级<br>
	 * 2.调用CustomerMapper.findAll()方法得到顾客的详情信息<br>
	 * 3.调用CustomerMapper.findAllSplit()方法进行顾客的分页查询<br>
	 * 4.调用CustomerMapper.getAllCount()方法进行顾客数量的查询.<br>
	 * @param column 模糊查询列
	 * @param keyWord 关键字
	 * @param currentPage 当前页
	 * @param lineSize 每页显示的行数
	 * @return
	 */
	public Map<String,Object> listC(long currentPage, int lineSize,String column, String keyWord);
}
