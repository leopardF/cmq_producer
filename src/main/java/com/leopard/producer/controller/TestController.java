package com.leopard.producer.controller;

import com.alibaba.fastjson.JSONObject;
import com.leopard.utils.cmq.producer.config.ProducerService;
import com.leopard.utils.constant.Response;
import com.leopard.utils.filter.loginfo.annotations.PointcutLogger;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PointcutLogger
public class TestController {

    @Autowired
    private ProducerService service;

    @RequestMapping(value = "/send")
    public Response sendProducer(String name) {

        service.sendMsg(name);

        return Response.success("send ok " + name);
    }

    @RequestMapping(value = "/test2")
    public String test2(@RequestBody User user, @RequestHeader(value = "requestId", required = false) String requestId) {

        throw new RuntimeException("55");
    }

    @RequestMapping(value = "/test")
    public Response<String> test(@RequestBody User user, @RequestHeader(value = "requestId", required = false) String requestId) {

        System.out.println("方法入参：" + user.toString());
        System.out.println("方法头入参requestId：" + requestId);
        return Response.success("send ok" + user.toString());
    }

}

@Data
class User {
    private String name;
    private String memo;
    private List<String> list;
    private String requestId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
