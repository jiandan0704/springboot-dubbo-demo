package com.example.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo //扫描所有dubbo上的服务
@SpringBootApplication
public class ProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }

}
