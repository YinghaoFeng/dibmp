package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IWarehouseDAO;
import cn.mldn.dibmp.fyh.service.IWarehouseService;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.util.service.abs.AbstractService;

@Service
public class WarehouseServiceImpl extends AbstractService implements IWarehouseService {
	
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Override
	public Map<String, Object> addPre(Long wiid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Warehouse vo) {
		return warehouseDAO.doCerate(vo) ;
	}

	@Override
	public Map<String, Object> list(long currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allWarehouses", warehouseDAO.findAllSplit(super.paramToMap(currentPage, lineSize, column, keyWord))) ;
		map.put("allCounts", warehouseDAO.getSplitCount(super.paramToMap(column, keyWord))) ;
		return map ;
	}

	@Override
	public List<Warehouse> listByWitem(long wiid) {
		return warehouseDAO.findByWitem(wiid);
	}

}
