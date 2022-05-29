package Part5_Thread;

/**
 * 同步块的应用
 *
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        shop shop = new shop();
        Thread t1 = new Thread("Thread1"){
            @Override
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread("Thread2"){
            @Override
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

// 定义一个商店类
class shop{
    public void buy(){
        try {
            Thread t = Thread.currentThread(); // 获取buy方法的线程对象
            System.out.println(t.getName() + "正在挑衣服 ... ");
            Thread.sleep(5000);
            /**
             * 同步块在使用时，需注意要在"（）"中添加指定的同步监视器对象
             * 该对象可以是任何的引用类型
             * 只要保证多个需要同步执行该代码块的线程看到的这个对象是同一个即可
             * 实际开发中也可以结合实际情况选择的
             */
            synchronized (this){
                System.out.println(t.getName() + "正在试衣服...");
                Thread.sleep(5000);
            }
            System.out.println(t.getName() +"结账离开...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


