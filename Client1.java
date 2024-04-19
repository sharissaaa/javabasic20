import java.io.*;
import java.net.*;
class Client1
{
    public static void main(String args[])
    {
        try{
            Socket as;
            DataInputStream sin;
            DataOutputStream sout;
            as=new Socket("localhost",1234);
            sin=new DataInputStream(as.getInputStream());
            sout=new DataOutputStream(as.getOutputStream());
            String str=sin.readUTF();
            System.out.println("server says:"+str);
            sout.writeUTF("bye");
            System.in.read();



        }catch(Exception e)
        {

        }
    }
}