package Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "[view]")
	private int view;
	
	@Column(name = "share")
	private int share;
	
	@Column(name = "sold")
	private int sold;
	
	@Column(name = "poster")
	private String poster;
	
	@Column(name = "describe")
	private String describe;
	
	@Column(name = "date_submitted")
	private Timestamp date_submitted;
	
	@Column(name = "isActive")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "product")
	List<CartEntity> cart;
	
	@OneToMany(mappedBy = "product")
	List<DetailedInvoiceEntity> detailedInvoi;

	public ProductEntity(int id, String title, String category, BigDecimal price, int quantity, int view, int share,
			int sold, String poster, String describe, Timestamp date_submitted, Boolean isActive, List<CartEntity> cart,
			List<DetailedInvoiceEntity> detailedInvoi) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.view = view;
		this.share = share;
		this.sold = sold;
		this.poster = poster;
		this.describe = describe;
		this.date_submitted = date_submitted;
		this.isActive = isActive;
		this.cart = cart;
		this.detailedInvoi = detailedInvoi;
	}

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Timestamp getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(Timestamp date_submitted) {
		this.date_submitted = date_submitted;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<CartEntity> getCart() {
		return cart;
	}

	public void setCart(List<CartEntity> cart) {
		this.cart = cart;
	}

	public List<DetailedInvoiceEntity> getDetailedInvoi() {
		return detailedInvoi;
	}

	public void setDetailedInvoi(List<DetailedInvoiceEntity> detailedInvoi) {
		this.detailedInvoi = detailedInvoi;
	}

	
	
	
}
