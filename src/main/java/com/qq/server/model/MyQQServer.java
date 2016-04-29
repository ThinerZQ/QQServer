/**
 * 锟斤拷锟斤拷QQ锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟节硷拷锟斤拷锟饺达拷某锟斤拷QQ锟酵伙拷锟斤拷锟斤拷锟斤拷锟斤拷
 */
package com.qq.server.model;

import com.qq.common.Massage;
import com.qq.common.User;

import java.net.*;
import java.io.*;

public class MyQQServer {


    public MyQQServer() {

        try {

            System.out.println("Start Server on port : 9999 ");
            ServerSocket ss = new ServerSocket(9999);

            while (true) {

                Socket s = ss.accept();

                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                User u = (User) ois.readObject();

                System.out.println("User try login：" +u.toString());

                Massage m = new Massage();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                if (u.getPassWord().equals("123")) {

                    m.setMassageType("1");
                    oos.writeObject(m);

                    //Start Thread to deal this socket
                    ServerConnectThread sct = new ServerConnectThread(s);
                    // 缓存线程
                    SocketThreadMap.addClientThread(u.getUserId(), sct);
                    // 启动线程
                    sct.start();
                    System.out.println("User login success：" +u.toString());
                } else {
                    m.setMassageType("2");
                    oos.writeObject(m);
                    s.close();
                    System.out.println("User login failed：" +u.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
