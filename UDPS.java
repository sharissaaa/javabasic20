import java.io.*;
import java.net.*;

class UDPS {
    public static void main(String args[]) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        try {
            ds = new DatagramSocket(1234);
            byte[] buffer = new byte[1000];
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            System.out.println("From client: " + new String(dp.getData(), 0, dp.getLength()));
            System.out.println("Client port: " + dp.getPort());
            
            // Prepare the reply message
            String replyMessage = "from server ok";
            byte[] replyBuffer = replyMessage.getBytes();
            DatagramPacket reply = new DatagramPacket(replyBuffer, replyBuffer.length, dp.getAddress(), dp.getPort());
            ds.send(reply);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } finally {
            if (ds != null)
                ds.close();
        }
    }
}