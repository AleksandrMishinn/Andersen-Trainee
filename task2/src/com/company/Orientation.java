package com.company;

public enum Orientation {

    NORTH("север", new int[]{0, 1}, "EAST", "WEST"),
    EAST("восток", new int[]{1, 0}, "SOUTH", "NORTH"),
    SOUTH("юг", new int[]{0, -1}, "WEST", "EAST"),
    WEST("запад", new int[]{-1, 0}, "NORTH", "SOUTH");

    private String title;
    private int[] axisValue;
    private String nextDirection;
    private String previousDirection;

    Orientation(String title, int[] axisValue, String nextDirection, String previousDirection) {
        this.title = title;
        this.axisValue = axisValue;
        this.nextDirection = nextDirection;
        this.previousDirection = previousDirection;
    }

    public int[] getAxisValue() {
        return axisValue;
    }

    public String getTitle() {
        return title;
    }

    public String getNextDirection() {
        return nextDirection;
    }

    public String getPreviousDirection() {
        return previousDirection;
    }

    public static Orientation next(Orientation currentOrientation) {
        return Orientation.valueOf(currentOrientation.getNextDirection());
    }

    public static Orientation previous(Orientation currentOrientation) {
        return Orientation.valueOf(currentOrientation.getPreviousDirection());
    }

    @Override
    public String toString() {
        return title;
    }
}
