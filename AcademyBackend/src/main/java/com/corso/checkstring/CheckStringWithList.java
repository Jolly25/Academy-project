package com.corso.checkstring;

import java.util.Set;

import com.corso.standardwords.StandardWords;
import com.corso.standardwords.StandardWordsFromDB;
import com.corso.standardwords.StandardWordsFromTxt;

public abstract class CheckStringWithList extends CheckString{

	private Set<String> countrylist;
	
	public CheckStringWithList(CheckString next) {
		super(next);
		//StandardWords sw = new StandardWordsFromDB();
		StandardWords sw = new StandardWordsFromTxt("bla");
		countrylist = sw.getStandardWords();
	}
	
	public CheckStringWithList() {
		super();
		//StandardWords sw = new StandardWordsFromDB();
		StandardWords sw = new StandardWordsFromTxt("bla");
		countrylist = sw.getStandardWords();
	}

	@Override
	protected String checkimpl(String input) {
		for(String s : countrylist) {
			if(internalcheck(s, input)) return s;
		}
		return null;
	}

	protected abstract boolean internalcheck(String s, String input);

}
