package com.corso.checkstring;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.standardwords.StandardWords;

public abstract class CheckStringWithList extends CheckString{	
	
	@Autowired
	private StandardWords sw;
	
	private Set<String> countrylist;

	@Override
	protected String checkimpl(String input) {
		countrylist = sw.getStandardWords();
		for(String s : countrylist) {
			if(internalcheck(s.toLowerCase(), input.toLowerCase())) return s;
		}
		return null;
	}

	protected abstract boolean internalcheck(String s, String input);

}

