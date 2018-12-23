package ug.ktrusilo.javaut.zad05.service;

import java.util.List;

import ug.ktrusilo.javaut.zad05.domain.Producer;

public interface ProducerManager {
	void addProducer(Producer producer);
	List<Producer> getAllProducers();
	Producer getProducerById(long id);
	void deleteProducer(Producer producer);
	void updateProducer(Producer producer);
	Producer getProducerByName(String name);
	void clearTable();
}
