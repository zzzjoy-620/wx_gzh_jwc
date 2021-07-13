package zzzjoy.util;


import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.tree.ExpandVetoException;
import java.security.SecureRandom;

/**
 * AES 加密工具类
 * @author EternalRay
 */

public class AesUtils{

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 加盐内容
     */
    private static final String SALTPRE="ASSVA";

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password){
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(DEFAULT_CHARSET);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            byte[] result = cipher.doFinal(byteContent);
            return parseByte2HexStr(result);
        }catch (Exception e) {
            System.out.println(e.getMessage());;
            return "";
        }
    }

    /**
     * AES 解密操作
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用**初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
            //执行操作
            byte[] result = cipher.doFinal(parseHexStr2Byte(content));
            return new String(result, DEFAULT_CHARSET);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 生成加密秘钥
     */
    private static SecretKeySpec getSecretKey(final String password) {
        try {
            //返回生成指定算法**生成器的 KeyGenerator 对象
            KeyGenerator kg = null;
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kg.init(128, secureRandom);
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 自定义内容加盐
     * @return 返回结果传入encrypt、decrypt方法的password参数
     */
    public static String customSaltContent(){
        return DigestUtils.md5Hex(SALTPRE).substring(8, 24);
    }
    public static void main(String[] args){
        String s = "245439";
        System.out.println("加密前的明文:" + s);
        String s1 = AesUtils.encrypt(s, "XASEqd212fq12121#!12121");
        System.out.println("密文:" + s1);
        System.out.println("解密后的明文:" + AesUtils.decrypt(s1, "XASEqd212fq12121#!12121"));
    }

}
