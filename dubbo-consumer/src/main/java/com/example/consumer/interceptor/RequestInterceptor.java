package com.example.consumer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义一个拦截器
 */
public class RequestInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    //校验token值
    String token = request.getParameter("token");
    if (Strings.isNotEmpty(token) && "yfj".equals(token)) {
      return true;
    }
    //这里注意 print 与 write 的区别
    //String data = null;
    //    response.getWriter().print(data);
    response.getWriter().write("token err! please confirm you token");
    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    String className = ((HandlerMethod) handler).getBean().getClass().getSimpleName();
    String methodName = ((HandlerMethod) handler).getMethod().getName();
    System.out.println(
        className + "--" + "处理请求" + request.getServletPath() + "--" + "处理请求方法的" + methodName);

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler,
      @Nullable Exception ex) throws Exception {
  }

}
