package com.vaibhavi.issuetracker.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vaibhavi.issuetracker.dao.DeveloperDao;
import com.vaibhavi.issuetracker.entity.DeveloperEntity;

@Service
public class DeveloperService{

  @Autowired
  private DeveloperDao developerDao;

  public DeveloperEntity add(String name) {
    DeveloperEntity developer = new DeveloperEntity(name);
    return developerDao.save(developer);
  }

  public List<DeveloperEntity> getDevelopers(){ return developerDao.findAll(); }
  public DeveloperEntity getById(Integer id) { return developerDao.getById(id); }
  public DeveloperEntity update(DeveloperEntity developer) { return developerDao.save(developer); }
  public void delete(Integer developerId) { developerDao.deleteById(developerId); }
  public Long getDeveloperCount() { return developerDao.count(); }
}
