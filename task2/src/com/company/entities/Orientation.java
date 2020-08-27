package com.company.entities;

public enum Orientation {

    NORTH("север", 0, 1) {
        @Override
        public Orientation next() {
            return EAST;
        }

        @Override
        public Orientation previous() {
            return WEST;
        }
    },
    EAST("восток", 1, 0) {
        @Override
        public Orientation next() {
            return SOUTH;
        }

        @Override
        public Orientation previous() {
            return NORTH;
        }
    },
    SOUTH("юг", 0, -1) {
        @Override
        public Orientation next() {
            return WEST;
        }

        @Override
        public Orientation previous() {
            return EAST;
        }
    },
    WEST("запад", -1, 0) {
        @Override
        public Orientation next() {
            return NORTH;
        }

        @Override
        public Orientation previous() {
            return SOUTH;
        }
    };

    private String title;
    private int XValue;
    private int YValue;

    Orientation(String title, int XValue, int YValue) {
        this.title = title;
        this.XValue = XValue;
        this.YValue = YValue;
    }

    public String getTitle() {
        return title;
    }

    public int getXValue() {
        return XValue;
    }

    public int getYValue() {
        return YValue;
    }

    public abstract Orientation next();

    public abstract Orientation previous();

    @Override
    public String toString() {
        return title;
    }
}
