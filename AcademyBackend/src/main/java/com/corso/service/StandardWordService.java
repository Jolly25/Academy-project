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
	
	public List<String> getRandomStandardWords(int n, int d) {
		List<StandardWord> allsw = dao.findAllSWByDifficult(d);
		List<String> randomlist = new ArrayList<>();
		while(randomlist.size() < n) {
			int randomNum = (int)(Math.random() * allsw.size());
			String swtoadd = allsw.get(randomNum).getValue();
			if(!randomlist.contains(swtoadd)) randomlist.add(swtoadd);
		}
		return randomlist;
	}
	
	public String getCCA2FromCommon(String common) {
		StandardWord sw = dao.findByCommon(common);
		return sw.getCca2();
	}
	
	public void setDao(StandardWordDAO dao) {
		this.dao = dao;
	}
}
