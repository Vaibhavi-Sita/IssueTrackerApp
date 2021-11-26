package com.vaibhavi.issuetracker.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavi.issuetracker.dao.BugDao;
import com.vaibhavi.issuetracker.entity.BugIssueEntity;
import com.vaibhavi.issuetracker.enums.BugPriorityEnum;
import com.vaibhavi.issuetracker.enums.BugStatusEnum;


@Service
public class BugService {
	
	@Autowired
	private BugDao bugDao;
	
	public List<BugIssueEntity> getBugs(){
		return bugDao.findAll();
	}
	
	public BugIssueEntity getById(Integer id) {
		return bugDao.getById(id);
	}

	public BugIssueEntity add(BugIssueEntity bug) {
		bug.setCreationDate(Calendar.getInstance().getTime());
		return bugDao.save(bug);
	}

	public BugIssueEntity update(BugIssueEntity bug) {
		return bugDao.save(bug);
	}

	public void delete(Integer developerId) {
		bugDao.deleteById(developerId);;
	}
	
	public HashMap<Integer, String> getBugPriorityMap() {
		return (HashMap<Integer, String>) BugPriorityEnum.getMap();
	}
	
	public HashMap<Integer, String> getBugStatusMap() {
		return (HashMap<Integer, String>) BugStatusEnum.getMap();
	}

	public BugIssueEntity getBug(Integer bugId) {
		return bugDao.getById(bugId);
	}
}
