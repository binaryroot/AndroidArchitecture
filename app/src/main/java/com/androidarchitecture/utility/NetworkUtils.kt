package com.androidarchitecture.utility

import java.net.HttpURLConnection

import javax.inject.Singleton

import okhttp3.Response

class NetworkUtils {

    fun isNotAuthorized(response: Response): Boolean {
        return response.code() == HttpURLConnection.HTTP_FORBIDDEN || response.code() == HttpURLConnection.HTTP_UNAUTHORIZED
    }

    /**
     * This method coverts url from  'https://www.example.com/' to 'https://www.example.com'

     * @return converted url
     */
    fun formatToBaseUrl(str: String): String {
        var url = str
        if (str[str.length - 1] == '/') {
            url = str.substring(0, str.length - 1)
        }
        return url
    }
}
