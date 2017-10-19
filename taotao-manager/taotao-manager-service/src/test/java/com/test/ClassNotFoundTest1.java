package com.test;

import java.net.URL;




import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;


public class ClassNotFoundTest1 {
	@Test
	public void  test1(){
	    URL url = DruidDataSource.class.getProtectionDomain().getCodeSource().getLocation();  
	    System.out.println("path:"+url.getPath()+"  name:"+url.getFile());  
	    /**
	     * path:/D:/j2ee/repository/org/springframework/spring-context/4.2.4.RELEASE/spring-context-4.2.4.RELEASE.jar  
	     * name:/D:/j2ee/repository/org/springframework/spring-context/4.2.4.RELEASE/spring-context-4.2.4.RELEASE.jar

	     */
	}
}
