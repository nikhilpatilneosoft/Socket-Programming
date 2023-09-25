package SocketProgramming;

import java.net.ServerSocket;

public class SocketServer {

    public static void main(String[] args) {

        System.out.println("Wating for client...");

        try
        {
            ServerSocket serverSocket = new ServerSocket(1234);
            serverSocket.accept();
            System.out.println("connected to client");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }

}
