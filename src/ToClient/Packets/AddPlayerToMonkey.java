package ToClient.Packets;

import ToClient.ToClientPacket;
import ToClient.eClientPackets;
import io.netty.buffer.ByteBuf;
import model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wed on 10.02.16.
 */
public class AddPlayerToMonkey extends ToClientPacket {

    private List<Account> accounts=new ArrayList<>();

    public void get(ByteBuf buffer) {
        int count = buffer.readInt();
        for (int i = 0; i < count; i++) {
            Account a = new Account(buffer.readLong(), buffer.readShort());
            accounts.add(a);
        }
    }

    public void send(ByteBuf buffer) {
        buffer.writeInt(accounts.size());

        for(Account p:accounts)
        {
            buffer.writeLong(p.get_id());
            buffer.writeShort(p.get_serverId().getValue());
        }
    }

    public eClientPackets getType()
    {
        return eClientPackets.ADD_PLAYER_TO_M;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}