package com.alardear.core.check;
/**
 * 
 * @author http://zhengdi1992.github.io/
 * 拼写错误后的词本身就不合法，如错误的将“giraffe”写成“graffe”;
 */
public class NonWordCheck implements Checker{

	@Override
	public boolean match(String word) {
		// TODO Auto-generated method stub
		return false;
	}

}
