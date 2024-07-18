package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class UDPserver {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            while(true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("수신된 클라이언트 메시지: " + msg);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                socket.close();
            }
        }
    }
}
