package com.yc.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Component
public class ExcelUtil {
	public void createExcel(List<?> objs, OutputStream os) throws IOException, RowsExceededException, WriteException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(objs.size()==0){
			return;
		}
		//String str=objs.get(0).getClass().getName();
		//int index=str.lastIndexOf('.')+1;
		//str=str.substring(index);
		//File file = new File("E:/"+str+"报表.xls");
		//file.createNewFile();
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		Label label = null;
		for (int i = 0; i < objs.size(); i++) {
			Object obj= objs.get(i);
			Field[] flist = obj.getClass().getDeclaredFields();
			for (int j = 0; j < flist.length; j++) {
				flist[j].setAccessible(true);
				String name = flist[j].getName();
				String upperName = name.substring(0, 1).toUpperCase()  
                        + name.substring(1); 
				if (i == 0) {
					label = new Label(j, i, name);
					sheet.addCell(label);
				}
				label = new Label(j, i+1, getMethodValue(obj,upperName));
				sheet.addCell(label);
			}
		}
		workbook.write();
		workbook.close();
		os.close();
	}
	private static String getMethodValue(Object obj,String upperName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = obj.getClass().getMethod("get" + upperName);
		Object value=method.invoke(obj);
		if(upperName.contains("Date")&&value!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(value);
		}
		if(value!=null){
			return value.toString();
		}
		return "";
	}
	public List<?> readExcel(File file,Class<?> classpath) throws BiffException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException{
		Workbook workbook=Workbook.getWorkbook(file);
		Sheet sheet=workbook.getSheet(0);
		String[] str=new String[sheet.getColumns()];
		Method[] classMethod=classpath.getMethods();
		Method[] colMethod=new Method[sheet.getColumns()];
		for(int i=0;i<sheet.getColumns();i++){
			String contents=sheet.getCell(i,0).getContents();
			str[i]="set"+contents.substring(0, 1).toUpperCase()+contents.substring(1);
		}
		for(int i=0;i<sheet.getColumns();i++){
			for(int j=0;j<classMethod.length;j++){
				if(str[i].equals(classMethod[j].getName())){
					colMethod[i]=classMethod[j];
					break;
				}
			}
		}
		List<Object> list=new ArrayList<>();
		for(int i=1;i<sheet.getRows();i++){
			System.out.println(sheet.getRows());
			Object obj=classpath.newInstance();
			for (int j = 0; j < sheet.getColumns(); j++) {
				if(colMethod[j].getName().contains("Date")){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					colMethod[j].invoke(obj, sdf.parse(sheet.getCell(j,i).getContents()));
				}else if(colMethod[j].getName().contains("Id")){
					System.out.println("i:"+i+";j:"+j);
					colMethod[j].invoke(obj, Integer.parseInt(sheet.getCell(j,i).getContents()));
				}else{
					System.out.println(colMethod[j].getName());
					colMethod[j].invoke(obj, sheet.getCell(j,i).getContents());
				}
			}
			list.add(obj);
		}
		return list;
	}
}