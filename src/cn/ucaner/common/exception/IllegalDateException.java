package cn.ucaner.common.exception;

public class IllegalDateException extends OrderException {
	
	private static final long serialVersionUID = 1L;
	private int code;

	public IllegalDateException(String message) {
		super(message);
	}
	
	public IllegalDateException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
