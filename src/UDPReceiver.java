import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class UDPReceiver {
    DatagramSocket socket;

    public UDPReceiver(int port) {
        try {
            socket = new DatagramSocket(port);
            socket.setReuseAddress(true);
        } catch (SocketException exp) {
            System.out.println("Failed to create UDP client socket:");
            exp.printStackTrace();
        }
    }

    public UDPPacket receive() {
        DatagramPacket packet = new DatagramPacket(new byte[64], 64);
        try {
            socket.receive(packet);
            byte[] data = Arrays.copyOfRange(packet.getData(), 0, packet.getLength());

            UDPPacket udpPacket = new UDPPacket(data, packet.getSocketAddress());
            return udpPacket;
        } catch (IOException exp) {
            System.out.println("Failed to receive packet:");
            exp.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        UDPReceiver client = new UDPReceiver(9876);
        UDPPacket packet = client.receive();
        System.out.println(new String(packet.getPayload(), StandardCharsets.UTF_8));
        System.out.println(packet.getAddress().toString());
    }

}
