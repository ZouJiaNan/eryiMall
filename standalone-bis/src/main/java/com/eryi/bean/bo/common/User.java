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
     * �û���
     */
    private String userName;
    /**
     * ����
     */
    private String password;
    /**
     * �ǳ�
     */
    private String nickName;
    /**
     * ͷ��
     */
    private String picture;

    public User(String id){
        this.id = id;
    }
}
