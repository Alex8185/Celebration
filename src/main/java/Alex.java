import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Alex {
    public static void main(String[] args) {

        Human suboch = new Suboch();
        Human ivanovskiy = new Ivanovskiy();

        suboch.speak("Здравствуй Алексей Анатольевич");
        ivanovskiy.speak("Здравствуй Алексей Анатольевич");
        Scanner scanner = new Scanner(System.in);
        suboch.speak("Леха, введи свой возраст: ");
        String line = scanner.nextLine();
        if (line.equalsIgnoreCase("40")) {
            suboch.speak("Я так и знал, открой только что скачанный папку java файл happy.jpg");

            String path;
            path = "https://hodiki.by/wp-content/uploads/photo_2021-03-22_14-07-53.jpg";
            String fileName = "src/main/java/happy.jpg";

            FileOutputStream fout = null;
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new URL(path).openStream());
                fout = new FileOutputStream(fileName);
                byte data[] = new byte[1024];
                int count = 0;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                    fout.flush();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        } else {
            suboch.speak("Когда стукнет 40, попробуешь еще раз)))");
    }
}}