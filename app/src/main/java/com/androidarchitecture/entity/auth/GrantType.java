package com.androidarchitecture.entity.auth;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({GrantType.GR_CLIENT_CREDENTIALS, GrantType.GR_REFRESH_TOKEN, GrantType.GR_PASSWORD})
public @interface GrantType {
	String GR_CLIENT_CREDENTIALS = "client_credentials";
	String GR_REFRESH_TOKEN = "refresh_token";
	String GR_PASSWORD = "password";
}
