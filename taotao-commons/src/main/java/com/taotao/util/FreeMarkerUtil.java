package com.taotao.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil{
	/**
	 * @param map 传入的数据
	 * @param basePath 模板所在路径
	 * @param templete 模版文件名
	 * @param outPath 输出路径
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static  void generateHTMl(Map<Object,Object> map,String basePath,String templete,String outPath) throws IOException, TemplateException {
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDirectoryForTemplateLoading(new File(basePath));
		Template template = configuration.getTemplate(templete);
		File file = new File(outPath);
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		Writer writer = new FileWriter(file);
		template.process(map, writer);
		writer.close();
	}
}
