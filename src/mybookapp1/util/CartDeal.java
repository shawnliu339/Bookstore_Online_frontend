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
	 * ���չ��ﳵ�е���Ʒ���������ܽ��
	 * 
	 * @param carts ���ﳵ�е���Ʒ�б�
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
