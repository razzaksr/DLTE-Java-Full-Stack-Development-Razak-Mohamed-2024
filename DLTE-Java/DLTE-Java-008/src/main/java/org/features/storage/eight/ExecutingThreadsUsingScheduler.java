package org.features.storage.eight;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutingThreadsUsingScheduler {
    public static void main(String[] args) {
        CardRecords cardRecords=new CardRecords();
        ScheduledExecutorService service= Executors.newScheduledThreadPool(1);
        ScheduledFuture future = service.scheduleAtFixedRate(cardRecords,2,3, TimeUnit.SECONDS);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(true);
                service.shutdown();
            }
        },15,TimeUnit.SECONDS);
    }
}
