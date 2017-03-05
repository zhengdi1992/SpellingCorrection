package com.alardear.dictionary;

import java.util.List;

public interface WordsDict {
	void refreash(List<String> words);
	
	String find(String word);
	
}
