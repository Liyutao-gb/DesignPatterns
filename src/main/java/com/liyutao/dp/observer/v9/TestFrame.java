package com.liyutao.dp.observer.v9;

import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @auther lytstart
 * @create 2020-02-23-23:11
 */
public class TestFrame extends Frame {
    public void launch() {
        Button b = new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();
        this.setLocation(400, 400);
//        this.addWindowListener((WindowAdapter) windowClosing(e) {System.exit(0); });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }


    private class MyActionListener implements ActionListener, com.liyutao.dp.observer.v9.ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed!");
        }

        @Override
        public void actionPerformed(com.liyutao.dp.observer.v9.ActionEvent e) {

        }
    }

    private class MyActionListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed2!");
        }
    }
}
