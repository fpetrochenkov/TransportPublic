//package com.roxoft.parsing;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.roxoft.model.Depos;
//import com.roxoft.model.Depot;
//
//public class JSON {
//
//	public void parser() {		
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {				
//			
//	        ArrayList<Depot> depos = (ArrayList<Depot>) mapper.readValue(new File("src/main/resources/Depo.json"), new TypeReference<List<Depot>>(){});		
//	        System.out.println(depos);
//			
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
