package cn.mldn.web.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组集合工具类
 * @author yaojia
 *
 */
public class ArrayUtil {

   
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

  
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

}
