package ToClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wed on 11.03.16.
 */
public enum eClientPackets {
    UNKNOWN(0),LOGIN(1),INFO(2),ADD_PLAYER_TO_M(3),REMOVE_PLAYER_TO_M(4),ADD_GAME_TO_C(5),REMOVE_GAME_TO_C(6)
    ,SEND_GAME_STS(7),STS_INFO_TO_SITE(8),SEND_GAME_TO_SITE(9);

    private static Map<Integer,eClientPackets> _pakets=new HashMap<>();
    private final int value;

    private eClientPackets(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static {
        for(eClientPackets p:eClientPackets.values())
        {
            _pakets.put(p.getValue(),p);
        }
    }

    public static eClientPackets get(int i)
    {
        if(_pakets.containsKey(i))
            return _pakets.get(i);
        return eClientPackets.UNKNOWN;
    }
}
