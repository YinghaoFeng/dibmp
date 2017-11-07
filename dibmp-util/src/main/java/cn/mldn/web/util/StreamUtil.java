package cn.mldn.web.util;

import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件流工具类
 * @author yaojia
 *
 */
public class StreamUtil {

	private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);
	
	/**
	 * 进行流的转换
	 * @param inputStream
	 * @param outputStream
	 */
	public static void convert(InputStream inputStream, OutputStream outputStream) {
		try {
			int length = 0;
			byte [] buffer = new byte[2*1024];
			while((inputStream.read(buffer, 0, buffer.length)) !=-1) {
				outputStream.write(buffer, 0, length);
			}
			outputStream.flush();
		}catch(Exception e) {
			logger.error("流转换出错了", e);
			throw new RuntimeException(e);
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				logger.error("资源释放错误", e);
			}
		}
	}
}
