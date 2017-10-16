package cn.ucaner.common.exception;

public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OrderException(String message, Throwable e) {
		super(message, e);
	}
	public OrderException(String message) {
		super(message);
	}
}
