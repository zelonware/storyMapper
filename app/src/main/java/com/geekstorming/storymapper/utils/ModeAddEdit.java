package com.geekstorming.storymapper.utils;

/**
 * Class for managing add or edit modes in POJOs
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ModeAddEdit {

    public static final int ADD_MODE = 0;
    public static final int EDIT_MODE = 1;

    private int mode;

    public ModeAddEdit(int mode) {
        if (mode < ADD_MODE || mode > EDIT_MODE)
            throw new IllegalArgumentException(" Invalid AddEditMode " + mode);
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }


}
