package cn.mldn.web.util;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import cn.mldn.util.exception.CacheException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis工具类
 * @author yaojia
 *
 */
public class RedisUtil {

	private static final String REDIS_HOST = "192.168.142.134" ;
	private static final int REDIS_PORT = 6379 ;
	private static final int TIMEOUT = 2000 ; 
	private static final int MAX_TOTAL = 200 ;	
	private static final int MAX_IDLE = 20 ;	
	private static final int MAX_WAIT_MILLIS = 1000 ;
	private static final boolean TEST_ON_BORROW = true ;
	private static final String REDIS_AUTH = "hello" ;	
	private static JedisPool pool = null ;	
	
	static {
		JedisPoolConfig config = new JedisPoolConfig() ;
		config.setMaxTotal(MAX_TOTAL);
		config.setMaxIdle(MAX_IDLE);
		config.setMaxWaitMillis(MAX_WAIT_MILLIS);
		config.setTestOnBorrow(TEST_ON_BORROW); 
		pool = new JedisPool(config,REDIS_HOST,REDIS_PORT,TIMEOUT,REDIS_AUTH) ;
	}
	
	/*public RedisUtil() {
		JedisPoolConfig config = new JedisPoolConfig() ;
		config.setMaxTotal(MAX_TOTAL);
		config.setMaxIdle(MAX_IDLE);
		config.setMaxWaitMillis(MAX_WAIT_MILLIS);
		config.setTestOnBorrow(TEST_ON_BORROW); 
		pool = new JedisPool(config,REDIS_HOST,REDIS_PORT,TIMEOUT,REDIS_AUTH) ;
	}*/
	
	
	/**
     * 获取Jedis实例
     * @return
     */
    public static Jedis getJedis() {
        try {
            if (pool != null) {
                Jedis resource = pool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void close(final Jedis jedis) {
        if (jedis != null) {
        	jedis.close();
        }
    }
    
    /**
     * 
     * @param key
     * @return
     */
    public static Object get(Object key) {
    	Object obj = null ;
    	Jedis cache = getJedis();
    	try {
    		if(null == cache) {
    			return null;
    		}
    		byte [] b = cache.get(key.getClass().getName().getBytes());
    		if(b !=null) {
    			 obj = new String(b);
    		}
    	}finally {
    		
    	}
		return obj;
    }
    
    /**
     * 
     * @param key
     * @param value
     */
    public static void put(String key, String value) {
    	Jedis cache = getJedis();
    	String common = "yaojia-";
      try {
    	if(value == null) {
    		cache.del(key.getClass().getName().getBytes());
    	}else {
    		cache.set(common+key, value);
    	}
      }catch(Exception e){
    	  throw new CacheException(e);
      }finally {
    	  cache.close();
      }
    }
    
    /**
     * 
     * @return
     */
    public static Set<String> keys() {
		Jedis cache = getJedis();
		try {
			Set<String> keys = cache.keys("yaojia-*"); 
			return keys;
		} catch (Exception e) {
			throw new CacheException(e);
		} finally {
			cache.close();
		}
	}
    /**
     * 
     * @param key
     * @param value
     */
    public static void update(String key, String value) {
		put(key, value);
	}
    public static void main(String[] args) {
    	String key = "mldn";
    	String key1 = "funlo";
    	Goods vo = new Goods();
    	vo.setDelflag(1);
    	vo.setGid(1l);
    	vo.setLastin(new Date());
    	vo.setName("yaojiaiteye@163.com");
    	vo.setNote("dddddd");
    	vo.setPrice(1000.0);
    	Goods vo1 = new Goods();
    	vo1.setDelflag(2);
    	vo1.setGid(2l);
    	vo1.setLastin(new Date());
    	vo1.setName("yaoj63.com");
    	vo1.setNote("mmmmmm");
    	vo1.setPrice(1123.0);
    	RedisUtil.put("cc", vo.toString());
    	RedisUtil.put(key1, vo1.toString());
        System.err.println(RedisUtil.keys());
        Set<String> keys = RedisUtil.getJedis().keys("yaojia-*") ;
		Iterator<String> iter = keys.iterator() ;
		while (iter.hasNext()) {
			String keyss = iter.next() ;
			System.err.println(key + " = " + RedisUtil.getJedis().get(keyss));
		}
	}
}
