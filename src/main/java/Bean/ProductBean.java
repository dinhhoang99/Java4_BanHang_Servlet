package Bean;

import java.math.BigDecimal;

public class ProductBean {
	private String productName;
	private String category;
	private BigDecimal price;
	private int quantity;
	private String description;
	private Boolean active;
	public ProductBean(String productName, String category, BigDecimal price, int quantity, String description,
			Boolean active) {
		super();
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.active = active;
	}
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
}
