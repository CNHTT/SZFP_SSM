package com.extra.interceptor;

import org.java_websocket.WebSocketImpl;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Extra on 2017/8/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class StratFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        startWebSocketInstantMsg();
    }

    private void startWebSocketInstantMsg() {
        WebSocketImpl.DEBUG  =false;
        WeServer s;
        s = new WeServer(7777);
        s.start();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    public void destroy() {

    }
}
