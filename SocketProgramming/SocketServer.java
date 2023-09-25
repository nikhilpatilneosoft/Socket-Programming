package SocketProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {

        System.out.println("Wating for client...");

        try
        {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            System.out.println("connected to client");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String output = br.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Server says:" + output);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }

}
