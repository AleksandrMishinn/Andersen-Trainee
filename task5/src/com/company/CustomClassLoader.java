package com.company;

import java.io.*;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String path) {
        String className = new File(path).getName().replaceAll("[.][^.]+$", ""); //Получение имени класса без расширения из пути к файлу класса.
        String fullClassName = getClass().getPackageName().replaceAll("/", ".") + "." + className; //Получения имени класса вида com.company.ExternalClass
        byte[] byteFile = loadClassFromFile(path);

        return defineClass(fullClassName, byteFile, 0, byteFile.length);
    }

    private byte[] loadClassFromFile(String path) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        try (InputStream inputStream = new FileInputStream(new File(path))) {
            int value;

            while ((value = inputStream.read()) != -1) {
                byteStream.write(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteStream.toByteArray();
    }
}
