package com.mongodb;

import java.util.ArrayList;
import java.util.List;


public class AppServer {
    private final int MAX_RECOMMENDED_UTILIZATION_PERCENTAGE = 75;

    private final String _name;
    private final Machine _machine;
    private final List<File> _files;


    public AppServer(final String pName, final Machine pMachine) {
        _name = pName;
        _machine = pMachine;
        _files = new ArrayList<>();
    }


    public Machine getMachine() {
        return _machine;
    }

    public List<File> getFiles() {
        return _files;
    }

    public void addFile(final File pJob) {
        _files.add(pJob);
    }


    public int getTotalDiskUtilization() {
        int diskUtilization = 0;
        for (File file : _files) {
            diskUtilization += file.getSizeMb();
        }
        return diskUtilization;
    }

    public boolean isDiskUtilizationAboveRecommendedPercentage() {
        return getTotalDiskUtilization() > MAX_RECOMMENDED_UTILIZATION_PERCENTAGE / 100. * _machine.getDiskSizeMb();
    }

    public void alertIfDiskUtilizationAboveRecommendedPercentage() {
        if (isDiskUtilizationAboveRecommendedPercentage()) {
            System.err.println("AppServer " + _name + " is utilizing more than " + MAX_RECOMMENDED_UTILIZATION_PERCENTAGE + "% of the space available on " + _machine.getName());
        }
    }
}
