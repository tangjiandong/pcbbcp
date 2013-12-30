package  com.app.transaction.shop.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.dao.BaseDaoImpl;
import com.app.transaction.shop.dao.ShopinfoDao;



/**
*
*商户信息DaoImpl
*/ 
@SuppressWarnings("all") 
@Repository("shopinfoDaoImpl") 
public class  ShopinfoDaoImpl extends BaseDaoImpl implements ShopinfoDao {

	/**
	*
	*新增商户信息
	*/ 
	public void addTAppShopinfo(EntityBase entity) throws Exception {
	    this.insert("TAppShopinfo.insertTAppShopinfoByModel", entity);
	}

	/**
	*
	*修改商户信息
	*/ 
	public void updateTAppShopinfo(EntityBase entity) throws Exception {
	    this.update("TAppShopinfo.updateTAppShopinfoByModel", entity);
	}

	/**
	*
	*新增商户信息
	*/ 
	public void deleteTAppShopinfo(EntityBase entity) throws Exception {
	    this.delete("TAppShopinfo.deleteTAppShopinfoByModel", entity);
	}

	/**
	*
	*查找商户信息
	*/ 
	public Object findTAppShopinfo(EntityBase entity) throws Exception{
	  return  this.findByProperty("TAppShopinfo.selectTAppShopinfoByModel", entity);
	}

	/**
	*
	*查询商户信息
	*/ 
	public List listTAppShopinfo(EntityBase entity) throws Exception{
	  return  this.listByProperty("TAppShopinfo.selectTAppShopinfoByModel", entity);
	}

	/**
	*
	*查询商户信息分页列表
	*/ 
	public ReturnData listTAppShopinfoPage(EntityBase entity) throws Exception {
	  return  this.listDataPaging("TAppShopinfo.selectTAppShopinfoByModel_list_page", entity);
	}


}