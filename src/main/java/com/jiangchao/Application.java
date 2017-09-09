package com.jiangchao;

import java.util.concurrent.CountDownLatch;

import com.jiangchao.com.jiangchao.kafka.Customer;
import com.jiangchao.com.jiangchao.kafka.Producter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    Producter producter () {
        return new Producter();
    }

    @Bean
    Customer customer () {
        return new Customer();
    }
    public static void  main(String[] args) throws InterruptedException {
       ApplicationContext ctx = SpringApplication.run(Application.class, args);
       //LOGGER.info("Sending message...");
       //Producter producter = ctx.getBean(Producter.class);
       //producter.send();
        LOGGER.info("Customer message...");
        Customer customer = ctx.getBean(Customer.class);
        customer.customer();
       System.exit(0);
    }
}
