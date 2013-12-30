/**
 * 文件名: DefaultAction.java
 * 作者：caiqf
 * 完成日期：2012-12-7
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.app.common.model.ReturnData;
import com.app.module.shop.dto.TAppShopinfo;
import com.app.transaction.common.action.BaseAction;
import com.app.transaction.shop.service.ShopinfoService;


/**
 * Class: DefaultAction.java Description: 管理系统后台主页Action
 * 
 * @author caiqf
 * @date 2012-12-7
 */
@SuppressWarnings("all")
public class DefaultAction extends BaseAction {
	private static final long serialVersionUID = 8029706494886407357L;

	@Resource
	private ShopinfoService shopinfoService;
	
	/**
	 * 
	 * @author 
	 * @date 2012-12-7 下午04:05:17
	 * @describe 管理系统后台主页
	 * @return String
	 */
	public String gotoHome() {
		try {
//           //新增
//			TAppShopinfo  shopinfo=new TAppShopinfo();
//			shopinfo.setShopname("香蜜湖KFC");
//			shopinfo.setTel("13692278565");
//			shopinfo.setAddress("香蜜湖美食街");
//			shopinfo.setIshot("9");
//			shopinfo.setStatus("3");
//			shopinfo.setCredate(new Date());
//			shopinfoService.addTAppShopinfo(shopinfo);
			
			//查询 并修改
//			TAppShopinfo  shopinfo=new TAppShopinfo();
//			shopinfo.setId(9);
//			Object obj=shopinfoService.findTAppShopinfo(shopinfo);
//			
//			if(obj !=null){
//				shopinfo=(TAppShopinfo)obj;
//				System.out.println(shopinfo.getShopname());
//				shopinfo.setShopname("香蜜湖KFC1");
//				shopinfo.setTel("13692278565 0755-87456321");
//				shopinfo.setAddress("香蜜湖美食街1");
//				shopinfo.setIshot("8");
//				shopinfo.setStatus("5");
//				shopinfo.setCredate(new Date());
//				shopinfoService.updateTAppShopinfo(shopinfo);
//			}
//			
			
			//删除
//			TAppShopinfo  shopinfo=new TAppShopinfo();
//			shopinfo.setId(9);
//			shopinfoService.deleteTAppShopinfo(shopinfo);
			
			
			
//			//查询列表
//			TAppShopinfo  shopinfo=new TAppShopinfo();
//			List list =shopinfoService.listTAppShopinfo(shopinfo);
//			System.out.println(list);

			
			//分页
//			 ReturnData rd; // 用户信息分页列表对象
//			 TAppShopinfo  shopinfo=new TAppShopinfo();
//			 shopinfo.setPageNumber(this.getPageNumber());
//				shopinfo.setPageSize(4);
//			rd = shopinfoService.listTAppShopinfoPage(shopinfo);
//			System.out.println(rd.getResultlist());
//			System.out.println(rd.getRecordCount());
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "home";
	}
}
