package com.mongodb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BackupSystemIntTests {
    private final int N_APP_SERVERS = 3;
    private final int N_FILES_PER_APP_SERVER = 5;


    @Test
    public void testBackupSystem() {
        BackupSystem backupSystem = new BackupSystem();

        for (int i = 0; i < N_APP_SERVERS; i++) {
            Machine machine = new Machine("Machine " + i, 1000 + 500 * i);
            AppServer appServer = new AppServer("AppServer " + i, machine);
            backupSystem.addAppServer(appServer);

            for (int j = 0; j < N_FILES_PER_APP_SERVER; j++) {
                File file = new File("File " + i + "_" + j);
                file.setSizeMb(100 + 10 * j);
                appServer.addFile(file);
            }
        }

        for (int i = 0; i < N_APP_SERVERS; i++) {
            assertFalse(backupSystem.getAppServers().get(i).isDiskUtilizationAboveRecommendedPercentage());
        }

        backupSystem.getAppServers().get(0).getFiles().get(0).incrementSizeMb(200);
        assertTrue(backupSystem.getAppServers().get(0).isDiskUtilizationAboveRecommendedPercentage());
    }
}
