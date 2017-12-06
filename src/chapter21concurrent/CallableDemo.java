package chapter21concurrent;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/6
 * Mail:zhengjun1987@outlook.com
 */
class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("TaskWithResult.call  " + Thread.currentThread().getName());
        return "result of TaskWithResult "+id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> future : futures) {
            try {
                String s = future.get();
                System.out.println("future.get() = " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
//        TaskWithResult.call  pool-1-thread-1
//        TaskWithResult.call  pool-1-thread-2
//        TaskWithResult.call  pool-1-thread-5
//        TaskWithResult.call  pool-1-thread-4
//        TaskWithResult.call  pool-1-thread-3
//        TaskWithResult.call  pool-1-thread-6
//        TaskWithResult.call  pool-1-thread-7
//        TaskWithResult.call  pool-1-thread-2
//        TaskWithResult.call  pool-1-thread-7
//        future.get() = result of TaskWithResult 0
//        TaskWithResult.call  pool-1-thread-6
//        future.get() = result of TaskWithResult 1
//        future.get() = result of TaskWithResult 2
//        future.get() = result of TaskWithResult 3
//        future.get() = result of TaskWithResult 4
//        future.get() = result of TaskWithResult 5
//        future.get() = result of TaskWithResult 6
//        future.get() = result of TaskWithResult 7
//        future.get() = result of TaskWithResult 8
//        future.get() = result of TaskWithResult 9
    }
}
