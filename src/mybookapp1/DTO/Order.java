package mybookapp1.DTO;

public class Order {
	private Integer id;
	private Integer goodsAmount;
	private String username;
	private String truename;
	private String address;
	private Integer ZIP;
	private String tel;
	private String email;
	private String payType;
	private String delivery;
	private Double discount;
	private String date;
	private String memo;
	private Integer state;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Integer goodsAmount, String username, String truename,
			String address, Integer zIP, String tel, String email,
			String payType, String delivery, Double discount, String date,
			String memo, Integer state) {
		super();
		this.id = id;
		this.goodsAmount = goodsAmount;
		this.username = username;
		this.truename = truename;
		this.address = address;
		ZIP = zIP;
		this.tel = tel;
		this.email = email;
		this.payType = payType;
		this.delivery = delivery;
		this.discount = discount;
		this.date = date;
		this.memo = memo;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(Integer goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZIP() {
		return ZIP;
	}

	public void setZIP(Integer ZIP) {
		this.ZIP = ZIP;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ZIP == null) ? 0 : ZIP.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((goodsAmount == null) ? 0 : goodsAmount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((payType == null) ? 0 : payType.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result
				+ ((truename == null) ? 0 : truename.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (ZIP == null) {
			if (other.ZIP != null)
				return false;
		} else if (!ZIP.equals(other.ZIP))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (goodsAmount == null) {
			if (other.goodsAmount != null)
				return false;
		} else if (!goodsAmount.equals(other.goodsAmount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (payType == null) {
			if (other.payType != null)
				return false;
		} else if (!payType.equals(other.payType))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (truename == null) {
			if (other.truename != null)
				return false;
		} else if (!truename.equals(other.truename))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", goodsAmount=" + goodsAmount + ", username="
				+ username + ", truename=" + truename + ", address=" + address
				+ ", ZIP=" + ZIP + ", tel=" + tel + ", email=" + email
				+ ", payType=" + payType + ", delivery=" + delivery
				+ ", discount=" + discount + ", date=" + date + ", memo="
				+ memo + ", state=" + state + "]";
	}

}
