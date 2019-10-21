package com.test.system.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class JwtUtil {
	
	 private static final String USERNAME = "username";

	    private static final String KEY = "123456qwe";

	    /**
	     * 过期时间（分钟）
	     */
	    private static final int EXPIRATION_TIME = 5;

	    /**
	     * 生成token
	     *
	     * @param userName
	     * @return
	     * @author 刘朋
	     * <br/>date 2019-01-09
	     */
	    public static String createToken(String userName) {
	        Algorithm algorithm = Algorithm.HMAC256(KEY);

	        Date expirationDate = DateUtils.addMinutes(new Date(), EXPIRATION_TIME);
	        //生成token
	        return JWT.create().withClaim(USERNAME, userName)
	                .withExpiresAt(expirationDate)
	                .sign(algorithm);
	    }

	    /**
	     * 获取用户名
	     *
	     * @param token
	     * @return
	     * @author 刘朋
	     * <br/>date 2019-03-08
	     */
	    public static String getUsername(String token) {
	        return getValueByToken(token, USERNAME);
	    }

	    /**
	     * 获取token中的值
	     *
	     * @param token
	     * @param key
	     * @return
	     */
	    public static String getValueByToken(String token, String key) {
	        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KEY)).build();
	        DecodedJWT decode = verifier.verify(token);
	        return decode.getClaim(key).asString();
	    }

	    /**
	     * 校验是否过期，过期返回true
	     * @param token
	     * @return
	     * @author 刘朋
	     * <br/>date 2019-03-12
	     */
	    public static boolean isExpires(String token){
	        if(StringUtils.isBlank(token)){
	            return true;
	        }
	        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KEY)).build();
	        try {
	            verifier.verify(token);
	        }catch (JWTVerificationException e){
	            return true;
	        }
	        return false;
	    }

}
