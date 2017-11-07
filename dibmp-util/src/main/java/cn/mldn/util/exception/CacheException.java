package cn.mldn.util.exception;


/**
 * 自定义异常类
 * @author yaojia
 *
 */
public class CacheException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CacheException(String s) {
		super(s);
	}

	public CacheException(String s, Throwable e) {
		super(s, e);
	}

	public CacheException(Throwable e) {
		super(e);
	}
}