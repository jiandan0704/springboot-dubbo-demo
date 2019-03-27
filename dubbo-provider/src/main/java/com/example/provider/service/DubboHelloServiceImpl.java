package com.example.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.DubboHelloService;

@Service   //注意：这是Dubbo的注解，不是spring的
public class DubboHelloServiceImpl implements DubboHelloService {

  @Override
  public String hello(String name) {
    return "hello ::: " + name;
  }
}
