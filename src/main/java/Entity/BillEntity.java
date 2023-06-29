package Entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@Column(name = "total_bill")
	private int totalBill;
	
	@Column(name = "order_date")
	private Timestamp oderDate;
	
	@OneToMany(mappedBy = "bill")
	List<DetailedInvoiceEntity> detailedInoice;

	public BillEntity(int id, UserEntity user, int totalBill, Timestamp oderDate,
			List<DetailedInvoiceEntity> detailedInoice) {
		super();
		this.id = id;
		this.user = user;
		this.totalBill = totalBill;
		this.oderDate = oderDate;
		this.detailedInoice = detailedInoice;
	}

	public BillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	public Timestamp getOderDate() {
		return oderDate;
	}

	public void setOderDate(Timestamp oderDate) {
		this.oderDate = oderDate;
	}

	public List<DetailedInvoiceEntity> getDetailedInoice() {
		return detailedInoice;
	}

	public void setDetailedInoice(List<DetailedInvoiceEntity> detailedInoice) {
		this.detailedInoice = detailedInoice;
	}
	
	
}
