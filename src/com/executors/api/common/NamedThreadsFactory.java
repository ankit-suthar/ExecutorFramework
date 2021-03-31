package com.executors.api.common;

import com.sun.istack.internal.NotNull;
import java.util.concurrent.ThreadFactory;

public class NamedThreadsFactory implements ThreadFactory {

    private static int count=0;
    private static String NAME="MyThread-";

    @Override
    public Thread newThread(@NotNull Runnable r) {
        Thread t = new Thread(r,NAME+ ++count);
        return t;
    }
}
