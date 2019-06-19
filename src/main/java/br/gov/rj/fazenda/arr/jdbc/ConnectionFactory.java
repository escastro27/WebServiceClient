package br.gov.rj.fazenda.arr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import br.gov.rj.fazenda.arr.util.PropertiesHelper;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			return DriverManager.getConnection(
					PropertiesHelper.getUrlBD(),
					PropertiesHelper.getUserBD(),
					PropertiesHelper.getPassBD());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}