package com.sxg.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxg.ssh.domain.Student;
import com.sxg.ssh.dto.StudentDTO;
import com.sxg.ssh.service.StudentService;
import com.sxg.ssh.utils.ExcelTemplate;
import com.sxg.ssh.utils.ExcleUtil;

@ParentPackage("ssh")  
@Controller
public class ParseExcelAction extends ActionSupport 
	implements ModelDriven<StudentDTO> {

	private static final long serialVersionUID = 1L;
	
	private  StudentDTO stuDTO = new StudentDTO();
	@Override
	public StudentDTO getModel() {
		return stuDTO;
	}
	
	@Autowired
	private StudentService studentService;

	//导入Excel文件
    private File excel;
    
	private String excelFileName;
	
	private String excelContentType;
    
    //封装要上传的文件
    public File getExcel() {
        return excel;
    }
    
    public void setExcel(File excel) {
        this.excel = excel;
    }
    
	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getExcelContentType() {
		return excelContentType;
	}

	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}

	@Action(value="/importExcel", results={@Result(name="importExcel", type="chain",
			location="stus")})
    public String importExcel(){
		
        ActionContext tx = ActionContext.getContext();
        String successanderror="";
        
        if(excel != null){
            try {
                //读取excel文件分析Excel文件中的数据
            	XSSFWorkbook  wb = new XSSFWorkbook(new FileInputStream(excel));
                
                //读取第一页的内容
            	XSSFSheet sheet = wb.getSheetAt(0);
                
                //从数据行开始读取数据
                for(int i=1; i<=sheet.getLastRowNum(); i++){
                	XSSFRow row = sheet.getRow(i);
                    
                    StudentDTO stuDTO = new StudentDTO();
                    
                    stuDTO.setStuNo(ExcleUtil.getStringValue(row, 0));
                    stuDTO.setStuName(ExcleUtil.getStringValue(row, 1));
                    stuDTO.setStuAge(ExcleUtil.getIntCellValue(row, 2));
              
                    studentService.saveStudent(stuDTO);
                }
                
            } catch (Exception e) {
                successanderror=e.getMessage();
            }finally{
                tx.put("sande",successanderror);
            }
        }
        return "importExcel";
    }
	
	@Action(value="/exportExcel", results={@Result(name="exportExcel", type="chain",
			location="stus")})
	public String exportExcel() {

        List<Student> stus = studentService.findStudents(stuDTO);//从数据库中获取要导出的集合
        
        //获取模板样式,需自行创建
        ExcelTemplate template = ExcelTemplate.newInstance("E:/123.xlsx");  
        for(int i=0; i<stus.size(); i++){
            Student stu = (Student)stus.get(i);
            //创建一行
            template.createRow(i);
            
            //创建列
            template.createCell(stu.getStuNo());
            template.createCell(stu.getStuName());
            template.createCell(stu.getStuAge().toString());
        }
        
        FileOutputStream fOut;
		try {
			
			fOut = new FileOutputStream("d:\\bookdata.xlsx");
	        try {
	            template.getWorkbook().write(fOut);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return "exportExcel";  
	}
}
