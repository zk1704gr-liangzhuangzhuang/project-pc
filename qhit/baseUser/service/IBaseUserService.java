package com.qhit.baseUser.service;

import java.util.List;
import com.qhit.baseUser.pojo.BaseUser;
/**
* Created by GeneratorCode on 2019/04/02
*/
public interface IBaseUserService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseUser findById(Object id);

    List<BaseUser> search(BaseUser baseUser);

}