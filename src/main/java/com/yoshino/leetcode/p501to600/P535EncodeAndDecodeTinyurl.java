package com.yoshino.leetcode.p501to600;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TinyURL的加密与解密
 *
 * @author wangxin
 * 2020/5/7 20:13
 * @since
 **/
public class P535EncodeAndDecodeTinyurl {

    private static String BASE_URL = "http://tinyurl.com/";
    private static Map<String, String> URL_MAP = new HashMap<>();
    private static AtomicInteger ID_GEN = new AtomicInteger();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = String.valueOf(ID_GEN.getAndIncrement());
        URL_MAP.put(shortUrl, longUrl);
        return BASE_URL + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return URL_MAP.get(shortUrl.substring(BASE_URL.length()));
    }

    public static void main(String[] args) {
        P535EncodeAndDecodeTinyurl codec = new P535EncodeAndDecodeTinyurl();
        System.out.println(codec.decode(codec.encode("123")));
    }

}
