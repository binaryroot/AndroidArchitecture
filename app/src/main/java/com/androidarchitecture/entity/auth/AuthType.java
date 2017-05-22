package com.androidarchitecture.entity.auth;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({AuthType.BASIC, AuthType.BEARER})
public @interface AuthType {
	String BEARER = "Bearer";
	String BASIC = "Basic";
}