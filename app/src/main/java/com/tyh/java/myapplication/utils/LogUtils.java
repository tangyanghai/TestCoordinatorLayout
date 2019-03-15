package com.tyh.java.myapplication.utils;

import android.util.Log;

/**
 * 创建人: tyh
 * 创建时间: 2019/2/27
 * 描述:
 */
public class LogUtils {
    public static void logMethod() {
        StackTraceElement[] temp = Thread.currentThread().getStackTrace();
        StackTraceElement a = temp[3];
        String className = a.getClassName();
        int start = className.lastIndexOf(".") + 1;
        Log.e("=======>" + a.getMethodName(), className.substring(start, className.length()));
    }

    public static void logWithMethod(String msg) {
        StackTraceElement[] temp = Thread.currentThread().getStackTrace();
        StackTraceElement a = temp[3];
        String className = a.getClassName();
        int start = className.lastIndexOf(".") + 1;
        Log.e("=======>" + className.substring(start, className.length())+"   "+ a.getMethodName(), msg);
    }

    public static void logWithClass(String msg) {
        StackTraceElement[] temp = Thread.currentThread().getStackTrace();
        StackTraceElement a = temp[3];
        String className = a.getClassName();
        int start = className.lastIndexOf(".") + 1;
        Log.e("=======>" + className.substring(start, className.length()), msg);
    }
}
