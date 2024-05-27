package com.hf.left.netty.serialize;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/20 17:39
 * @version: 1.0
 */
@Data
@ToString
public class SubscribeResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private int subReqID;

    private int respCode;

    private String desc;

    public SubscribeResp(int subReqID){
        this.subReqID = subReqID;
    }
}
