package com.company.entities.transport;

import com.company.commands.factories.CommandFactory;
import com.company.commands.factories.TransportCommandFactory;
import com.company.entities.Field;
import com.company.entities.Figure;
import com.company.entities.Orientation;
import com.company.entities.Position;

public class Transport extends Figure {

    public Transport(Position position, Field field, Orientation orientation, CommandFactory factory) {
        super(position, field, orientation, factory);
    }

    public Transport() {
        this(new Position(0, 0), new Field(5, 5), Orientation.NORTH, new TransportCommandFactory());
    }
}
