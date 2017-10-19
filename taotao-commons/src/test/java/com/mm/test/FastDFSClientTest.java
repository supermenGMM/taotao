package com.mm.test;


import org.junit.Before;
import org.junit.Test;

import com.taotao.util.FastDFSClient;
import com.taotao.util.exception.FileException;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 *
 * @author yangxin
 * @version 1.0
 * @date 2016/10/19
 */
public class FastDFSClientTest {
	FastDFSClient fastDFSClient;
	@Before
	public void before(){
		fastDFSClient = new FastDFSClient();
	}

    /**
     * 文件上传测试
     * @throws FileException 
     */
    @Test
    public void testUpload() throws FileException {
        File file = new File("C:/Users/lemon/Pictures/b.jpg");
        Map<String,String> metaList = new HashMap<String, String>();
        metaList.put("width","1024");
        metaList.put("height","768");
        metaList.put("author","杨信");
        metaList.put("date","20161018");
        String fid = fastDFSClient.uploadFile(file,file.getName());
        System.out.println("upload local file " + file.getPath() + " ok, fileid=" + fid);
        //上传成功返回的文件ID： group1/M00/00/00/wKgAyVgFk9aAB8hwAA-8Q6_7tHw351.jpg
    }

    /**
     * 文件下载测试
     */
    @Test
    public void testDownload() {
        int r = fastDFSClient.downloadFile("group1/M00/00/00/wKg3gFnbh2yAGCa9AANdh3PFfQI659.jpg", new File("DownloadFile_fid.jpg"));
        System.out.println(r == 0 ? "下载成功" : "下载失败");
    }

    /**
     * 获取文件元数据测试
     */
    @Test
    public void testGetFileMetadata() {
        Map<String,String> metaList = fastDFSClient.getFileMetadata("group1/M00/00/00/wKg3gFnbh2yAGCa9AANdh3PFfQI659.jpg");
        if(metaList==null){
        	return ;
        }
        for (Iterator<Map.Entry<String,String>>  iterator = metaList.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String,String> entry = iterator.next();
            String name = entry.getKey();
            String value = entry.getValue();
            System.out.println(name + " = " + value );
        }
    }
    
    /**
     * 文件删除测试
     */
    @Test
    public void testDelete() {
        int r = fastDFSClient.deleteFile("group1/M00/00/00/wKg3gFnbh2yAGCa9AANdh3PFfQI659.jpg");
        System.out.println(r == 0 ? "删除成功" : "删除失败");
    }
}