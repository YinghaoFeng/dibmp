package cn.mldn.dibmp.service.abc;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStirageService {
	/**
	 * 建立一个String,Object类型的的map
	 * @return
	 */
	protected Map<String, Object> StringObjectMap() {
		 HashMap<String, Object> map = new HashMap<String,Object>();
		return map;
	}
	
	public boolean  isEmptyString(String culumn,String keyWord) {
		if("".equals(culumn)||"".equals(keyWord)) {
			return true;
		}
		return false;
		
	}
}
