package ToServer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wed on 11.03.16.
 */
public enum eServerPackets {
    UNKNOWN(0),LOGIN(1),INFO(2),GAME_START_M(3),GAME_END_C(4),GET_GAME_STS(5),GET_GAME_SITE(6),ADD_USER(7);

    private static Map<Integer,eServerPackets> _pakets=new HashMap<>();
    private final int value;

    private eServerPackets(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static {
        for(eServerPackets p:eServerPackets.values())
        {
            _pakets.put(p.getValue(),p);
        }
    }

    public static eServerPackets get(int i)
    {
        if(_pakets.containsKey(i))
            return _pakets.get(i);
        return eServerPackets.UNKNOWN;
    }
}
