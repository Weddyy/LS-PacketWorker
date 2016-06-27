package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by wed on 11.02.16.
 */
public class GameEnd extends ToServerPacket {

    String ServerId, lastChunk;
    long gameId;
    int state;

    public String getServerId() {
        return ServerId;
    }

    public String getLastChunk() {
        return lastChunk;
    }

    public long getGameId() {
        return gameId;
    }

    public int getState() {
        return state;
    }

    public void get(ByteBuf buffer) {

        gameId = buffer.readLong();

        int countBytes = buffer.readInt();
        byte[] b = new byte[countBytes];
        buffer.readBytes(b);

        ServerId = new String(b, Charset.forName("UTF-8"));
        state = buffer.readInt();

        countBytes = buffer.readInt();
        b = new byte[countBytes];
        buffer.readBytes(b);

        lastChunk = new String(b, Charset.forName("UTF-8"));
    }

    public void send(ByteBuf buffer) {
        buffer.writeLong(gameId);

        buffer.writeInt(ServerId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(ServerId.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(state);

        buffer.writeInt(lastChunk.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(lastChunk.getBytes(Charset.forName("UTF-8")));
    }

    public eServerPackets getType()
    {
        return eServerPackets.GAME_END_C;
    }

    public void setServerId(String serverId) {
        ServerId = serverId;
    }

    public void setLastChunk(String lastChunk) {
        this.lastChunk = lastChunk;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setState(int state) {
        this.state = state;
    }
}
