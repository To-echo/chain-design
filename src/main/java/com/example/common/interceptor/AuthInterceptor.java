package com.example.common.interceptor;

import com.example.common.chain.LinkedHandlerChain;
import com.example.common.chain.RequestBody;
import com.example.common.chain.impl.ConcreateA;
import com.example.common.chain.impl.ConcreateB;
import com.example.common.chain.impl.ConcreateC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tianp
 **/
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static LinkedHandlerChain linkedHandlerChain;

    static {
        linkedHandlerChain = new LinkedHandlerChain();
        //添加A
        ConcreateA concreatea = new ConcreateA("concreateA");
        concreatea.setIncludePatterns("/concreateA/**");
        concreatea.setExcludePatterns("/concreateA/b/**");
        //添加B
        ConcreateB concreateb = new ConcreateB("concreateB");
        concreateb.setIncludePatterns("/concreateB/**");
        concreateb.setExcludePatterns("/concreateB/b/**");
        //添加C
        ConcreateC concreatec = new ConcreateC("concreateC");
        concreatec.setIncludePatterns("/concreateC/**");
        concreatec.setExcludePatterns("/concreateC/b/**");

        linkedHandlerChain.addLast(concreatea);
        linkedHandlerChain.addLast(concreateb);
        linkedHandlerChain.addLast(concreatec);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestBody requestBody = new RequestBody();
        requestBody.setUri(request.getRequestURI());
        linkedHandlerChain.handle(requestBody);
        return super.preHandle(request, response, handler);
    }
}
