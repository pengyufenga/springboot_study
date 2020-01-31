package com.pyf.rabbitmq.service;

import com.pyf.rabbitmq.bean.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Student student){
        System.out.println("收到消息" + student);
    }
}
