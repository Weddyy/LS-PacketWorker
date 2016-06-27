package ToServer;

import ToServer.Packets.*;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by Wed on 11.03.16.
 */
public abstract class ToServerPacket {

    public static ToServerPacket read(ByteBuf buffer) throws IOException {
        if(!buffer.isReadable())
            return null;
        int id = buffer.readUnsignedShort();
        ToServerPacket packet = parse(id);
        if(packet == null)
            throw new IOException("Bad packet ID: " + id);
        packet.get(buffer);
        return packet;
    }

    private static ToServerPacket parse(int id)
    {
        switch (eServerPackets.get(id))
        {
            case LOGIN:
                return new LoginPacket();
            case INFO:
                return new Info();
            case GAME_START_M:
                return new GameStart();
            case GAME_END_C:
                return new GameEnd();
            case GET_GAME_STS:
                return new GetGameToSTS();
            case GET_GAME_SITE:
                return new GetGameToSite();
            case ADD_USER:
                return new AddNewUser();
            default: return null;
        }
    }

    public abstract void get(ByteBuf buffer);

    public abstract eServerPackets getType();

    public abstract void send(ByteBuf buffer);
}
