package  com.app.transaction.shop.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.service.BaseServiceImpl;
import com.app.transaction.shop.service.ShopinfoService;
import com.app.transaction.shop.dao.ShopinfoDao;



/**
*
*商户信息ServiceImpl
*/ 
@SuppressWarnings("all") 
@Service("shopinfoServiceImpl") 
public class  ShopinfoServiceImpl extends BaseServiceImpl implements ShopinfoService {


	@Resource
	private  ShopinfoDao shopinfoDao;


	/**
	*
	*新增商户信息
	*/ 
	public void addTAppShopinfo(EntityBase entity) throws Exception {
	    this.shopinfoDao.addTAppShopinfo(entity);
	}

	/**
	*
	*修改商户信息
	*/ 
	public void updateTAppShopinfo(EntityBase entity) throws Exception {
	    this.shopinfoDao.updateTAppShopinfo(entity);
	}

	/**
	*
	*新增商户信息
	*/ 
	public void deleteTAppShopinfo(EntityBase entity) throws Exception {
	    this.shopinfoDao.deleteTAppShopinfo(entity);
	}

	/**
	*
	*查找商户信息
	*/ 
	public Object findTAppShopinfo(EntityBase entity) throws Exception{
	  return  this.shopinfoDao.findTAppShopinfo(entity);
	}

	/**
	*
	*查询商户信息
	*/ 
	public List listTAppShopinfo(EntityBase entity) throws Exception{
	  return  this.shopinfoDao.listTAppShopinfo(entity);
	}

	/**
	*
	*查询商户信息分页列表
	*/ 
	public ReturnData listTAppShopinfoPage(EntityBase entity) throws Exception {
	  return  this.shopinfoDao.listTAppShopinfoPage(entity);
	}


}