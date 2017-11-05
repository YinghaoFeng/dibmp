package cn.mldn.web.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.mldn.web.util.FileUtil;
import cn.mldn.web.util.StreamUtil;

/**
 * 文件上传工具类
 * @author yaojia
 *
 */
public class UploadHelper {

	private static final Logger logger = LoggerFactory.getLogger(UploadHelper.class);
	
	/**
	 * 进行文件上传
	 * @param filePath
	 * @param input
	 */
	public static void upload(String filePath, InputStream input) {
		try {
			if(input !=null) {
				FileUtil.createFile(filePath);
				InputStream inputStream = new BufferedInputStream(input);
				OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
				StreamUtil.convert(inputStream, outputStream);
			}
	    }catch(Exception e) {
	    	logger.error("上传文件出错了", e);
	    	throw new RuntimeException(e);
	    }
	}
}
