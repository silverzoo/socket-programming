package tcp;

import java.io.*;
import java.net.Socket;

public class TCPclient {
    public static void main(String[] args) throws IOException {
        String sentence;
        String modiSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("서버에 보낼 메시지를 입력하세요: ");
        sentence = inFromUser.readLine();

        outToServer.writeBytes(sentence + '\n');
        modiSentence = inFromServer.readLine();

        System.out.println("서버로부터의 응답: " + modiSentence);
        clientSocket.close();
    }
}
