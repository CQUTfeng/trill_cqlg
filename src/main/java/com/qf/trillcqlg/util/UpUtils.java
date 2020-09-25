package com.qf.trillcqlg.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;


public class UpUtils {

	public static String upfile(MultipartFile file, HttpServletRequest request) {
		//判断文件后缀
		//file.getOriginalFilename().endsWith("")
		//http://localhost:8080/trill/video/
		String realPath = request.getSession().getServletContext().getRealPath("/video/");

		File file1 = new File(realPath);
		if (!file1.exists()) {
			file1.mkdirs();
		}
		String orgName = file.getOriginalFilename();
		try {
			//http://localhost:8080/trill/video/aa.mp4
			FileOutputStream fos = new FileOutputStream(realPath+orgName,true);
			fos.write(file.getBytes());
			fos.flush();
			fos.close();
			return "200";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "501";

		}
	}

}
