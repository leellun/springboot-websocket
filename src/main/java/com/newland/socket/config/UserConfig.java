package com.newland.socket.config;

import com.newland.socket.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: leell
 * Date: 2023/2/26 20:36:58
 */
public class UserConfig {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(0L, "test1"));
        users.add(new User(1L, "test2"));
        users.add(new User(2L, "test3"));
        users.add(new User(3L, "test4"));
        users.add(new User(4L, "test5"));
        users.add(new User(5L, "test6"));
        users.add(new User(6L, "test7"));
    }

    public static User getUser(Long uid) {
        return users.stream().filter(item -> item.getUid().equals(uid)).findFirst().get();
    }
    public static User getUser(String username) {
        return users.stream().filter(item -> item.getName().equals(username)).findFirst().get();
    }
}
