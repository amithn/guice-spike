package com.spike.logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class LoggingInterceptor implements MethodInterceptor {
    org.slf4j.Logger logger = LoggerFactory.getLogger("LOG");

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("Invoking "+ invocation.getMethod().getName() +"  on  " +
                LoggerUtil.getClassname(invocation.getMethod().toString()));
        long startTime = System.currentTimeMillis();
        invocation.proceed();
        long endTime = System.currentTimeMillis();

        logger.info("Finished executing " + invocation.getMethod().getName() +
                "() on " + LoggerUtil.getClassname(invocation.getMethod().toString()) + " in " + (endTime - startTime) + " milliseconds ");
        return null;
    }


}
