package com.mongodb;


public class Machine {
    private final String _name;
    private final int _diskSizeMb;


    public Machine(final String pName, final int pDiskSizeMb) {
        _name = pName;
        _diskSizeMb = pDiskSizeMb;
    }


    public String getName() {
        return _name;
    }

    public int getDiskSizeMb() {
        return _diskSizeMb;
    }
}
