package com.pengheng.pojo;

/**
 * @project IPersistence
 * @remark
 * @Author Administrator
 * @date 2020/10/24
 */
public class User {
    private Integer id;
    private String username;


    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + '}';
    }
}
