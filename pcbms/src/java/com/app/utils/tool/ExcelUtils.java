/**
 * 文件名:ExcelUtils.java
 * 作者：caiqifan
 * 完成日期：2011-6-22
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 */
package com.app.utils.tool;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Class: exportUtil.java Description: Excel导出工具类
 * 
 * @author caiqifan
 * @version 1.0, 2011-6-22
 * @since JDK1.6
 */
public class ExcelUtils {
	/**
	 * @author caiqifan
	 * @date 2011-6-22 下午04:26:54
	 * @describe 导出自定义的Excel到指定路径
	 * @param title
	 *            存放标题数组
	 * @param filepath
	 *            自定义指定存放路径
	 * @param sheetname
	 *            Sheet标签页名
	 * @param list
	 *            存放需导出的数据集合
	 * @return void
	 * @exception
	 * @version 1.0
	 */
	public static void writeExcel(String[] title, String filepath,
			String sheetname, List<Object[]> list) {
		try {
			// 创建Excel工作薄
			WritableWorkbook wwb;
			// 新建的xls文件输出路径
			OutputStream os = new FileOutputStream(filepath);
			wwb = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet(sheetname, 0);
			Label label; // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z, 样式(可为空)
			// 填充标题行数据
			for (int i = 0; i < title.length; i++) {
				WritableFont titleWf = new WritableFont(
						WritableFont.createFont("仿宋_GB2312"),// 字体
						WritableFont.DEFAULT_POINT_SIZE, // 字号
						WritableFont.BOLD, // 粗体
						false, // 斜体
						UnderlineStyle.NO_UNDERLINE, // 下划线
						Colour.BLACK, // 字体颜色
						ScriptStyle.NORMAL_SCRIPT);
				WritableCellFormat wc = new WritableCellFormat(titleWf);
				wc.setAlignment(Alignment.CENTRE); // 设置文字水平居中
				wc.setVerticalAlignment(VerticalAlignment.CENTRE); // 设置文字垂直居中
				wc.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
				wc.setBackground(jxl.format.Colour.ICE_BLUE); // 设置单元格背景颜色
				label = new Label(i, 0, title[i], wc);
				sheet.addCell(label);
				sheet.setColumnView(i, 25); // 设置列的宽度
				sheet.setRowView(0, 400); // 设置行的高度
			}
			// 填充表格数据行
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					WritableCellFormat wc = new WritableCellFormat();
					wc.setAlignment(Alignment.CENTRE); // 设置文字水平居中
					wc.setVerticalAlignment(VerticalAlignment.CENTRE); // 设置文字垂直居中
					wc.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线
					Object[] obj = (Object[]) list.get(i);
					for (int j = 0; j < obj.length; j++) {
						label = new Label(j, i + 1, getObjString(obj[j]), wc);
						sheet.addCell(label);
						sheet.setRowView(i + 1, 400); // 设置行的高度
					}
				}
			}
			wwb.write(); // 写入数据
			wwb.close(); // 关闭文件
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getObjString(Object obj) {
		String objstr = "";
		if (obj != null) {
			objstr = obj.toString();
		}
		return objstr;
	}
}
