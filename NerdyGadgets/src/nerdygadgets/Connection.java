// Tiemen Nienhuis S1093024 ICTM2N
/*package nerdygadgets;

import com.jcraft.jsch.*;
import java.awt.*;
import javax.swing.*;
import com.jcraft.jsch.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import static java.lang.System.in;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection extends readChannelOutput {
    private Session session;

    private String user;
    private String host;
    private String password;
    private String command;
    public String result;

    
    public Connection(String user, String host, String password) {
//        Stelt goede gebruiker in
        if(user == "1") {
            this.user = "student";
        } else {
            this.user = user;
        }
        
//        Stelt goede IP-adres in
        this.host = "145.44.234." + host;
        
//        Stelt goede wachtwoord in
        if(password == "1") {
            this.password = "Welkom01!";
        } else {
            this.password = password;
        }
        
        try {
        this.open(this.user, this.host, this.password);

//        System.out.print(result);
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void open(String username, String hostname, String password) throws JSchException{

        JSch jSch = new JSch();

        session = jSch.getSession(username, hostname, 22);
        Properties config = new Properties(); 
        config.put("StrictHostKeyChecking", "no");  // not recommended
        session.setConfig(config);
        session.setPassword(password);

        session.connect();
        System.out.println("Connected!");
    }

    public String runCommand(String command) throws JSchException, IOException {
//        Steld goede commando in
        if(command == "cpu") {
            command = "grep 'cpu ' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)}  {print usage}'";
        } else if(command == "disk") {
            command = "df -hl | awk '/^\\/dev\\/sd[ab]/ { sum+=$5 } END { print sum }'";
        } else if(command == "time") {
            command = "uptime | awk -F'( |,|:)+' '{print $6,$7\",\",$8,\"hours,\",$9,\"minutes.\"}'";
        } else {
            command = command;
        }
        
        if (!session.isConnected())
            throw new RuntimeException("Not connected to an open session.  Call open() first!");

        ChannelExec channel = null;
        channel = (ChannelExec) session.openChannel("exec");

        channel.setCommand(command);
        channel.setInputStream(null);

        InputStream in = channel.getInputStream();

        channel.connect();
        String result = getChannelOutput(channel, in);
        channel.disconnect();
        
        if(command == "disk") {
            result = result.split("utes")[0];
        }
        return result;
    }


    private String getChannelOutput(Channel channel, InputStream in) throws IOException{

        byte[] buffer = new byte[1024];
        StringBuilder strBuilder = new StringBuilder();

        String line = "";
        while (true){
            while (in.available() > 0) {
                int i = in.read(buffer, 0, 1024);
                if (i < 0) {
                    break;
                }
                strBuilder.append(new String(buffer, 0, i));
            }

            if(line.contains("logout")){
                break;
            }

            if (channel.isClosed()){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee){}
        }

        return strBuilder.toString();   
    }
    
    public void close() {
        session.disconnect();
        System.out.println("Disconnected!");
    }

}*/