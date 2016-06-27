package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 08.02.16.
 */
public class LoginPacket extends ToServerPacket {

    public Short index;

    public void get(ByteBuf buffer) {
        index = buffer.readShort();
    }

    public void send(ByteBuf buffer) {
        buffer.writeShort(index);
    }

    public eServerPackets getType()
    {
        return eServerPackets.LOGIN;
    }

    public Short getIndex() {
        return index;
    }

    public void setIndex(Short index) {
        this.index = index;
    }
}