package uta.shan.fusionBasedDS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import uta.shan.communication.Messager;
import uta.shan.communication.Util;

/**
 * Created by xz on 6/7/17.
 */
public class Listener extends Thread{
    private int port;
    private ServerSocket serverSocket;
    private Server server;
    public Listener(int port,Server server) {
        this.port = port;
        this.server = server;
    }

    public int getPort() {
        return this.port;
    }

    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    @Override
    public void run() {
        try{
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                Socket socket = serverSocket.accept();
                String request = Messager.getRequest(socket);
                if(Util.DEBUG){
                    System.out.println("get request from client: "+request);
                }
                String reply = server.handleRequest(request,socket);
                if(reply!=null)
                    Messager.sendMsg(reply,socket);
            } catch (IOException e) {
                System.out.println("server: "+server.getId()+" down!");
                break;
            }
        }
    }
}