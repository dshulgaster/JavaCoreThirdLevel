package gbjc3.les03;

import java.io.File;
import java.io.IOException;

public class MainExpFromLesson {
    public static void main(String[] args) throws IOException {
        // Создаем директорию
        //        File file = new File("a/b/c");
        //        System.out.println(file.isDirectory());
        //        file.mkdirs();

        File file = new File("a/b/c/");
        // Создаем файл
        //file.createNewFile();
        // Переименовываем файл (перемещаем аналогично, но меняем путь, а имя файла оставляем прежним)
        //file.renameTo(new File("a/b/c/123_new.txt"));

        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());

        String[] list = file.list();
        File[] files = file.listFiles();

        System.out.println(list);
        System.out.println(file);

    }
}
