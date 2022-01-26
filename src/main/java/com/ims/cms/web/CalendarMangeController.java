package com.ims.cms.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.cms.vo.CalendarVo;

@RestController
@RequestMapping("/calendar")
public class CalendarMangeController {
	
	
	@PostMapping("/add")
	public Map<String,String> addCalender(@RequestBody CalendarVo calendarVo){
		
		
		Map<String,String> result = new HashMap<String,String>();
		
		result.put("code", "success");
		
		return result;
	}
	
}
