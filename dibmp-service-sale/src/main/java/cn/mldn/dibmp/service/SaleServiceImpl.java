package cn.mldn.dibmp.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.GoodsMapper;
import cn.mldn.dibmp.service.abs.AbstractService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.GoodsStorageAndApply;
import cn.mldn.dibmp.service.ISaleService;
@Service
public class SaleServiceImpl extends AbstractService implements ISaleService {

	@Resource
	private GoodsMapper goodsMapper;
	
	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) {
		// TODO Auto-generated method stub
		Map<String,Object> param = super.handleParams(column, keyWord, currentPage, lineSize);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allGoods", this.goodsMapper.findAllSplit(param));
		map.put("allRecorders", this.goodsMapper.getSplitCount(param));
		return map;
	}
	@Override
	public boolean edit(Goods vo) {
		// TODO Auto-generated method stub
		return this.goodsMapper.doUpdate(vo);
	}
	@Override
	public Map<String, Object> findGoodsDetailsById(Long gid) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("GoodsDetails", this.goodsMapper.findGoodsDetailsById(gid));
		return null;
	}
	@Override
	public GoodsStorageAndApply findGoodsStorageApply(Long gid) {
		// TODO Auto-generated method stub
		return this.goodsMapper.findGoodsStorageApply(gid);
	}

}
