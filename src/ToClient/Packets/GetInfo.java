package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 10.02.16.
 */
public class GetInfo extends ToClientPacket {

    public void send(ByteBuf buffer) {
    }

    public void get(ByteBuf buffer) {
    }

    public eClientPackets getType()
    {
        return eClientPackets.INFO;
    }

}