package com.async.object;

public class AsyncServer {
    int serverId;
    String url;
    String cluster;
    boolean isAlive;
    long lastSeen;
    int retryCount;

    public AsyncServer(int serverId, String url, long lastSeen, String cluster) {
        this.serverId = serverId;
        this.url = url;
        this.cluster = cluster;
        this.lastSeen = lastSeen;
        this.isAlive = true;
        retryCount = 0;
    }

    public int getServerId() {
        return serverId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public void incrementRetryCount() {
        this.retryCount = this.retryCount + 1;
    }
}
