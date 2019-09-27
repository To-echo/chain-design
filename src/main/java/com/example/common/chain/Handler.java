package com.example.common.chain;

/**
 * @author tianp
 **/
public interface Handler {
    /**
     * 是否支持处理
     *
     * @param uri 匹配uri
     * @return true 成功 false 失败
     */
    boolean support(String uri);

    /**
     * 处理
     *
     * @param requestBody 处理参数封装
     * @return true 成功 false 失败
     */
    boolean handle(RequestBody requestBody);

    /**
     * 获取处理器名字
     *
     * @return 处理器名字
     */
    String getName();

}
