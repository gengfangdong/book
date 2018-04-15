package com.book.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class Filedownload {
	public ResponseEntity<byte[]> download(String filename,String path) throws Exception{
		ResponseEntity<byte[]> responseEntity = null;
		HttpHeaders headers=new HttpHeaders();
		InputStream input;
	            File file=new File(path+"\\"+filename);
	            input=new FileInputStream(file);
	            byte[] byt=Filedownload.readStream(input);
	            
	            headers.setContentDispositionFormData("attachment",filename);
	    		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	            responseEntity=new ResponseEntity<byte[]>(byt,headers, HttpStatus.CREATED);
	            input.close();
	    
		return responseEntity;
		
	}
	public static byte[] readStream(InputStream inStream) throws Exception{     
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];     
        int len = -1;     
        while((len = inStream.read(buffer)) != -1){     
          outStream.write(buffer, 0, len);      
        }       
        outStream.close();      
        inStream.close();  
        return outStream.toByteArray();     
      } 
}
