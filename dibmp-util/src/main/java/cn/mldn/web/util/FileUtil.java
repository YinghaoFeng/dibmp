package cn.mldn.web.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件操作工具类
 * @author yaojia
 *
 */
public class FileUtil {

	  private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	/**
	 * 创建文件名称
	 * @param file
	 * @return
	 */
	public static String getFileName(MultipartFile file) {
		String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String fileName = UUID.randomUUID() + fileSuffix;
		return fileName;
	}
	 
	/**
	 * 创建文件
	 * @param filePath
	 * @return
	 */
	public static File createFile(String filePath) {
		File file = null ;
		try {
			file = new File(filePath);
			File parentDir = file.getParentFile();
			if(!parentDir.exists()) {
				 FileUtils.forceMkdir(parentDir);
			}
		}catch(Exception e) {
			logger.error("创建文件出错啦", e);
			throw new RuntimeException(e);
		}
		return file;
	}
}
