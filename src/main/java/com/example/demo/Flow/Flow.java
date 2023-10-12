package com.example.demo.Flow;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="A-2")
public class Flow {
	
	@Id
	   public String id;
		private String appName;
		private String flowName;
		private String description;

}
