package com.roxoft.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.xml.stream.XMLStreamException;

import com.roxoft.dao.mybatis.AddressDaoImpl;
import com.roxoft.dao.mybatis.BusDaoImpl;
import com.roxoft.dao.mybatis.DepotDaoImpl;
import com.roxoft.dao.mybatis.DriversDaoImpl;
import com.roxoft.dao.mybatis.TaxiDaoImpl;
import com.roxoft.dao.mybatis.TrainDaoImpl;
import com.roxoft.dao.mybatis.TramDaoImpl;
import com.roxoft.dao.mybatis.TrolleybusDaoImpl;
import com.roxoft.dao.services.DepotService;
import com.roxoft.exceptions.DataNotFoundException;


public class Main{

	public static void main(String[] args) throws XMLStreamException, IOException, SQLException, DataNotFoundException {

//		DepotService serv = new DepotService();
//		serv.createDepos();
		DepotDaoImpl depo = new DepotDaoImpl();
		depo.getAll();
        AddressDaoImpl addr = new AddressDaoImpl();
        addr.read(1);
        addr.getAll();
		DriversDaoImpl drive = new DriversDaoImpl();
		drive.getAll();
		drive.read(2);
		BusDaoImpl bus = new BusDaoImpl();
		bus.read(2);
		bus.getAll();
		TrolleybusDaoImpl trolley = new TrolleybusDaoImpl();
		trolley.getAll();
		trolley.read(4);
		
		TramDaoImpl tram = new TramDaoImpl();
		tram.getAll();
		tram.read(7);
		TrainDaoImpl train = new TrainDaoImpl();
		train.getAll();
		train.read(10);
		TaxiDaoImpl taxi = new TaxiDaoImpl();
		taxi.getAll();
		taxi.read(12);
		

		
		
	}	
}
