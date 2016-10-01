package mybookapp1.DTO;

public class Sale {

	private Integer id;
	private Double money;
	private String date;
	private Integer orderId;

	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(Integer id, Double money, String date, Integer orderId) {
		super();
		this.id = id;
		this.money = money;
		this.date = date;
		this.orderId = orderId;
	}

	public Integer getId() {
		return id;
	}

	public Double getMoney() {
		return money;
	}

	public String getDate() {
		return date;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		Sale other = (Sale) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", money=" + money + ", date=" + date
				+ ", orderId=" + orderId + "]";
	}

}
