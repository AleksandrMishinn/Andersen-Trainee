package com.company;

public class Field {

    private int[] size;

    public Field(int[] size) {
        this.size = size;
    }

    public Field() {
        this(new int[] {5,5});
    }

    public int[] getSize() {
        return size;
    }
}



