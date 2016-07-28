package ch72.net;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    @Bean
    BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }


    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
