package com.example.demo.Application;

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

@RestController
public class ApplicationController {
	
	@Autowired
    ApplicationService as;

    @PostMapping("/app")
    public String addProduct(@Validated @RequestBody Application app)
    {
    	return as.addProduct(app);
    }

    @GetMapping("/app/{appName}/{flowName}")
    public List<Object> getApplicationByAppNameAndFlowName(@PathVariable String appName, String flowName)
    {
    	List<Object> obj=new ArrayList<>();
    	obj.add(as.getApplicationByAppNameAndFlowName(appName,flowName));
    	return obj;
    }
    
    @GetMapping("/apps")
    public List<Application> getAllApplications()
    {
    	return as.getAll();
    }
    
    @PutMapping("/app/{id}")
    public Application updateApplication(@PathVariable String id,@Validated @RequestBody Application app)
    {
    	return as.update(id, app);
    }

    @DeleteMapping("/app/{id}")
    public String deleteApplicationById(@PathVariable String id)
    {
    	return as.deleteApplicationById(id);
    }

}
