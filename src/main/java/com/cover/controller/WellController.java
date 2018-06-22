package com.cover.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cover.entity.Well;
import com.cover.entity.WellLocation;
import com.cover.service.WellService;

@RequestMapping("/func/well")
@Controller
public class WellController {
	@Resource
	private WellService wellService;

	@RequestMapping("/getWellInfo.action")
	@ResponseBody
	public HashMap<String, List<HashMap<String, String>>> d() {
		HashMap<String, List<HashMap<String, String>>> s = new HashMap<String, List<HashMap<String, String>>>();
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Well> welllist = wellService.selectAllWell();
		System.out.println("输出" + welllist);
		for (Well item : welllist) {
			HashMap<String, String> ss = new HashMap<String, String>();
			ss.put("Id", String.valueOf(item.getWellId()));
			ss.put("fLong", String.valueOf(item.getfLong()));
			ss.put("fLati", String.valueOf(item.getfLati()));
			ss.put("WellNo", item.getWellNo());
			ss.put("UpCoverStatus", String.valueOf(item.getUpCoverStatus()));
			ss.put("VibratingStatus", String.valueOf(item.getVibratingStatus()));
			ss.put("DownCoverStatus", String.valueOf(item.getDownCoverStatus()));
			list.add(ss);
		}
		// HashMap<String,String> ss = new HashMap<String,String>();
		// ss.put("fLong", "121.399339");
		// ss.put("fLati", "31.3158651");
		// ss.put("orderON", "123");
		// ss.put("status", "123");

		// HashMap<String,String> sss = new HashMap<String,String>();
		// sss.put("fLong", "121.3994");
		// sss.put("fLati", "31.317");
		// sss.put("orderON", "124");
		// sss.put("status", "124");

		// list.add(sss);
		// list.add(ss);
		s.put("data", list);
		return s;
	}

	@RequestMapping("/findWellLocation.action")
	@ResponseBody // HttpServletRequest request
	public WellLocation getWellByOrderNO(String wellOrder) {
		WellLocation well = wellService.selectWellByWellNO(wellOrder);// String
																		// orderNO=request.getParameter("wellOrder");
		System.out.println(well.toString());
		return well;
	}

	@RequestMapping("/saveWell.action")
	@ResponseBody
	public void saveWell(@RequestBody WellLocation well) {
		wellService.saveWell(well);
	}

	@RequestMapping("/getWellLocationByStatus.action")
	@ResponseBody
	public HashMap<String, List<HashMap<String, String>>> getWellLocationByStatus(HttpServletRequest request) {
		System.out.println("sss");
		HashMap<String, List<HashMap<String, String>>> s = new HashMap<String, List<HashMap<String, String>>>();
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		int upstatus = Integer.parseInt(request.getParameter("upCoverStatus"));
		System.out.println(upstatus);
		int downstatus = Integer.parseInt(request.getParameter("downCoverStatus"));
		int vibratingstatus = Integer.parseInt(request.getParameter("vibratingStatus"));
		System.out.println(downstatus);
		System.out.println(vibratingstatus);
		List<Well> welllist = wellService.insert(upstatus, downstatus, vibratingstatus);
		for (Well item : welllist) {
			HashMap<String, String> ss = new HashMap<String, String>();
			ss.put("Id", String.valueOf(item.getWellId()));
			ss.put("fLong", String.valueOf(item.getfLong()));
			ss.put("fLati", String.valueOf(item.getfLati()));
			ss.put("WellNo", item.getWellNo());
			ss.put("UpCoverStatus", String.valueOf(item.getUpCoverStatus()));
			ss.put("VibratingStatus", String.valueOf(item.getVibratingStatus()));
			ss.put("DownCoverStatus", String.valueOf(item.getDownCoverStatus()));
			list.add(ss);
		}
		s.put("data", list);
		System.out.println(s);
		return s;		
	}
}
