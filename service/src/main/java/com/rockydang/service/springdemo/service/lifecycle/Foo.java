package com.rockydang.service.springdemo.service.lifecycle;

import java.util.Date;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年10月04日 10:45
 */
public class Foo  {
    private String username;
    private Date birthday;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
