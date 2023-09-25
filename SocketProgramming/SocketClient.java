package SocketProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {

        System.out.println("want to connect to server");

        try
        {
            Socket socket = new Socket("127.0.0.1", 1234);
            System.out.println("connected to server");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please entrer the data you want to send.");
            String str = br.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}

