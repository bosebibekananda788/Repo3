package com.therealdemo.Request;

import java.util.List;

public class InQueryRequest {
	
	private List<String> firstNames;
	
	protected InQueryRequest() {};

	public List<String> getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(List<String> firstNames) {
		this.firstNames = firstNames;
	}

}
