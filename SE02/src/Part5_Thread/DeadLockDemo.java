package Part5_Thread;

/**
 * 当多个线程都各自持有一个锁的同时，等待对方释放锁，就会形成死锁
 * 一种僵持状态，这种状态称之为死锁
 */
public class DeadLockDemo {
    static Object chopsticks = new Object();
    static Object spoon = new Object();

    public static void main(String[] args) {
        Thread np = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("North People start eating");
                    synchronized (chopsticks) {
                        System.out.println("North People is using Chopsticks, Start Eating...");
                        Thread.sleep(5000);
                        System.out.println("North people finished rice wanna get spoone");
                    }
                    System.out.println("North people put down chopsticks");
                    synchronized (spoon){
                        System.out.println("North people start drinking...");
                        Thread.sleep(5000);
                        System.out.println("North people finish drinking");
                    }
                    System.out.println("North people put down spoon");

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Thread sp = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("South People start drinking");
                    synchronized (spoon) {
                        System.out.println("South People is using spoon, Start drinking...");
                        Thread.sleep(5000);
                        System.out.println("South people finished soup wanna get chopsticks");
                    }
                    System.out.println("Sorth people put down spoon");
                    synchronized (chopsticks){
                        System.out.println("South people start eatting...");
                        Thread.sleep(5000);
                        System.out.println("South people finish eating");
                    }
                    System.out.println("Sorth people put down chopsticks");

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        np.start();
        sp.start();
    }
}
