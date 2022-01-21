package com.saltfish.dailypractice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author saltfish
 * @date 2021/7/27 14:03
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.warn("debug：init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.warn("debug：do filter");
    }

    @Override
    public void destroy() {
        log.warn("debug：destroy filter");
    }
}
