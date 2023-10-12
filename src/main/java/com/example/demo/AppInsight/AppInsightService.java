package com.example.demo.AppInsight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppInsightService {
	
	@Autowired
    AppInsightRepository air;
    
    public String addAppInsight(AppInsight ai)
    {
        air.save(ai);
        return ai.getAppName()+" is added successfully";
    }
    
    public List<Object> getAppInsightByAppNameAndFlowName(String appName,String flowName)
    {
    	List<Object> obj=new ArrayList<>();
    	obj.add(air.findByAppNameAndFlowName(appName,flowName));
    	return obj;
    }
    
    public List<AppInsight> getAll()
    {
    	return air.findAll();
    }
    
    public AppInsight update(String id,AppInsight ai)
    {
    	ai.setId(id);
    	return air.save(ai);
    }
    
    public String deleteAppInsight(String id)
    {
        air.deleteById(id);
        return id+" deleted successfully";
    }

}
