package com.trkj.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BalanceJavaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalanceJavaProjectApplication.class, args);
    }

}
