package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;
import model.Player;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wed on 15.03.16.
 */
public class SendGameToSite extends ToClientPacket {

    private long gameId;
    private boolean dis;
    private String serverId;
    private String lastChunk=null;
    private String cryptKey;
    private String gameMode;
    private String gameType;
    private long time;
    private long mapId;
    private List<Player> players=new ArrayList<>();

    public void send(ByteBuf buffer) {
        buffer.writeLong(gameId);

        buffer.writeInt(serverId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(serverId.getBytes(Charset.forName("UTF-8")));

        dis=lastChunk==null || lastChunk.equals("");
        buffer.writeBoolean(dis);

        if(dis)
            return;

        buffer.writeInt(cryptKey.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(cryptKey.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(gameMode.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(gameMode.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(gameType.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(gameType.getBytes(Charset.forName("UTF-8")));

        buffer.writeLong(time);

        buffer.writeLong(mapId);

        buffer.writeInt(players.size());

        for (Player g:players) {
            buffer.writeInt(g.getName().getBytes(Charset.forName("UTF-8")).length);
            buffer.writeBytes(g.getName().getBytes(Charset.forName("UTF-8")));

            buffer.writeInt(g.getRune().getBytes(Charset.forName("UTF-8")).length);
            buffer.writeBytes(g.getRune().getBytes(Charset.forName("UTF-8")));

            buffer.writeInt(g.getMastery().getBytes(Charset.forName("UTF-8")).length);
            buffer.writeBytes(g.getMastery().getBytes(Charset.forName("UTF-8")));

            buffer.writeLong(g.getChampionId());

            buffer.writeLong(g.getPlayerId());

            buffer.writeLong(g.getSpell1D());

            buffer.writeLong(g.getSpell2D());

            buffer.writeLong(g.getTeadId());

        }
    }

    public void get(ByteBuf buffer) {
        gameId = (buffer.readLong());

        int countBytes=buffer.readInt();
        byte[] b=new byte[countBytes];
        buffer.readBytes(b);

        serverId = (new String(b, Charset.forName("UTF-8")));

        dis = (buffer.readBoolean());

        if(dis)
            return;
        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        cryptKey = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        gameMode = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        gameType = (new String(b, Charset.forName("UTF-8")));

        time = (buffer.readLong());
        mapId = (buffer.readLong());

        int countPlayers=buffer.readInt();

        for(int i=0;i<countPlayers;i++)
        {
            Player s =new Player();

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            s.setName(new String(b, Charset.forName("UTF-8")));

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            s.setRune(new String(b, Charset.forName("UTF-8")));

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            s.setMastery(new String(b, Charset.forName("UTF-8")));

            s.setChampionId(buffer.readLong());
            s.setPlayerId(buffer.readLong());
            s.setSpell1D(buffer.readLong());
            s.setSpell2D(buffer.readLong());
            s.setTeadId(buffer.readLong());

            players.add(s);
        }
    }

    public eClientPackets getType()
    {
        return eClientPackets.SEND_GAME_TO_SITE;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public boolean isDis() {
        return dis;
    }

    public void setDis(boolean dis) {
        this.dis = dis;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getLastChunk() {
        return lastChunk;
    }

    public void setLastChunk(String lastChunk) {
        this.lastChunk = lastChunk;
    }

    public String getCryptKey() {
        return cryptKey;
    }

    public void setCryptKey(String cryptKey) {
        this.cryptKey = cryptKey;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}