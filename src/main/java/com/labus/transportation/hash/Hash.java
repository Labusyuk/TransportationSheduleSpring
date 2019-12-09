package com.labus.transportation.hash;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface Hash {
    public String getHash(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
