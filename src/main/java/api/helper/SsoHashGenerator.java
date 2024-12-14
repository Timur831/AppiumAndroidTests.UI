package api.helper;

import api.pojo.SsoCtnUser;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SsoHashGenerator{
    public static String getSsoHash(SsoCtnUser ssoCtnUser, String method) throws NoSuchAlgorithmException, InvalidKeyException {
        String secret = "PREVED";
        String data = "";
        switch (method){
            case "get":
                data = ssoCtnUser.login;
                break;
            case "add":
                data = ssoCtnUser.linkedAccountPassword + ssoCtnUser.linkedAccountLogin + ssoCtnUser.login;
                break;
            case "delete":
                data = ssoCtnUser.login + ssoCtnUser.linkedAccountLogin;
                break;
            case "changeName":
                data = ssoCtnUser.linkedAccountLogin + ssoCtnUser.login;
                break;
        }
        byte[] hashValue;

        SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.US_ASCII), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(keySpec);

        hashValue = mac.doFinal(data.getBytes(StandardCharsets.US_ASCII));

        return Base64.getEncoder().encodeToString(hashValue);
    }
}
