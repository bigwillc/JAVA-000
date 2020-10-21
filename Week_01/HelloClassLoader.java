package org.java.week1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        CustomClassLoader classLoader = new CustomClassLoader();
        try {
            //Class<?> hello = classLoader.loadClass("com.java.resources.Hello");
            Class<?> hello = classLoader.findClass("Hello");

            Object instance = hello.newInstance();
            instance.getClass().getMethod("hello").invoke(instance);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    static class CustomClassLoader extends ClassLoader {
        String prefix = "com/java/resources/";
        String suffix = ".xlass";

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            File file = new File(prefix + name + suffix);

            try (FileInputStream inputStream = new FileInputStream(file)) {
                byte[] bytes = new byte[1024];
                int index = 0;
                while (true) {
                    int read = inputStream.read();
                    if (read != -1) {
                        bytes[index++] = (byte) (255 - read);
                    } else {
                        break;
                    }
                }
                return super.defineClass(name, bytes, 0, index);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.findClass(name);
        }



    }

}