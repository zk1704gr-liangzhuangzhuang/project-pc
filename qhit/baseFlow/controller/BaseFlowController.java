package com.qhit.baseFlow.controller; 

import com.qhit.baseFlow.pojo.BaseFlow; 
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/08
*/ 

@RestController 
@RequestMapping("/baseFlow") 
public class BaseFlowController { 

    @Resource 
    IBaseFlowService baseFlowService; 

    @RequestMapping("/insert") 
    public void insert(BaseFlow baseFlow,HttpSession session) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        baseFlow.setCompid(baseUser.getCompid());
        baseFlowService.insert(baseFlow);
    } 

    @RequestMapping("/delete") 
    public void delete(Integer flowid) { 
        baseFlowService.delete(flowid); 
    } 

    @RequestMapping("/update") 
    public void update(BaseFlow baseFlow) { 
        baseFlowService.update(baseFlow); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(BaseFlow baseFlow) { 
        baseFlowService.updateSelective(baseFlow); 
    } 

    @RequestMapping("/load") 
    public BaseFlow load(Integer flowid) { 
        BaseFlow baseFlow = baseFlowService.findById(flowid); 
        return baseFlow; 
    } 

    @RequestMapping("/list") 
    public List<BaseFlow> list()  { 
        List<BaseFlow> list = baseFlowService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<BaseFlow> search(BaseFlow baseFlow) { 
        List<BaseFlow> list = baseFlowService.search(baseFlow); 
        return list; 
    } 

} 
