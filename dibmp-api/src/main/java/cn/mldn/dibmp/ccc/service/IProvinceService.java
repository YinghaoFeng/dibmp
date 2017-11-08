package cn.mldn.dibmp.ccc.service;

import java.util.List;

import cn.mldn.dibmp.vo.Province;

public interface IProvinceService {
	/**
	 * 查询所有省份信息
	 * @return
	 */
	public List<Province> findAll();
}
