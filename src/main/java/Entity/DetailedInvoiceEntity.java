package Entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detailed_invoice")
public class DetailedInvoiceEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bill")
	private BillEntity bill;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private ProductEntity product;
	
	@Column(name = "total_money")
	private BigDecimal totalMoney;

	public DetailedInvoiceEntity(int id, BillEntity bill, ProductEntity product, BigDecimal totalMoney) {
		super();
		this.id = id;
		this.bill = bill;
		this.product = product;
		this.totalMoney = totalMoney;
	}

	public DetailedInvoiceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
