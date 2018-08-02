package com.TimeTrackerApp.core.dao;

import java.util.List;

import com.TimeTrackerApp.core.domain.Attendance;
import com.TimeTrackerApp.core.domain.AttendanceRequest;

public interface AttendanceDao {

	List<Attendance> getAll();

	void save(AttendanceRequest attendance);

	List<Attendance> getByQuantity(Integer index, String emailId);

}
