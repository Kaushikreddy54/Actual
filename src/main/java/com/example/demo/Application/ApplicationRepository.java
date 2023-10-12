package com.example.demo.Application;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends MongoRepository<Application,String>{
	
	List<Object> findByAppNameAndFlowName(String appName, String flowName);

}
