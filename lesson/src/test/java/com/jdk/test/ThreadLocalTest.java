package com.jdk.test;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest {

	public static void main(String[] args) {
		
		ThreadLocal<Map> threadLocal = new ThreadLocal<>();
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("name", "nana1");
		
		threadLocal.set(map);
		
		//threadLocal.remove();
		
		Map getMap = threadLocal.get();
		
		System.out.println(getMap);

	}

}
