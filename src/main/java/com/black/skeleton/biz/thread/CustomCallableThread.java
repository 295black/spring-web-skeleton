package com.black.skeleton.biz.thread;

import java.util.concurrent.Callable;

public class CustomCallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "I am a CustomCallableThread~";
    }
}