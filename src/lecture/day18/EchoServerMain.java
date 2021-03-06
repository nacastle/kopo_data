package lecture.day18;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    java EchoServerMain 10001
*/
public class EchoServerMain {
    public static void main(String[] args) {

//        System.out.println(args.length);

//        if (args.length != 1) {
//            System.out.println("    사용법 : java EchoServerMain port 번호");
//            System.exit(0);
//        }

//        int portNo = Integer.parseInt(args[0]);

        try {
            ServerSocket server = new ServerSocket(10001);
            System.out.println("클라이언트의 접속을 기다립니다...");

            Socket client = server.accept();
            System.out.println("접속된 클라이언트 정보 : [" + client.getInetAddress() + "]");

            // 클라가 전송해준 메세지를 수신할 객체
            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            // 수신한 메세지를 클라에게 재전송할 객체
            OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);

            while (true) {
                String msg = br.readLine();
                if (msg == null) {
                    System.out.println("클라이언트 [" + client.getInetAddress() + "]과의 접속해제");
                    client.close();
                    break;
                }

                System.out.println("[" + client.getInetAddress() + "] :" + msg);

                pw.println(msg);
                pw.flush();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
