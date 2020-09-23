package com.gmail.yurakhomenko2020;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo (path = "D:\\Lesson2.2\\src\\com\\gmail\\yurakhomenko2020\\text.txt")
public class ContainerText {
    String stroka = "BEM — Block Element Modifier is a methodology that helps you to create reusable components and code sharing in front-end development";

    @Saver
    public void save (String path) {
        try(FileWriter writer = new FileWriter(path)) {
            writer.write(stroka);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

