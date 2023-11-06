package com.corso.dao;

import java.util.List;
import com.corso.model.StandardWord;

public class StandardWordDAO extends BaseDAO{
	
	@SuppressWarnings("unchecked")
	public List<StandardWord> findAllSW() {
		return (List<StandardWord>) super.all(StandardWord.class);
		
	}

}
