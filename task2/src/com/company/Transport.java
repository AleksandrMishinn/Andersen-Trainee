package com.company;

public class Transport {

    protected Orientation orientation;
    protected Field field;
    protected int[] position;

    public Transport() {
        this(new int[]{0,0}, new Field(new int[]{5,5}), Orientation.NORTH);
    }

    public Transport(int[] position, Field field, Orientation orientation) {
        this.position = position;
        this.field = field;
        this.orientation = orientation;
    }

}
