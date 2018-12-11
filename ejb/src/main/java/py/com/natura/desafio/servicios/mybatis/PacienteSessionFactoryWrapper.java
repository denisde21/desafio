package py.com.natura.desafio.servicios.mybatis;

import java.io.IOException;

import javax.ejb.Singleton;

import org.apache.ibatis.session.SqlSession;

@Singleton
public class PacienteSessionFactoryWrapper extends SessionFactoryWrapper {

	public PacienteSessionFactoryWrapper() throws IOException {
	}

	@Override
	protected String getConfigURI() {
		return "mybatis/configuraciones/MyBatisConfiguration.xml";
	}

	public SqlSession getMyBatisSqlSession() {
		return getSqlSession();
	}
}
