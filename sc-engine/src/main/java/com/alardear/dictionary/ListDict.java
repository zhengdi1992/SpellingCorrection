package com.alardear.dictionary;

import java.util.List;
import java.util.Optional;

/**
 * 简单list构建的字典
 * @author http://zhengdi1992.github.io/
 *
 */
public class ListDict implements WordsDict{
	private List<String> dict;
	
	@Override
	public String find(String word){
		Optional<String> any = dict.stream().parallel().filter(w -> w.equals(word)).findAny();
		return any.isPresent()? any.get() : "";
	}

	@Override
	public void refreash(List<String> words) {
		dict = words;
		
	}
	
}
