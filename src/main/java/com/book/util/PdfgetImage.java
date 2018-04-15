package com.book.util;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Component;
@Component
public class PdfgetImage {
	private static final String FTP_ADDRESS="";
	private static final int FTP_PORT=21;
	private static final String FTP_USERNAME="";
	private static final String FTP_PASSWORD="";
	private static final String FTP_FILEPATH="/htdocs/Book/img/";
	/** 
    * 生成一本书的缩略图
    * @param inputFile        需要生成缩略图的书籍的完整路径
    * @param outputFile    生成缩略图的放置路径
    */
   public void pdfToImagePath(String filePath,String fileDirectory,String filename){
       int i=0;
       String imagePath;  
       File file = new File(filePath);  
       InputStream input;
       try {  
           File f = new File(fileDirectory);  
           if(!f.exists()){  
               f.mkdir();  
           }  
           PDDocument doc = PDDocument.load(file);  
           
           PDFRenderer renderer = new PDFRenderer(doc);   
           int pageCount = doc.getNumberOfPages();  
           
           BufferedImage image = renderer.renderImage(i, 1.25f);  //第二个参数越大生成图片分辨率越高，转换时间也就越长  
           ByteArrayOutputStream bs =new ByteArrayOutputStream();

           ImageOutputStream imOut =ImageIO.createImageOutputStream(bs);

           ImageIO.write(image,"jpg",imOut); //scaledImage1为BufferedImage，jpg为图像的类型

           input =new ByteArrayInputStream(bs.toByteArray());
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();

            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(ftp.makeDirectory(FTP_FILEPATH )){

            };
            if(ftp.changeWorkingDirectory(FTP_FILEPATH )){

            };
            if(ftp.storeFile(filename+".jpg",input)){

            }
            
            input.close();
            doc.close();
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
        
   
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   }  
       
}
