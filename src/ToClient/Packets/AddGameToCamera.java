package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 14.03.16.
 */
public class AddGameToCamera extends ToClientPacket {

    private long idGame;
    private String serverId,path;

    public void send(ByteBuf buffer) {
        buffer.writeInt(serverId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(serverId.getBytes(Charset.forName("UTF-8")));

        buffer.writeLong(idGame);

        buffer.writeInt(path.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(path.getBytes(Charset.forName("UTF-8")));
    }

    public void get(ByteBuf buffer) {
        int countBytes=buffer.readInt();
        byte[] b=new byte[countBytes];
        buffer.readBytes(b);

        serverId = new String(b, Charset.forName("UTF-8"));
        idGame = buffer.readLong();

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);
        path = new String(b, Charset.forName("UTF-8"));
    }

    public eClientPackets getType()
    {
        return eClientPackets.ADD_GAME_TO_C;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}