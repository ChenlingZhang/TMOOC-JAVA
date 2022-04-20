package cn.tedu.submarine;

import javax.swing.*;

/**
 * 图片资源加载类
 */
public class ImageResources {
    public static ImageIcon battleShip;
    public static ImageIcon bomb;
    public static ImageIcon gameover;
    public static ImageIcon mine;
    public static ImageIcon minesubmarine;
    public static ImageIcon obsersubmarine;
    public static ImageIcon sea;
    public static ImageIcon start;
    public static ImageIcon torpedo;
    public static ImageIcon torpedosubmarine;

    static{
        battleShip = new ImageIcon("img/battleship.png");
        bomb = new ImageIcon("img/bomb.png");
        gameover = new ImageIcon("img/gameover.png");
        mine = new ImageIcon("img/mine.png");
        minesubmarine = new ImageIcon("img/minesubm.png");
        obsersubmarine = new ImageIcon("img/obsersubm.png");
        sea = new ImageIcon("img/sea.png");
        start = new ImageIcon("img/start.png");
        torpedo = new ImageIcon("img/torpedo.png");
        torpedosubmarine = new ImageIcon("img/torpesubm.png");
    }

    public static void main(String[] args) {
        System.out.println(battleShip.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
        System.out.println(gameover.getImageLoadStatus());
        System.out.println(mine.getImageLoadStatus());
        System.out.println(minesubmarine.getImageLoadStatus());
        System.out.println(obsersubmarine.getImageLoadStatus());
        System.out.println(sea.getImageLoadStatus());
        System.out.println(start.getImageLoadStatus());
        System.out.println(torpedo.getImageLoadStatus());
        System.out.println(torpedosubmarine.getImageLoadStatus());

    }



}
