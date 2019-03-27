package com.example.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.DubboHelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DubboController {

  @Reference //这里一定要注意：  引入dubbo的 @Reference
  private DubboHelloService dubboHelloService;

  @RequestMapping("/{dubbo}")
  public String hello(@PathVariable(value = "dubbo") String youName) {
    return dubboHelloService.hello(youName);
  }

}
