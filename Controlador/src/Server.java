
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {

    public static void main(String args[]) throws IOException, InterruptedException {

        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());


        while (true) {

            Thread.sleep(5000);
            String input = dis.readUTF();

            if (input.equals("ate logo")) {
                break;
            }

            System.out.println("Requisicao Recebida: " + input);
            String result = "Requisicao Invalida";

            StringTokenizer st = new StringTokenizer(input);

            int operation = Integer.parseInt(st.nextToken());

            int umidade = operation;

            if (umidade <= 30) {

                result = "Ligando Irrigação";

            } else if (umidade > 30) {

                result = "Irrigação não necessária";

            } else {
                System.out.println("Telemetria invalida");
            }
            System.out.println("Respondendo requisicao...");

            dos.writeUTF(result);
        }
        
    }
}
