package ToServer.Packets;

import ToServer.ToServerPacket;
import ToServer.eServerPackets;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 10.02.16.
 */
public class Info extends ToServerPacket {

    public double tCPU_IdleTime,memUse,memFree,swapUsed,swapFree;
    public int countUsers;
    public long round,api,request;

    public void get(ByteBuf buffer) {
        tCPU_IdleTime=buffer.readDouble();
        memUse=buffer.readDouble();
        memFree=buffer.readDouble();
        swapUsed=buffer.readDouble();
        swapFree=buffer.readDouble();

        countUsers=buffer.readInt();

        round=buffer.readLong();
        api=buffer.readLong();
        request=buffer.readLong();
    }

    public void send(ByteBuf buffer) {
        buffer.writeDouble(tCPU_IdleTime);
        buffer.writeDouble(memUse);
        buffer.writeDouble(memFree);
        buffer.writeDouble(swapUsed);
        buffer.writeDouble(swapFree);

        buffer.writeInt(countUsers);

        buffer.writeLong(round);
        buffer.writeLong(api);
        buffer.writeLong(request);
    }

    public eServerPackets getType()
    {
        return eServerPackets.INFO;
    }

    public double gettCPU_IdleTime() {
        return tCPU_IdleTime;
    }

    public void settCPU_IdleTime(double tCPU_IdleTime) {
        this.tCPU_IdleTime = tCPU_IdleTime;
    }

    public double getMemUse() {
        return memUse;
    }

    public void setMemUse(double memUse) {
        this.memUse = memUse;
    }

    public double getMemFree() {
        return memFree;
    }

    public void setMemFree(double memFree) {
        this.memFree = memFree;
    }

    public double getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(double swapUsed) {
        this.swapUsed = swapUsed;
    }

    public double getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(double swapFree) {
        this.swapFree = swapFree;
    }

    public int getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(int countUsers) {
        this.countUsers = countUsers;
    }

    public long getRound() {
        return round;
    }

    public void setRound(long round) {
        this.round = round;
    }

    public long getApi() {
        return api;
    }

    public void setApi(long api) {
        this.api = api;
    }

    public long getRequest() {
        return request;
    }

    public void setRequest(long request) {
        this.request = request;
    }
}