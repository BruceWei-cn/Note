package com.ming.demo.design.pattern.strategy.nostratery;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Ming
 * @Date: 2021/6/9 11:15
 * @Description: 不使用策略模式： 模拟电商中分享不同类型商品的环节
 */
public class ShareFactory {

	enum ShareType {
		SINGLE(1, "单商品"),
		MULTI(2, "多商品"),
		ORDER(3, "下单");

		private Integer code;
		private String desc;

		ShareType(Integer code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public Integer getCode(){
			return code;
		}
	}

	/**
	 * 用if-else模拟多种策略场景，并根据场景做出响应
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Integer shareType = 1;
		// 业务逻辑 -> 用if - else来模拟多种情况，区分行为策略
		if (shareType.equals(ShareType.SINGLE.getCode())){
			SingleItemShare singleItemShare = new SingleItemShare();
			singleItemShare.algorithm("单商品");
		}else if (shareType.equals(ShareType.MULTI.getCode())) {
			MultiItemShare multiItemShare = new MultiItemShare();
			multiItemShare.algorithm("多商品");
		} else if (shareType.equals(ShareType.ORDER.getCode())) {
			OrderItemShare orderItemShare = new OrderItemShare();
			orderItemShare.algorithm("下单");
		} else {
			throw new Exception("未知分享类型");
		}
	}
}
