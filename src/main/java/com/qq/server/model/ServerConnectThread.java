/**
 *
 */

package com.qq.server.model;

import java.net.*;
import java.io.*;

import com.qq.common.Massage;

public class ServerConnectThread extends Thread {

    private Socket s;

    public ServerConnectThread(Socket s) {
        this.s = s;
    }

    public void run() {
        while (true) {
            try {

                ObjectInputStream ois = new ObjectInputStream(this.s.getInputStream());
                Massage m = (Massage) ois.readObject();

                System.out.println(m.getSender() + " to  " + m.getGetter() + " say: " + m.getNews());

                ServerConnectThread sct = SocketThreadMap.getClientThread(m.getGetter());

                ObjectOutputStream oos = new ObjectOutputStream(sct.s.getOutputStream());

                oos.writeObject(m);

            } catch (Exception e) {
                e.printStackTrace();

            }

        }
    }

}
