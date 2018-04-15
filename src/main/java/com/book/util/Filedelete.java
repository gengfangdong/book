package com.book.util;

import java.io.IOException;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;
@Component
public class Filedelete {
	private String filePath="/file/";
	private static final String FTP_ADDRESS="";
	private static final int FTP_PORT=21;
	private static final String FTP_USERNAME="";
	private static final String FTP_PASSWORD="";
	private static final String FTP_IMAGEPATH="/htdocs/Book/img/";
	public void delete(String filename) throws Exception{
		 FTPClient ftp = new FTPClient();
	        ftp.setControlEncoding("GBK");
	        try{
	            int reply;
	            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
	            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
	            reply = ftp.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(reply)) {
	                ftp.disconnect();
	            }
	            if(ftp.changeWorkingDirectory(FTP_IMAGEPATH)){
	            	System.out.println("ftp change");
	            };
	            if(ftp.deleteFile(filename+".jpg")){
	            	System.out.println("image delete");
	            };
	            ftp.logout();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (ftp.isConnected()) {
	                try {
	                    ftp.disconnect();
	                } catch (IOException ioe) {
	                }
	            }
	        }
		
	}
}
