package com.eryi.bean.bo.common;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String picture;

    public User(String id){
        this.id = id;
    }
}
