/**
 * @Filename: MenuAction.java
 * @Author：caiqf
 * @Date：2013-7-12
 */
package com.app.transaction.sys.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.app.common.model.ReturnData;
import com.app.module.sys.dto.TTgSysMenuinfo;
import com.app.transaction.common.action.BaseAction;
import com.app.transaction.sys.service.SysService;

/**
 * @Class: MenuAction.java
 * @Description: 菜单管理Action
 * @Author：caiqf
 * @Date：2013-7-12
 */
@SuppressWarnings("all")
public class MenuAction extends BaseAction {
	private static final long serialVersionUID = 5233796069870270496L;

	@Resource
	private SysService sysService;

	private TTgSysMenuinfo menuInfo = new TTgSysMenuinfo(); // 菜单信息对象
	private List menuList = new ArrayList(); // 菜单信息列表
	private ReturnData rd; // 用户信息分页列表对象
	private Integer pid = 0; // 菜单编号
	private String pname; // 菜单名称

	/**
	 * @Author：caiqf
	 * @Description: 进入菜单管理页面
	 * @Date：2013-7-12 上午10:08:08
	 * @Return：String
	 */
	public String list() {
		try {
			/** 查询菜单信息分页列表 */
			this.menuInfo.setPageNumber(this.getPageNumber());
			this.menuInfo.setPageSize(20);
			this.menuInfo.setParentid(this.pid); // 父菜单编号
			this.rd = this.sysService.listTTgSysMenuinfoPage(this.menuInfo);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "list";
	}

	/**
	 * @Author：caiqf
	 * @Description: 查询菜单信息列表
	 * @Date：2013-7-29 下午5:29:38
	 * @Return：void
	 */
	public String listAjax() {
		try {
			if (null == this.pid) {
				return null;
			}

			/** 根据父分类编号查询内容分类信息列表 */
			TTgSysMenuinfo menu = new TTgSysMenuinfo();
			menu.setParentid(this.pid); // 父菜单编号
			this.menuList = this.sysService.listTTgSysMenuinfo(menu);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "listAjax";
	}

	/**
	 * @Author：caiqf
	 * @Description: 进入创建菜单页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String create() {
		try {
			if (null != this.pid && this.pid > 0) {
				/** 查询菜单信息 */
				TTgSysMenuinfo menu = new TTgSysMenuinfo();
				menu.setMid(this.pid); // 分类编号
				Object m = this.sysService.findTTgSysMenuinfo(menu);
				if (null != m) {
					menu = (TTgSysMenuinfo) m;
					this.pid = menu.getMid();
					this.pname = menu.getMname();
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "create";
	}

	/**
	 * @Author：caiqf
	 * @Description: 创建菜单提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void createSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.pid) {
				flag = "1111"; // 父菜单编号为空
				return;
			}
			if (null == this.menuInfo.getMname()
					|| "".equals(this.menuInfo.getMname().trim())) {
				flag = "1"; // 菜单名称为空
				return;
			}
			if (null == this.menuInfo.getMdesc()
					|| "".equals(this.menuInfo.getMdesc().trim())) {
				flag = "2"; // 菜单描述为空
				return;
			}
			if (null == this.menuInfo.getMsort()) {
				flag = "3"; // 排序号为空
				return;
			}

			/** 根据菜单名称查询菜单信息 */
			TTgSysMenuinfo menu = new TTgSysMenuinfo();
			menu.setMname(this.menuInfo.getMname()); // 菜单名称
			menu.setParentid(this.pid); // 父菜单编号
			Object m = this.sysService.findTTgSysMenuinfo(menu);
			if (null != m) {
				flag = "4"; // 菜单名称已存在
				return;
			}

			/** 查询父菜单信息 */
			Integer levelno = 1; // 菜单级别数
			menu = new TTgSysMenuinfo();
			menu.setMid(this.pid); // 主键(菜单编号)
			m = this.sysService.findTTgSysMenuinfo(menu);
			if (null != m) {
				menu = (TTgSysMenuinfo) m;
				/** 修改菜单信息 */
				if (this.pid > 0) {
					menu.setIsleaf("1"); // 是否有下级节点(1是0否)
					this.sysService.updateTTgSysMenuinfo(menu);
					levelno = menu.getLevelno() + 1;
				}
			}

			/** 保存菜单信息 */
			TTgSysMenuinfo entity = new TTgSysMenuinfo();
			entity.setParentid(this.pid); // 二级菜单
			entity.setMname(this.menuInfo.getMname()); // 菜单名称
			entity.setMdesc(this.menuInfo.getMdesc()); // 菜单描述
			entity.setActionurl(this.menuInfo.getActionurl()); // 链接地址
			entity.setMsort(this.menuInfo.getMsort()); // 排序号
			entity.setIsvalid(this.menuInfo.getIsvalid()); // 是否有效(1是0否)
			entity.setRemark(this.menuInfo.getRemark()); // 备注
			entity.setOptuserid(this.getLoginUserId()); // 操作人编号
			entity.setOptusername(this.getLoginUserName()); // 操作人姓名
			entity.setOptdate(new Date()); // 操作时间
			entity.setIsleaf("0"); // 是否有下级节点(1是0否)
			entity.setLevelno(levelno); // 菜单级别数
			this.sysService.addTTgSysMenuinfo(entity);

			flag = "0000";
		} catch (Exception e) {
			flag = "1111"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			out.print(flag);
			out.flush();
			out.close();
		}
	}

	/**
	 * @Author：caiqf
	 * @Description: 进入编辑菜单页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String edit() {
		try {
			/** 查询菜单信息 */
			if (null == this.menuInfo || null == this.menuInfo.getMid()) {
				return "error";
			}
			Object m = this.sysService.findTTgSysMenuinfo(this.menuInfo);
			if (null != m) {
				this.menuInfo = (TTgSysMenuinfo) m;
			} else {
				return "error";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "edit";
	}

	/**
	 * @Author：caiqf
	 * @Description: 编辑菜单提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void editSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.menuInfo || null == this.menuInfo.getMid()) {
				flag = "1111"; // 菜单编号为空
				return;
			}
			if (null == this.menuInfo.getMname()
					|| "".equals(this.menuInfo.getMname().trim())) {
				flag = "1"; // 菜单名称为空
				return;
			}
			if (null == this.menuInfo.getMdesc()
					|| "".equals(this.menuInfo.getMdesc().trim())) {
				flag = "2"; // 菜单描述为空
				return;
			}
			if (null == this.menuInfo.getMsort()) {
				flag = "3"; // 排序号为空
				return;
			}

			/** 根据菜单名称查询菜单信息 */
			TTgSysMenuinfo menu = new TTgSysMenuinfo();
			menu.setMid(this.menuInfo.getMid()); // 菜单编号
			Object m = this.sysService.findTTgSysMenuinfo(menu);
			if (null != m) {
				menu = (TTgSysMenuinfo) m;
				if (!this.menuInfo.getMname().equals(menu.getMname())) {
					TTgSysMenuinfo entity = new TTgSysMenuinfo();
					entity.setMname(this.menuInfo.getMname()); // 菜单名称
					entity.setParentid(menu.getParentid()); // 父菜单编号
					m = this.sysService.findTTgSysMenuinfo(entity);
					if (null != m) {
						flag = "4"; // 菜单名称已存在
						return;
					}
				}

				/** 修改菜单信息 */
				this.sysService.updateTTgSysMenuinfo(this.menuInfo);

				flag = "0000";
			}
		} catch (Exception e) {
			flag = "1111"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			out.print(flag);
			out.flush();
			out.close();
		}
	}

	public TTgSysMenuinfo getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(TTgSysMenuinfo menuInfo) {
		this.menuInfo = menuInfo;
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	public ReturnData getRd() {
		return rd;
	}

	public void setRd(ReturnData rd) {
		this.rd = rd;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
}
