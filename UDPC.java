import java.io.*;
import java.net.*;

class UDPC {
    public static void main(String args[]) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        try {
            ds = new DatagramSocket();
            byte[] buffer = new byte[1000];
            InetAddress shost = InetAddress.getByName("localhost"); // Added variable declaration
            String message = "Hello"; // Added a sample message
            byte[] m = message.getBytes(); // Converted message to bytes
            dp = new DatagramPacket(m, m.length, shost, 1234); // Corrected the variable name and added missing length
            ds.send(dp);
            
            // Reusing buffer for receiving reply
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            System.out.println("Reply: " + new String(dp.getData(), 0, dp.getLength())); // Trimmed unnecessary characters

        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } finally {
            if (ds != null)
                ds.close();
        }
    }
}