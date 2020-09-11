package com.company;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

public class ClassLoaderDemo {

    private static final Logger LOGGER = Logger.getLogger(ClassLoaderDemo.class.getName());

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Введите путь к подключаемому классу"); // пример: C:\Users\Aleksandr\IdeaProjects\Andersen-Trainee\task5\external folder\ExternalLoadableClass.class
        String path = scanner.nextLine();

        if (!Files.exists(Paths.get(path))) {
            LOGGER.info("Неверно указан путь.");
            return;
        }

        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> externalClass = customClassLoader.findClass(path);
        Object ExternalClassObject = externalClass.getDeclaredConstructor().newInstance();
        LOGGER.info(ExternalClassObject.toString());
    }
}
