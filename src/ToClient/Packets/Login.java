package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 14.03.16.
 */
public class Login extends ToClientPacket {

    private boolean allOk;

    public void send(ByteBuf buffer) {
        buffer.writeBoolean(allOk);
    }

    public void get(ByteBuf buffer) {
        allOk = buffer.readBoolean();
    }

    public eClientPackets getType()
    {
        return eClientPackets.LOGIN;
    }

    public boolean isAllOk() {
        return allOk;
    }

    public void setAllOk(boolean allOk) {
        this.allOk = allOk;
    }
}