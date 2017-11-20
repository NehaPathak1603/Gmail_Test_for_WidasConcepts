package generic;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	public static String getCellValue(String path,String sheet,int row,int cell)
	{
		String v="";
		try 
		{
			 Workbook wb=WorkbookFactory.create(new File(path));
			 Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
			 v=c.toString();
		} 
		
	    catch (Exception e) 
		{
			
		} 
		return v;
	}
	public static int getRowCount(String path,String sheet)
	{
		int rc=0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new File(path));
			rc= wb.getSheet(sheet).getLastRowNum();
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return rc;
	}
		

}
