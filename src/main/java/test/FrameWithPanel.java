package main.java.test;

import java.awt.*;

/**
 * @className: FrameWithPanel
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/12/5
 **/
public class FrameWithPanel extends Frame {
    public static void main(String[] args) {
        Frame fr = new Frame("Frame with Panel");
        Panel panel = new Panel();
        fr.setSize(400,400);
        fr.setBackground(Color.BLUE);
        fr.setLayout(null);
        panel.setSize(200,200);
        panel.setBackground(Color.yellow);
        fr.add(panel);
        fr.setVisible(true);
    }
}
