/**
 * ���Ƿ������˵Ŀ��ƽ��棬������ɺܶ๦��
 */
package com.qq.server.view;

import com.qq.server.model.MyQQServer;

import javax.swing.*;

import java.awt.event.*;

public class MyServerPanel extends JFrame implements ActionListener {

    JPanel jp1;
    JButton jb1, jb2;

    public static void main(String[] args) {

        MyServerPanel msp = new MyServerPanel();
    }

    public MyServerPanel() {

        jp1 = new JPanel();
        jb1 = new JButton("Start");
        jb1.addActionListener(this);
        jb2 = new JButton("Stop");

        jp1.add(jb1);
        jp1.add(jb2);

        this.add(jp1);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            MyQQServer ms = new MyQQServer();
        }

    }

}
