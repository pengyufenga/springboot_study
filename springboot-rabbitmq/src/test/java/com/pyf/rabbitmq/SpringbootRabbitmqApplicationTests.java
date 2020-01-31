package com.pyf.rabbitmq;

import com.pyf.rabbitmq.bean.Student;
import com.sun.javafx.collections.MappingChange;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
        Exchange exchange = new DirectExchange("amqpadmin.exchange");
        amqpAdmin.declareExchange(exchange);
        System.out.println("创建完成");
    }

    @Test
    public void createBinding(){
        Binding binding = new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null);
        amqpAdmin.declareBinding(binding);
        System.out.println("binding成功");
    }

    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        System.out.println("queue创建完成");
    }

    /**
     * 1、单播（点对点）
     */
    @Test
    void contextLoads() {
        //rabbitTemplate.send(exchange,routeKey,message);
        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","first message");
        map.put("data",Arrays.asList("hello","world",123,true));
//        rabbitTemplate.convertAndSend("exchange.dirct","atguigu.news",map);
        rabbitTemplate.convertAndSend("exchange.dirct","atguigu.news",new Student("彭大大","男"));
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Student("彭小小","女"));
    }

}
