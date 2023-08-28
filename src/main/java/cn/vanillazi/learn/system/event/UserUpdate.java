package cn.vanillazi.learn.system.event;

import cn.vanillazi.learn.system.entity.User;
import lombok.Data;

@Data
public class UserUpdate {
    private User user;
}
