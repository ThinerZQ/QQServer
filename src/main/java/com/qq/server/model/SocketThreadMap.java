/**
 * ����һ��������������ߵ��û����׽��ֵ�HashMap
 */

package com.qq.server.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SocketThreadMap {

    public static Map hm = new ConcurrentHashMap<String, ServerConnectThread>();

    public static void addClientThread(String userId, ServerConnectThread sct) {
        hm.put(userId, sct);
    }

    public static ServerConnectThread getClientThread(String userId) {
        return (ServerConnectThread) hm.get(userId);
    }

}
