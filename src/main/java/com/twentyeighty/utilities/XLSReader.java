package com.twentyeighty.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XLSReader {
	@SuppressWarnings("unused")
	private XLSReader() {
	}// Dummy Constructor

	public XLSReader(TableLayout tableLayout, String xlsFileName,String sheetName,String testName) {
		this.tableLayout = tableLayout;
		this.xlsFileName = xlsFileName;
	}

	/**
	 * Helps you set the conditional selection of the data. E.g. If ignore set
	 * to true. Returned data set will not contain value with particular key.
	 * 
	 * @param selection
	 * @param ignore
	 */
	public void setSelection(Hashtable<String, String> selection, boolean ignore) {
		this.selection = selection;
		this.ignore = ignore;
	}

	public Object[][] getTableArray(String sheetName, String tableName)
			throws Exception {
		Sheet sheet = getSheet(sheetName);
		if (sheet == null)
			throw new Exception("Sheet " + sheetName + " is empty!");
		List<Cell> cells = getTable(sheet, tableName);
		if (cells.size() < 2 || cells == null)
			throw new Exception("Table " + tableName + " is not found!");
		return getData(sheet, cells);
	}

	private Object[][] getData(Sheet sheet, List<Cell> cells) {
		if (this.tableLayout.equals(TableLayout.HORIZONTAL))
			return readDataHorizontally(sheet, cells);
		else
			return readDataVertically(sheet, cells);
	}

	private Object[][] readDataHorizontally(Sheet sheet, List<Cell> cells) {
		int tableStartRow, tableStartCol, tableEndRow, tableEndCol;
		tableStartRow = cells.get(0).getRow() + 1;
		tableStartCol = cells.get(0).getColumn() + 1;
		tableEndRow = cells.get(1).getRow()+1 ;
		tableEndCol = cells.get(1).getColumn()+1 ;
		System.out.println("Start Row: " + tableStartRow + "\tStartCol: "
				+ tableStartCol + "\tEndRow: " + tableEndRow
				+ "\tTableEndCol: " + tableEndCol);
		List<Hashtable<String, String>> dataList = new ArrayList<Hashtable<String, String>>();
		for (int i = tableStartRow + 1; i < tableEndRow - 1; i++) {
			Hashtable<String, String> data = new Hashtable<String, String>();
			for (int j = tableStartCol; j < tableEndCol - 1; j++) {
				String Key = sheet.getCell(j, tableStartRow).getContents();
				String Val = sheet.getCell(j, i).getContents();
				System.out.println("Reading Row: " + i + "\tReading Col: " + j
						+ "\tKey: " + Key + "\tVal: " + Val);
				data.put(Key, Val);
			}
			dataList.add(data);
		}
		return applyFilter(dataList);
	}

	private Object[][] readDataVertically(Sheet sheet, List<Cell> cells) {
		int tableStartRow, tableStartCol, tableEndRow, tableEndCol;
		tableStartRow = cells.get(0).getRow() + 1;
		tableStartCol = cells.get(0).getColumn() + 1;
		tableEndRow = cells.get(1).getRow() + 1;
		tableEndCol = cells.get(1).getColumn() + 1;
		System.out.println("Start Row: " + tableStartRow + "\tStartCol: "
				+ tableStartCol + "\tEndRow: " + tableEndRow
				+ "\tTableEndCol: " + tableEndCol);
		List<Hashtable<String, String>> dataList = new ArrayList<Hashtable<String, String>>();
		for (int i = tableStartCol + 1; i < tableEndCol - 1; i++) {
			Hashtable<String, String> data = new Hashtable<String, String>();
			{
				for (int j = tableStartRow + 1; j < tableEndRow - 1; j++) {
					String Key = sheet.getCell(tableStartCol, j).getContents();
					String Val = sheet.getCell(i, j).getContents();
					System.out.println("Key: " + Key + "\tVal: " + Val);
					data.put(Key, Val);
				}
				dataList.add(data);
			}
		}
		return applyFilter(dataList);
	}

	private Object[][] applyFilter(List<Hashtable<String, String>> data) {
		System.out.println("@applyFilter: Data size passed is: " + data.size());
		{
			if (selection != null && selection.size() > 0) {
				List<Hashtable<String, String>> newList = new ArrayList<Hashtable<String, String>>();
				System.out.println("Selection is not null!");
				Set<String> keys = this.selection.keySet();
				for (Hashtable<String, String> tempHash : data) {
					int keyCount = keys.size();
					int i = 0;
					for (String key : keys) {
						String valueInSelection = this.selection.get(key);
						String valueInTempHash = tempHash.get(key);
						if (valueInSelection.toLowerCase().equals(
								valueInTempHash.toLowerCase())
								&& !ignore && valueInSelection != null) {
							{
								if (++i == keyCount)
									newList.add(tempHash);
							}
						}
					}
				}
				return getObjectArrayFromHashList(newList);
			} else
				System.out.println("Selection is null! Using newList as data..");
		}
		return getObjectArrayFromHashList(data);
	}

	private Object[][] getObjectArrayFromHashList(
			List<Hashtable<String, String>> data) {
		System.out.println("@getObjectArrayFromHashList: Data size passed is: "
				+ data.size());
		Object[][] dataArray = new Object[data.size()][1];
		{
			int i = 0;
			for (Hashtable<String, String> hashData : data) {
				dataArray[i][0] = hashData;
				i++;
			}
		}
		return dataArray;
	}

	private Sheet getSheet(String sheetName) throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File(this.xlsFileName));
		return workbook.getSheet(sheetName);
	}

	private List<Cell> getTable(Sheet sheet, String tableName) {
		List<Cell> cells = new ArrayList<Cell>();
		int tableStartRow, tableStartCol;
		Cell tableStart = sheet.findCell(tableName);
		tableStartRow = tableStart.getRow();
		tableStartCol = tableStart.getColumn();
		Cell tableEnd = sheet.findCell(tableName, tableStartCol + 1,
				tableStartRow + 1, sheet.getColumns() - 1, sheet.getRows() - 1, false);
		cells.add(tableStart);
		cells.add(tableEnd);
		System.out.println(this.getClass() + "@getTableStart Row: "
				+ tableStartRow + "\tStartCol: " + tableStartCol + "\tEndRow: "
				+ tableEnd.getRow() + "\tTableEndCol: " + tableEnd.getColumn());
		return cells;
	} 

	private Hashtable<String, String> selection;
	private boolean ignore;
	private TableLayout tableLayout;
	private String xlsFileName;
}
