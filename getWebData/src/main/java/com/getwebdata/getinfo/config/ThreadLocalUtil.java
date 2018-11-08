package com.getwebdata.getinfo.config;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreadLocalUtil {
    public static ThreadLocal<ArrayList<String>> threadLocal = new ThreadLocal<ArrayList<String>>(){
        @Override
        protected ArrayList<String> initialValue() {
            return new ArrayList<>(512);
        }
    };

}
