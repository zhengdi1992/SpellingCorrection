package com.alardear.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CompressLogAspect implements InvocationHandler {

	private Object target;

	public CompressLogAspect(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String instanceName = target.getClass().getName().substring(target.getClass().getName().lastIndexOf(".") + 1);
		String methodName = method.getName();
		Object result = null;
		System.out.println("------" + instanceName + "-------" + methodName + "-----before------------------");
		System.out.println("before size = " + ((byte[]) args[0]).length);
		Long start = System.nanoTime();
		result = method.invoke(target, args);
		Long end = System.nanoTime();
		System.out.println("after size = " + ((byte[]) result).length);
		System.out.println("time uesd = " + (end - start) / 1000 + "us");
		System.out.println("------" + instanceName + "-------" + methodName + "-----end------------------");
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),
				this);
	}
}
