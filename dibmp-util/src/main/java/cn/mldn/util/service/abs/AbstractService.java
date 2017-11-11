package cn.mldn.util.service.abs;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务层继承的公共父类
 * @author YOOTK
 */
public abstract class AbstractService {
	public Map<String,Object> paramToMap(long currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("start", (currentPage - 1) * lineSize) ;
		map.put("lineSize", lineSize) ;
		if ("".equals(column)) {
			map.put("column", null) ;	// 明确设置null
		} else {
			map.put("column", column) ;
		}
		if ("".equals(keyWord)) {
			map.put("keyWord", null) ;	// 明确设置null
		} else {
			map.put("keyWord", "%"+keyWord+"%") ; 
		}
		return map ;
	}
	public Map<String,Object> paramToMap(String column,String keyWord){
		Map<String,Object> map = new HashMap<String,Object>() ;
		if ("".equals(column)) {
			map.put("column", null) ;	// 明确设置null
		} else {
			map.put("column", column) ;
		}
		if ("".equals(keyWord)) {
			map.put("keyWord", null) ;	// 明确设置null
		} else {
			map.put("keyWord",  "%"+keyWord+"%") ; 
		}
		return map ;
	}
	
	public Map<String,Object> paramToMap(long did,long current, int lineSize) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("start", (current - 1) * lineSize) ;
		map.put("lineSize", lineSize) ;
		map.put("did", did) ;
		return map ;
	}
	
	public Map<String,Object> paramToMap(long currentPage, int lineSize, String column, String keyWord,String appmid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("start", (currentPage - 1) * lineSize) ;
		map.put("lineSize", lineSize) ;
		map.put("appmid", appmid) ;
		if ("".equals(column)) {
			map.put("column", null) ;	// 明确设置null
		} else {
			map.put("column", column) ;
		}
		if ("".equals(keyWord)) {
			map.put("keyWord", null) ;	// 明确设置null
		} else {
			map.put("keyWord", "%"+keyWord+"%") ; 
		}
		return map ;
	}
	
	public Map<String,Object> paramToMap(String column,String keyWord,String appmid){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("appmid", appmid) ;
		if ("".equals(column)) {
			map.put("column", null) ;	// 明确设置null
		} else {
			map.put("column", column) ;
		}
		if ("".equals(keyWord)) {
			map.put("keyWord", null) ;	// 明确设置null
		} else {
			map.put("keyWord",  "%"+keyWord+"%") ; 
		}
		return map ;
	}

}
