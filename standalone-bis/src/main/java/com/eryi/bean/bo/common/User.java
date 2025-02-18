package com.eryi.bean.bo.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User {

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
}
