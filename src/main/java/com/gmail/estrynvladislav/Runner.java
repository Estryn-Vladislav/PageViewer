package com.gmail.estrynvladislav;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static final String URL = "https://www.stihi.ru/avtor/estrin1994est";

    public static void main(String[] args) {
        CheckPageTask task = new CheckPageTask(URL);
        Executor.start(task);
    }

    private static class Executor {
        static void start(CheckPageTask task) {
            ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            for (int i = 0; i < 10000; i++) {
                service.execute(task);
            }
            service.shutdown();
        }
    }
}