package com.konsumen.repository;

import java.util.List;

import com.konsumen.model.Konsumen;

public interface KonsumenRepository {
	int save(Konsumen konsumen);

	int update(Konsumen konsumen);

	Konsumen findById(int id);

	int deleteById(int id);

	List<Konsumen> findAll();

	int deleteAll();
}
