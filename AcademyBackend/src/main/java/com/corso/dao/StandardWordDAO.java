package com.corso.dao;

import java.util.ArrayList;
import java.util.List;

import com.corso.model.StandardWord;

public class StandardWordDAO extends BaseDAO{
	
	@SuppressWarnings("unchecked")
	public List<StandardWord> findAllSW() {
		return (List<StandardWord>) super.all(StandardWord.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<StandardWord> findAllSWByDifficult(int dif) {
		List<StandardWord> list = new ArrayList<StandardWord>();
		for(StandardWord sw: (List<StandardWord>) super.all(StandardWord.class)) {
			if(sw.getDifficolta()==dif) {
				list.add(sw);
			}
		}
		return list;
	}
	
	public StandardWord findByCommon(String common) {
		return (StandardWord) super.findOneByAttribute(StandardWord.class, "Common", common);
	}

}
