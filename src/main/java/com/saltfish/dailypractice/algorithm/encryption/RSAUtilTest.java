package com.saltfish.dailypractice.algorithm.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

/**
 * RSA测试
 */
public class RSAUtilTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        // 测试
        Map<String, String> keyMap = RSAUtil.createKeys(1024);
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥: \n\r" + privateKey);

        System.out.println("公钥加密——私钥解密");
        String str = "测试";
        System.out.println("\r明文：\r\n" + str);
        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = RSAUtil.publicEncrypt(str, RSAUtil.getPublicKey(publicKey));
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(privateKey));
        System.out.println("解密后文字: \r\n" + decodedData);
    }
}
