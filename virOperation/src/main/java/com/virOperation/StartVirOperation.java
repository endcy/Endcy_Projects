package com.virOperation;

import com.virOperation.core.TaskThread;
import com.virOperation.utils.PropertiesUtil;

public class StartVirOperation {
    public static void main(String[] args) {
        PropertiesUtil.initProperties();
        TaskThread taskThread = new TaskThread();
        taskThread.run();
    }
}
