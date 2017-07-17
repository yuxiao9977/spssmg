package com.yt.sm.frame.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
/**
 * 导入Excel工具类
 * @author Administrator
 *
 */
public class ImpUtil {
	/** 
     * POI:解析Excel文件中的数据并把每行数据封装成一个实体 
     * @param fis 文件输入流 
     * @return List<XykxyxxVO> Excel中数据封装实体的集合 
	 * @throws IOException 
     */  
	 public static List<Person> importPerson(InputStream fis,String fileType) throws IOException { 
		 	//这里是解析出来的Excel的数据存放的List集合  
	        List<Person> infos = new ArrayList<Person>();  
	         //这里是解析出来的Excel中的每一条数据封装的实体BEAN.  
	        Person person = null; 
	        Workbook hwb = null;
	        if (fileType.equals("xls")) { 
	        	//创建Excel97或2003工作薄  
	        	hwb = new HSSFWorkbook(fis);
	        }  
	        else if(fileType.equals("xlsx")){
	        	 //创建Excel2007工作薄  
	        	hwb = new XSSFWorkbook(fis);
	        }  
	        try {  
	            //创建Excel工作薄  
	            //得到第一个工作表  
	             Sheet sheet = hwb.getSheetAt(0);  
	             Row row = null;  
	            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数   
	             	person = new Person(); 
	                for(int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
	                	row = sheet.getRow(j);  
	                	if(j==1){
	                    person.setXm(ImpUtil.getCellValue(row.getCell(1)));
	                    person.setXb(ImpUtil.getCellValue(row.getCell(4)));
	                    person.setCsrq(row.getCell(6).toString());
	                    person.setJg(ImpUtil.getCellValue(row.getCell(8)));
	                	}               
	                	if(j==2){
	                		person.setMz(ImpUtil.getCellValue(row.getCell(1)));
	                		person.setDp(ImpUtil.getCellValue(row.getCell(3)));
	                		person.setWhcd(ImpUtil.getCellValue(row.getCell(6)));
	                		person.setJszc(ImpUtil.getCellValue(row.getCell(8)));
	                	}               
	                	if(j==3){
	                		person.setZy(ImpUtil.getCellValue(row.getCell(1)));
	                		person.setZc(ImpUtil.getCellValue(row.getCell(5)));
	                	}               
	                	if(j==4){
	                		person.setWysp(ImpUtil.getCellValue(row.getCell(1)));
	                		person.setXcsgz(ImpUtil.getCellValue(row.getCell(6)));
	                	}               
	                	if(j==5){
	                		person.setGzdw(ImpUtil.getCellValue(row.getCell(1)));
	                		person.setZw(ImpUtil.getCellValue(row.getCell(7)));
	                	}               
	                	if(j==6){
	                		person.setTxdz(ImpUtil.getCellValue(row.getCell(1)));
	                		person.setDh(ImpUtil.getCellValue(row.getCell(7)));
	                	}               
	                	if(j==7){
	                		person.setHsrh(ImpUtil.getCellValue(row.getCell(2)));
	                		person.setBhzw(ImpUtil.getCellValue(row.getCell(7)));
	                	}               
	                	if(j==8){
	                		person.setXl(ImpUtil.getCellValue(row.getCell(1)));
	                		person.setByxx(ImpUtil.getCellValue(row.getCell(4)));
	                		person.setXw(ImpUtil.getCellValue(row.getCell(7)));
	                	}               
	                	if(j==9){
	                		person.setGzjl(ImpUtil.getCellValue(row.getCell(1)));
	                	}               
	                	if(j==10){
	                		person.setKycg(ImpUtil.getCellValue(row.getCell(1)));
	                	}               
	                }  
	                infos.add(person);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return infos;  
	    }  
	 public static List<Group> importGroup(InputStream fis,String fileType) throws IOException { 
		 //这里是解析出来的Excel的数据存放的List集合  
		 List<Group> infos = new ArrayList<Group>();  
		 //这里是解析出来的Excel中的每一条数据封装的实体BEAN.  
		 Group group = null; 
		 Workbook hwb = null;
		 if (fileType.equals("xls")) {  
			 //创建Excel97或2003工作薄  
	        	hwb = new HSSFWorkbook(fis);
	        }  
	        else if(fileType.equals("xlsx")){ 
	        	 //创建Excel2007工作薄  
	        	hwb = new XSSFWorkbook(fis);
	        } 
		 try {  
			 //创建Excel工作薄  
			 //得到第一个工作表  
			 Sheet sheet = hwb.getSheetAt(0);  
			 Row row = null;  
			 //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数   
			 group = new Group(); 
			 //遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数  
			 for(int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
				 row = sheet.getRow(j);  
				 if(j==1){
					 group.setSqdwmc(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==2){
					 group.setDwfr(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==3){
					 group.setChxhlsxm(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==4){
					 group.setDwrs(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==5){
					 group.setJsrys(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==6){
					 group.setGjzcrs(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==7){
					 group.setZjzcrs(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==8){
					 group.setDwdz(ImpUtil.getCellValue(row.getCell(1)));
					 group.setYb(ImpUtil.getCellValue(row.getCell(7)));
				 }               
				 if(j==9){
					 group.setLxrxm(ImpUtil.getCellValue(row.getCell(1)));
					 group.setLxdh(ImpUtil.getCellValue(row.getCell(3)));
					 group.setCz(ImpUtil.getCellValue(row.getCell(7)));
				 }               
				 if(j==10){
					 group.setEm(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==11){
					 group.setChzzjb(ImpUtil.getCellValue(row.getCell(1)));
					 group.setBh(ImpUtil.getCellValue(row.getCell(5)));
				 }               
				 if(j==12){
					 group.setYwfw(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==13){
					 group.setDwcbw(ImpUtil.getCellValue(row.getCell(1)));
				 }               
				 if(j==15){
					 group.setRhsj(ImpUtil.getCellValue(row.getCell(1)));
				 }               
			 }  
			 infos.add(group);  
		 } catch (Exception e) {  
			 e.printStackTrace();  
		 }  
		 return infos;  
	 }  
	 /**
	  * 判断从Excel文件中解析出来数据的格式  
	  * @param cell
	  * @return
	  */
	    private static String getCellValue(Cell cell){  
	        String value = null;  
	        //简单的查检列类型  
	        switch(cell.getCellType())  
	        {  
	            case Cell.CELL_TYPE_STRING://字符串  
	                value = cell.getRichStringCellValue().getString();  
	                break;  
	          case Cell.CELL_TYPE_NUMERIC://数字  
	                long dd = (long)cell.getNumericCellValue();  
	                value = dd+"";  
	                break;
	            case Cell.CELL_TYPE_BLANK:  
	                value = "";  
	                break;     
	            case Cell.CELL_TYPE_FORMULA:  
	                value = String.valueOf(cell.getCellFormula());  
	                break;  
	            case Cell.CELL_TYPE_BOOLEAN://boolean型值  
	                value = String.valueOf(cell.getBooleanCellValue());  
	                break;  
	            case Cell.CELL_TYPE_ERROR:  
	                value = String.valueOf(cell.getErrorCellValue());  
	                break;  
	            default:  
	                break;  
	        }  
	        return value;  
	    }  
}
