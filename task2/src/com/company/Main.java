package com.company;

import com.company.commands.CommandPanel;
import com.company.entities.Figure;
import com.company.entities.transport.Tractor;

public class Main {

    /**
     * Метод добавлен для демонстрации работы приложения.
     */
    public static void main(String[] args) {

        Figure tractor = new Tractor();
        CommandPanel panel = new CommandPanel(tractor);
        panel.init();

//        Figure stone = new Stone();
//        CommandPanel panel = new CommandPanel(stone);
//        panel.init();

    }
}
