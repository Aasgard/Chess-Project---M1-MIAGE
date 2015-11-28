package tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Folder extends File {
	
	private static final long serialVersionUID = 1L;
	private String path;
	
	public Folder(String p){
		super(p);
		this.path = p;
	}
	
	public String getPath(){
		return this.path;
	}
	
	public List<String> getFilesName(){
		List<String> alFilesName = new ArrayList<String>();
		File[] arrayFiles = this.listFiles();
		
		for (File file : arrayFiles) {
			alFilesName.add(file.getName());
		}
		
		return alFilesName;
	}
	
	public void printFolder(){
		System.out.println(this.getFilesName());
	}
}
