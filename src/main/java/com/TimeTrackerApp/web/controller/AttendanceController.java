package com.TimeTrackerApp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TimeTrackerApp.core.domain.Attendance;
import com.TimeTrackerApp.core.domain.AttendanceRequest;
import com.TimeTrackerApp.service.AttendanceService;

@Controller
@RequestMapping(value="attendance")
public class AttendanceController extends BaseController {

	@Autowired
	private AttendanceService attendanceService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Attendance>> getAll() {
		
		List<Attendance> attendanceList = attendanceService.getAll();
		
		return new ResponseEntity<List<Attendance>>(attendanceList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Attendance> save(@RequestBody AttendanceRequest attendance) {
		
		attendanceService.save(attendance);
		
		return new ResponseEntity<Attendance>(HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/getByEmail", method=RequestMethod.GET)
	public ResponseEntity<List<Attendance>> getByQuantity(@RequestParam(value="quantity") Integer quantity,
																									@RequestParam(value="emailId") String emailId) {
		System.out.println("Hello....");
		List<Attendance> attendanceList = attendanceService.getByQuantity(quantity, emailId);

		return new ResponseEntity<List<Attendance>>(attendanceList, HttpStatus.OK);
	}
	
}
