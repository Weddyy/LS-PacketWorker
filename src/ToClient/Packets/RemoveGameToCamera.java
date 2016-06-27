package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 14.03.16.
 */
public class RemoveGameToCamera extends ToClientPacket {

    private long idGame;
    private String serverId;

    public void send(ByteBuf buffer) {
        buffer.writeInt(serverId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(serverId.getBytes(Charset.forName("UTF-8")));

        buffer.writeLong(idGame);
    }

    public void get(ByteBuf buffer) {
        int countBytes=buffer.readInt();
        byte[] b=new byte[countBytes];
        buffer.readBytes(b);

        serverId = new String(b, Charset.forName("UTF-8"));
        idGame = buffer.readLong();
    }

    public eClientPackets getType()
    {
        return eClientPackets.REMOVE_GAME_TO_C;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
}