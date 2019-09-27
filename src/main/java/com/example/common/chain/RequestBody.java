package com.example.common.chain;

/**
 * 请求处理封装类
 *
 * @author tianp
 **/
public class RequestBody {
    private String uri;
    //根据业务定义
    private Object body;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
