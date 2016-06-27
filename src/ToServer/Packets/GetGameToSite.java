package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

/**
 * Created by wed on 19.02.16.
 */
public class GetGameToSite extends ToServerPacket {

    boolean onlyOne;
    int gameId;

    public boolean isOnlyOne() {
        return onlyOne;
    }

    public int getGameId() {
        return gameId;
    }

    public void get(ByteBuf buffer) {

        gameId = buffer.readInt();
        onlyOne = buffer.readBoolean();
    }

    public void send(ByteBuf buffer) {
        buffer.writeInt(gameId);
        buffer.writeBoolean(onlyOne);
    }

    public eServerPackets getType()
    {
        return eServerPackets.GET_GAME_SITE;
    }

    public void setOnlyOne(boolean onlyOne) {
        this.onlyOne = onlyOne;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}