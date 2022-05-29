package Part5_Thread;

public class SyncDemo4 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                foo.methodA();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                foo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}

class Foo{
    public synchronized void methodA(){
        Thread thread = Thread.currentThread(); // 运行A方法的线程
        System.out.println(thread.getName() +" ：正在执行A方法");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(thread.getName()+": 执行A方法完毕！");
    }

    public synchronized void methodB(){
        Thread thread = Thread.currentThread(); // 运行B方法的线程
        System.out.println(thread.getName() +" ：正在执行B方法");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(thread.getName()+": 执行B方法完毕！");
    }
}