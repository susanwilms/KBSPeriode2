// Tiemen Nienhuis S1093024 ICTM2N
package nerdygadgets;

import com.jcraft.jsch.Channel;
import java.io.InputStream;


public class readChannelOutput {
    public static void readChannelOutput(Channel channel){
        
        byte[] buffer = new byte[1024];
        
        try{
            InputStream in = channel.getInputStream();
            String line = "";
            while (true){
                while (in.available() > 0) {
                    int i = in.read(buffer, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    line = new String(buffer, 0, i);
                    System.out.println(line);
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
        }catch(Exception e){
        System.out.println("Error while reading channel output: "+ e);
        }
    }
}
