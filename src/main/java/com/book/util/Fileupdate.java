package com.book.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class Fileupdate {
	@Autowired
	private PdfgetImage pdfgetImage;
	private String filePath="/file/";
	private String getExt(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	private String createFileName(String fileName){	
		return UUID.randomUUID().toString()+"."+getExt(fileName);
	}
	
	public void delete(String fileName){
		
		File file=new File(fileName);
		if (file.exists()) {
		    //"删除文件失败："+fName+"文件不存在";
			System.out.println("文件存在！");
		}
		 if (file.delete()) {
             System.out.println("删除单个文件" + fileName + "成功！");
             
         } else {
             System.out.println("删除单个文件" + fileName + "失败！");
         }
		 
	}
	public String uploadFile(MultipartFile file,String fileName,String path){
		if(path!=null){
			filePath=path;
		}
		return this.uploadFile(file, fileName);
	}
	public String uploadFile(MultipartFile file,String fileName){
		String newName=createFileName(fileName);
		String name=filePath+"\\"+newName;
		System.out.println(name);
		try {
			file.transferTo(new File(name));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	        
		pdfgetImage.pdfToImagePath(name,filePath,newName);
		
		return newName;
	}
}
