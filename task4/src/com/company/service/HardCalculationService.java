package com.company.service;

import com.company.proxy.annotations.CachedMethod;

public class HardCalculationService implements Service {
    @Override
    @CachedMethod
    public int doHardWork(int params) throws InterruptedException {
        Thread.sleep(5000); // Имитация сложнейших вычислений.
        return 1489229 * params;
    }
}
