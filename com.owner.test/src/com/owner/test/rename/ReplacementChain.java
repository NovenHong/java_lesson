package com.owner.test.rename;

import java.util.HashMap;
import java.util.Map;

public class ReplacementChain {
	
	private Map<String,String> map;

	public ReplacementChain() {
		this.map = new HashMap<String,String>();
	}
	
	public Map<String,String> getMap() {
		return map;
	}
	
	public ReplacementChain addRegulation(String oldStr,String newStr) {
		this.map.put(oldStr, newStr);
		return this;
	}
}
