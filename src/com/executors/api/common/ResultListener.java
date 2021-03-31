package com.executors.api.common;

public interface ResultListener<T> {

    void notifyResult(T result);
}
