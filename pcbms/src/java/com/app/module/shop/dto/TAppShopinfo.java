package  com.app.module.shop.dto;
import com.app.common.model.EntityBase;
import java.util.Date;


/**
*
*商户信息
*/ 
@SuppressWarnings("all") 
public class  TAppShopinfo extends EntityBase {

	private	Integer	id;//主键
	private	String	shopname;//商户名称
	private	String	tel;//送餐电话
	private	String	address;//商户地址
	private	String	ishot;//是否今日推荐(1是0否)
	private	String	status;//是否有效(1是0否)
	private	Date	credate;//创建时间

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setShopname(String shopname){
		this.shopname=shopname;
	}
	public String getShopname(){
		return shopname;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public String getTel(){
		return tel;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setIshot(String ishot){
		this.ishot=ishot;
	}
	public String getIshot(){
		return ishot;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setCredate(Date credate){
		this.credate=credate;
	}
	public Date getCredate(){
		return credate;
	}

}