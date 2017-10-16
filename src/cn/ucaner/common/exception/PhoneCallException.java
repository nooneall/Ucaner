package cn.ucaner.common.exception;

public class PhoneCallException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PhoneCallException(String message, Throwable e) {
		super(message, e);
	}
	
	public PhoneCallException(String message) {
		super(message);
	}
}
