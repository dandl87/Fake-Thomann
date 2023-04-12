package com.protom.fakethomann.model.dao;

import com.protom.fakethomann.model.entity.Instrument; 

public interface InstrumentDAO {
	
	boolean createInstrument(Instrument instrument);
	Instrument readInstrument(String code);
	boolean updateInstrument(Instrument instrument);
	boolean deleteInstrument(String code);
	
	//ArrayList<Strumento> readAllStrumenti();
	//ArrayList<Strumento> readAllStrumentiByType(String type);


}
