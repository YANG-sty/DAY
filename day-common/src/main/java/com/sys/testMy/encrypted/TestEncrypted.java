package com.sys.testMy.encrypted;

import jodd.util.StringUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

/**
 * @author yangLongFei 2021-03-21-16:09
 */
public class TestEncrypted {

    @Test
    public void test1() throws Exception {

        /**
         * 138491878522222 15
         * e6f6316fdf28eb442a95a6cdaf9db503 32
         *
         * 13849187 -52222 15
         * 76a74b4a112d06df7da6b514849777a1 32
         *
         * 1384918785222222 16
         * 441770382aabe202c56e9916ccf5ef3a4e188f2db29815cb9f9649ecc1c9ebf8 64
         *
         * 444555666111222111111 21
         * a31e3c098b887203cba9398825eef3a57c44655d85e0b88b8ac6b0b9f18a3d99 64
         *
         * 4445556661112221111112222222222 31
         * a31e3c098b887203cba9398825eef3a56f3c6ddef65db8312417c6234bd173b2 64
         *
         * 44455566611122211111122222222223 32
         * a31e3c098b887203cba9398825eef3a5286490dc8c842fcd68e4df950c9688d44e188f2db29815cb9f9649ecc1c9ebf8 96
         *
         *
         * 一二三四五 5
         * d4457b8a03f120c25ef4ae0cc9d149dd 32
         *
         * 一二三四五六 6
         * fbeb2c857f614b06da69976940b6157d07c6d66bee1c1521a45af71be2fc85a7 64
         *
         */
        String object = "13849187 852222";
        System.out.println(object + " " + object.length());
        String value = encryptEcb("cc9368581322479ebf3e79348a2757d9", object, "UTF-8");
        System.out.println(value + " " + value.length());
    }


    @Test
    public void test2() throws Exception {
        String object = "13849187852";
        String value = encryptEcb("cc9368581322479ebf3e79348a2757d9", object, "UTF-8");
        System.out.println(value + " " + value.length());

        String like = "13849187852";
        String likeValue = encryptEcb("cc9368581322479ebf3e79348a2757d9", like, "UTF-8");
        System.out.println(likeValue + " " + likeValue.length());


    }


    private static final String ENCODING = "UTF-8";
    public static final String ALGORIGTHM_NAME = "SM4";
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS7Padding";
    public static final int DEFAULT_KEY_SIZE = 128;

    final static String key = "cc9368581322479ebf3e79348a2757d9";


    static {
        Security.addProvider(new BouncyCastleProvider());
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null){
            double version = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME).getVersion();
            System.out.println("原有version="+version);
        }
    }

    /**
     *  @Description:生成ecb暗號
     */
    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName,BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORIGTHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }

    /**
     *  @Description:自動生成密鑰
     */
    public static byte[] generateKey() throws Exception {
        return generateKey(DEFAULT_KEY_SIZE);
    }

    public static byte[] generateKey(int keySize) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORIGTHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
        kg.init(keySize, new SecureRandom());
        return kg.generateKey().getEncoded();
    }


    /**
     *  @Description:加密
     */
    public static String encryptEcb(String hexKey, String paramStr, String charset) throws Exception {
        String cipherText = "";
        if (null != paramStr && !"".equals(paramStr)) {
            byte[] keyData = ByteUtils.fromHexString(hexKey);
            charset = charset.trim();
            if (charset.length() <= 0) {
                charset = ENCODING;
            }
            byte[] srcData = paramStr.getBytes(charset);
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            cipherText = ByteUtils.toHexString(cipherArray);
        }
        return cipherText;
    }

    /**
     *  @Description:加密模式之ecb
     */
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        byte[] bs = cipher.doFinal(data);
        return bs;
    }

    /**
     *  @Description:sm4解密
     */
    public static String decryptEcb(String hexKey, String cipherText, String charset) throws Exception {
        String decryptStr = "";
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        byte[] srcData = decrypt_Ecb_Padding(keyData, cipherData);
        charset = charset.trim();
        if (charset.length() <= 0) {
            charset = ENCODING;
        }
        decryptStr = new String(srcData, charset);
        return decryptStr;
    }

    /**
     *  @Description:解密
     */
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }

    /**
     *  @Description:密碼校驗
     */
    public static boolean verifyEcb(String hexKey,String cipherText,String paramStr) throws Exception {
        boolean flag = false;
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        byte[] decryptData = decrypt_Ecb_Padding(keyData,cipherData);
        byte[] srcData = paramStr.getBytes(ENCODING);
        flag = Arrays.equals(decryptData,srcData);
        return flag;
    }

    /**获取加密后的号码
     * @param phone
     * @return
     */
    public static String getSM4Phone(String phone){
        if(phone == null || StringUtil.isBlank(phone)){
            return "";
        }
        //如果本来就加密
        if(phone.indexOf("greeEnc")!=-1){
            return phone;
        }
        String encryptPhone = "";
        String cipher = null;
        try {
            cipher = encryptEcb(key, phone,ENCODING);
            encryptPhone = cipher+"-greeEnc-"+phone.charAt(phone.length()-1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return encryptPhone;
        }
    }

    /**号码解密
     * @param encryptPhone
     * @return
     */
    public static String getOriginPhone(String encryptPhone){
        if(encryptPhone == null || StringUtil.isBlank(encryptPhone)){
            return "";
        }
        //如果本来就没有加密
        if(encryptPhone.indexOf("greeEnc")==-1){
            return encryptPhone;
        }
        String originPhone = "";
        try {
            if(encryptPhone.charAt(encryptPhone.length()-2) != 45){
                return "";
            }
            originPhone = decryptEcb(key, encryptPhone.substring(0,encryptPhone.length()-10),ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return originPhone;
        }
    }

    /**获取加密后的信息
     * @param info
     * @return
     */
    public static String getSM4CommonInfo(String info){
        String encryptInfo = "";
        String cipher = null;
        if(info == null || StringUtil.isBlank(info)){
            return "";
        }
        //如果本来就加密
        if(info.indexOf("greeEnc")!=-1){
            return info;
        }
        try {
            cipher = encryptEcb(key, info,ENCODING);
            encryptInfo = cipher+"-greeEnc";

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return encryptInfo;
        }

    }

    /**获取解密后的信息
     * @param encryptInfo
     * @return
     */
    public static String getOriginCommonInfo(String encryptInfo){
        if(encryptInfo == null || StringUtil.isBlank(encryptInfo)){
            return "";
        }
        //如果本来就没有加密
        if(encryptInfo.indexOf("greeEnc")==-1){
            return encryptInfo;
        }
        if(isEncryptedPhone(encryptInfo)){
            return getOriginPhone(encryptInfo);
        }
        String originInfo = "";
        try {
            if(encryptInfo.charAt(encryptInfo.length()-8) != 45){
                return "";
            }
            originInfo = decryptEcb(key, encryptInfo.substring(0,encryptInfo.length()-8),ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return originInfo;
        }
    }

    private static boolean isEncryptedPhone(String encryptInfo) {
        int index = encryptInfo.indexOf("greeEnc");
        return encryptInfo.substring(index+7).length() > 0;
    }

    /**名称脱敏
     * @param name
     * @return
     */
    public static String fuzzingName(String name){
        if(name == null || name.length() == 0){
            return "";
        }
        int length = name.length();
        StringBuffer returnedName = new StringBuffer(name.substring(0,1));
        for(int idx = 1;idx < length;idx ++){
            returnedName.append("*");
        }
        return returnedName.toString();
    }

    /**地址脱敏
     * @param address
     * @return
     */
    public static String fuzzingAddress(String address){
        int length = address.length();

        if(address == null || length == 0){
            return "";
        }
        int half = Math.floorDiv(length,2);

        StringBuffer returnedAddress = new StringBuffer(address.substring(0,half));

        for(int idx = half-1;idx < address.length()-1;idx ++){
            returnedAddress.append("*");
        }

        return returnedAddress.toString();
    }

    /**保险单号脱敏
     * @param insuranceNumber
     * @return
     */
    public static String fuzzingInsuranceNumber(String insuranceNumber){
        int length = insuranceNumber.length();

        if(insuranceNumber == null || length == 0){
            return "";
        }

        int half = Math.floorDiv(length,2);

        StringBuffer returnedInsuranceNumber = new StringBuffer(insuranceNumber.substring(0,half));

        for(int idx = half-1;idx < insuranceNumber.length()-1;idx ++){
            returnedInsuranceNumber.append("*");
        }

        return returnedInsuranceNumber.toString();
    }

    /**资格证号脱敏
     * @param qualificationNumber
     * @return
     */
    public static String fuzzingQualificationNumber(String qualificationNumber){
        int length = qualificationNumber.length();

        if(qualificationNumber == null || length == 0){
            return "";
        }

        int half = Math.floorDiv(length,2);

        StringBuffer returnedQualificationNumber = new StringBuffer(qualificationNumber.substring(0,half));

        for(int idx = half-1;idx < qualificationNumber.length()-1;idx ++){
            returnedQualificationNumber.append("*");
        }

        return returnedQualificationNumber.toString();
    }

    /**qq脱敏
     * @param qq
     * @return
     */
    public static String fuzzingQQ(String qq){
        int length = qq.length();

        if(qq == null || length == 0){
            return "";
        }

        int half = Math.floorDiv(length,2);

        StringBuffer returnedQQ = new StringBuffer(qq.substring(0,half));
        for(int idx = half-1;idx < qq.length()-1;idx ++){
            returnedQQ.append("*");
        }

        return returnedQQ.toString();
    }

    /**电子邮箱号脱敏
     * @param email
     * @return
     */
    public static String fuzzingEmail(String email){
        int length = email.length();
        int cindex = email.indexOf("@");
        if(email == null || length == 0 || cindex == -1){
            return "";
        }
        StringBuffer preEmail = new StringBuffer();
        String returnedEmail = email.substring(cindex);
        for(int idx = 0;idx < cindex;idx ++){
            preEmail.append("*");
        }
        preEmail.append(returnedEmail);
        return preEmail.toString();
    }

    /**手机号码脱敏
     * @param phone
     * @return
     */
    public static String fuzzingPhone(String phone){
        int length = phone.length();

        if(phone == null || length == 0){
            return "";
        }
        if(length < 11){
            return phone;
        }
        StringBuffer returnedPhone = new StringBuffer(phone.substring(0,3));
        for(int idx = 3;idx < length-3;idx ++){
            returnedPhone.append("*");
        }
        returnedPhone.append(phone.substring(length-3));
        return returnedPhone.toString();
    }

    public static boolean isEncrypted(String info){
        return info.indexOf("-greeEnc") != -1;
    }


    /**
     *  @Description:測試類
     */
    public static void main(String[] args) {
        try {
//            String json = "中华人民共和国广州市天河区黄埔大道第十条街101号999";
//            // 自定義的32位16進位密鑰
//            String cipher = EncryptionUtils.encryptEcb(key, json,ENCODING);
//            System.out.println(cipher);
//            System.out.println(EncryptionUtils.verifyEcb(key, cipher, json));
//            json = EncryptionUtils.decryptEcb(key, cipher,ENCODING);
//            System.out.println(json);

            System.out.println("加密后的号码："+getSM4Phone("18620438992"));

            System.out.println("脱敏后的号码："+fuzzingPhone("18620438992"));


            System.out.println("解密后的号码："+getOriginPhone("f51aba9cecb6aec81104a653fa16c9b1-greeEnc-2"));

            System.out.println("加密后的普通信息："+getSM4CommonInfo("中华人民共和国广州市天河区黄埔大道第十条街101号999"));

            System.out.println("解密后的普通信息："+getOriginCommonInfo("d04bd128edfbedd2db49ae65704bfaa9-greeEnc"));

            System.out.println("模糊的姓名："+fuzzingName("G18789890987"));

            System.out.println("模糊的邮件地址："+fuzzingEmail("yyyui@163.com"));

            System.out.println("模糊的qq："+fuzzingQQ("285866133"));

            System.out.println("模糊的保险单："+fuzzingInsuranceNumber("285866133"));

            System.out.println("模糊的资格证："+fuzzingQualificationNumber("285866133"));

            System.out.println("模糊的地址："+fuzzingAddress("中华人民共和国广州市天河区黄埔大道第十条街101号999"));


            System.out.println("测试当前数据是否加密："+isEncrypted("没有加密"));

            System.out.println("测试当前数据是否加密："+isEncrypted("有加密的-greeEnc"));

            System.out.println(isEncryptedPhone("1c9b353691416b7805120982cbf33069-greeEnc-0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
