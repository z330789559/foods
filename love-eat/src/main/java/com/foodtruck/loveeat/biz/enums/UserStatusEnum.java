package com.foodtruck.loveeat.biz.enums;

/**
 * UserStatusEnum
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserStatusEnum{
    //enum element for query
    All(0, "ALL"),

    Normal(1,"normal"),

    Disable(2,"disable")
    ;

    private int code;

    @Getter
    private String name;

    UserStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

  @JsonValue
    public int getCode() {
        return code;
    }

  public UserStatusEnum getSelf(int code) {
        for (UserStatusEnum value : UserStatusEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;

    }
  @JsonCreator
    public static UserStatusEnum getEnum(int code) {
        for (UserStatusEnum value : UserStatusEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }


}
