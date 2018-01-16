package com.mongodb;


public class File {
    private final String _name;
    private int _sizeMb;


    public File(final String pName) {
        _name = pName;
        _sizeMb = 0;
    }


    public String getName() {
        return _name;
    }

    public int getSizeMb() {
        return _sizeMb;
    }

    public void setSizeMb(final int pSizeMb) {
        _sizeMb = pSizeMb;
    }

    public void incrementSizeMb(final int pIncSizeMb) {
        _sizeMb += pIncSizeMb;
    }
}
