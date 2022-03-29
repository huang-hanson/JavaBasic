package com.hanson.UUID;

import java.util.UUID;

public class uuid {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
    }
}
