package work.metanet.utils;

import java.util.Map;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignUtil {
	
	public static String getDigestStr_sha256(Map<String, Object> map) {
		//return SecureUtil.signParams(DigestAlgorithm.SHA256, map, "&", "=",true);
		String signStr = getSignStr(map);
		log.info("signStr:{}",signStr);
		String sha256Str = getDigestStr_sha256(signStr);
		log.info("sha256Str:{}",sha256Str);
		return sha256Str;
	}
	
	public static String getSignStr(Map<String, Object> map) {
		return MapUtil.sortJoin(map, "&", "=", true);
	}
	
	public static String getDigestStr_sha256(String signStr) {
		return SecureUtil.sha256(signStr);
	}
	
	public static String sign_Sha256withAES(String secret,Map<String, Object> map) {
		return SecureUtil.aes(secret.getBytes()).encryptHex(getDigestStr_sha256(map));
	}
	
	public static String sign_AES(String secret,String digestStr) {
		AES aes = SecureUtil.aes(secret.getBytes());
		return aes.encryptHex(digestStr);
	}
	
	public static String unSign_AES(String secret,String sign) {
		return SecureUtil.aes(secret.getBytes()).decryptStr(sign);
	}
	
	public static void main(String[] args) {
		//test();
		System.out.println(unSign_AES("KpEhUHjyNCyhSl8G", "0CB110AE395E60AB57C757D5ED2CB0C0F22564120CBE28AC7ED0C0A2E5A4FB02CC3E5058140C093795599694D70E85CDD98704D4126FD6B2941C79CCD4B0BF40"));
	}
	
}
