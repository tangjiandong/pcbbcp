package  com.app.transaction.shop.dao;
import java.util.List;
import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.BaseDao;



/**
*
*商户信息Dao
*/ 
@SuppressWarnings("all") 
public interface  ShopinfoDao extends BaseDao {

	/**
	*
	*新增商户信息
	*/ 
	public void addTAppShopinfo(EntityBase entity) throws Exception;

	/**
	*
	*修改商户信息
	*/ 
	public void updateTAppShopinfo(EntityBase entity) throws Exception;

	/**
	*
	*新增商户信息
	*/ 
	public void deleteTAppShopinfo(EntityBase entity) throws Exception;

	/**
	*
	*查找商户信息
	*/ 
	public Object findTAppShopinfo(EntityBase entity) throws Exception;

	/**
	*
	*查询商户信息
	*/ 
	public List listTAppShopinfo(EntityBase entity) throws Exception;

	/**
	*
	*查询商户信息分页列表
	*/ 
	public ReturnData listTAppShopinfoPage(EntityBase entity) throws Exception;


}