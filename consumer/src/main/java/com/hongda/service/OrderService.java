package com.hongda.service;

import com.common.service.UserService;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author liuyibo
 * @Date 2023/5/27 11:51
 **/
@Service
public class OrderService {
    @Resource
    private RestTemplate restTemplate;

    @DubboReference(version = "1.0")
    UserService userservice;

    public String getOrder() {
       // String userName = restTemplate.getForObject("http://localhost:8080/user", String.class);

       /* String user = userservice.getUser();
        return user + "------1234567890";*/
        return sayHello();
    }

    public String getServerStream(){
        userservice.sayHelloServerStream("serverStream", new StreamObserver<String>() {
            public void onNext(String data) {
                System.out.println(data);
            }

            public void onError(Throwable throwable) {

            }

            public void onCompleted() {

            }
        });
        return "success";
    }

    public String sayHello(){
        StreamObserver<String> helloStream = userservice.sayHelloStream(new StreamObserver<String>() {
            public void onNext(String data) {
                // 接受服务端返回的数据
                System.out.println("接受服务端数据....."+data);
            }

            public void onError(Throwable throwable) {

            }

            public void onCompleted() {

            }
        });

        // 获取参数分批发送服务端
        helloStream.onNext("1.......");
        helloStream.onNext("2.........");
        helloStream.onNext("3........");
        helloStream.onNext("4........");
        helloStream.onCompleted();
        return "success";
    }
}
