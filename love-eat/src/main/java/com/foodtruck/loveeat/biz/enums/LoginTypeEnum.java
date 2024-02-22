package com.foodtruck.loveeat.biz.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;


/**
 * LoginType loginType
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoginTypeEnum{

     //enum element for query
	All(0, "ALL"),

	PwdLogin(1,"password login")
	;

	private int code;

	@Getter
	private String name;

	LoginTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}


	@JsonValue
	public int getCode() {
		return code;
	}

	public LoginTypeEnum getSelf(int code) {
		for (LoginTypeEnum value : LoginTypeEnum.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		return null;

	}

	@JsonCreator
	public static LoginTypeEnum getEnum(int code) {
		for (LoginTypeEnum value : LoginTypeEnum.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		return null;
	}
}
