package py.com.natura.desafio.servicios;

import javax.ejb.EJB;

import org.apache.ibatis.session.SqlSession;

import py.com.natura.desafio.servicios.mybatis.PacienteSessionFactoryWrapper;


public abstract class PacienteMyBatisServiceBase<T,E, MP > {
	
	@EJB
	private PacienteSessionFactoryWrapper factory;


	/**
	 * Identifica la clase real de los Modelos (T.class)
	 * @return el tipo de clase real
	 */
	protected abstract Class<T> getEntityBeanType();

	public SqlSession getSqlSession() {
		return factory.getSqlSession();
	}
}
