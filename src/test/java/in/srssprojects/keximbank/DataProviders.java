package in.srssprojects.keximbank;

import org.testng.annotations.DataProvider;

import utilitiles.ExcelHelper;

public class DataProviders {
	
	@DataProvider(name="empData")
	public Object[][] getEmpData(){
		ExcelHelper excel = new ExcelHelper();
		return excel.getSheetData("resources", "testdata.xlsx", "empdata");
	}
	
	@DataProvider(name="roleData")
	public Object[][] getRoleData(){
		ExcelHelper excel = new ExcelHelper();
		return excel.getSheetData("resources", "testdata.xlsx", "roledata");
	}

}
