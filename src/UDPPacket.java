import java.net.SocketAddress;

public class UDPPacket {
    private byte[] payload;
    private SocketAddress address;

    public UDPPacket(byte[] payload, SocketAddress address) {
        this.payload = payload;
        this.address = address;
    }

    public UDPPacket(byte[] payload) {
        this.payload = payload;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public SocketAddress getAddress() {
        return address;
    }

    public void setAddress(SocketAddress address) {
        this.address = address;
    }
}
