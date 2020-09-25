package com.company.proxy;

import java.util.Arrays;
import java.util.Objects;

public class MethodPair {

    private String methodName;
    private Object[] args;

    public MethodPair(String methodName, Object[] args) {
        this.methodName = methodName;
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodPair pair = (MethodPair) o;
        return Objects.equals(methodName, pair.methodName) &&
                Arrays.equals(args, pair.args);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(methodName);
        result = 31 * result + Arrays.hashCode(args);
        return result;
    }
}
