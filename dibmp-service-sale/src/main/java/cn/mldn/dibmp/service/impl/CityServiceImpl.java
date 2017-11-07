package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.ccc.service.ICityService;
import cn.mldn.dibmp.dao.CityMapper;
import cn.mldn.dibmp.vo.City;
@Service
public class CityServiceImpl implements ICityService {
	@Resource
	private CityMapper cityDAO;
	@Override
	public List<City> listByProvince(long pid) {
		return cityDAO.findByProvince(pid);
	}

}
