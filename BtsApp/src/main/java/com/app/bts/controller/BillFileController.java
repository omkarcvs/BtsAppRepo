package com.app.bts.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.app.bts.entity.BillFileEntity;
import com.app.bts.entity.BillTrackEntity;
import com.app.bts.entity.DepartmentEntity;
import com.app.bts.entity.user.User;
import com.app.bts.service.BillFileService;
import com.app.bts.service.BillTrackService;
import com.app.bts.service.DepartmentService;
import com.app.bts.service.user.UserService;
import com.app.bts.util.CommonUtils;

@Controller
//@RequestMapping("/bts/")
public class BillFileController {
	
	//final static String HOST_IP="http://localhost:8085";
	final static String HOST_IP="";
	
	@Autowired
	BillFileService billFileService;
	
	@Autowired
	DepartmentService deptService;	
	
	@Autowired
	BillTrackService billTrackService;
	
	@Autowired
	UserService userService;
	                
	Logger  logger= LoggerFactory.getLogger(BillFileController.class);
	
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage(ModelMap model)
	{
		String resultData="";
		 model.addAttribute("loggedinuser", getPrincipal());
		try {
			
			User u=userService.findBySSO(getPrincipal());
			model.put("userName", u.getFirstName()+" "+u.getLastName());
			
			resultData="home";			
		} catch (Exception e) {			
			resultData="error";			
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		logger.error("Testing of Log4j");		
		model.addAttribute("HOST_IP", HOST_IP);  
		model.addAttribute("loggedinuser", getPrincipal());
		
		return resultData;
	}
	
	@RequestMapping(value="/createDakBill", method = RequestMethod.GET)
	public String createDakBill(ModelMap model)
	{	
		String resultData="";		
		model.addAttribute("loggedinuser", getPrincipal());
		try {		
			 
			resultData="dak";	
			model.addAttribute("file", new BillFileEntity());  
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}		
		return resultData;
	}	
	
	@RequestMapping(value="/createDakBill", method = RequestMethod.POST)
	public String createDakBill(@ModelAttribute("file") BillFileEntity billFileEntity,ModelMap model)
	{
		 String resultData="";			
		 model.addAttribute("loggedinuser", getPrincipal());
		try {
			
			 System.out.println("Getting the bil details");
			 
			 billFileEntity.setCreatedBy(getPrincipal());
			 billFileEntity.setBillStatus(0);
			 Long dakSavedRefNo=billFileService.save(billFileEntity);
			 String successMsg="DAK REF NO: "+dakSavedRefNo;
			 model.put("successMsg", successMsg);/*dakSavedRefNo*/
			 model.addAttribute("loggedinuser", getPrincipal());
			 System.out.println("Save Successfully");			
			 model.addAttribute("file", new BillFileEntity());  
			 resultData="success";	
		
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		return resultData;
		
	}
	
	@RequestMapping(value="/createBill", method = RequestMethod.GET)
	public String createBill(ModelMap model) {	
		String resultData="";
		model.addAttribute("loggedinuser", getPrincipal());
		try {	
			 
			List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==0).collect(Collectors.toList());
			model.addAttribute("billFile", new BillFileEntity()); 	
			model.addAttribute("billFileList", billFileList); 			
			
			resultData="createBill";			
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		return resultData;
	}	
	
	@RequestMapping(value="/loadDakData", method = RequestMethod.POST)
	public String searchNewBill(@ModelAttribute("billFile") BillFileEntity billFileEntity,ModelMap model)
	{	
		    String resultData="";
		    model.addAttribute("loggedinuser", getPrincipal());
			try {
				
				System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttSSSSSSSSSSSSSSSSSSSSSSSttttttttttttttttttttttttttt");
				List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==0).collect(Collectors.toList());
				System.out.println("billFileList "+billFileList);
				BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(), 0);
				System.out.println("billFileList "+billFileEntityLoad);
				System.out.println(" BillTrackRefNo : "+billFileEntityLoad.getBillTrackRefNo());
				
				model.addAttribute("billFile", new BillFileEntity()); 	
				model.addAttribute("billFileList", billFileList); 
				model.addAttribute("billFileEntityLoad",billFileEntityLoad); 	
				System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttEEEEEEEEEEEEEEEEEEEEEEEEttttttttttttttttttttttttttt");
				
				
				resultData="createBill";			
			}catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}
			
			return resultData;
	}
	
	@RequestMapping(value="/createBill", method = RequestMethod.POST)
	public String saveNewBill(@ModelAttribute("billFile") BillFileEntity billFile,ModelMap model) //0->1
	{
		   String resultData="";
		   model.addAttribute("loggedinuser", getPrincipal());
			try {	
				 
				System.out.println("Getting the bil details");
				System.out.println(billFile);
				//System.out.println("RefNo: "+file.getRefNumber());
				System.out.println("Amount : "+billFile.getAmount());
				System.out.println("invoiceDate : "+billFile.getInvoiceDate());
				billFile.setCreatedBy(getPrincipal());
				
				System.out.println("Befor update>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				billFileService.updateBillFile(billFile);
				System.out.println("Befor update<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

				
				System.out.println("Save Successfully");
				
				 model.put("successMsg", "Bill Created Successfully");
				
				resultData="success";			
			} catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}
			
			return resultData;
	}
	
	
	/*  Bill Dispatcher Start  */
	@RequestMapping(value="/dispatchBill", method = RequestMethod.GET)
	public String billDispacher(ModelMap model)	{
		
		 String resultData="";
		 model.addAttribute("loggedinuser", getPrincipal());
			try {				
				
			    List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==1).collect(Collectors.toList());
			    
			    List<DepartmentEntity> listOfDepartment=deptService.getDeptList();
			    model.put("listOfDepartment", listOfDepartment);
			    
			    List<User> listOfEmployees=userService.findAllUsers();
			    model.put("listOfEmployees", listOfEmployees);
			    
				model.addAttribute("billFile", new BillFileEntity()); 	
				model.addAttribute("billFileList", billFileList); 		
				
				
				
				resultData="dispatchBill";			
			} catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}			
			return resultData;		
	}
	
	
	@RequestMapping(value="/loadForDispatcherData", method = RequestMethod.POST)
	public String searchForDispatcherBill(@ModelAttribute("billFile") BillFileEntity billFileEntity,ModelMap model)
	{	
		    String resultData="";
		    model.addAttribute("loggedinuser", getPrincipal());
			try {		
				    
				    List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==1).collect(Collectors.toList());
				    BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(), 1);
				    
				    List<DepartmentEntity> listOfDepartment=deptService.getDeptList();
				    model.put("listOfDepartment", listOfDepartment);
				    
				    List<User> listOfEmployees=userService.findAllUsers();
				    model.put("listOfEmployees", listOfEmployees);
				    
					model.addAttribute("billFile", new BillFileEntity()); 	
					model.addAttribute("billFileList", billFileList); 
					 model.put("billFileEntityLoad", billFileEntityLoad);
				
				resultData="dispatchBill";			
			} catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}
			
			return resultData;
	}
	
	/* Saving the dipatche data */
	@RequestMapping(value="/dispatchBill", method = RequestMethod.POST)
	public String saveDispacherBill(@ModelAttribute("billFile") BillFileEntity billFile,ModelMap model)// 1->2
	{		
		   String resultData="";
		   model.addAttribute("loggedinuser", getPrincipal());
			try {	
				 
				billFile.setCreatedBy(getPrincipal());
				billFileService.updateBillFile(billFile);
				 model.put("successMsg", "Bill Dispatched Successfully");
				resultData="success";			
			} catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}
			
			return resultData;
	}
	
	
	/*Recive Bill Send Request*/
	@RequestMapping(value="/receiveBill", method = RequestMethod.GET)
	public String billReceive(ModelMap model)
	{
		    String resultData="";
		    model.addAttribute("loggedinuser", getPrincipal());
			try {			
				
			     List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==2).collect(Collectors.toList());
			     model.addAttribute("billFileList", billFileList); 
			     model.addAttribute("billFile", new BillFileEntity()); 	
				
				resultData="receivBill";			
			} catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}
			
			return resultData;
	}
	
	@RequestMapping(value="/loadForReceiverData", method = RequestMethod.POST)
	public String searchForReceiverBill(@ModelAttribute("billFile") BillFileEntity billFileEntity,ModelMap model)
	{	    
	    String resultData="";
	    model.addAttribute("loggedinuser", getPrincipal());
		try {				
				
			    List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==2).collect(Collectors.toList());
			    BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(), 2);
			    
			   
			    
				model.addAttribute("billFile", new BillFileEntity()); 	
				model.addAttribute("billFileList", billFileList); 
				model.addAttribute("billFileEntityLoad", billFileEntityLoad); 
			
			    resultData="receivBill";			
		} catch (Exception e) {			
			    resultData="error";
			    logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		 return resultData;	
	}
	
	
	/* Saving the Recive Bill */
	@RequestMapping(value="/receiveBill", method = RequestMethod.POST)
	public String saveBillReceive(@ModelAttribute("file") BillFileEntity billFile,ModelMap model)
	{
	    String resultData="";
	    model.addAttribute("loggedinuser", getPrincipal());
		try {	
			
			billFile.setCreatedBy(getPrincipal());
			billFileService.updateBillFile(billFile);
			System.out.println("Save Successfully");
			
			if("5".equals(billFile.getActionOnBill()))
			{
				model.put("successMsg", "Bill Returned Successfully");
			}else {
				model.put("successMsg", "Bill Received Successfully");
			}
			
			
			resultData="success";			
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		return resultData;
	}
	
	/*closing Bill Send Request*/
	@RequestMapping(value="/closeBill", method = RequestMethod.GET)
	public String billClose(ModelMap model)
	{
		
	    String resultData="";
	    model.addAttribute("loggedinuser", getPrincipal());
		try {	
			
			     List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==3).collect(Collectors.toList());
			   //BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(), 3);
			     model.addAttribute("billFileList", billFileList); 
			     model.addAttribute("billFile", new BillFileEntity()); 	
			resultData="closeBill";			
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		return resultData;		
	}
	
	//Load data for closing bill
	@RequestMapping(value="/loadForClosingData", method = RequestMethod.POST)
	public String searchForCloseBill(@ModelAttribute("billFile") BillFileEntity billFileEntity,ModelMap model)
	{	
	    String resultData="";
	    model.addAttribute("loggedinuser", getPrincipal());
		try {	
				
			    List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==3).collect(Collectors.toList());
			    BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(), 3);
			    
			   
			    
				model.addAttribute("billFileEntityLoad", billFileEntityLoad); 	
				model.addAttribute("billFileList", billFileList); 	
				model.addAttribute("billFile", new BillFileEntity()); 	
			resultData="closeBill";			
		} catch (Exception e) {			
			resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		return resultData;
	}
	/* Saving  the closing Bill */
	@RequestMapping(value="/closeBill", method = RequestMethod.POST)
	public String saveBillClose(@ModelAttribute("billFile") BillFileEntity billFile,ModelMap model)//status 3-> 4
	{
		    String resultData="";
		    model.addAttribute("loggedinuser", getPrincipal());
			try {
				
				System.out.println("Getting the Receiver bill details");	
				billFile.setCreatedBy(getPrincipal());
				billFileService.updateBillFile(billFile);
				System.out.println("Save Closed Bill Successfully");
				
				if("6".equals(billFile.getActionOnBill()))
				{
					model.put("successMsg", "Bill Returned Successfully");
				}else {
					model.put("successMsg", "Bill Closed Successfully");
				}
				
				
				 
		    resultData="success";			
			} catch (Exception e) {			
				resultData="error";
				logger.error(CommonUtils.getStackTrace(e)); 
			}
			return resultData;
	}
	
	@RequestMapping(value="/trackBill", method = RequestMethod.GET)
	public String trackBill(ModelMap model)
	{
	    String resultData="";
	    model.addAttribute("loggedinuser", getPrincipal());
		try {	
			
			 List<BillFileEntity> billFileList=billFileService.getAllCreatedBill();
			 // List<BillFileEntity> billFileList=billFileService.getAllCreatedBill().stream().filter(billFile->billFile.getBillStatus()==4).collect(Collectors.toList());
		   // BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(), 4);
			
			 model.addAttribute("billFileList", billFileList); 
			 model.addAttribute("billFile", new BillFileEntity());
			resultData="billTracking";			
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		return resultData;
	}
/*Error page*/
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String errorPage(ModelMap model)
	{
		String resultData="";
		 model.addAttribute("loggedinuser", getPrincipal());
		try {
			
			resultData="error";			
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		model.addAttribute("loggedinuser", getPrincipal());		
		return resultData;
	}
	@RequestMapping(value="/trackBill", method = RequestMethod.POST)
	public String trackBill(ModelMap model,@ModelAttribute("billFile") BillFileEntity billFileEntity,HttpServletRequest req)
	{
	    String resultData="";
	    model.addAttribute("loggedinuser", getPrincipal());
		try {
			 	
			   List<BillFileEntity> billFileList=billFileService.getAllCreatedBill();		   
			   BillFileEntity billFileEntityLoad=billFileService.getByBillTrackRefNo(billFileEntity.getBillTrackRefNo());			
			   List<BillTrackEntity> billTrackList=billTrackService.getByBillTrackRefNo(billFileEntity.getBillTrackRefNo());//need to change according to
			   
			   System.out.println("billTrackList : "+billTrackList);
			   
			   System.out.println(" file.getBillTrackRefNo() : "+req.getParameter("billTrackRefNo"));
			   System.out.println(billTrackList);
			    model.addAttribute("billFileEntityLoad", billFileEntityLoad); 	
				model.addAttribute("billFileList", billFileList); 	
				model.addAttribute("billFile", new BillFileEntity()); 
				model.addAttribute("billTrackList", billTrackList); 	
				
			resultData="billTracking";			
		} catch (Exception e) {			
			resultData="error";
			logger.error(CommonUtils.getStackTrace(e)); 
		}
		
		return resultData;
	}
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Enter in getPrincipal() : AppController " );

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		System.out.println("Exit from getPrincipal() : AppController " );

		return userName;
	}
	
	/*
	@RequestMapping("/welcome")
	public String firstPage() {
		return "welcome";
	}
	*/
	/*
	 * @RequestMapping("/base-definition") public String firstPageT() { return
	 * "test"; }
	 */
	/* 
	   @RequestMapping("/test") public String firstPagey() { return "test"; }
	*/ 
	
	
	
	
}
