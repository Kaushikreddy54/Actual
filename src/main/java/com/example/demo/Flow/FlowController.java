package com.example.demo.Flow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Application.ApplicationService;

@RestController
public class FlowController {
	
	@Autowired
    FlowService fs;
	@Autowired
    ApplicationService as;

    @PostMapping("/flow")
    public String addFlow(@Validated @RequestBody Flow flow)
    {
    	return fs.addFlow(flow);
    }

    @GetMapping("/flow/{appName}/{flowName}")
    public List<Object> getFlowByAppNameAndFlowName(@PathVariable String appName, @PathVariable String flowName)
    {
    	List<Object> obj=new ArrayList<>();
    	obj.add(fs.getFlowByAppNameAndFlowName(appName,flowName));
    	obj.add(as.getApplicationByAppNameAndFlowName(appName,flowName));
    	return obj;
    }
    
    @GetMapping("/flows")
    public List<Flow> getAllFlows()
    {
    	return fs.getAll();
    }
    
    @PutMapping("/flow/{id}")
    public Flow updateFlow(@PathVariable String id,@Validated @RequestBody Flow flow)
    {
    	return fs.update(id, flow);
    }

    @DeleteMapping("/flow/{id}")
    public String deleteFlowById(@PathVariable String id)
    {
    	return fs.deleteFlowById(id);
    }

}
