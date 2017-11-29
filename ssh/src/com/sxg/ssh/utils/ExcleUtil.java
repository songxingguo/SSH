package com.sxg.ssh.utils;

import java.text.DecimalFormat;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcleUtil {
    public static int getIntCellValue(XSSFRow row,int index){
        int rtn = 0;
        try {
        	XSSFCell cell = row.getCell((short)index);
            rtn = (int)cell.getNumericCellValue();
        } catch (RuntimeException e) {
        }
        return rtn;
    }
    
    public static String getStringValue(XSSFRow row,int index){
        String rtn = "";
        try {
        	XSSFCell cell = row.getCell(index);
            rtn = getCellStringValue(cell);
        } catch (RuntimeException e) {
        }
        return rtn;
    }
    
    /**
     * 将列转换为字符串
     * @param cell
     * @return
     */
    public static String getCellStringValue(XSSFCell cell) {      
        String cellValue = "";      
        switch (cell.getCellType()) {      
        case XSSFCell.CELL_TYPE_STRING://字符串类型   
            cellValue = cell.getStringCellValue();      
            if(cellValue.trim().equals("")||cellValue.trim().length()<=0)      
                cellValue=" ";      
            break;      
        case XSSFCell.CELL_TYPE_NUMERIC: //数值类型   
            cellValue = formScientific(cell.getNumericCellValue());      
            break;      
        case XSSFCell.CELL_TYPE_FORMULA: //公式   
            cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);      
            cellValue = String.valueOf(cell.getNumericCellValue());      
            break;      
        case XSSFCell.CELL_TYPE_BLANK:      
            cellValue=" ";      
            break;      
        case XSSFCell.CELL_TYPE_BOOLEAN:      
            break;      
        case XSSFCell.CELL_TYPE_ERROR:      
            break;      
        default:      
            break;      
        }      
        return cellValue;      
    }  
    
    /**
     * 将科学计数法转换为字符串
     * @param number
     * @return
     */
    private static String formScientific(Double number) {
    	return new DecimalFormat("0").format(number);  
    }
}
