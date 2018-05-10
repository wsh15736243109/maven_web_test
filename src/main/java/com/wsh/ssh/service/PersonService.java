package com.wsh.ssh.service;

import com.wsh.ssh.dao.PersonDao;
import com.wsh.ssh.domain.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Service用于标注业务层组件
public class PersonService {
    @Autowired //使用@AutoWired进行自动装配。
    private PersonDao personDao;

    //增删改查的方法
    public void addPerson(PersonModel personModel){
        personDao.addPerson(personModel);
    }

    public void deletePerson(String id){
        personDao.deletePersonById(id);
    }
    public void updatePerson(PersonModel personModel){
    }
    public List<PersonModel> queryPerson(){
        return personDao.queryPerson();
    }
    public PersonModel queryPersonById(String id){
        return personDao.queryPersonById(id);
    }
}
