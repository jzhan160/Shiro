package com.demo.test.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class encryption {
    public static void main(String[] args) {
        String credential = "1234";
        //String hashAlgorithm = "MD5";
        String hashAlgorithm = "SHA1";

        ByteSource credentialSalt = ByteSource.Util.bytes("b");
        int hashIteration = 1024;
        Object result =  new SimpleHash(hashAlgorithm,credential,credentialSalt,hashIteration);
        System.out.println(result);
    }
}
