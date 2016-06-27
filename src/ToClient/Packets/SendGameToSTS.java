package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 15.03.16.
 */
public class SendGameToSTS extends ToClientPacket {

    private long id;
    private String serverId;
    private String patc;
    private String lastChunk;

    public void send(ByteBuf buffer) {
        buffer.writeLong(id);

        buffer.writeInt(serverId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(serverId.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(patc.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(patc.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(lastChunk.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(lastChunk.getBytes(Charset.forName("UTF-8")));
    }

    public void get(ByteBuf buffer) {
        id = (buffer.readLong());

        int countBytes=buffer.readInt();
        byte[] b=new byte[countBytes];
        buffer.readBytes(b);

        serverId = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        patc = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        lastChunk = (new String(b, Charset.forName("UTF-8")));
    }

    public eClientPackets getType()
    {
        return eClientPackets.SEND_GAME_STS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getPatc() {
        return patc;
    }

    public void setPatc(String patc) {
        this.patc = patc;
    }

    public String getLastChunk() {
        return lastChunk;
    }

    public void setLastChunk(String lastChunk) {
        this.lastChunk = lastChunk;
    }
}