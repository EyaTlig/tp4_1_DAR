package Server;
import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 1234;
    private static byte[] data = new byte[1024];

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(PORT);
        System.out.println("Lancement du serveur");

        while (true) {
            DatagramPacket paquet = new DatagramPacket(data, data.length);
            socket.receive(paquet);
            String msg = new String(paquet.getData(), 0, paquet.getLength());
            System.out.println(paquet.getAddress() + " : " + msg);
            String reponse = "Bienvenue " + msg;
            DatagramPacket envoi = new DatagramPacket(reponse.getBytes(), reponse.length(), paquet.getAddress(), paquet.getPort());
            socket.send(envoi);
        }
    }
}