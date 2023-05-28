package com.common.service;

import org.apache.dubbo.common.stream.StreamObserver;

public interface UserService {
    // unary
    public String getUser();

    //server-stream 服务端流，获取的用户信息通过参数 response这个字段返回客户端
    default void sayHelloServerStream(String name, StreamObserver<String> response){

    }
    // client-stream /bi-stream ：客户端流，正常返回
    default StreamObserver<String> sayHelloStream(StreamObserver<String> response){
        return response;
    }

}
