package com.example.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.DubboHelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DubboController {

  /**
   * 服务降级：
   *    分布式环境下服务之间存在一定依赖关系，当整个依赖链中某个服务崩溃或者网络不同时，
   *    远程调用无法成功并抛出RpcException。为了避免这个，因此对服务【降级】，在调用
   *    失败时返回默认数据
   *
   *
   * 这里一定要注意：  引入dubbo的 @Reference
   * true 表示开启 服务降低; 也可以 return null
   */
  @Reference(mock = "true")
  private DubboHelloService dubboHelloService;

  @RequestMapping("/{dubbo}")
  public String hello(@PathVariable(value = "dubbo") String youName) {
    return dubboHelloService.hello(youName);
  }

}
