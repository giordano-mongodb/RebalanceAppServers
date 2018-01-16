package com.mongodb;

import java.util.ArrayList;
import java.util.List;


public class BackupSystem {
    private final List<AppServer> _appServers;


    public BackupSystem() {
        _appServers = new ArrayList<>();
    }


    public List<AppServer> getAppServers() {
        return _appServers;
    }

    public void addAppServer(final AppServer pAppServer) {
        _appServers.add(pAppServer);
    }


    public void checkAllDaemonsAlerts() {
        for (AppServer appServer : _appServers) {
            appServer.alertIfDiskUtilizationAboveRecommendedPercentage();
        }
    }


    public static void main(String[] args) throws InterruptedException {
	    BackupSystem backupSystem = new BackupSystem();

	    while (true) {
            backupSystem.checkAllDaemonsAlerts();
            Thread.sleep(5000);
        }
    }
}
