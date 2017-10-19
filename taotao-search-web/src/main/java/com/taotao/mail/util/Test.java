package com.taotao.mail.util;

public class Test {
		
//	用于测试的main方法
	public static void main(String[] args) {
	    String toAddress = "mm852458550@live.com";
//	    String toaddr = "852458550@qq.com";
	//        String title = "【测试标题】Testing Subject-myself-TEXT";
	//        String title = "【测试标题】Testing Subject-myself-HTML";
	//        String title = "【测试标题】Testing Subject-myself-eml文件";
	    String title = "hell0";
	    String content = "生日快乐";
	    
		EmailSendInfo mailInfo = EmailSend.getEmailAuthenticator(toAddress, title, content);
	      
	     //发送文体格式邮件
	         EmailSend.sendTextMail(mailInfo);
	     //发送html格式邮件
	//         EmailSender.sendHtmlMail(mailInfo);  
	     //发送含附件的邮件
//	     EmailSender.sendAttachmentMail(mailInfo);
	     //读取eml文件发送
	//         File emailFile = new File("file/EML_myself-eml.eml");
	//         File emailFile = new File("file/EML_reademl-eml文件_含文本附件.eml");
	//         File emailFile = new File("file/EML_reademl-eml文件_含图片附件.eml");
	//         File emailFile = new File("file/EML_reademl-eml文件_含多个附件.eml");
	//         EmailSender.sendMail(mailInfo, emailFile);
	}
//	以文本格式发送邮件
	

}

