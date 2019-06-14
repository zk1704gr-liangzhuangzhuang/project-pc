package com.qhit.produceJob.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceJob.service.IProduceJobService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/10
*/ 

@RestController 
@RequestMapping("/produceJob") 
public class ProduceJobController { 

    @Resource 
    IProduceJobService produceJobService; 

    @RequestMapping("/insert") 
    public void insert(ProduceJob produceJob) { 
        produceJobService.insert(produceJob); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer jobid) { 
        produceJobService.delete(jobid); 
    } 

    @RequestMapping("/update") 
    public void update(ProduceJob produceJob) { 
        produceJobService.update(produceJob); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(ProduceJob produceJob) { 
        produceJobService.updateSelective(produceJob); 
    } 

    @RequestMapping("/load") 
    public ProduceJob load(Integer jobid) { 
        ProduceJob produceJob = produceJobService.findById(jobid); 
        return produceJob; 
    } 

    @RequestMapping("/list") 
    public List<ProduceJob> list()  { 
        List<ProduceJob> list = produceJobService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search")
    public List<ProduceJob> search(ProduceJob produceJob) {
        List<ProduceJob> list = produceJobService.search(produceJob);
        return list;
    }
    @RequestMapping("/model")
    public Map<String,Object> model(String year, HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Map<String,Object> data1 = produceJobService.model(year,baseUser.getCompid());
        return  data1;
    }

} 
