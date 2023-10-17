package com.springtxn.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

//Dynamic Proxy for ConnectionImpl Object
//Nobody can call ConnectionImpl object directly
//If any internal call is happening through this object it will go through the proxy
//which can log which method is being called (commit/rollback/close)
public class ConnectionInvocationHandler implements  org.springframework.cglib.proxy.InvocationHandler {

	private Connection connection;

	public ConnectionInvocationHandler(Connection connection) {
		this.connection = connection;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().contains("commit") || method.getName().contains("rollback")
				|| method.getName().contains("close")){
			System.out.println("Connection Trace ..." + method.toGenericString());

		}
		Object returnValue = method.invoke(connection, args);
		return returnValue;
	}

}
