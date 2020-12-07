
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress ip = InetAddress.getLocalHost();
        int port = 4444;
        Scanner sc = new Scanner(System.in);

        Socket s = new Socket(ip, port);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        while (true) {
            Thread.sleep(5000);
            System.out.print("Digite a telemetria: ");

            String inp = sc.nextLine();

            if (inp.equals("ate logo")) {
                break;
            }

            dos.writeUTF(inp);

            System.out.println("Resposta: " + dis.readUTF());
        }
    }
}
