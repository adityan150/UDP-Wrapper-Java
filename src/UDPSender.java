import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDPSender {
    private DatagramSocket socket;

    public UDPSender() {
        try {
            socket = new DatagramSocket();
            socket.setReuseAddress(true);
        } catch (SocketException exp) {
            System.out.println("Exception occurred when creating socket: ");
            exp.printStackTrace();
        }
    }

    public void send(byte[] data, int destinationPort) {
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress(destinationPort));

        try {
            socket.send(packet);
            System.out.println("Packet sent: " + packet.toString());
        } catch (IOException exp) {
            System.out.println("Failed to send packet: " + packet.toString());
            exp.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UDPSender server = new UDPSender();
        server.send("Hello".getBytes(StandardCharsets.UTF_8), 9876);
    }
}
