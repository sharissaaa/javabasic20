import java.io.*;
import java.net.*;
class Server1
{
    public static void main(String args[])
    {
        ServerSocket ss;
        Socket as;
        DataInputStream sin;
        DataOutputStream sout;
        try{
            ss=new ServerSocket(1234);
            as=ss.accept();
            sin=new DataInputStream(as.getInputStream());
            sout=new DataOutputStream(as.getOutputStream());
            sout.writeUTF("welcome client");
            String str=sin.readUTF();
            System.out.println("client says"+str);
            System.in.read();

        }catch(Exception e)
        {
            
        }
    }
}