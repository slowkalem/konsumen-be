package com.konsumen.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.konsumen.model.Konsumen;

@Repository
public class JdbcKonsumenRepository implements KonsumenRepository {

	@Autowired
	private JdbcTemplate jdbcKonsumen;

	@Override
	public int save(Konsumen konsumen) {
		return jdbcKonsumen.update(
				"INSERT INTO konsumen (id, nama, alamat, kota, provinsi, tgl_registrasi, status) VALUES(?,?,?,?,?,?,?)",
				new Object[] { konsumen.getId(), konsumen.getNama(), konsumen.getAlamat(), konsumen.getKota(),
						konsumen.getProvinsi(),
						konsumen.getTgl_registrasi(), konsumen.getStatus()
				});
	}

	@Override
	public int update(Konsumen konsumen) {
		return jdbcKonsumen.update(
				"UPDATE konsumen SET nama = ?, alamat = ?, kota = ?, provinsi = ?, tgl_registrasi = ?, status = ? "
						+ "where id = ?",
				new Object[] { konsumen.getNama(), konsumen.getAlamat(), konsumen.getKota(), konsumen.getProvinsi(),
						konsumen.getTgl_registrasi(), konsumen.getStatus(), konsumen.getId() });
	}

	@Override
	public Konsumen findById(int id) {
		try {
			Konsumen konsumen = jdbcKonsumen.queryForObject("SELECT * FROM konsumen where id = ?",
					BeanPropertyRowMapper.newInstance(Konsumen.class), id);
			return konsumen;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public int deleteById(int id) {
		return jdbcKonsumen.update("DELETE FROM konsumen WHERE id=?", id);
	}

	@Override
	public List<Konsumen> findAll() {
		return jdbcKonsumen.query("SELECT * from konsumen", BeanPropertyRowMapper.newInstance(Konsumen.class));
	}

	@Override
	public int deleteAll() {
		return jdbcKonsumen.update("DELETE from konsumen");
	}

}
