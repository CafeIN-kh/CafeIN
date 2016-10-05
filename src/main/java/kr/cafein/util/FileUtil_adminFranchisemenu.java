package kr.cafein.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class FileUtil_adminFranchisemenu {

	
	
	public static String UPLOAD_PATH="C:/Users/naddana/git/CafeIN/src/main/webapp/upload/franchise_menu";
	
	//"F:/javaworld/workspace/CafeIN/src/main/webapp/resources/cafein_user/assets/img/franchise/menu"
	public static String rename(String fileName)throws Exception{

		if(fileName==null) return null;

		String newName = "";

		return rename(fileName,newName);
	}
	
	public static void makeFile(String filename){
		 //파일 객체 생성
		String path = "F:/Javawork/workspace_CafeInSpring/CafeIN/src/main/webapp/upload/franchise_menu/"+filename;
		
        File file = new File(path);
        //!표를 붙여주어 파일이 존재하지 않는 경우의 조건을 걸어줌
        if(!file.exists()){
            //디렉토리 생성 메서드
            file.mkdirs();
        } 
	}

	public static String moveFile(String filename, String foldername){

		String beforeFilePath = "F:/Javawork/workspace_CafeInSpring/CafeIN/src/main/webapp/upload/franchise_menu/"+filename+".jpg";
		String afterFilePath = "F:/Javawork/workspace_CafeInSpring/CafeIN/src/main/webapp/upload/franchise_menu/"+foldername+"/"+filename+".jpg";
		
		try{
			File file = new File(beforeFilePath);
			
			if(file.renameTo(new File(afterFilePath))){
				return afterFilePath;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

		
	}
	
	
	public static String rename(String fileName,String newName)
			throws Exception{
		if(fileName == null) return null;

		File file = new File(UPLOAD_PATH,fileName);

		//파일명을 원하는 형식으로 변경하기
		int idx = fileName.lastIndexOf(".");

		String extention = "";
		String newFileName = "";

		if(idx !=-1){
			extention = fileName.substring(idx);
		}
		//newName 전달시 확장자를 제외해야 하지만 확장자를 포함할 경우는 제거함
		int newIdx = newName.lastIndexOf(".");
		if(newIdx !=-1){
			newName = newName.substring(0,newIdx);
		}
		//확장자 포함 새로운 파일명
		newFileName = newName + extention.toLowerCase();

		File fs = new File(UPLOAD_PATH,newFileName);
		file.renameTo(fs); //파일명을 변경

		return newFileName;
	}
	public static void removeFile(String fileName){
		if(fileName != null){
			File file = new File(UPLOAD_PATH,fileName);
			if(file.exists()) file.delete();
		}
	}

	public static String createThumbnail(String uploadedFile,int thumbnailWidth, int thumbnailHeight){
		return createThumbnail(uploadedFile, null, thumbnailWidth, thumbnailHeight);
	}
	
	public static String createThumbnail(String uploadedFile,String thumbnailFile,int thumbnailWidth, int thumbnailHeight){
		if(thumbnailFile==null){
			int index = uploadedFile.lastIndexOf(".");
			if(index !=-1){//썸네일의 확장자는 jpg로 변경
				thumbnailFile = "s" + uploadedFile.substring(0,index) + ".jpg";
			}
		}else{
			int index = thumbnailFile.lastIndexOf(".");
			if(index !=-1){//썸네일의 확장자는 jpg로 변경
				thumbnailFile = thumbnailFile.substring(0,index) + ".jpg";
			}
		}
		
		FileInputStream fs = null; 
		try { 
			fs = new FileInputStream(UPLOAD_PATH+"/"+uploadedFile);
			BufferedImage im = ImageIO.read(fs);

			int width;
			int height;

			if(thumbnailHeight == 0){//높이를 0으로 지정했을 경우 넓이를 

				int radio = im.getWidth() / thumbnailWidth;//축소할 비율을 구함

				width = thumbnailWidth;
				height = im.getHeight() / radio;
			}else{
				width = thumbnailWidth;
				height = thumbnailHeight;
			}

			BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D 	g2 = thumb.createGraphics();

			g2.drawImage(im.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, width, height, null);
			ImageIO.write(thumb, "jpg", new File(UPLOAD_PATH,thumbnailFile));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fs!=null)try {fs.close();} catch (IOException e) {}
		}
		return thumbnailFile;
	}
}
