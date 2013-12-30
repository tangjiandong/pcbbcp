/**
 * @Filename: UserAction.java
 * @Author：caiqf
 * @Date：2013-7-2
 */
package com.app.transaction.user.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.app.common.model.ReturnData;
import com.app.module.sys.dto.TTgSysRoleinfo;
import com.app.module.sys.dto.TTgSysRoleuserRel;
import com.app.module.user.dto.TTgUserinfo;
import com.app.transaction.common.action.BaseAction;
import com.app.transaction.sys.service.SysService;
import com.app.transaction.user.service.UserService;
import com.app.utils.constant.Constant;
import com.app.utils.constant.MD5;

/**
 * @Class: UserAction.java
 * @Description: 用户信息Action
 * @Author：caiqf
 * @Date：2013-7-2
 */
@SuppressWarnings("all")
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 3898545733452341762L;

	@Resource
	private UserService userService;
	@Resource
	private SysService sysService;

	private TTgUserinfo userInfo = new TTgUserinfo(); // 用户信息对象
	private ReturnData rd; // 用户信息分页列表对象
	private List dataList = new ArrayList(); // 角色信息列表对象
	private String password; // 旧密码
	private String passwordnew; // 新密码
	private String passwordconfirm; // 确认密码
	private String ids; // 主键编号字符串

	/**
	 * @Author：caiqf
	 * @Description: 进入个人资料修改页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String info() {
		try {
			/** 查询用户信息 */
			this.userInfo.setUserid(this.getLoginUserId()); // 用户编号
			Object u = this.userService.findTTgUserinfo(this.userInfo);
			if (null != u) {
				this.userInfo = (TTgUserinfo) u;
			} else {
				return "error";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "info";
	}

	/**
	 * @Author：caiqf
	 * @Description: 个人资料修改提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void infoSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.userInfo || null == this.userInfo.getUserid()) {
				flag = "1111"; // 用户编号为空
				return;
			}
			if (null == this.userInfo.getRealname()
					|| "".equals(this.userInfo.getRealname().trim())) {
				flag = "1"; // 真实姓名为空
				return;
			}

			/** 修改用户信息 */
			this.userService.updateTTgUserinfo(this.userInfo);

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
	 * @Description: 进入密码修改页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String pwd() {
		try {
			/** 查询用户信息 */
			this.userInfo.setUserid(this.getLoginUserId()); // 用户编号
			Object u = this.userService.findTTgUserinfo(this.userInfo);
			if (null != u) {
				this.userInfo = (TTgUserinfo) u;
			} else {
				return "error";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "pwd";
	}

	/**
	 * @Author：caiqf
	 * @Description: 密码修改提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void pwdSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.userInfo || null == this.userInfo.getUserid()) {
				flag = "1111"; // 用户编号为空
				return;
			}
			if (null == this.password || "".equals(this.password.trim())) {
				flag = "1"; // 旧密码为空
				return;
			}
			// 根据登录帐号查询用户登录信息
			this.userInfo.setUserid(this.getLoginUserId()); // 用户编号
			Object u = this.userService.findTTgUserinfo(this.userInfo);
			if (null != u) {
				this.userInfo = (TTgUserinfo) u;
				if (!this.userInfo.getPassword().equals(
						MD5.getInstance().getMD5(this.password))) {
					flag = "2"; // 旧密码错误
					return;
				}
			}
			if (null == this.passwordnew || "".equals(this.passwordnew.trim())) {
				flag = "3"; // 新密码为空
				return;
			}
			if (this.passwordnew.length() < 6 || this.passwordnew.length() > 16) {
				flag = "4"; // 新密码格式错误
				return;
			}
			if (null == this.passwordconfirm
					|| "".equals(this.passwordconfirm.trim())) {
				flag = "5"; // 确认密码为空
				return;
			}
			if (!this.passwordnew.equals(this.passwordconfirm)) {
				flag = "6"; // 两次密码不一致
				return;
			}

			/** 修改用户信息 */
			this.userInfo.setPassword(MD5.getInstance()
					.getMD5(this.passwordnew)); // 用户密码
			this.userService.updateTTgUserinfo(this.userInfo);

			flag = "0000"; // 成功
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
	 * @Description: 进入用户管理页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String list() {
		try {
			/** 查询用户信息分页列表 */
			this.userInfo.setPageNumber(this.getPageNumber());
			this.userInfo.setPageSize(20);
			this.rd = this.userService.listTTgUserinfoPage(this.userInfo);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "list";
	}
	
	

	/**
	 * @Author：caiqf
	 * @Description: 进入创建用户页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String create() {
		return "create";
	}

	/**
	 * @Author：caiqf
	 * @Description: 创建用户提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void createSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.userInfo.getUsername()
					|| "".equals(this.userInfo.getUsername().trim())) {
				flag = "1"; // 用户名为空
				return;
			}
			if (null == this.userInfo.getRealname()
					|| "".equals(this.userInfo.getRealname().trim())) {
				flag = "2"; // 真实姓名为空
				return;
			}
			if (null == this.userInfo.getPassword()
					|| "".equals(this.userInfo.getPassword().trim())) {
				flag = "3"; // 密码为空
				return;
			}

			/** 根据用户名查询用户信息 */
			TTgUserinfo user = new TTgUserinfo();
			user.setUsername(this.userInfo.getUsername()); // 用户名
			Object u = this.userService.findTTgUserinfo(user);
			if (null != u) {
				flag = "4"; // 用户名已存在
				return;
			}

			/** 保存用户信息 */
			user.setRealname(this.userInfo.getRealname()); // 真实姓名
			user.setPassword(MD5.getInstance().getMD5(
					this.userInfo.getPassword())); // 密码
			user.setUtype(this.userInfo.getUtype()); // 用户类别(1管理员2普通用户)
			user.setUphone(this.userInfo.getUphone()); // 联系电话
			user.setRemark(this.userInfo.getRemark()); // 说明
			user.setIsvalid(this.userInfo.getIsvalid()); // 是否有效(1是0否)
			user.setRegclsdate(new Date()); // 注册/失效时间
			user.setOptuserid(this.getLoginUserId()); // 操作人编号
			user.setOptusername(this.getLoginUserName()); // 操作人姓名
			user.setOptdate(new Date()); // 操作时间
			this.userService.addTTgUserinfo(user);

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
	 * @Description: 进入编辑用户页面
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public String edit() {
		try {
			/** 查询用户信息 */
			if (null == this.userInfo.getUserid()) {
				return "error";
			}
			Object u = this.userService.findTTgUserinfo(this.userInfo);
			if (null != u) {
				this.userInfo = (TTgUserinfo) u;
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
	 * @Description: 编辑用户提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void editSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.userInfo || null == this.userInfo.getUserid()) {
				flag = "1111"; // 用户编号为空
				return;
			}
			if (null == this.userInfo.getRealname()
					|| "".equals(this.userInfo.getRealname().trim())) {
				flag = "1"; // 真实姓名为空
				return;
			}

			/** 保存用户信息 */
			this.userService.updateTTgUserinfo(this.userInfo);

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
	 * @Description: 密码重置提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void resetPwd() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.userInfo || null == this.userInfo.getUserid()) {
				flag = "1111"; // 用户编号为空
				return;
			}

			/** 修改用户信息 */
			this.userInfo.setPassword(MD5.getInstance().getMD5(
					Constant.DEFAULT_USER_PWD)); // 用户密码
			this.userService.updateTTgUserinfo(this.userInfo);

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
	 * @Description: 进入分配角色页面
	 * @Date：2013-7-12 上午10:08:08
	 * @Return：String
	 */
	public String role() {
		try {
			if (null == this.userInfo || null == this.userInfo.getUserid()) {
				return "error"; // 用户编号为空
			}

			/** 查询角色信息列表 */
			TTgSysRoleinfo role = new TTgSysRoleinfo();
			this.dataList = this.sysService.listTTgSysRoleinfo(role);

			/** 查询角色用户关联信息列表 */
			TTgSysRoleuserRel ru = new TTgSysRoleuserRel();
			ru.setUserid(this.userInfo.getUserid()); // 用户编号
			List list = this.sysService.listTTgSysRoleuserRel(ru);
			if (null != list && list.size() > 0) {
				this.ids = "";
				for (int i = 0; i < list.size(); i++) {
					ru = (TTgSysRoleuserRel) list.get(i);
					this.ids += "[" + ru.getRoleid().toString() + "]" + ",";
				}
				if (!"".equals(this.ids)) {
					this.ids = this.ids.substring(0, this.ids.length() - 1);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "role";
	}

	/**
	 * @Author：caiqf
	 * @Description: 分配角色提交
	 * @Date：2013-7-2 下午3:59:24
	 * @Return：String
	 */
	public void roleSub() {
		PrintWriter out = this.getWriter();
		String flag = "";
		try {
			/** 校验信息 */
			if (null == this.userInfo || null == this.userInfo.getUserid()) {
				flag = "1111"; // 用户编号为空
				return;
			}
			if (null == this.ids || "".equals(this.ids)) {
				flag = "1111";
				return;
			}

			// 用户编号字符串
			String[] temp = this.ids.split(",");
			if (temp.length > 0) {
				/** 先删除后保存角色用户关联信息 */
				TTgSysRoleuserRel ru = new TTgSysRoleuserRel();
				ru.setUserid(this.userInfo.getUserid()); // 用户编号
				this.sysService.deleteTTgSysRoleuserRel(ru);
				for (int i = 0; i < temp.length; i++) {
					ru = new TTgSysRoleuserRel();
					ru.setRoleid(Integer.valueOf(temp[i])); // 角色编号
					ru.setUserid(this.userInfo.getUserid()); // 用户编号
					ru.setOptuserid(this.getLoginUserId()); // 操作人编号
					ru.setOptusername(this.getLoginUserName()); // 操作人名称
					ru.setOptdate(new Date()); // 创建时间
					this.sysService.addTTgSysRoleuserRel(ru);
				}

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

	public TTgUserinfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(TTgUserinfo userInfo) {
		this.userInfo = userInfo;
	}

	public ReturnData getRd() {
		return rd;
	}

	public void setRd(ReturnData rd) {
		this.rd = rd;
	}

	public String getPassword() {
		return password;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordnew() {
		return passwordnew;
	}

	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
	}

	public String getPasswordconfirm() {
		return passwordconfirm;
	}

	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SysService getSysService() {
		return sysService;
	}

	public void setSysService(SysService sysService) {
		this.sysService = sysService;
	}

	
	
}
