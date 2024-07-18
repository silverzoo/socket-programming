package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPclient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            //현재 기기의 주소: 도메인은 localhost == 로컬 IP는 127.0.0.1
            //InetAddress IPAddress = InetAddress.getByName("localhost");
            InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

            String hostName = IPAddress.getHostName();
            String hostAddress = IPAddress.getHostAddress();

            byte[] sendData = new byte[1024];
            String sentence = "Hello, server!";
            System.out.println("호스트 이름은: " + hostName);
            System.out.println("호스트 주소는: " + hostAddress);

            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String modiSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("서버 메시지: " + modiSentence);
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
