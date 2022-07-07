package ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 线程池：
 * 1: 控制线程的数量
 * 2：复用线程
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService threadpool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Thread t = Thread.currentThread();
                    String name = t.getName();
                    System.out.println(name+":正在执行任务");
                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){

                    }
                    System.out.println(name+":执行任务完毕");
                }
            };
            //将任务交给线程池
            threadpool.execute(runnable);
            System.out.println("将一个任务交给了线程池");
        }
        threadpool.shutdown();
        System.out.println("销毁线程池");
    }
}
