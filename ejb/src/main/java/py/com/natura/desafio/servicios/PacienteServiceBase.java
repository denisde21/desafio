package py.com.natura.desafio.servicios;

import javax.ejb.EJB;

import org.apache.ibatis.session.SqlSession;

import py.com.natura.desafio.servicios.mybatis.PacienteSessionFactoryWrapper;

public abstract class PacienteServiceBase{
	
	@EJB
	private PacienteSessionFactoryWrapper factory;

	public SqlSession getSqlSession() {
		return factory.getSqlSession();
	}
}
