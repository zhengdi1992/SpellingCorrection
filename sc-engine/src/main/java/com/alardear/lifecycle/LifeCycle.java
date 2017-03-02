package com.alardear.lifecycle;
/**
 * 预设组件生命周期接口,统一管理组件的生命周期及其生命周期事件
 * @author http://zhengdi1992.github.io/
 *
 */
public interface LifeCycle {
	void init();
	void start();
	void stop();
	void destory();
}
