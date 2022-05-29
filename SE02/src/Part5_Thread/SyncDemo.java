package Part5_Thread;

/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一个临界资源时，由于线程的切换不确定，导致操作顺序出现混乱而引发的各种逻辑错误
 * 临界资源：操作该资源的完整的过程同一时刻只能有单线程
 */
public class SyncDemo {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(true) {
                    int bean = table.getBeans();
                    System.out.println(getName() + " There has " + bean + " on table");
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while(true) {
                    int bean = table.getBeans();
                    System.out.println(getName() + " There has " + bean + " on table");
                }
            }
        };
        t1.start();
        t2.start();
    }


}

/**
 * 模拟桌子
 */
class Table{
    private int beans = 20;
    public synchronized int getBeans(){
        if (beans < 0){
            throw new RuntimeException("There has no beans on table");
        }
        return beans--;
    }
}
