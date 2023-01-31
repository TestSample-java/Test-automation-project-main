package com.org.ita.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryAnalyser implements IRetryAnalyzer {
    private static final int retryLimit = 2;
    private final AtomicInteger counter = new AtomicInteger((retryLimit));

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean retry = false;
        if (isRetryAvailable()) {
            retry = true;
            counter.decrementAndGet();
        }

        return retry;
    }

    private boolean isRetryAvailable() {
        return counter.intValue() > 0;
    }
}
