package cn.ucaner.common.exception;

public class AppointmentTimeConfigException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AppointmentTimeConfigException(String message, Throwable e) {
		super(message, e);
	}
	public AppointmentTimeConfigException(String message) {
		super(message);
	}
}
