package com.hanfeng.chess.client;
import java.security.MessageDigest;

/*
 * name不使用封装
 * password使用
 * 暂时没有UID，AGE，SEX这些信息，就造成用户名为唯一识别方法
 * */
public class user {
	public String name = ""; 
	private String password = "";
	
	public user(String userName) {
		this.name = userName;
	}
	
	public void setPassword(String userPassword) {
		try {
			this.password = encryptUserPassword(userPassword).toString();
		}catch(Exception e) {
			System.out.println("假的！加密都出错！");
			e.printStackTrace();
		}
	}
	
	//get的密码已经加密
	public String getPassword() {
		return this.password;
	}
	//加密算法
	//但是感觉在传参处存在漏洞，可能会导致用户密码泄露
	private static byte[] encryptUserPassword(String userPassword) throws Exception {
		//MD5加密，非常简单。
		String userInfo = new String("ThisIsAGameByHanFeng_@" + userPassword);
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(userInfo.getBytes());
		return md5.digest();

	}
}
