package com.spike.logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Invoking  " + invocation.getMethod());
        invocation.proceed();
        System.out.println("[Done] Invoking Class " + invocation.getClass() + " with params " + invocation.getArguments());
        return null;
    }
}
