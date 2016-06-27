package ToClient;

import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by Wed on 14.03.16.
 */
public abstract class ToClientPacket {

    public static ToClientPacket read(ByteBuf buffer) throws IOException {
        if(!buffer.isReadable())
            return null;
        int id = buffer.readUnsignedShort();
        ToClientPacket packet = parse(id);
        if(packet == null)
            throw new IOException("Bad packet ID: " + id);
        packet.get(buffer);
        return packet;
    }

    private static ToClientPacket parse(int id)
    {
        switch (eServerPackets.get(id))
        {
            case LOGIN:
            default: return null;
        }
    }

    public abstract void get(ByteBuf buffer);

    public abstract eClientPackets getType();

    public abstract void send(ByteBuf buffer);
}

