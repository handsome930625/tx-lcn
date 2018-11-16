package com.codingapi.tm.listener;

import com.codingapi.tm.listener.service.InitService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * servlet 容器监听器 区别与 spring ioc 容器
 *
 * @author lorne
 * @date 2017/7/1
 */
@Component
public class ServerListener implements ServletContextListener {

    private InitService initService;

    /**
     * 主要是设置常量信息，和启动netty
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        WebApplicationContext springContext = WebApplicationContextUtils
                .getWebApplicationContext(event.getServletContext());
        initService = springContext.getBean(InitService.class);
        initService.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        initService.close();
    }

}
