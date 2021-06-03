package com.dingdian.family.tree.pojo.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ReturnData {
    private Object data;
    private Integer code;
    private String msg;

    public static ReturnData success() {
        ReturnData return_data = new ReturnData();
        return_data.setCode(200);
        return_data.setMsg("SUCCESS");
        return return_data;
    }

    public static ReturnData success(Object data) {
        ReturnData return_data = new ReturnData();
        return_data.setData(data);
        return_data.setCode(200);
        return_data.setMsg("SUCCESS");
        return return_data;
    }

    public static ReturnData fail(int code,String msg) {
        ReturnData return_data = new ReturnData();
        return_data.setCode(code);
        return_data.setMsg(msg);
        return return_data;
    }

    public static ReturnData fail(int code,String msg,Object data) {
        ReturnData return_data = new ReturnData();
        return_data.setCode(code);
        return_data.setMsg(msg);
        return_data.setData(data);
        return return_data;
    }
}
