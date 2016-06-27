package model;

/**
 * Created by Wed on 14.03.16.
 */
public class CharBan {
    private long charId;
    private long teamId;
    private Integer pickTurn;

    public long getCharId() {
        return charId;
    }

    public void setCharId(long charId) {
        this.charId = charId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public Integer getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(Integer pickTurn) {
        this.pickTurn = pickTurn;
    }
}
