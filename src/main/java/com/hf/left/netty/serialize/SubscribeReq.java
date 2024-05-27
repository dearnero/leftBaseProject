package com.hf.left.netty.serialize;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/20 17:34
 * @version: 1.0
 */
@Data
@ToString
public class SubscribeReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private int subReqID;

    private String userName;

    private String productName;

    private String phoneNumber;

    private String address;

    public SubscribeReq(int subReqID){
        this.subReqID= subReqID;
    }
}
