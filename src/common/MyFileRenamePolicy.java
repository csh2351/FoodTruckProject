package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {
		
	@Override
	public File rename(File oldFile) {
		File newFile = null;
		do {
			//현재 시간을 가져오는 메소드
			long currentTime=System.currentTimeMillis();
			//날짜형식으로 밀리세컨까지 표시
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			//0~999까지의 임의의 수 발생!
			int rndNum = (int)(Math.random()*1000);
			
			String oldName = oldFile.getName();
			String ext="";
			int dot = oldName.indexOf(".");
			if(dot>-1) 
			{
				ext = oldName.substring(dot);
			}
			String newName = sdf.format(currentTime)+"_"+rndNum+ext;
			newFile=new File(oldFile.getParent(), newName); //getParent() 현재 파일이 들어갈 위치 경로, 부모 디렉토리
			
			
		}while(!createFile(newFile));
		
		return newFile;
	}
	
	public boolean createFile(File newFile) {
		try
		{
			//createNewFile() : 파일을 생성하는 메소드로
			//만약에 생성하는 곳에 파일이 있으면 생성하지 않고 exception 발생, 없으면 true 리턴
			
			return newFile.createNewFile();
			
		} catch(IOException e)
		{
			return false;
		}
	}
}
