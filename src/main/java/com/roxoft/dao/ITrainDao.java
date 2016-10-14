package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.transport.Train;

public interface ITrainDao {

	public void create(Train entity);

	public Train read(int key);

	public List<Train> getAll();
}
