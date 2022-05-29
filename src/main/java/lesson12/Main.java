package lesson12;

import lesson11.ApplicationConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;


public class Main {
    @Value("${database.url}")
    private static String autoDatabaseUrl;

    static void springResources() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Resource fileRes = ctx.getResource("file:./src/main/resources/wiki.html");
        Resource webRes = ctx.getResource("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
        try {
            System.out.println(fileRes.getURL());
            System.out.println(webRes.getURL());

            File wikiHtml = fileRes.getFile();
            System.out.println(wikiHtml.canRead());
            FileReader wikiReader = new FileReader(wikiHtml);
            System.out.println((char) wikiReader.read());

            ReadableByteChannel byteChannel = webRes.readableChannel();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void springEnvironment(/*@Value("${database.login}") String autoDatabaseLogin*/) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Environment environment = ctx.getEnvironment();
        System.out.println(environment.containsProperty("database.login"));
        String databaseUrl = environment.getProperty("database.url");
        System.out.println(databaseUrl);

        System.out.println("autovalue databaseUrl = " + autoDatabaseUrl);
//        System.out.println("autovalue databaseLogin = " + autoDatabaseLogin);
    }

    public static void main(String[] args) {
        springResources();
        springEnvironment();
    }
}
