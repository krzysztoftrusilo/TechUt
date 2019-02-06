package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import ug.ktrusilo.javaut.zad04.domain.Owner;

public interface OwnerManager {
	void addOwner(Owner owner);
	Owner getById(long id);
	List<Owner> getAll();
	void deleteOwner(Owner owner);
	void updateOwner(Owner owner);
	void clearTable();
}
