package com.company.entities.natural;

import com.company.commands.factories.CommandFactory;
import com.company.commands.factories.NatureCommandFactory;
import com.company.entities.Field;
import com.company.entities.Figure;
import com.company.entities.Orientation;
import com.company.entities.Position;

public class NaturalObjects extends Figure {

    public NaturalObjects(Position position, Field field, Orientation orientation, CommandFactory factory) {
        super(position, field, orientation, factory);
    }

    public NaturalObjects() {
        this(new Position(5, 5), new Field(10, 10), Orientation.WEST, new NatureCommandFactory());
    }
}
