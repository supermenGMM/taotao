package com.taotao.uitl.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.constant.BackConstant;
import com.taotao.util.FastDFSClient;
import com.taotao.util.JsonUtils;
import com.taotao.util.exception.FileException;

@Controller
@RequestMapping("/pic")
public class PictureController {
	private Logger logger = Logger.getLogger(PictureController.class);
	/**
	 * 上传
	 * @param uploadFile
	 * @return 
	 * @throws FileException 
	 * 
	 */
	@RequestMapping(value="/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String upload(@RequestParam(name="uploadFile",required=true) MultipartFile uploadFile){
		Map<String, Object> result = new HashMap<>();
//		先获取文件名
		String originalFilename = uploadFile.getOriginalFilename();
		logger.info("originalFile:"+originalFilename);
		
		try {
			String pid = new FastDFSClient().uploadFile(uploadFile.getBytes(), originalFilename,null);
			String url= FastDFSClient.HTTP_TRACK_SERVE+pid;
//			返回结果
			result.put(BackConstant.ERROR,0);
			result.put(BackConstant.URL, url);
		} catch (Exception e) {
			result.put(BackConstant.ERROR, 1);
			result.put(BackConstant.MESSAGE, "服务器错误，上传失败!请重试");
			e.printStackTrace();
		}
		String json = JsonUtils.objectToJson(result);
		logger.warn("结果"+result);
		return json;
		
	}
}
