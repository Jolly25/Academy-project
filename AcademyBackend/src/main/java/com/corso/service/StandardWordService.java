package com.corso.service;

import java.util.ArrayList;
import java.util.List;

import com.corso.dao.StandardWordDAO;
import com.corso.model.StandardWord;

public class StandardWordService {
	
	private StandardWordDAO dao;
	
	public List<StandardWord> findAll() {
		return dao.findAllSW();
	}
	
	public List<String> getRandomStandardWords(int n) {
		List<StandardWord> allsw = dao.findAllSW();
		List<String> randomlist = new ArrayList<>();
		while(randomlist.size() < n - 1) {
			int randomNum = (int)(Math.random() * allsw.size());
			String swtoadd = allsw.get(randomNum).getValue();
			if(!randomlist.contains(swtoadd)) randomlist.add(swtoadd);
		}
		return randomlist;
	}
	
	public void setDao(StandardWordDAO dao) {
		this.dao = dao;
	}
}
