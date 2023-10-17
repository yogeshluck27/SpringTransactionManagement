package com.springtxn.aspects;

import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

@Component
@Aspect
public class DataSourceAspect {
	//This class is added to check which methods are getting executed internally when we are adding @Transactional annotation
	// getConnection/commit/close methods of javax.sql.DataSource class will be executing internally.
	
	@Around("target(javax.sql.DataSource)")
	public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("Datasource Tracker : "+proceedingJoinPoint.getSignature());
		Object returnValue = proceedingJoinPoint.proceed(); //method will get executed
		Connection con = (Connection) Proxy.newProxyInstance(SQLServerConnection.class.getClassLoader(), new Class[]{Connection.class}, 
				new ConnectionInvocationHandler((Connection) returnValue));
		return con;
		
	}
}
