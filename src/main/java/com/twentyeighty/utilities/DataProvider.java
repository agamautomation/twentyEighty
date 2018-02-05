package com.twentyeighty.utilities;

public class DataProvider {

	public Object[][] dataReader(String DataFilePath,String SheetName,String TestName)
	{
		try{
			XLSReader reader = new XLSReader(TableLayout.HORIZONTAL, DataFilePath, SheetName,TestName);
			System.out.println("Reader Started!");
			Object[][] data = reader.getTableArray(SheetName,TestName);
			if(data == null)System.out.println("@Data Is Null!");
			return  data;	
		}
		catch(Exception e){
			e.printStackTrace();
		}
			return null;
	}
}
