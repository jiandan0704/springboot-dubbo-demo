package com.example.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.DubboHelloService;
import java.util.concurrent.TimeUnit;

/**
 * mock 的作用是：当远程调用失败时，返回 DubboHelloServiceMock 中该方法hello 的 默认值
 */
@Service(mock = "com.example.api.DubboHelloServiceMock") //注意：这是Dubbo的注解，不是spring的
public class DubboHelloServiceImpl implements DubboHelloService {

  @Override
  public String hello(String name) {
    try {
      //模拟远程调用服务超时
      TimeUnit.SECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "hello ::: " + name;
  }
}
