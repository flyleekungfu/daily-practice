package com.saltfish.dailypractice.algorithm.encryption;

import java.security.Key;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/**
 * RSAUtil2测试
 */
public class RSAUtil2Test {

    public static void main(String[] args) throws Exception {
        // 使用公钥、私钥对象加解密
        List<Key> keyList = RSAUtil2.getRSAKeyObject(1024);
        RSAPublicKey puk = (RSAPublicKey) keyList.get(0);
        RSAPrivateKey prk = (RSAPrivateKey) keyList.get(1);
        String message = "referrer:[http://www.example.com/start.html](http://www.example.com/start.htmluser_agent: Mozilla/4.08 [en] (Win98; I ;Nav)";
        String encryptedMsg = RSAUtil2.encryptByPublicKey(message, puk);
        String decryptedMsg = RSAUtil2.decryptByPrivateKey(encryptedMsg, prk);
        System.out.println("object key ! message ==  decryptedMsg ? " + message.equals(decryptedMsg));

        // 使用字符串生成公钥、私钥完成加解密
        List<String> keyStringList = RSAUtil2.getRSAKeyString(1024);
        String pukString = keyStringList.get(0);
        String prkString = keyStringList.get(1);
        System.out.println("公钥:" + pukString);
        System.out.println("私钥:" + prkString);
        // 生成公钥、私钥
        puk = RSAUtil2.getPublicKey(pukString);
        prk = RSAUtil2.getPrivateKey(prkString);
        encryptedMsg = RSAUtil2.encryptByPublicKey(message, puk);
        decryptedMsg = RSAUtil2.decryptByPrivateKey(encryptedMsg, prk);
        System.out.println("string key ! message ==  decryptedMsg ? " + message.equals(decryptedMsg));
    }
}
