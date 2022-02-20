package com.KomSoft.lection16;

import java.io.File;

public class MakeDestDir {
    private final String destination;

    public MakeDestDir(String destination) {
        this.destination = destination;
        File fileDir = new File(destination);
        if(!fileDir.exists()) {
            fileDir.mkdir();
        }
    }
}
