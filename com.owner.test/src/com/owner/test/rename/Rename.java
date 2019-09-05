package com.owner.test.rename;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

public class Rename {
	
	public static void MultiRename(String dirpath,ReplacementChain chain) {
		
		File file = new File(dirpath);
		
		String[] list = file.list();
		
		for(String filename : list) {
			
			String oldname = filename;
			
			Map<String, String> map = chain.getMap();
			for(Entry<String, String> entry : map.entrySet()) {
				filename = filename.replace(entry.getKey(), entry.getValue());
			}
			
			File oldfile = new File(dirpath + "\\" + oldname);
			
			oldfile.renameTo(new File(dirpath + "\\" + filename));
			
		}
		
		System.out.println("Rename all file success!");
	}

	public static void main(String[] args) {
		
		ReplacementChain chain = new ReplacementChain();
		
		chain.addRegulation("%replacement%-", "");
		
		Rename.MultiRename("test", chain);
	}

}
