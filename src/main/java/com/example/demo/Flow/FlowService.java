package com.example.demo.Flow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowService {
	
	@Autowired
    FlowRepository fr;
    
    public String addFlow(Flow flow)
    {
        fr.save(flow);
        return flow.getAppName()+" is added successfully";
    }
    public List<Object> getFlowByAppNameAndFlowName(String appName, String flowName)
    {
    	List<Object> obj=new ArrayList<>();
        obj.add(fr.findFlowByAppNameAndFlowName(appName,flowName));
        return obj;
    }
    
    public List<Flow> getAll()
    {
    	return fr.findAll();
    }
    
    public Flow update(String id,Flow flow)
    {
    	flow.setId(id);
    	return fr.save(flow);
    }
    
    public String deleteFlowById(String id)
    {
        fr.deleteById(id);
        return id+" deleted successfully";
    }

}
