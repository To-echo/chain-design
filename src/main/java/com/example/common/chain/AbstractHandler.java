package com.example.common.chain;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author tianp
 **/
public abstract class AbstractHandler implements Handler {
    /**
     * 处理器名称
     */
    private String name;
    /**
     * 拦截uri
     */
    private String[] includePatterns;

    /**
     * 放行uri
     */
    private String[] excludePatterns;

    /**
     * ant 匹配
     */
    private PathMatcher pathMatcher = new AntPathMatcher();
    /**
     * 下一个处理器
     */
    private AbstractHandler next = null;

    public AbstractHandler(String name) {
        this.name = name;
    }

    public boolean support(String uri) {
        if (excludePatterns != null) {
            for (String exclude : excludePatterns) {
                if (pathMatcher.match(exclude, uri)) {
                    return false;
                }
            }
        }
        if (includePatterns != null) {
            for (String include : includePatterns) {
                if (pathMatcher.match(include, uri)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给子类实现的真正处理方法
     *
     * @param requestBody 请求参数
     * @return true 成功 false 失败
     */
    public abstract boolean process(RequestBody requestBody);

    public boolean handle(RequestBody requestBody) {
        if (next != null) {
            if (next.support(requestBody.getUri())) {
                System.out.println(next.getName() + "开始处理");
                return next.process(requestBody);
            } else {
                next.handle(requestBody);
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractHandler getNext() {
        return next;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public String[] getIncludePatterns() {
        return includePatterns;
    }

    public String[] getExcludePatterns() {
        return excludePatterns;
    }

    public PathMatcher getPathMatcher() {
        return pathMatcher;
    }

    public void setPathMatcher(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    public void setIncludePatterns(String[] includePatterns) {
        this.includePatterns = includePatterns;
    }

    public void setExcludePatterns(String[] excludePatterns) {
        this.excludePatterns = excludePatterns;
    }
}
