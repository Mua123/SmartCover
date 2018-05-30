package com.cover.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cover.entity.WellLocation;
import com.cover.service.WellLocationService;



@RequestMapping("/func/well")
@Controller
public class WellLocationController {
	@Resource 
	private WellLocationService welllocationService;
	@RequestMapping("/getWellLocation.action")  
	@ResponseBody
	public HashMap<String,List<HashMap<String,String>>> d()
	{
	  HashMap<String,List<HashMap<String,String>>> s = new HashMap<String,List<HashMap<String,String>>>();
	  List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	  List<WellLocation> welllist =  welllocationService.selectAllWell();
      System.out.println("输出"+welllist);
	  for(WellLocation item : welllist) {
		  HashMap<String,String> ss = new HashMap<String,String>();
		  ss.put("WellNO", String.valueOf(item.getWellNO()));
		  ss.put("fLong", String.valueOf(item.getfLong()));
		  ss.put("fLati", String.valueOf(item.getfLati()));
		  ss.put("Province", item.getProvince());
		  ss.put("City", String.valueOf(item.getCity()));
		  ss.put("District", String.valueOf(item.getDistrict()));
		  ss.put("Road", String.valueOf(item.getRoad()));
		  list.add(ss);
	  }
//	  HashMap<String,String> ss = new HashMap<String,String>();
//	  ss.put("fLong", "121.399339");
//	  ss.put("fLati", "31.3158651");
//	  ss.put("orderON", "123");
//	  ss.put("status", "123");
  
//	  HashMap<String,String> sss = new HashMap<String,String>();
//	  sss.put("fLong", "121.3994");
//	  sss.put("fLati", "31.317");
//	  sss.put("orderON", "124");
//	  sss.put("status", "124");
	  
//	  list.add(sss);
//	  list.add(ss);	  
	  s.put("data", list);
	  return s;
	  }
	
	@RequestMapping("/getWellData.action") 
	@ResponseBody    //HttpServletRequest request
	public WellLocation getWellByOrderNO(String wellOrder) {	
		WellLocation well=welllocationService.selectWellByWellNO(wellOrder);//String orderNO=request.getParameter("wellOrder");
		System.out.println(well.toString());
		return well;
	}	
}
		


