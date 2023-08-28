package cn.vanillazi.learn.test.handler;

import cn.vanillazi.learn.system.event.UserUpdate;

import org.springframework.context.event.EventListener;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateHandler {

    public UserUpdateHandler(){
        System.out.println("test");
    }
    @EventListener
    @Async
    public void onUserUpdated(UserUpdate userUpdate){
        System.out.println(userUpdate.getUser());
    }
}
