
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PrincipalCliente {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 2500);
        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String datos;
        String datosEntrada = "";
        String todo = "";
        Scanner scanner = new Scanner(System.in);
        datos = scanner.nextLine();
        escritor.println(datos);
        while (true) {
            datosEntrada = lector.readLine();
            if ((datosEntrada.equals(""))) {
                System.exit(0);
            }
            System.out.println(datosEntrada);
        }

    }

}
