package com.app.transaction.channel.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.app.common.model.ReturnData;

import com.app.jdbc.service.JdbcBaseService;
import com.app.module.channel.dto.TTgChannelInfo;
import com.app.transaction.channel.service.ChannelService;
import com.app.transaction.common.action.BaseAction;
import com.app.utils.constant.MD5;


public class ChannelAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private ChannelService channelService;

	@Resource(name = "jdbcBaseServiceImpl")
	private JdbcBaseService baseService;

	private TTgChannelInfo ttgChannelInfo;

	private ReturnData rd;

	/**
	 * 获取渠道信息列表
	 * 
	 * @return
	 */
	public String getChannelList() {
		try {
			if (ttgChannelInfo == null) {
				ttgChannelInfo = new TTgChannelInfo();
			}
			ttgChannelInfo.setPageNumber(this.getPageNumber());
			ttgChannelInfo.setPageSize(20);
			rd = this.channelService.getChannelList(ttgChannelInfo);
			
			System.out.println(baseService.list("select * from  t_tg_channel_info"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e);
		}
		return "list";
	}

	/**
	 * 跳转到新增渠道页面
	 * 
	 * @return
	 */
	public String gotoAddChannel() {
		return "create";
	}

	/**
	 * 新增渠道信息
	 */
	public void saveChannel() {
		PrintWriter out = this.getWriter();
		String flag = "0000";
		try {
			if (ttgChannelInfo == null) {
				ttgChannelInfo = new TTgChannelInfo();
			}
			if("".equals(this.ttgChannelInfo.getChlname()) || null==this.ttgChannelInfo.getChlname()){
				flag="1";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlcomname()) || null==this.ttgChannelInfo.getChlcomname()){
				flag="2";
				return;
			}else if("".equals(this.ttgChannelInfo.getChltel()) || null==this.ttgChannelInfo.getChltel()){
				flag="3";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlmobile()) || null==this.ttgChannelInfo.getChlmobile()){
				flag="4";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlemail()) || null==this.ttgChannelInfo.getChlemail()){
				flag="5";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlamount()) || null==this.ttgChannelInfo.getChlamount()){
				flag="6";
				return;
			}
			this.channelService.saveChannel(ttgChannelInfo);
			String id = this.ttgChannelInfo.getId().toString();
			String name = this.getTtgChannelInfo().getChlname();
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date = new Date();
			String str = id + name + simpledateformat.format(date);
			this.ttgChannelInfo
					.setChlprikey(MD5.getInstance().get16BitMD5(str));
			this.ttgChannelInfo.setChlkey(MD5.getInstance().getNBitMD5(
					this.ttgChannelInfo.getChlprikey()
							+ this.ttgChannelInfo.getId()
							+ simpledateformat.format(date), 32));
			this.ttgChannelInfo.setJoindate(date);
			this.channelService.upChannel(ttgChannelInfo);
		} catch (Exception e) {
			flag = "1111";
			// TODO: handle exception
			log.error(e.getMessage(),e);
		} finally {
			out.print(flag);
			out.flush();
			out.close();
		}
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	public String gotoUpChannel() {
		try {
			if (ttgChannelInfo == null) {
				ttgChannelInfo = new TTgChannelInfo();
			}
			ttgChannelInfo = (TTgChannelInfo) this.channelService
					.findChannel(ttgChannelInfo);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e);
		}
		return "edit";
	}

	/**
	 * 修改渠道信息
	 */
	public void upChannel() {
		PrintWriter out = this.getWriter();
		String flag = "0000";
		try {
			if (ttgChannelInfo == null) {
				ttgChannelInfo = new TTgChannelInfo();
			}
			if (ttgChannelInfo == null) {
				ttgChannelInfo = new TTgChannelInfo();
			}
			if("".equals(this.ttgChannelInfo.getChlname()) || null==this.ttgChannelInfo.getChlname()){
				flag="1";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlcomname()) || null==this.ttgChannelInfo.getChlcomname()){
				flag="2";
				return;
			}else if("".equals(this.ttgChannelInfo.getChltel()) || null==this.ttgChannelInfo.getChltel()){
				flag="3";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlmobile()) || null==this.ttgChannelInfo.getChlmobile()){
				flag="4";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlemail()) || null==this.ttgChannelInfo.getChlemail()){
				flag="5";
				return;
			}else if("".equals(this.ttgChannelInfo.getChlamount()) || null==this.ttgChannelInfo.getChlamount()){
				flag="6";
				return;
			}			
			this.channelService.upChannel(ttgChannelInfo);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(),e);
		} finally {
			out.print(flag);
			out.flush();
			out.close();
		}
	}

	public TTgChannelInfo getTtgChannelInfo() {
		return ttgChannelInfo;
	}

	public void setTtgChannelInfo(TTgChannelInfo ttgChannelInfo) {
		this.ttgChannelInfo = ttgChannelInfo;
	}

	public ReturnData getRd() {
		return rd;
	}

	public void setRd(ReturnData rd) {
		this.rd = rd;
	}

}
