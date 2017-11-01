package cn.ucaner.components.core.security;

/**
 * Created by yangzhao on 17/7/20.
 */
public class SecurityUtil {

    private static final AES aes;

    private static final DES des;

    private static final RSA rsa;

    private static final RSA256 rsa256;

    private static final Base64 base64;

    static {
        aes = new AES();
        des = new DES();
        rsa = new RSA();
        rsa256 = new RSA256();
        base64 = new Base64();
    }

    public static ISecurity getAES(){
        return (ISecurity) aes;
    }
    public static ISecurity getDES(){
        return (ISecurity) des;
    }
    public static ISecurity getRSA(){
        return (ISecurity) rsa;
    }
    public static ISecurity getRSA256(){
        return (ISecurity) rsa256;
    }
    public static ISecurity getBase64(){
        return (ISecurity) base64;
    }
}
