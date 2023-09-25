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

            String input = "y";

            while(!input.equals("n"))
            {
                input = br.readLine();

                if(input.equals("n"))
                    break;

                int integerInput = Integer.parseInt(input);

                int output = fibo(integerInput);

                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println("Server says: " + output);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int fibo(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }

}
