package com.foodtruck.loveeat.contoller.response;

/**
 * R
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseUtils<T> {


  @Data
  @NoArgsConstructor
  public static class R<T>{
    private int code;
    private String msg;
    private T data;
  }

  public static <T> R ok(T data) {
    R r = new R();
    r.setCode(0);
    r.setMsg("success");
    r.setData(data);
    return r;
  }

  public static <T> R fail(int code, String msg) {
    R r = new R();
    r.setCode(code);
    r.setMsg(msg);
    return r;
  }

}
