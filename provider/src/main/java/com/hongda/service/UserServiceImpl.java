package com.hongda.service;

import com.common.service.UserService;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author liuyibo
 * @Date 2023/5/27 11:36
 **/
@DubboService(version = "1.0")
public class UserServiceImpl implements UserService {

    public String getUser() {
        return "hongda";
    }

    public void sayHelloServerStream(String name, StreamObserver<String> response) {
       // 处理第一批还回数据
        response.onNext("hello-----"+name);

        // 处理第二批还回数据
        response.onNext("hello1----"+name);

        response.onCompleted();

    }

    public StreamObserver<String> sayHelloStream(final StreamObserver<String> response) {
        return new StreamObserver<String>() {
            public void onNext(String data) {
                // 接受客户端传过来的参数数据
                System.out.println("服务端接受的数据......"+data);

                // 根据参数进行业务处理

                // 返回客户端响应结果
                response.onNext("响应结果"+data);
            }

            public void onError(Throwable throwable) {

            }

            public void onCompleted() {
                // 返回客户端...
                System.out.println("发送完成.....");
            }
        };
    }
}
