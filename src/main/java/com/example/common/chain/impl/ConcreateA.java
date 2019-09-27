package com.example.common.chain.impl;

import com.example.common.chain.AbstractHandler;
import com.example.common.chain.RequestBody;
import org.springframework.util.PathMatcher;

/**
 * @author tianp
 **/
public class ConcreateA extends AbstractHandler {
    public ConcreateA(String name) {
        super(name);
    }

    @Override
    public boolean process(RequestBody requestBody) {
        System.out.println("A 处理");
        return super.handle(requestBody);
    }

    @Override
    public void setPathMatcher(PathMatcher pathMatcher) {
        super.setPathMatcher(pathMatcher);
    }

    @Override
    public void setIncludePatterns(String... includePatterns) {
        super.setIncludePatterns(includePatterns);

    }

    @Override
    public void setExcludePatterns(String... excludePatterns) {
        super.setExcludePatterns(excludePatterns);
    }
}
