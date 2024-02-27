package org.features.storage.eight;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutingThreadsUsingExecutor {
    public static void main(String[] args) {
        CardRecords cardRecords=new CardRecords();
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(cardRecords);
        ThreadPoolExecutor poolExecutor= (ThreadPoolExecutor) executor;
        poolExecutor.shutdown();
    }
}
