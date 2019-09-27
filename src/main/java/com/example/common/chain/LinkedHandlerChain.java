package com.example.common.chain;

/**
 * @author tianp
 **/
public class LinkedHandlerChain {
    /**
     * 头节点
     */
    private static final AbstractHandler HEAD = new AbstractHandler("head"){

        @Override
        public boolean process(RequestBody requestBody) {
            return true;
        }
    };
    private AbstractHandler TAIL = HEAD;
    public void addLast(AbstractHandler handler){
        TAIL.setNext(handler);
        TAIL = handler;
    }
    public boolean handle(RequestBody requestBody){
       return HEAD.handle(requestBody);
    }
}
