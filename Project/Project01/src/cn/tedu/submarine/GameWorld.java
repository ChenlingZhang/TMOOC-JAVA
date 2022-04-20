package cn.tedu.submarine;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.event.KeyAdapter; // 键盘监听器
import java.awt.event.KeyEvent; // 键盘事件

/**
 * 游戏窗口类，负责运行游戏
 * 存放游戏相关的所有代码逻辑
 */
public class GameWorld extends JPanel{ //2. 类继承JPannel
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER =2;
    private int currentState = START;

    BattleShip ship = new BattleShip(); //战舰对象
    Bomb[] bomb = {}; // 深水炸弹对象
    SeaObject[] submarines = {}; // 代表3种潜艇
    SeaObject[] thunders = {}; //代表两种水雷

    public SeaObject createSubmarine(){
        //产生 0-20的随机数
        int randomNumber = (int)(Math.random()*20);
        if (randomNumber < 10){
            return  new ObserverSubmarine();
        }
        else if (randomNumber <15){
            return new TorpedoSubmarine();
        }
        else return new MineSubmarine();
    }
    /**
     * 将随机产生的潜艇对象 装到潜艇数组中
     */
    // 潜艇产生速度控制
    private int submarinesEnterIndex = 0;
    private int thunderEnterIndex = 0;
    public void submarinesEnterAction(){
        submarinesEnterIndex++;
        if (submarinesEnterIndex % 40 == 0)
        {
            SeaObject submarine = createSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = submarine;
        }
    }
    public void thunderEnterAction(){
        // 1. 限制雷生成的速度
        thunderEnterIndex++;
        if (thunderEnterIndex%40 == 0){
            for (int i = 0; i < submarines.length; i++) {
                SeaObject thunder = submarines[i].shootThunder();
                if (thunder != null) {
                    thunders = Arrays.copyOf(thunders, thunders.length + 1);
                    thunders[thunders.length - 1] = thunder;
                }
            }
        }

    }

    public void bombEnterAction(){
        bomb = Arrays.copyOf(bomb, bomb.length+1);
        bomb[bomb.length-1]= ship.shootBomb();
    }

    public void stepAction(){
        for (SeaObject submarine:submarines) {
            submarine.step();
        }
        for (SeaObject thunder:thunders) {
            thunder.step();
        }
        for (int i = 0; i < bomb.length; i++) {
            bomb[i].step();
        }
    }
    // 此方法是用来自动判断并删除越界对象的方法
    public void   Recycle(){
        // 1. 遍历 数组 判断是否越界
        // 2. 若成立则将当前对象剔除出数组中
        for (int i = 0; i < submarines.length; i++) {
            if (submarines[i].isNeedRecycle()|| submarines[i].isDead()){
                submarines[i] = submarines[submarines.length-1];
                submarines = Arrays.copyOf(submarines,submarines.length-1);
            }
        }
        for(int i=0; i<thunders.length;i++){
            if (thunders[i].isNeedRecycle() || thunders[i].isDead()){
                thunders[i] = thunders[thunders.length-1];
                thunders = Arrays.copyOf(thunders,thunders.length-1);
            }
        }
        for (int i = 0; i < bomb.length; i++ ) {
            if (bomb[i].isNeedRecycle() || bomb[i].isDead()){
                bomb[i] = bomb[bomb.length-1];
                bomb = Arrays.copyOf(bomb,bomb.length-1);
            }
        }
    }

    int score = 0;

    public void bombBangAction(){
        for (Bomb b: bomb) {
            for (SeaObject s: submarines) {
                if (b.isHit(s)){
                    b.Dead();
                    s.Dead();
                    if (s instanceof EnemyScore){
                        EnemyScore addScore = (EnemyScore)s;
                        score += addScore.getScore();
                    }else if(s instanceof EnemyLife){
                        EnemyLife addLife = (EnemyLife) s;
                        ship.setLife(addLife.getLife());
                    }
                }
            }
        }
    }

    public void thunderBombAction(){
        for (SeaObject thunder: thunders) {
            if (thunder.isLive() && thunder.isHit(ship)){
                thunder.Dead();
                ship.subtraceLife();
            }
        }
    }

    public void checkGameOverAction(){
        if (ship.getLife()<=0){
            currentState = GAMEOVER;
        }
    }

    public void action() {
        // 实现键盘监听事件相关逻辑代码
        KeyAdapter keyPress = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    if (currentState == START) {
                        currentState = RUNNING;
                    }

                    else if (currentState == GAMEOVER) {
                        currentState = START;
                    }

                    else {
                        bombEnterAction();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    ship.moveLeft();
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    ship.moveRight();
                }
            }
        };
        this.addKeyListener(keyPress); // 将键盘监听器添加到检测中


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (currentState == RUNNING) {
                    // 自定义的任务逻辑
                    submarinesEnterAction();
                    thunderEnterAction();
                    stepAction();
                    bombBangAction();
                    thunderBombAction();
                    checkGameOverAction();
                    Recycle();
                    // 刷新绘制
                    repaint();
                }

            }
        };
        // 1. 具体执行的任务 2. 延时多久开始执行 3. 执行第一次后下一次执行的间隔时间
        timer.schedule(task,5000,10);

    }

    // 绘制界面
    public void paintWorld(){
        // 1. 创建画框
        JFrame frame = new JFrame();
        this.setFocusable(true);
        frame.add(this); // 将当前底板添加到画框中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口
        frame.setSize(WIDTH ,HEIGHT  + 27);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // 设置窗口可见
    }


    @Override
    public void paint(Graphics g) {
        if (currentState == START){
            ImageResources.start.paintIcon(null,g,0,0);
        }
        else if (currentState == RUNNING) {
            ImageResources.sea.paintIcon(null, g, 0, 0);
            ship.paintImage(g);
            for (SeaObject submarine : submarines) {
                submarine.paintImage(g);
            }
            for (SeaObject thunder : thunders) {
                thunder.paintImage(g);
            }
            for (Bomb value : bomb) {
                value.paintImage(g);
            }

            g.drawString("Life: " + ship.getLife(), 400, 50);
            g.drawString("Score: " + score, 200, 50);
        }
        else if (currentState == GAMEOVER){
            ImageResources.gameover.paintIcon(null,g,0,0);
            submarines = new SeaObject[]{};
            bomb = new Bomb[]{};
            thunders = new SeaObject[]{};
            score = 0;
            ship.setLife(5);
        }


    }


    public static void main(String[] args) {
        GameWorld gw = new GameWorld();
        gw.paintWorld();
        gw.action();
    }




}
