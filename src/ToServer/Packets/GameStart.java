package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;
import model.CharBan;
import model.Player;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wed on 10.02.16.
 */
public class GameStart extends ToServerPacket {

    private String serverId;
    private long idGame;
    private String cryptKey;
    private Timestamp gameStart;
    private Timestamp gameDate;
    private long mapId;
    private String gameMode;
    private String gameType;
    private long gameQueryConfig;
    private long gameLength;
    private long gameStartToSend;
    private List<Player> plrs=new ArrayList<>();
    private List<CharBan> bans=new ArrayList<>();

    public void get(ByteBuf buffer) {
        gameLength =buffer.readLong();
        gameStart = (new Timestamp(buffer.readLong()));
        idGame = (buffer.readLong());
        gameQueryConfig = (buffer.readLong());
        mapId = (buffer.readLong());

        int countBytes=buffer.readInt();
        byte[] b=new byte[countBytes];
        buffer.readBytes(b);

        gameMode = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        gameType = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        cryptKey = (new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        serverId = (new String(b, Charset.forName("UTF-8")));

        int countMass=buffer.readInt();

        for(int i=0;i<countMass;i++){
            CharBan ban=new CharBan();
            ban.setCharId(buffer.readLong());
            ban.setTeamId(buffer.readLong());
            ban.setPickTurn(buffer.readInt());
            bans.add(ban);
        }

        countMass=buffer.readInt();
        for(int i=0;i<countMass;i++){
            Player player=new Player();
            player.setIsBot(buffer.readBoolean());
            player.setSpell1D(buffer.readLong());
            player.setSpell2D(buffer.readLong());
            player.setPlayerIcon(buffer.readLong());
            player.setChampionId(buffer.readLong());
            player.setTeadId(buffer.readLong());
            player.setPlayerId(buffer.readLong());

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            player.setName(new String(b, Charset.forName("UTF-8")));


            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);
            player.setMastery(new String(b, Charset.forName("UTF-8")));

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            player.setRune(new String(b, Charset.forName("UTF-8")));
            plrs.add(player);
        }
        gameDate = (new Timestamp(System.currentTimeMillis()));
    }

    public void send(ByteBuf buffer) {
        buffer.writeLong(gameLength);
        buffer.writeLong(gameStartToSend);
        buffer.writeLong(idGame);
        buffer.writeLong(gameQueryConfig);
        buffer.writeLong(mapId);

        buffer.writeInt(gameMode.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(gameMode.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(gameType.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(gameType.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(cryptKey.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(cryptKey.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(serverId.getBytes(Charset.forName("UTF-8")).length);
        buffer.writeBytes(serverId.getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(bans.size());

        for(int i=0;i<bans.size();i++)
        {
            buffer.writeLong(bans.get(i).getCharId());
            buffer.writeLong(bans.get(i).getTeamId());
            buffer.writeInt(bans.get(i).getPickTurn());
        }

        buffer.writeInt(plrs.size());

        for(int i=0;i<plrs.size();i++)
        {
            buffer.writeBoolean(plrs.get(i).getIsBot());
            buffer.writeLong(plrs.get(i).getSpell1D());
            buffer.writeLong(plrs.get(i).getSpell2D());
            buffer.writeLong(plrs.get(i).getPlayerIcon());
            buffer.writeLong(plrs.get(i).getChampionId());
            buffer.writeLong(plrs.get(i).getTeadId());
            buffer.writeLong(plrs.get(i).getPlayerId());

            buffer.writeInt(plrs.get(i).getName().getBytes(Charset.forName("UTF-8")).length);
            buffer.writeBytes(plrs.get(i).getName().getBytes(Charset.forName("UTF-8")));

            buffer.writeInt(plrs.get(i).getMastery().getBytes(Charset.forName("UTF-8")).length);
            buffer.writeBytes(plrs.get(i).getMastery().getBytes(Charset.forName("UTF-8")));

            buffer.writeInt(plrs.get(i).getRune().getBytes(Charset.forName("UTF-8")).length);
            buffer.writeBytes(plrs.get(i).getRune().getBytes(Charset.forName("UTF-8")));

        }
    }

    public eServerPackets getType()
    {
        return eServerPackets.GAME_START_M;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public String getCryptKey() {
        return cryptKey;
    }

    public void setCryptKey(String cryptKey) {
        this.cryptKey = cryptKey;
    }

    public Timestamp getGameStart() {
        return gameStart;
    }

    public void setGameStart(Timestamp gameStart) {
        this.gameStart = gameStart;
    }

    public Timestamp getGameDate() {
        return gameDate;
    }

    public void setGameDate(Timestamp gameDate) {
        this.gameDate = gameDate;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
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

    public long getGameQueryConfig() {
        return gameQueryConfig;
    }

    public void setGameQueryConfig(long gameQueryConfig) {
        this.gameQueryConfig = gameQueryConfig;
    }

    public long getGameLength() {
        return gameLength;
    }

    public void setGameLength(long gameLength) {
        this.gameLength = gameLength;
    }

    public long getGameStartToSend() {
        return gameStartToSend;
    }

    public void setGameStartToSend(long gameStartToSend) {
        this.gameStartToSend = gameStartToSend;
    }

    public List<Player> getPlrs() {
        return plrs;
    }

    public void setPlrs(List<Player> plrs) {
        this.plrs = plrs;
    }

    public List<CharBan> getBans() {
        return bans;
    }

    public void setBans(List<CharBan> bans) {
        this.bans = bans;
    }
}