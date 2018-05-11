package com.sundata.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import com.sundata.common.exception.ServiceException;

/**
 * 文件处理类
 * 
 */
public class FileUtil {

	/**
	 * 根据传入参数分析获取文件存放目录，创建并返回完整的路径信息
	 * @param path 文件存放的根目录
	 * @param typeinfo 文件的子目录
	 * @param flag 子目录之间的分隔符
	 * @return
	 */
	public static String createPath(String path, String typeinfo, String flag) {
		// 获取文件存放根目录
		String filepath = ""; // 子路径
		String fullpath = ""; // 完整路径
		if (!typeinfo.equals("")) {
			String type[] = typeinfo.split(flag);
			for (int i = 0; i < type.length; i++) {
				filepath += "/" + type[i];
			}
		}

		fullpath = path + filepath;
		File file = new File(fullpath);
		if (!file.exists()) {// 创建路径目录
			file.mkdirs();
		}
		return fullpath;
	}

	/**
	 * 创建指定路径
	 * @param path 待创建路径
	 */
	public static void createPath(String path) {
		createPath(path, "", "");
	}

	/**
	 * 删除指定目录及其下的文件、子目录，指定目录不存在时不报错
	 * @param path 待删除目录
	 * @throws ServiceException 指定目录存在且删除失败时抛出异常
	 */
	public static void deletePath(String path) throws ServiceException {
		File file = new File(path);
		if (file.exists()) {
			try {
				FileUtils.deleteDirectory(file);
			} catch (IOException e) {
				throw new ServiceException("目录[" + path + "]删除失败", e);
			}
		}
	}

	/**
	 * 获取指定目录下所有文件名称存放到列表中
	 * @param path 路径信息
	 * @return list
	 */
	public static List<String> getDirFile(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		if (file.listFiles().length > 0) {
			for (int j = 0; j < file.listFiles().length; j++) {
				File filetmp = file.listFiles()[j];
				list.add(filetmp.getName());
			}
		}

		return list;
	}

	/**
	 * 删除指定路径下的指定文件
	 * @param path 路径信息
	 * @param name 文件名称
	 * @return true|false 删除成功返回true 失败返回false
	 */
	public static boolean delFileByName(String path, String name) {
		boolean flag = false;

		String pathfilename = path + File.separator + name;
		File dirfile = new File(pathfilename);
		if (dirfile.exists()) {
			flag = dirfile.delete();
		}
		return flag;
	}

	/**
	 * 上传文件到服务器指定位置
	 * @param strfullpath 路径
	 * @param filename 文件名
	 * @param stream 文件输入流
	 * @throws Exception 
	 */
	public static void uploadFile(String strfullpath, String filename, InputStream stream) throws Exception {
		// 路径名
		String path = strfullpath + File.separator;
		// 文件名
		File dir = new java.io.File(path);
		if (!dir.exists())
			dir.mkdir();
		// 文件的路径全称
		String pathfilename = path + filename;
		File dirfile = new java.io.File(pathfilename);
		// 判断上传的文件是否存在，如果存在则先删除，后上传
		if (dirfile.exists()) {
			boolean flag = dirfile.delete();
			if (!flag) {
				throw new Exception("文件[" + pathfilename + "]删除失败");
			}
		}
		try {
			FileUtils.copyInputStreamToFile(stream, dirfile);
		} catch (IOException e) {
			throw new ServiceException("文件[" + pathfilename + "]读写失败", e);
		}
	}

	/**
	 * 文件下载方法，页面中下载文件到客户端
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @param response http应答
	 */
	public static void getContent(String fileName, HttpServletResponse response, String filePath) {
		String downloadFilePath = filePath + File.separator + fileName;
		File downloadResourceFile = new File(downloadFilePath);
		InputStream input = null;
		try {
			input = new FileInputStream(downloadResourceFile);
		} catch (FileNotFoundException e) {
			throw new ServiceException("文件["+downloadResourceFile+"]不存在", e);
		}
		try {
			getContent(fileName, response, input);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					throw new ServiceException("读写文件失败", e);
				}
			}
		}
	}

	/**
	 * 文件下载方法，页面中下载字节数组形式的文件到客户端
	 * @param fileName 文件名称
	 * @param response http应答
	 * @param bytes 字节数组
	 */
	public static void getContent(String fileName, HttpServletResponse response, byte[] bytes) {
		InputStream input = null;
		try {
			input = new ByteArrayInputStream(bytes);
			getContent(fileName, response, input);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					throw new ServiceException("读写文件失败", e);
				}
			}
		}
	}

	/**
	 * 文件下载方法，页面中下载输入流形式的文件到客户端
	 * @param fileName 文件名称
	 * @param response http应答
	 * @param input 输入流
	 */
	public static void getContent(String fileName, HttpServletResponse response, InputStream input) {
		OutputStream outputStream = null;
		try {
			outputStream = setHeader(response,fileName);
			byte[] buffer = new byte[8192];
			int readSize = 0;
			while ((readSize = input.read(buffer)) != -1)
				outputStream.write(buffer, 0, readSize);
		} catch (IOException e) {
			throw new ServiceException("读写文件失败", e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					throw new ServiceException("读写文件失败", e);
				}
			}
		}
	}


	
	/**
	 * 设置应答头 
	 * @param response
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	private static OutputStream setHeader(HttpServletResponse response,String fileName) throws IOException {
		response.setHeader("Connection", "close");
		response.setHeader("Content-Type", "application/octet-stream");
		response.setContentType("application/x-msdownload");
		//response.setHeader("Content-Disposition", "attachment; filename=\"" + StringUtil.toUtf8String(fileName) + "\"");
		return  response.getOutputStream();
	}
	
	/**
	 * 将字符串内容写到文件中
	 * @param content
	 * @param path
	 * 2015-10-23
	 * @Author Magic
	 */
	public static void  writeFileByStr(String content,String path) {
		try {
			FileWriter fw=new FileWriter(new File(path));
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			throw new ServiceException("读写文件失败", e);
		}
	}

	/**
	 * 将长整形的文件字节数转换为以K为单位的字符串
	 * @param filesize
	 * @return
	 */
	
}
