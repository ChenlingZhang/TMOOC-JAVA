package Part5_Thread;

public class SyncDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Boo.dosome();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Boo.dosome();
            }
        }; 
        t1.start();
        t2.start();
    }
}
class Boo{
    public synchronized static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ": 正在执行dosome方法...");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(t.getName()+": 执行完毕！");
    }
}
