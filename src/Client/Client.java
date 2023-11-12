package Client;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Client {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1024];

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donnez votre nom et prénom : ");
        String message = scanner.nextLine();
        byte[] data = message.getBytes();
        InetAddress adresseDest = InetAddress.getByName("localhost");
        DatagramPacket paquet = new DatagramPacket(data, data.length, adresseDest, PORT);
        DatagramSocket socket = new DatagramSocket();
        socket.send(paquet);
        DatagramPacket recu = new DatagramPacket(buffer, buffer.length);
        socket.receive(recu);
        System.out.println(new String(recu.getData(), 0, recu.getLength()));
        System.out.println("Adresse : " + recu.getAddress());
        System.out.println("Port : " + recu.getPort());
    }
}