/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2017年6月12日</p>
 *  <p> Created by 钟乳石</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.dictonary;

public enum OrderStatusEnum {
	/* 管理后台，医生状态，病人状态*/
   UNRECEIVE(1,"待接诊","待接诊","待接诊"),
   UNSERVICE(2,"待服务","待服务","待服务"),
   SERVICING(3,"服务中","服务中","服务中"),
   FINISHED(4,"已完成","已完成","已完成"),
   SERVIC_EXCEPTION(5,"服务异常","服务异常","服务异常"),
   REJECTED(6,"已拒绝","已拒绝 ","已拒绝"),//已拒绝 
   TRANSED(7,"已转诊","已取消","已取消"),
   NOTRANS(8,"拒转诊","已取消","已取消"),
   CANCELED(9,"已取消","已取消","已取消"), //用户在医生接诊前取消订单
   TIMEOUT(10,"已过期","已过期","已过期");// 预约时间到了还没有进行转诊
/*   RETURNFEEING(11,"退费中","","退费中"),
   RETURNFEEED(12,"已退费","","退费中");  // 
*/
  
   
   private int orderStatus;
   private String orderStatusLabel;
   private String docOrderStatusLabel;
   
   private OrderStatusEnum(int orderStatus, String orderStatusLabel,
		   String docOrderStatus,String patientOrderStatus) {
		this.orderStatus = orderStatus;
		this.orderStatusLabel = orderStatusLabel;
	}

	public int getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getOrderStatusLabel() {
		return orderStatusLabel;
	}
	
	public void setOrderStatusLabel(String orderStatusLabel) {
		this.orderStatusLabel = orderStatusLabel;
	}
	
	public  OrderStatusEnum getStatusEnum(Integer status) {
		if(OrderStatusEnum.UNRECEIVE.getOrderStatus() == status) {
			return OrderStatusEnum.UNRECEIVE;
		}
		if(OrderStatusEnum.UNSERVICE.getOrderStatus() == status) {
			return OrderStatusEnum.UNSERVICE;
		}
		if(OrderStatusEnum.SERVICING.getOrderStatus() == status) {
			return OrderStatusEnum.SERVICING;
		}
		if(OrderStatusEnum.FINISHED.getOrderStatus() == status) {
			return OrderStatusEnum.FINISHED;
		}
		if(OrderStatusEnum.SERVIC_EXCEPTION.getOrderStatus() == status) {
			return OrderStatusEnum.SERVIC_EXCEPTION;
		}
		if(OrderStatusEnum.REJECTED.getOrderStatus() == status) {
			return OrderStatusEnum.REJECTED;
		}
		if(OrderStatusEnum.NOTRANS.getOrderStatus() == status) {
			return OrderStatusEnum.NOTRANS;
		}
		if(OrderStatusEnum.NOTRANS.getOrderStatus() == status) {
			return OrderStatusEnum.NOTRANS;
		}
		if(OrderStatusEnum.CANCELED.getOrderStatus() == status) {
			return OrderStatusEnum.CANCELED;
		}
		if(OrderStatusEnum.TIMEOUT.getOrderStatus() == status) {
			return OrderStatusEnum.TIMEOUT;
		}
		return null;
	}
	   
   
}
