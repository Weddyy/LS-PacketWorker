package model;

/**
 * Created by Wed on 14.03.16.
 */
public class Player {
    private String name;
    private boolean isBot;
    private long spell1D;
    private long spell2D;
    private long playerIcon;
    private long championId;
    private long playerId;
    private long teadId;
    private String rune;
    private String mastery;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsBot() {
        return isBot;
    }

    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }

    public long getSpell1D() {
        return spell1D;
    }

    public void setSpell1D(long spell1D) {
        this.spell1D = spell1D;
    }

    public long getSpell2D() {
        return spell2D;
    }

    public void setSpell2D(long spell2D) {
        this.spell2D = spell2D;
    }

    public long getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(long playerIcon) {
        this.playerIcon = playerIcon;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getTeadId() {
        return teadId;
    }

    public void setTeadId(long teadId) {
        this.teadId = teadId;
    }

    public String getRune() {
        return rune;
    }

    public void setRune(String rune) {
        this.rune = rune;
    }

    public String getMastery() {
        return mastery;
    }

    public void setMastery(String mastery) {
        this.mastery = mastery;
    }
}
