package com.company;

public abstract class Command {

    public Transport transport;

    public Command(Transport transport) {
        this.transport = transport;
    }

    public Command() {
    }

    public abstract boolean execute();
}
