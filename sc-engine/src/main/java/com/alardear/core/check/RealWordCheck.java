package com.alardear.core.check;

import java.util.List;

/**
 * 
 * @author http://zhengdi1992.github.io/
 * 拼写错误后的词仍然是合法的情况，
 * 如将“there”错误拼写为“three”（形近），
 * 将“peace”错误拼写为“piece”（同音），
 * 将“two”错误拼写为“too”（同音）。
 * 拼写纠错Spelling Error Correction：自动纠错，如把“hte”自动校正为“the”，
 * 或者给出一个最可能的拼写建议，甚至一个拼写建议列表。
 */
public class RealWordCheck extends NonWordCheck{
	
	public WordItem adviceBest(String word){
		return null;
	}
	
	public List<WordItem> advice(String word){
		return null;
	}
	
	class WordItem{
		private String value;
		private double probability;
	}
}
