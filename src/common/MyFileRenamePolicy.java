package common;

import java.io.File;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		File newFile=null;
		
		do {
			long currentTime=System.currentTimeMillis();
			//현제시간 밀리세컨으로 난수발생하기위해
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			//0~999까지의 임의이 수 난수발생.
			int rndNum=(int)(Math.random()*1000);
			
			//확장자명 가져오기
			String oldName=oldFile.getName();
			//확장자명
			String ext="";
			int dot=oldName.indexOf(".");
			
			if(dot>-1){
				ext=oldName.substring(dot);
				//포함해서시작
			}
			String newName=sdf.format(currentTime)+"_"+rndNum+ext;
			newFile=new File(oldFile.getParentFile(),newName);
			System.out.println("newFile"+newFile);

		} while (!createFile(newFile));
		
		return newFile;
	}

	private boolean createFile(File newFile) {
		try {
			//createNewFile() 파일을 생성하는 메소드로
			//만약에 생성하는곳에 파일이 있으면 생성하지ㅏ않고
			//exception발생/없으면 true리턴
											//중복이 있는지없는지 체크하는것이 여기 null이아닌 파일명이 있는지없는지만 확인
											//newFIle에 경로(getParentFile)와이름을 둘이 체크하고 확인하고 리턴한다. 
			boolean flag=newFile.createNewFile();
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

}
