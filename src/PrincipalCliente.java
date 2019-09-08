
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalCliente {

    public static void main(String[] args) throws IOException {
        iniciarCliente(args[0]);
       /* Socket socket = new Socket("127.0.0.1",Integer.parseInt(args[0]));
        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String datos;
        String datosEntrada = "";
        String todo = "";
        Scanner scanner = new Scanner(System.in);
        datos = scanner.nextLine();
        escritor.println(datos);
        //while (true) {
            datosEntrada = lector.readLine();
            if ((datosEntrada.equals(""))) {
                System.exit(0);
            }
            System.out.println(datosEntrada);
       // }*/

    }
    public static void iniciarCliente(String puerto){
        try {
            CrearCliente(puerto);
        } catch (Exception e) {
           System.out.println("Error al iniciar cliente "+e);
        }
    }
    public static void CrearCliente(String puerto){
        try {
            Socket socket = new Socket("127.0.0.1",Integer.parseInt(puerto));
            ConfigurarCliente(socket);
        } catch (IOException ex) {
             System.out.println("Error al crear socket "+ex);
        }
    }
    public static void ConfigurarCliente(Socket socket){
        PrintWriter escritor = null;
        try {
            escritor = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            System.out.println("Error al crear escritor "+ex);
        }
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            System.out.println("Error al crear lector "+ex);
        }
        String datos;
        String datosEntrada = "";
        String todo = "";
        Scanner scanner = new Scanner(System.in);
        datos = scanner.nextLine();
        escritor.println(datos);
        while (true) {
        try {
            //while (true) {
            datosEntrada = lector.readLine();
        } catch (IOException ex) {
            System.out.println("Error al leer respuesta "+ex);
        }
            if ((datosEntrada.equals(""))) {
                System.exit(0);
            }
            System.out.println(datosEntrada);
         }
    }

}
