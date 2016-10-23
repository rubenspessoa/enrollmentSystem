package server;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.json.simple.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

public class ServerTest {
	Server server;
	String resultKey = "result";
	
	@Before
	public void setUp() throws Exception {
		this.server = new Server();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFetchStudents() {
		String resultString = this.server.fetchStudents();
		JSONObject result = (JSONObject) JSONValue.parse(resultString);
		JSONArray array = (JSONArray) result.get(resultKey);
		

		assertEquals(5, array.size());
		
		Iterator<JSONObject> i = array.iterator();
		
		while(i.hasNext()) {
			JSONObject student = i.next();
			
			if((Long) student.get("registry") == 12398) {
				assertEquals("Maria Antônia", student.get("name"));
				assertEquals(new Long(0), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("TbD4sLMPBd", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
			}
			else if((Long) student.get("registry") == 9914918) {
				assertEquals("João da Silva", student.get("name"));
				assertEquals(new Long(0), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("0Y7xVqhuMU", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
			}
			else if((Long) student.get("registry") == 9915918) {
				assertEquals("José Vasconcelos", student.get("name"));
				assertEquals(new Long(0), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("rAXD7UBiUW", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
			}
			else if((Long) student.get("registry") == 9924812) {
				assertEquals("Jurema Torres", student.get("name"));
				assertEquals(new Long(100), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(2, ((JSONArray) student.get("coursedClasses")).size());
				
				Iterator<String> j = ((JSONArray) student.get("coursedClasses")).iterator();
				while(j.hasNext()) {
					String id = j.next();
					if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("MWn0ZDbyit") != 0) {
						fail("invalid id");
					}
				}
			}
			else if((Long) student.get("registry") == 98124812) {
				assertEquals("Alex Carvalho", student.get("name"));
				assertEquals(new Long(130), student.get("mandatoryCredits"));
				assertEquals(new Long(50), student.get("electiveCredit"));
				assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(3, ((JSONArray) student.get("coursedClasses")).size());
				
				Iterator<String> j = ((JSONArray) student.get("coursedClasses")).iterator();
				while(j.hasNext()) {
					String id = j.next();
					if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("yOqln8vNsA") != 0 && id.compareTo("SCWCADj6gM") != 0) {
						fail("invalid id");
					}
				}
			}
			else {
				fail("Invalid User");
			}
		}
	}

	@Test
	public void testFetchStudentWithId() {
		String resultString = this.server.fetchStudents();
		JSONObject result = (JSONObject) JSONValue.parse(resultString);
		JSONArray array = (JSONArray) result.get(resultKey);
		

		assertEquals(5, array.size());
		
		Iterator<JSONObject> i = array.iterator();
		
		while(i.hasNext()) {
			JSONObject student = i.next();
			
			resultString = server.fetchStudentWithId((String) student.get("objectId"));
			result = (JSONObject) JSONValue.parse(resultString);
			
			if((Long) student.get("registry") == 12398) {
				assertEquals("Maria Antônia", student.get("name"));
				assertEquals(new Long(0), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("TbD4sLMPBd", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
			}
			else if((Long) student.get("registry") == 9914918) {
				assertEquals("João da Silva", student.get("name"));
				assertEquals(new Long(0), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("0Y7xVqhuMU", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
			}
			else if((Long) student.get("registry") == 9915918) {
				assertEquals("José Vasconcelos", student.get("name"));
				assertEquals(new Long(0), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("rAXD7UBiUW", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
			}
			else if((Long) student.get("registry") == 9924812) {
				assertEquals("Jurema Torres", student.get("name"));
				assertEquals(new Long(100), student.get("mandatoryCredits"));
				assertEquals(new Long(0), student.get("electiveCredit"));
				assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(2, ((JSONArray) student.get("coursedClasses")).size());
				
				Iterator<String> j = ((JSONArray) student.get("coursedClasses")).iterator();
				while(j.hasNext()) {
					String id = j.next();
					if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("MWn0ZDbyit") != 0) {
						fail("invalid id");
					}
				}
			}
			else if((Long) student.get("registry") == 98124812) {
				assertEquals("Alex Carvalho", student.get("name"));
				assertEquals(new Long(130), student.get("mandatoryCredits"));
				assertEquals(new Long(50), student.get("electiveCredit"));
				assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
				assertEquals(3, ((JSONArray) student.get("coursedClasses")).size());
				
				Iterator<String> j = ((JSONArray) student.get("coursedClasses")).iterator();
				while(j.hasNext()) {
					String id = j.next();
					if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("yOqln8vNsA") != 0 && id.compareTo("SCWCADj6gM") != 0) {
						fail("invalid id");
					}
				}
			}
			else {
				fail("Invalid User");
			}
		}
	}
	

	@Test
	public void testFetchStudentsForClassWithId() {
		String[] classes = {"FOVrIDd8hB", "6CvPEgQO5Y", "SCWCADj6gM", "yOqln8vNsA", "MWn0ZDbyit", "fpICxXTeBi", "Ngh8JMKhYM", "dQAAP7Wkx9", "TKQCY40Nnn"};
		
		for(Integer j = 0; j < classes.length; j++) {
			String id = classes[j];
			
			String resultString = this.server.fetchStudentsForClassWithId(id);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			JSONArray array = (JSONArray) result.get(resultKey);

			if(id.compareTo("FOVrIDd8hB") == 0) {
				assertEquals(0, array.size());
			}
			else if(id.compareTo("6CvPEgQO5Y") == 0) {
				assertEquals(0, array.size());
			}
			else if(id.compareTo("SCWCADj6gM") == 0) {
				assertEquals(1, array.size());
			}
			else if(id.compareTo("yOqln8vNsA") == 0) {
				assertEquals(1, array.size());
			}
			else if(id.compareTo("MWn0ZDbyit") == 0) {
				assertEquals(1, array.size());
			}
			else if(id.compareTo("fpICxXTeBi") == 0) {
				assertEquals(0, array.size());
			}
			else if(id.compareTo("Ngh8JMKhYM") == 0) {
				assertEquals(0, array.size());
			}
			else if(id.compareTo("dQAAP7Wkx9") == 0) {
				assertEquals(2, array.size());
			}
			else if(id.compareTo("TKQCY40Nnn") == 0) {
				assertEquals(0, array.size());
			}
			else {
				fail("Invalid Id");
			}
			
			Iterator<JSONObject> i = array.iterator();
			
			while(i.hasNext()) {
				JSONObject student = i.next();
				
				if((Long) student.get("registry") == 12398) {
					assertEquals("Maria Antônia", student.get("name"));
					assertEquals(new Long(0), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("TbD4sLMPBd", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
				}
				else if((Long) student.get("registry") == 9914918) {
					assertEquals("João da Silva", student.get("name"));
					assertEquals(new Long(0), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("0Y7xVqhuMU", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
				}
				else if((Long) student.get("registry") == 9915918) {
					assertEquals("José Vasconcelos", student.get("name"));
					assertEquals(new Long(0), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("rAXD7UBiUW", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
				}
				else if((Long) student.get("registry") == 9924812) {
					assertEquals("Jurema Torres", student.get("name"));
					assertEquals(new Long(100), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(2, ((JSONArray) student.get("coursedClasses")).size());
					
					Iterator<String> k = ((JSONArray) student.get("coursedClasses")).iterator();
					while(k.hasNext()) {
						String id2 = k.next();
						if(id2.compareTo("dQAAP7Wkx9") != 0 && id2.compareTo("MWn0ZDbyit") != 0) {
							fail("invalid id");
						}
					}
				}
				else if((Long) student.get("registry") == 98124812) {
					assertEquals("Alex Carvalho", student.get("name"));
					assertEquals(new Long(130), student.get("mandatoryCredits"));
					assertEquals(new Long(50), student.get("electiveCredit"));
					assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(3, ((JSONArray) student.get("coursedClasses")).size());
					
					Iterator<String> k = ((JSONArray) student.get("coursedClasses")).iterator();
					while(k.hasNext()) {
						String id2 = k.next();
						if(id2.compareTo("dQAAP7Wkx9") != 0 && id2.compareTo("yOqln8vNsA") != 0 && id2.compareTo("SCWCADj6gM") != 0) {
							fail("invalid id");
						}
					}
				}
				else {
					fail("Invalid User");
				}
			}
		}
	}
	

	@Test
	public void testFetchClassWithId() {
		String[] classes = {"FOVrIDd8hB", "6CvPEgQO5Y", "SCWCADj6gM", "yOqln8vNsA", "MWn0ZDbyit", "fpICxXTeBi", "Ngh8JMKhYM", "dQAAP7Wkx9", "TKQCY40Nnn"};
		
		for(Integer j = 0; j < classes.length; j++) {
			String id = classes[j];
			String resultString = this.server.fetchClassWithId(id);
			System.out.println(resultString);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			result = (JSONObject) result.get(resultKey);
			
			if(id.compareTo("FOVrIDd8hB") == 0) {
				String name = (String) result.get("name");
				assertEquals("Software Básico", result.get("name"));
				assertEquals("INF 1600", result.get("code"));
				assertEquals(new Long(50), result.get("credits"));
				assertEquals(false, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(40), result.get("requiredCredit"));
				assertEquals(0, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("5VcNEte1s7", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("rAXD7UBiUW", ((JSONObject) result.get("course")).get("objectId"));
			}
			else if(id.compareTo("6CvPEgQO5Y") == 0) {
				assertEquals("Projeto de Sistema de Software I", result.get("name"));
				assertEquals("INF 1624", result.get("code"));
				assertEquals(new Long(40), result.get("credits"));
				assertEquals(false, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(2, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("lLvknd5N8B", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("5sBCpMQeAW", ((JSONObject) result.get("course")).get("objectId"));
				
				Iterator<String> k = ((JSONArray) result.get("requiredClasses")).iterator();
				while(k.hasNext()) {
					String id2 = k.next();
					if(id2.compareTo("dQAAP7Wkx9") != 0 && id2.compareTo("SCWCADj6gM") != 0) {
						fail("invalid id");
					}
				}
			}
			else if(id.compareTo("SCWCADj6gM") == 0) {
				assertEquals("Programação em ponto grande", result.get("name"));
				assertEquals("INF 1628", result.get("code"));
				assertEquals(new Long(50), result.get("credits"));
				assertEquals(false, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(1, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("5VcNEte1s7", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("5sBCpMQeAW", ((JSONObject) result.get("course")).get("objectId"));
				
				Iterator<String> k = ((JSONArray) result.get("requiredClasses")).iterator();
				while(k.hasNext()) {
					String id2 = k.next();
					if(id2.compareTo("dQAAP7Wkx9") != 0) {
						fail("invalid id");
					}
				}
			}
			else if(id.compareTo("yOqln8vNsA") == 0) {
				assertEquals("Laboratório de Programação I", result.get("name"));
				assertEquals("INF 1622", result.get("code"));
				assertEquals(new Long(70), result.get("credits"));
				assertEquals(true, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(1, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("5VcNEte1s7", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("5sBCpMQeAW", ((JSONObject) result.get("course")).get("objectId"));
				
				Iterator<String> k = ((JSONArray) result.get("requiredClasses")).iterator();
				while(k.hasNext()) {
					String id2 = k.next();
					if(id2.compareTo("dQAAP7Wkx9") != 0) {
						fail("invalid id");
					}
				}
			}
			else if(id.compareTo("MWn0ZDbyit") == 0) {
				assertEquals("Introdução a Ciência da Computação", result.get("name"));
				assertEquals("INF 1001", result.get("code"));
				assertEquals(new Long(40), result.get("credits"));
				assertEquals(true, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(0, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("2t1skGtEbT", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("rAXD7UBiUW", ((JSONObject) result.get("course")).get("objectId"));
			}
			else if(id.compareTo("fpICxXTeBi") == 0) {
				assertEquals("Inglês I", result.get("name"));
				assertEquals("LET 1501", result.get("code"));
				assertEquals(new Long(30), result.get("credits"));
				assertEquals(true, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(0, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("6QqkNVZ9Vo", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("TbD4sLMPBd", ((JSONObject) result.get("course")).get("objectId"));
			}
			else if(id.compareTo("Ngh8JMKhYM") == 0) {
				assertEquals("Hipermídia Adaptativa", result.get("name"));
				assertEquals("INF 1303", result.get("code"));
				assertEquals(new Long(30), result.get("credits"));
				assertEquals(false, result.get("isMandatory"));
				assertEquals(true, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(0, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("vp1nyvj1JY", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("0Y7xVqhuMU", ((JSONObject) result.get("course")).get("objectId"));
			}
			else if(id.compareTo("dQAAP7Wkx9") == 0) {
				assertEquals("Estruturas de Dados", result.get("name"));
				assertEquals("INF 1620", result.get("code"));
				assertEquals(new Long(60), result.get("credits"));
				assertEquals(true, result.get("isMandatory"));
				assertEquals(false, result.get("isAvailable"));
				assertEquals(new Long(0), result.get("requiredCredit"));
				assertEquals(0, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("aWbbZll3Og", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("5sBCpMQeAW", ((JSONObject) result.get("course")).get("objectId"));
			}
			else if(id.compareTo("TKQCY40Nnn") == 0) {
				assertEquals("Cálculo Numérico", result.get("name"));
				assertEquals("INF 1002", result.get("code"));
				assertEquals(new Long(40), result.get("credits"));
				assertEquals(true, result.get("isMandatory"));
				assertEquals(false, result.get("isAvailable"));
				assertEquals(new Long(100), result.get("requiredCredit"));
				assertEquals(0, ((JSONArray) result.get("requiredClasses")).size());
				assertEquals("aWbbZll3Og", ((JSONObject) result.get("teacher")).get("objectId"));
				assertEquals("rAXD7UBiUW", ((JSONObject) result.get("course")).get("objectId"));
			}
			else {
				fail("invalid class");
			}
		}
	}
	
	@Test
	public void testEnroll() {
		String resultString = this.server.fetchStudents();
		JSONObject result = (JSONObject) JSONValue.parse(resultString);
		JSONArray array = (JSONArray) result.get(resultKey);

		Iterator<JSONObject> i = array.iterator();

		while(i.hasNext()) {
			JSONObject student = i.next();


			String[] classes = {"FOVrIDd8hB", "6CvPEgQO5Y", "SCWCADj6gM", "yOqln8vNsA", "MWn0ZDbyit", "fpICxXTeBi", "Ngh8JMKhYM", "dQAAP7Wkx9", "TKQCY40Nnn"};
			
			for(Integer j = 0; j < classes.length; j++) {
				String classId = classes[j];
				
				resultString = server.signupStudentWithIdForClassWithId((String) student.get("objectId"), classId);
				System.out.println(resultString);
				result = (JSONObject) JSONValue.parse(resultString);
				Object res = result.get(resultKey);
				
				if(((String) student.get("objectId")).compareTo("RA9Xx51PSH") == 0) {
					if(classId.compareTo("FOVrIDd8hB") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("6CvPEgQO5Y") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("SCWCADj6gM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("yOqln8vNsA") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("MWn0ZDbyit") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("fpICxXTeBi") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("Ngh8JMKhYM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("dQAAP7Wkx9") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("TKQCY40Nnn") == 0) {
						assertNull(res);
					}
					else {
						fail("Invalid class");
					}
				}
				else if(((String) student.get("objectId")).compareTo("zlsk5GWLH2") == 0) {
					if(classId.compareTo("FOVrIDd8hB") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("6CvPEgQO5Y") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("SCWCADj6gM") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("yOqln8vNsA") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("MWn0ZDbyit") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("fpICxXTeBi") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("Ngh8JMKhYM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("dQAAP7Wkx9") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("TKQCY40Nnn") == 0) {
						assertNull(res);
					}
					else {
						fail("Invalid class");
					}
				}
				else if(((String) student.get("objectId")).compareTo("eETFJRGZ2s") == 0) {
					if(classId.compareTo("FOVrIDd8hB") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("6CvPEgQO5Y") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("SCWCADj6gM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("yOqln8vNsA") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("MWn0ZDbyit") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("fpICxXTeBi") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("Ngh8JMKhYM") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("dQAAP7Wkx9") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("TKQCY40Nnn") == 0) {
						assertNull(res);
					}
					else {
						fail("Invalid class");
					}
				}
				else if(((String) student.get("objectId")).compareTo("s3DaUQUo7I") == 0) {
					if(classId.compareTo("FOVrIDd8hB") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("6CvPEgQO5Y") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("SCWCADj6gM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("yOqln8vNsA") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("MWn0ZDbyit") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("fpICxXTeBi") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("Ngh8JMKhYM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("dQAAP7Wkx9") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("TKQCY40Nnn") == 0) {
						assertNull(res);
					}
					else {
						fail("Invalid class");
					}
				}
				else if(((String) student.get("objectId")).compareTo("rMIysaiw5n") == 0) {
					if(classId.compareTo("FOVrIDd8hB") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("6CvPEgQO5Y") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("SCWCADj6gM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("yOqln8vNsA") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("MWn0ZDbyit") == 0) {
						assertNotNull(res);
					}
					else if(classId.compareTo("fpICxXTeBi") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("Ngh8JMKhYM") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("dQAAP7Wkx9") == 0) {
						assertNull(res);
					}
					else if(classId.compareTo("TKQCY40Nnn") == 0) {
						assertNull(res);
					}
					else {
						fail("Invalid class");
					}
				}
				else {
					fail("invalid student");
				}
			}
		}
	}
	
	@Test
	public void testFetchDepartmentForStudentWithId() {
		String resultString = this.server.fetchStudents();
		JSONObject result = (JSONObject) JSONValue.parse(resultString);
		JSONArray array = (JSONArray) result.get(resultKey);
		

		assertEquals(5, array.size());
		
		Iterator<JSONObject> i = array.iterator();
		
		while(i.hasNext()) {
			JSONObject student = i.next();
			String studentId = (String) student.get("objectId");
			resultString = this.server.fetchDepartmentForStudentWithId(studentId);
			result = (JSONObject) JSONValue.parse(resultString);
			JSONObject department = (JSONObject) result.get(resultKey);
			String departmentId = (String) department.get("objectId");
			
			if(studentId.compareTo("RA9Xx51PSH") == 0) {
				assertEquals("Mj8dRFJ175", departmentId);
			}
			else if(studentId.compareTo("eETFJRGZ2s") == 0) {
				assertEquals("9dVnCtu1BW", departmentId);
			}
			else if(studentId.compareTo("s3DaUQUo7I") == 0) {
				assertEquals("9dVnCtu1BW", departmentId);
			}
			else if(studentId.compareTo("zlsk5GWLH2") == 0) {
				assertEquals("9dVnCtu1BW", departmentId);
			}
			else if(studentId.compareTo("rMIysaiw5n") == 0) {
				assertEquals("9dVnCtu1BW", departmentId);
			}
			else {
				fail("invalid student");
			}
		}
	}
	
	@Test
	public void testFetchClassesForStudentWithId() {
		String resultString = this.server.fetchStudents();
		JSONObject result = (JSONObject) JSONValue.parse(resultString);
		JSONArray array = (JSONArray) result.get(resultKey);
		

		assertEquals(5, array.size());
		
		Iterator<JSONObject> i = array.iterator();
		
		while(i.hasNext()) {
			JSONObject student = i.next();
			String studentId = (String) student.get("objectId");
			resultString = this.server.fetchClassesForStudentWithId(studentId);
			result = (JSONObject) JSONValue.parse(resultString);
			array = (JSONArray) result.get(resultKey);
			
			Iterator<JSONObject> j = array.iterator();
			
			if(studentId.compareTo("RA9Xx51PSH") == 0) {
				assertEquals(0, array.size());
			}
			else if(studentId.compareTo("eETFJRGZ2s") == 0) {
				assertEquals(0, array.size());
			}
			else if(studentId.compareTo("s3DaUQUo7I") == 0) {
				assertEquals(0, array.size());
			}
			else if(studentId.compareTo("zlsk5GWLH2") == 0) {
				assertEquals(2, array.size());
			}
			else if(studentId.compareTo("rMIysaiw5n") == 0) {
				assertEquals(3, array.size());
			}
			else {
				fail("invalid student");
			}
			
			while(j.hasNext()) {
				result = j.next();
				String id = (String) result.get("objectId");
				if(studentId.compareTo("RA9Xx51PSH") == 0) {
					
				}
				else if(studentId.compareTo("eETFJRGZ2s") == 0) {
					
				}
				else if(studentId.compareTo("s3DaUQUo7I") == 0) {
					
				}
				else if(studentId.compareTo("zlsk5GWLH2") == 0) {
					if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("MWn0ZDbyit") != 0) {
						fail("invalid class");
					}
				}
				else if(studentId.compareTo("rMIysaiw5n") == 0) {
					if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("yOqln8vNsA") != 0 && id.compareTo("SCWCADj6gM") != 0) {
						fail("invalid class");
					}
				}
				else {
					fail("invalid student");
				}
			}
		}
	}
	
	@Test
	public void testFetchAvailableClassesForSecretaryWithId() {
		String[] secs = {"ocJkzdQqD7", "QA22GxXCsg", "Rjsoejvn4D"};
		
		for(int i = 0; i < secs.length; i++) {
			String resultString = this.server.fetchAvailableClassesForSecretaryWithId(secs[i]);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			JSONArray array = (JSONArray) result.get(resultKey);
			
			if(secs[i].compareTo("ocJkzdQqD7") == 0) {
				assertEquals(1, array.size());
			}
			else if(secs[i].compareTo("QA22GxXCsg") == 0) {
				assertEquals(1, array.size());
			}
			else if(secs[i].compareTo("Rjsoejvn4D") == 0) {
				assertEquals(5, array.size());
			}
			else {
				fail("invalid sec");
			}
			
			Iterator<JSONObject> j = array.iterator();
			
			while(j.hasNext()) {
				result = j.next();
				String id = (String) result.get("objectId");
				
				if(secs[i].compareTo("ocJkzdQqD7") == 0) {
					if(id.compareTo("fpICxXTeBi") != 0) {
						fail("err");
					}
				}
				else if(secs[i].compareTo("QA22GxXCsg") == 0) {
					if(id.compareTo("Ngh8JMKhYM") != 0) {
						fail("err");
					}
				}
				else if(secs[i].compareTo("Rjsoejvn4D") == 0) {
					if(id.compareTo("FOVrIDd8hB") != 0 && id.compareTo("TKQCY40Nnn") != 0 && id.compareTo("MWn0ZDbyit") != 0 && id.compareTo("SCWCADj6gM") != 0 && id.compareTo("6CvPEgQO5Y") != 0 && id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("yOqln8vNsA") != 0) {
						fail("err");
					}
				}
				else {
					fail("invalid sec");
				}
			}
		}
	}
	
	@Test
	public void testFetchClassesForDepartmentWithId() {
		String[] departments = {"Mj8dRFJ175", "9dVnCtu1BW"};
		
		for(int i = 0; i < departments.length; i++) {
			String resultString = this.server.fetchClassesForDepartmentWithId(departments[i]);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			JSONArray array = (JSONArray) result.get(resultKey);
			
			if(departments[i].compareTo("Mj8dRFJ175") == 0) {
				assertEquals(1, array.size());
				assertEquals("fpICxXTeBi", (String) ((JSONObject) array.get(0)).get("objectId"));
			}
			else if(departments[i].compareTo("9dVnCtu1BW") == 0) {
				assertEquals(8, array.size());
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(0)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(1)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(2)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(3)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(4)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(5)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(6)).get("objectId"));
				assertNotEquals("fpICxXTeBi", (String) ((JSONObject) array.get(7)).get("objectId"));
			}
		}
		
		
	}
	
	@Test
	public void testFetchDepartments() {
		String resultString = this.server.fetchDepartments();
		JSONObject result = (JSONObject) JSONValue.parse(resultString);
		JSONArray array = (JSONArray) result.get(resultKey);

		assertEquals(2, array.size());
		
		Iterator<JSONObject> i = array.iterator();
		
		while(i.hasNext()) {
			JSONObject dep = i.next();
			
			if(((String)dep.get("objectId")).compareTo("Mj8dRFJ175") == 0) {
				assertEquals("Letras", dep.get("name"));
				assertEquals("ocJkzdQqD7", (String) (((JSONObject)dep.get("gradSecretary")).get("objectId")));
				assertEquals(null, dep.get("docSecretary"));
			}
			else if(((String)dep.get("objectId")).compareTo("9dVnCtu1BW") == 0) {
				assertEquals("Informática", dep.get("name"));
				assertEquals("Rjsoejvn4D", (String) (((JSONObject)dep.get("gradSecretary")).get("objectId")));
				assertEquals("QA22GxXCsg", (String) (((JSONObject)dep.get("docSecretary")).get("objectId")));
			}
			else {
				fail("invalid dep");
			}
		}
	}
	
	@Test
	public void testFetchSecretaryWithId() {
		String[] secs = {"ocJkzdQqD7", "QA22GxXCsg", "Rjsoejvn4D"};
		
		for(int i = 0; i < secs.length; i++) {
			String resultString = this.server.fetchSecretaryWithId(secs[i]);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			result = (JSONObject) result.get(resultKey);
			
			if(secs[i].compareTo("ocJkzdQqD7") == 0) {
				assertEquals("Graduação", result.get("name"));
			}
			else if(secs[i].compareTo("QA22GxXCsg") == 0) {
				assertEquals("Pós-graduação", result.get("name"));
			}
			else if(secs[i].compareTo("Rjsoejvn4D") == 0) {
				assertEquals("Graduação", result.get("name"));
			}
			else {
				fail("Invalid sec");
			}
		}
	}
	
	@Test
	public void testFetchTeachersWithId() {
		String[] ts = {"vp1nyvj1JY", "lLvknd5N8B", "aWbbZll3Og", "6QqkNVZ9Vo", "5VcNEte1s7", "2t1skGtEbT"};
		
		for(int i = 0; i < ts.length; i++) {
			String resultString = this.server.fetchTeacherWithId(ts[i]);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			result = (JSONObject) result.get(resultKey);
			
			if(ts[i].compareTo("vp1nyvj1JY") == 0) {
				assertEquals("Daniel Schawbe", result.get("name"));
			}
			else if(ts[i].compareTo("lLvknd5N8B") == 0) {
				assertEquals("Carlos Lucena", result.get("name"));
			}
			else if(ts[i].compareTo("aWbbZll3Og") == 0) {
				assertEquals("Marcus Poggi", result.get("name"));
			}
			else if(ts[i].compareTo("6QqkNVZ9Vo") == 0) {
				assertEquals("Ângela Souza", result.get("name"));
			}
			else if(ts[i].compareTo("5VcNEte1s7") == 0) {
				assertEquals("Arndt Von Staa", result.get("name"));
			}
			else if(ts[i].compareTo("2t1skGtEbT") == 0) {
				assertEquals("Bruno Feijó", result.get("name"));
			}
			else {
				fail("Invalid sec");
			}
		}
	}
	
	@Test
	public void testFetchStudentsForSecretaryWithId() {
		String[] secs = {"QA22GxXCsg", "ocJkzdQqD7", "Rjsoejvn4D"};
		
		for(int j = 0; j < secs.length; j++) {
			String resultString = this.server.fetchStudentsForSecretaryWithId(secs[j]);
			JSONObject result = (JSONObject) JSONValue.parse(resultString);
			JSONArray array = (JSONArray) result.get(resultKey);
			
			if(secs[j].compareTo("QA22GxXCsg") == 0) {
				assertEquals(1, array.size());
			}
			else if(secs[j].compareTo("ocJkzdQqD7") == 0) {
				assertEquals(1, array.size());
			}
			else if(secs[j].compareTo("Rjsoejvn4D") == 0) {
				assertEquals(3, array.size());
			}
			else {
				fail("Invalid sec");
			}
			
			Iterator<JSONObject> i = array.iterator();
			
			while(i.hasNext()) {
				JSONObject student = i.next();
				
				if((Long) student.get("registry") == 12398) {
					assertEquals("Maria Antônia", student.get("name"));
					assertEquals(new Long(0), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("TbD4sLMPBd", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
				}
				else if((Long) student.get("registry") == 9914918) {
					assertEquals("João da Silva", student.get("name"));
					assertEquals(new Long(0), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("0Y7xVqhuMU", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
				}
				else if((Long) student.get("registry") == 9915918) {
					assertEquals("José Vasconcelos", student.get("name"));
					assertEquals(new Long(0), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("rAXD7UBiUW", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(0, ((JSONArray) student.get("coursedClasses")).size());
				}
				else if((Long) student.get("registry") == 9924812) {
					assertEquals("Jurema Torres", student.get("name"));
					assertEquals(new Long(100), student.get("mandatoryCredits"));
					assertEquals(new Long(0), student.get("electiveCredit"));
					assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(2, ((JSONArray) student.get("coursedClasses")).size());
					
					Iterator<String> k = ((JSONArray) student.get("coursedClasses")).iterator();
					while(k.hasNext()) {
						String id = k.next();
						if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("MWn0ZDbyit") != 0) {
							fail("invalid id");
						}
					}
				}
				else if((Long) student.get("registry") == 98124812) {
					assertEquals("Alex Carvalho", student.get("name"));
					assertEquals(new Long(130), student.get("mandatoryCredits"));
					assertEquals(new Long(50), student.get("electiveCredit"));
					assertEquals("5sBCpMQeAW", ((JSONObject) student.get("course")).get("objectId"));
					assertEquals(3, ((JSONArray) student.get("coursedClasses")).size());
					
					Iterator<String> k = ((JSONArray) student.get("coursedClasses")).iterator();
					while(k.hasNext()) {
						String id = k.next();
						if(id.compareTo("dQAAP7Wkx9") != 0 && id.compareTo("yOqln8vNsA") != 0 && id.compareTo("SCWCADj6gM") != 0) {
							fail("invalid id");
						}
					}
				}
				else {
					fail("Invalid User");
				}
			}
		}
	}
}
		
