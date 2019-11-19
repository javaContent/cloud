package com.test.common.enums;

/**
 * 异常类型编码
 * @author Administrator
 *
 */
public enum ErrorCodeEnum {
	
	/*成功*/
	SUCESS(0,"成功"),
	LOGIN_ERR(101,"登陆失败"),
	DATA_SQL_ERROR(102,"执行数据库操作sql语法错误"),
	SYS_ERROR_OTHER(14999,"系统未知异常");
	
	private int errCode;
	private String message;
	ErrorCodeEnum(int code,String msg){
		this.errCode=code;
		this.message=msg;
	}
	public int getErrCode() {
		return errCode;
	}
	public String getMessage() {
		return message;
	}

}
