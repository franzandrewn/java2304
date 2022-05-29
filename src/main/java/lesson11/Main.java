package lesson11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    static void httpConnectionExample() {
        try {
            // Создание ссылки на ресурс
            URL urlToWikipedia = new URL("https://ru.wikipedia.org/wiki/HTML");
            System.out.printf("protocol: %s, host: %s, path: %s, port: %d\n", urlToWikipedia.getProtocol(),
                    urlToWikipedia.getHost(),
                    urlToWikipedia.getPath(),
                    urlToWikipedia.getPort());

            // Создание подключения из URL
            HttpURLConnection connection = (HttpURLConnection) urlToWikipedia.openConnection();
            // Задание метода запроса
            connection.setRequestMethod("GET");

            // Задание заголовков
//            connection.setRequestProperty("Accept", "text/html");

            // Записываем тело запроса (если есть)
//            OutputStream message = connection.getOutputStream();
//            String json = "{\"message\":\"hello\"}";
//            message.write(json.getBytes(StandardCharsets.UTF_8));

            // До getResponseCode - взаимодействие с запросом, после - с ответом
            int code = connection.getResponseCode();
            if (code == 200) {
                InputStream in = connection.getInputStream();
//                connection.getContentLength(); // получить количество байт в теле ответа
//                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("./src/main/resources/wiki.html"));
//                int i = in.read();
//                while (i != -1) {
//                    out.write(i);
//                    i = in.read();
//                }
                byte[] bytesIn = new byte[connection.getContentLength()];
                in.read(bytesIn);
                String messageIn = new String(bytesIn, StandardCharsets.UTF_8);
                System.out.println(messageIn);
                in.close();
//                out.close();
            } else {
                System.out.printf("code of response: %d", code);
            }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Создать URL к https://api.coindesk.com/v1/bpi/currentprice.json
    // (запрос в google "coindesk btc price json")
    // Создать HttpUrlConnection и задать ему метод "GET"
    // В случае кода 200 прочитать строчку с json и вывести её на экран
    static void task1() {
        try {
            URL urlToBtc = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
            HttpURLConnection connection = (HttpURLConnection) urlToBtc.openConnection();
            connection.setRequestMethod("GET");

            int code = connection.getResponseCode();
            if (code == 200) {
//                InputStream in = connection.getInputStream();
//                byte[] bytesIn = new byte[connection.getContentLength()];
//                in.read(bytesIn);
//                String messageIn = new String(bytesIn);
//                System.out.println(messageIn);

                InputStreamReader in = new InputStreamReader(connection.getInputStream());
                int i = in.read();
                while (i != -1) {
                    System.out.print((char) i);
                    i = in.read();
                }
                in.close();
            } else {
                System.out.println(code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void springIOCExample () {
//        SQLiteDataSource dataSource = new SQLiteDataSource();
//        dataSource.setUrl("jdbc:sqlite:./src/main/resources/users.db");
//        UserDao userDao = new UserDao(dataSource);
//        userDao.findById(2L);
//        userDao.findAll();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // Создание объекта UserDao с помощью ApplicationContext
        // (при необходимости создается объект DataSource и проставляется связь между объектами)
        UserDao userDao = ctx.getBean(UserDao.class);
        UserDao userDao2 = ctx.getBean(UserDao.class);
        System.out.println(userDao);
        System.out.println(userDao2);
        userDao.findAll();
        System.out.println(userDao.dataSource);

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }

    public static void main(String[] args) {
//        httpConnectionExample();
//        task1();
        springIOCExample();
    }

//    private static DataSource dataSource;
//
//    public static DataSource dataSource() {
//        if (dataSource == null) {
//            SQLiteDataSource dataSource = new SQLiteDataSource();
//            dataSource.setUrl("jdbc:sqlite:./src/main/resources/users.db");
//        }
//        return dataSource;
//    }
}
