package com.solider.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 进行登录验证的过滤器
 * @author Solider
 * @version 1.0
 * @since 3.0
 */

public class LogInCheckFilter implements Filter {

    // 使用hashSet集合保存放行路径
    private static final HashSet<String> passRequests =
            new HashSet<>(Arrays.asList("/index.jsp", "/signIn", "/signUp",
                                        "/css/img/1.jpg",  "/css/img/background.jpg",
                                        "/css/index.css", "/js/index.js"));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 进行登录验证，获取session对象，并限制不为空不创建
        HttpSession session = request.getSession(false);
        String servletPath = request.getServletPath();

        // 拦截条件
        if ((session != null && session.getAttribute("email") != null)
                || passRequests.contains(servletPath)) {
            // 登录成功，放行
            filterChain.doFilter(request, response);
        } else {
            // 如果session为空，证明没有用户登录，将页面重定向到登录页面
            response.sendRedirect(request.getContextPath());
        }

    }
}
