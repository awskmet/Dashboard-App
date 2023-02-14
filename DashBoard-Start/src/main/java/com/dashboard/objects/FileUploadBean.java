package com.dashboard.objects;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named(value="fileUploader")
@RequestScoped
public class FileUploadBean {
	private String folder="C:\\Users\\Anthony Doban\\Desktop\\dashboard\\UploadedHealthData\\";
	private Part uploadedFile;
	
	public Part getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public void saveFile() {
		
		String fileName="";
		
		try {
			System.out.println("Uploaded "+fileName);
			fileName=getFileName(uploadedFile);
			uploadedFile.write(folder+fileName);
		}catch (IOException e) {
			System.out.println("error");
			
		}
		
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
	}
	private static String getFileName(Part part) {
		System.out.println(part);
		System.out.println(part.getHeader("content-disposition"));
		for (String cd:part.getHeader("content-disposition").split(";")){
			if (cd.trim().startsWith("filename")) {
				String fileName=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				System.out.println(fileName);
				return fileName.substring(fileName.lastIndexOf('/')+1).substring(fileName.lastIndexOf('\\')+1);
			}
		}
		return null;
		
	}
}
