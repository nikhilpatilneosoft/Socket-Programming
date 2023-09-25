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

            String exit = "y";
            int input = 0, flag = 1;

            while(!exit.equals("n"))
            {
                System.out.print("Please enter the number for fibonacci: ");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                try {
                    input = Integer.parseInt(br.readLine());
                }
                catch (NumberFormatException x)
                {
                    System.out.println("Invalid input. It's not a number.");
                }

                flag = 0;

                while(flag == 0)
                {
                    if(input >= Integer.MIN_VALUE && input <= Integer.MAX_VALUE)
                        flag = 1;
                    else
                    {
                        System.out.println("Please enter a valid number");
                        input = Integer.parseInt(br.readLine());
                    }
                }

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(input);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(in.readLine());

                System.out.println("Do you want to continue? (y/n)");
                exit = br.readLine();

                if(exit == "n")
                {
                    out.println(exit);
                    System.out.println("Closing client.");
                }

                System.out.println("--------------------------------------------------------");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

