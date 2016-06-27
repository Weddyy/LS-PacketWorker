package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by wed on 19.02.16.
 */
public class AddNewUser extends ToServerPacket {

    String ServerId,name;
    long userId;

    public String getServerId() {
        return ServerId;
    }

    public String getName() {
        return name;
    }

    public long getUserId() {
        return userId;
    }

    public void setServerId(String serverId) {
        ServerId = serverId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void get(ByteBuf buffer) {

        userId = buffer.readLong();

        int countBytes = buffer.readInt();
        byte[] b = new byte[countBytes];
        buffer.readBytes(b);

        ServerId = new String(b, Charset.forName("UTF-8"));

         countBytes = buffer.readInt();
        b = new byte[countBytes];
        buffer.readBytes(b);

        name = new String(b, Charset.forName("UTF-8"));
    }

    public void send(ByteBuf buffer) {

        buffer.writeLong(userId);
        buffer.writeInt(ServerId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(ServerId.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(name.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(name.getBytes(Charset.forName("UTF-8")));
    }

    public eServerPackets getType()
    {
        return eServerPackets.ADD_USER;
    }


}
