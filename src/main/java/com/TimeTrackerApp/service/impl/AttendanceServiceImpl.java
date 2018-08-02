package com.TimeTrackerApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TimeTrackerApp.core.dao.AttendanceDao;
import com.TimeTrackerApp.core.domain.Attendance;
import com.TimeTrackerApp.core.domain.AttendanceRequest;
import com.TimeTrackerApp.service.AttendanceService;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDao attendanceDao;

	@Override
	public List<Attendance> getAll() {

		List<Attendance> attendanceList = attendanceDao.getAll();
		return attendanceList;
	}

	@Override
	public void save(AttendanceRequest attendance) {

		attendanceDao.save(attendance);
	}

	@Override
	public List<Attendance> getByQuantity(Integer index, String emailId) {

		List<Attendance> attendenceList = attendanceDao.getByQuantity(index, emailId);
		return attendenceList;
	}
}
