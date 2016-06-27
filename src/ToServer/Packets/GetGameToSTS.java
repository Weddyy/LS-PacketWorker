package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by wed on 12.02.16.
 */
public class GetGameToSTS extends ToServerPacket {

    String ServerId;
    long gameId;

    public String getServerId() {
        return ServerId;
    }


    public long getGameId() {
        return gameId;
    }


    public void get(ByteBuf buffer) {

        gameId = buffer.readLong();

        int countBytes = buffer.readInt();
        byte[] b = new byte[countBytes];
        buffer.readBytes(b);

        ServerId = new String(b, Charset.forName("UTF-8"));
    }

    public void send(ByteBuf buffer) {
        buffer.writeLong(gameId);

        buffer.writeInt(ServerId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(ServerId.getBytes(Charset.forName("UTF-8")));

    }

    public eServerPackets getType()
    {
        return eServerPackets.GET_GAME_STS;
    }

    public void setServerId(String serverId) {
        ServerId = serverId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }
}