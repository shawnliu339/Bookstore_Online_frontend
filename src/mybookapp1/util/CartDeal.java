package mybookapp1.util;

import java.text.DecimalFormat;
import java.util.List;

import mybookapp1.DTO.Cart;

public class CartDeal {
	
	private Double allMoney = 0.0;
	
	public CartDeal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * 接收购物车中的商品，并返回总金额
	 * 
	 * @param carts 购物车中的商品列表
	 */
	public Double getAllMoney(List<Cart> carts) {
		
		for(Cart cartTemp : carts){
			allMoney += cartTemp.getMoney();
		}
		
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		allMoney = Double.parseDouble(moneyFormat.format(allMoney));
		return allMoney;
	}

}
