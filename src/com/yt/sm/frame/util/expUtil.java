package com.yt.sm.frame.util;
import java.util.List;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class expUtil {
	@SuppressWarnings("deprecation")
	public static  XSSFWorkbook exportPerson(List<Person> list) {    
    	String[] excelHeader = 
    		{ "姓名", "性别", "单位", "入会时间", "担任学会职务"};  
    		// 单元格列宽  
    		int[] excelHeaderWidth = { 100, 80, 260, 150, 150 };  
    		  
    		XSSFWorkbook wb = new XSSFWorkbook();  
    		 XSSFSheet sheet = wb.createSheet("个人会员信息");  
    		sheet.setDisplayGridlines(false);//设置隐藏网格线
    		// 合并单元格  
    		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4)); 
    		//Region region=new Region(0,(short)0,0,(short)6);
    		//sheet.getMergedRegion(region);
    		// 设置大标题样式  
    		 XSSFRow row = sheet.createRow((int) 0); //创建行 
    		 XSSFCellStyle bigStyle = wb.createCellStyle();//创建样式 
    		 //设置实线
    		bigStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//设置单元格左边的样式
    		bigStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//设置单元格右边的样式
    		bigStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//设置单元格上边的样式
    		bigStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//设置单元格下边的样式
    		Font bigfont = wb.createFont();  
    		bigfont.setColor(HSSFColor.BLACK.index);  
    		bigfont.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体  
    		bigfont.setFontHeightInPoints((short)24);//设置字号
    		bigStyle.setFont(bigfont); 
    		bigStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 水平居中  
    		bigStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
    		//setRegionStyle(sheet,region,bigStyle);
    		
    		// 设置每列标题样式  
    		 XSSFCellStyle style1 = wb.createCellStyle(); 
    		//设置实线
    		style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);//设置单元格左边的样式
    		style1.setBorderRight(XSSFCellStyle.BORDER_THIN);//设置单元格右边的样式
    		style1.setBorderTop(XSSFCellStyle.BORDER_THIN);//设置单元格上边的样式
    		style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);//设置单元格下边的样式
    		 Font font1 = wb.createFont();  
    		font1.setColor(HSSFColor.BLACK.index);
    		font1.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD); // 粗体  
    		font1.setFontHeightInPoints((short)14);//设置字号
    		style1.setFont(font1); 
    		style1.setAlignment(XSSFCellStyle.ALIGN_LEFT); // 水平居左  
    		style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
    		  
    		// 设置每列样式  
    		 XSSFCellStyle style = wb.createCellStyle();  
    		// 设置居中样式  
    		style.setAlignment(XSSFCellStyle.ALIGN_LEFT); // 水平居左    
    		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
    		style.setWrapText(true);//自动换行
    		 //设置实线
    		 style.setBorderLeft(XSSFCellStyle.BORDER_THIN);//设置单元格左边的样式
    		 style.setBorderRight(XSSFCellStyle.BORDER_THIN);//设置单元格右边的样式
    		 style.setBorderTop(XSSFCellStyle.BORDER_THIN);//设置单元格上边的样式
    		 style.setBorderBottom(XSSFCellStyle.BORDER_THIN);//设置单元格下边的样式
    		 Font font = wb.createFont(); 
    		 font.setFontHeightInPoints((short)12);//设置字号
    		 style.setFont(font); 
    		
    		// 设置列宽度（像素）  
    		for (int i = 0; i < excelHeaderWidth.length; i++) {  
    		    sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);  
    		}  
    		  
    		// 添加大标题  
    		     XSSFCell bigcell = row.createCell(0);
    		    bigcell.setCellValue("个人会员信息");  
    		    bigcell.setCellStyle(bigStyle);  
    		// 添加每列标题 
    		    row = sheet.createRow(1);
    		    row.setHeightInPoints(28);//设置行高像素
    		for (int i = 0; i < excelHeader.length; i++) {  
    			XSSFCell cell = row.createCell(i);  
    			cell.setCellValue(excelHeader[i]);  
    			cell.setCellStyle(style1);  
    		}  
    		// 添加具体数据 
    		 for (int i = 0; i < list.size(); i++) {    
    	            row = sheet.createRow(i + 2);
    	           // row.setHeightInPoints(25);//设置行高像素
    	            Person person = list.get(i);  
    	            XSSFCell cell0 = row.createCell(0);
    	            cell0.setCellValue(person.getXm());
    	            cell0.setCellStyle(style);
    	            XSSFCell cell1 = row.createCell(1);
    	            cell1.setCellValue(person.getXb());
    	            cell1.setCellStyle(style);
    	            XSSFCell cell2 = row.createCell(2);
    	            cell2.setCellValue(person.getGzdw());
    	            cell2.setCellStyle(style);
    	            XSSFCell cell3 = row.createCell(3);
    	            cell3.setCellValue(person.getHsrh());
    	            cell3.setCellStyle(style);
    	            XSSFCell cell4 = row.createCell(4);
    	            cell4.setCellValue(person.getBhzw());
    	            cell4.setCellStyle(style);
    	        }  
    	return wb; 
    }

	public static XSSFWorkbook exportGroup(List<Group> list) {
		String[] excelHeader = 
    		{ "单位名称", "单位资质级别", "法人", "单位联系人", "联系方式","单位地址"};  
    		// 单元格列宽  
    		int[] excelHeaderWidth = { 150, 130, 120, 120, 120,260 };  
    		  
    		XSSFWorkbook wb = new XSSFWorkbook();  
    		 XSSFSheet sheet = wb.createSheet("团体会员信息");  
    		sheet.setDisplayGridlines(false);//设置隐藏网格线
    		// 合并单元格  
    		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,5)); 
    		//Region region=new Region(0,(short)0,0,(short)6);
    		//sheet.getMergedRegion(region);
    		// 设置大标题样式  
    		 XSSFRow row = sheet.createRow((int) 0); //创建行 
    		 XSSFCellStyle bigStyle = wb.createCellStyle();//创建样式 
    		 //设置实线
    		bigStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//设置单元格左边的样式
    		bigStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//设置单元格右边的样式
    		bigStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//设置单元格上边的样式
    		bigStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//设置单元格下边的样式
    		Font bigfont = wb.createFont();  
    		bigfont.setColor(HSSFColor.BLACK.index);  
    		bigfont.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体  
    		bigfont.setFontHeightInPoints((short)24);//设置字号
    		bigStyle.setFont(bigfont); 
    		bigStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 水平居中  
    		bigStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
    		//setRegionStyle(sheet,region,bigStyle);
    		
    		// 设置每列标题样式  
    		 XSSFCellStyle style1 = wb.createCellStyle(); 
    		//设置实线
    		style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);//设置单元格左边的样式
    		style1.setBorderRight(XSSFCellStyle.BORDER_THIN);//设置单元格右边的样式
    		style1.setBorderTop(XSSFCellStyle.BORDER_THIN);//设置单元格上边的样式
    		style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);//设置单元格下边的样式
    		 Font font1 = wb.createFont();  
    		font1.setColor(HSSFColor.BLACK.index);
    		font1.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD); // 粗体  
    		font1.setFontHeightInPoints((short)14);//设置字号
    		style1.setFont(font1); 
    		style1.setAlignment(XSSFCellStyle.ALIGN_LEFT); // 水平居左  
    		style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
    		  
    		// 设置每列样式  
    		 XSSFCellStyle style = wb.createCellStyle();  
    		// 设置居中样式  
    		style.setAlignment(XSSFCellStyle.ALIGN_LEFT); // 水平居左    
    		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
    		style.setWrapText(true);//自动换行
    		 //设置实线
    		 style.setBorderLeft(XSSFCellStyle.BORDER_THIN);//设置单元格左边的样式
    		 style.setBorderRight(XSSFCellStyle.BORDER_THIN);//设置单元格右边的样式
    		 style.setBorderTop(XSSFCellStyle.BORDER_THIN);//设置单元格上边的样式
    		 style.setBorderBottom(XSSFCellStyle.BORDER_THIN);//设置单元格下边的样式
    		 Font font = wb.createFont(); 
    		 font.setFontHeightInPoints((short)12);//设置字号
    		 style.setFont(font); 
    		
    		// 设置列宽度（像素）  
    		for (int i = 0; i < excelHeaderWidth.length; i++) {  
    		    sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);  
    		}  
    		  
    		// 添加大标题  
    		     XSSFCell bigcell = row.createCell(0);
    		    bigcell.setCellValue("团体会员信息");  
    		    bigcell.setCellStyle(bigStyle);  
    		// 添加每列标题 
    		    row = sheet.createRow(1);
    		    row.setHeightInPoints(28);//设置行高像素
    		for (int i = 0; i < excelHeader.length; i++) {  
    			XSSFCell cell = row.createCell(i);  
    			cell.setCellValue(excelHeader[i]);  
    			cell.setCellStyle(style1);  
    		}  
    		// 添加具体数据 
    		 for (int i = 0; i < list.size(); i++) {    
    	            row = sheet.createRow(i + 2);
    	           // row.setHeightInPoints(25);//设置行高像素
    	            Group group = list.get(i);  
    	            XSSFCell cell0 = row.createCell(0);
    	            cell0.setCellValue(group.getSqdwmc());
    	            cell0.setCellStyle(style);
    	            XSSFCell cell1 = row.createCell(1);
    	            cell1.setCellValue(group.getChzzjb());
    	            cell1.setCellStyle(style);
    	            XSSFCell cell2 = row.createCell(2);
    	            cell2.setCellValue(group.getDwfr());
    	            cell2.setCellStyle(style);
    	            XSSFCell cell3 = row.createCell(3);
    	            cell3.setCellValue(group.getLxrxm());
    	            cell3.setCellStyle(style);
    	            XSSFCell cell4 = row.createCell(4);
    	            cell4.setCellValue(group.getLxdh());
    	            cell4.setCellStyle(style);
    	            XSSFCell cell5 = row.createCell(5);
    	            cell5.setCellValue(group.getDwdz());
    	            cell5.setCellStyle(style);
    	        }  
    	return wb; 
	}

}
