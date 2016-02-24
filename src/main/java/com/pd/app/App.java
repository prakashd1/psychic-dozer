package com.pd.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("dozerMapping.xml");

		Mapper mapper = new DozerBeanMapper(mappingFiles);

		Map<String, Object> personMap = new HashMap<String, Object>();

		personMap.put("id", 1);
		personMap.put("name", "Prakash");
		personMap.put("dob1", "2001-W27-3");
		personMap.put("dob", new Date());
		
		Person p = mapper.map(personMap, Person.class);
		System.out.println("Person attributes");

		System.out.println(p.id + ":" + p.name + ": " + p.dob + ":" + p.getDob1());

		/*
		 * for (int i=0; i < 500; i++) { try { LOGGER.info("Sleep: " + i);
		 * Thread.sleep(5000); } catch (InterruptedException threadException) {
		 * LOGGER.error("InterruptedException: " + threadException.toString());
		 * } }
		 */

	}

}
