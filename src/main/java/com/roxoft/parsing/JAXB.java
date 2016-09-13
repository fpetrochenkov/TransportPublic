//package com.roxoft.parsing;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//
//import com.roxoft.model.Depos;
//
//
//public class JAXB {
//
//	public void parser() {		
//		try {
//		JAXBContext jc = JAXBContext.newInstance(Depos.class);
//			Unmarshaller u = jc.createUnmarshaller();
//			FileReader reader = new FileReader("src/main/resources/Transport.xml");
//			Depos depos = (Depos) u.unmarshal(reader);
//			System.out.println(depos.toString());
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//}
