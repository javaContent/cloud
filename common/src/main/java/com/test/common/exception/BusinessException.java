package com.test.common.exception;

import com.test.common.enums.ErrorCodeEnum;
/**
 * 业务异常类,规定service以及DAO层抛出的异常类型  
 * @author Administrator
 *
 */
public class BusinessException extends RuntimeException {
	
	/**异常信息编码*/
	protected int errorCode;
	
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: 异常构造</p> 
	* @param errorCode 统一异常编码
	 */
	public BusinessException(ErrorCodeEnum errorCode)
    {
        super(errorCode.getMessage());
        
        this.errorCode = errorCode.getErrCode();
    }
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param errorCode 统一异常编码
	* @param message 自定义异常描述
	 */
	public BusinessException(ErrorCodeEnum errorCode, String message)
    {
        super(message);
        
        this.errorCode = errorCode.getErrCode();
    }
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param errorCode 统一异常编码
	* @param e 异常内容
	 */
	 public BusinessException(ErrorCodeEnum errorCode, Throwable e)
	    {
	        super(errorCode.getMessage(), e);

	        this.errorCode = errorCode.getErrCode();
	    }
	 /**
	  * 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param errorCode 统一异常编码
	 * @param message 自定义异常描述
	 * @param e 异常内容
	  */
    public BusinessException(ErrorCodeEnum errorCode, String message, Throwable e)
    {
        super(message, e);

        this.errorCode = errorCode.getErrCode();
    }
    
	public BusinessException(Integer errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	public int getErrorCode() {
		return errorCode;
	}

}
