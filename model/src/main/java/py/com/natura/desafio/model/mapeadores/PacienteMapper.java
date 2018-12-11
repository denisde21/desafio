package py.com.natura.desafio.model.mapeadores;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import py.com.natura.desafio.model.FrecuenciaCardiaca;
import py.com.natura.desafio.model.Paciente;
import py.com.natura.desafio.model.PresionArterial;
import py.com.natura.desafio.model.SignosVitales;

public interface PacienteMapper {
	
	@Select({
		"select * from paciente "
		+ "where ci = #{ci,jdbcType=VARCHAR}"
	})
	@Results({
		@Result(column="ci", property="ci", jdbcType=JdbcType.VARCHAR),
		@Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
		@Result(column="edad", property="edad", jdbcType=JdbcType.INTEGER)
		
	})
	Paciente obtenerPaciente(String ci);
	
	@Select({
		"select * from ficha_paciente "
		+ "where ci = #{ci,jdbcType=VARCHAR}"
	})
	@Results({
		@Result(column="ci", property="ci", jdbcType=JdbcType.VARCHAR),
		@Result(column="presion_arterial", property="presionArterial", jdbcType=JdbcType.INTEGER),
		@Result(column="frecuencia_cardiaca", property="frecuenciaCardiaca", jdbcType=JdbcType.INTEGER),
		
	})
	List<SignosVitales> obtenerFichaPaciente(String ci);
	
	@Insert({
        "insert into paciente (ci,nombre,edad) ",
        "values (#{ci,jdbcType=VARCHAR}, #{nombre,jdbcType=VARCHAR}, ",
        "#{edad,jdbcType=INTEGER})"
    })
    int insertPaciente(Paciente record);
	
	@Insert({
        "insert into ficha_paciente (ci,presion_arterial,frecuencia_cardiaca) ",
        "values (#{ci,jdbcType=VARCHAR}, #{presionArterial,jdbcType=INTEGER}, ",
        "#{frecuenciaCardiaca,jdbcType=INTEGER})"
    })
    int insertFicha(SignosVitales record);
	
	@Delete({
		"delete from paciente "
		+ " where ci=#{ci,jdbcType=VARCHAR}"
	})
	int deletePaciente(String ci);
	
	@Delete({
		"delete from ficha_paciente "
		+ "where ci=#{ci,jdbcType=VARCHAR}"
	})
	int deleteFicha(String ci);
	
	@Update({
		"update paciente set "
		+ "nombre=#{nombre,jdbcType=VARCHAR},"
		+ "edad=#{edad,jdbcType=INTEGER}"
	})
	int update(Paciente record);
	
	@Select({
		" select * from frecuencia_cardiaca "
		+ "where sexo = #{sexo,jdbcType=VARCHAR} "
		+ "and edad_inicial <= #{edadInicial,jdbcType=INTEGER} "
		+ "and edad_final >= #{edadFinal,jdbcType=INTEGER} "
	})
	@Results({
		@Result(column="sexo", property="sexo", jdbcType=JdbcType.VARCHAR),
		@Result(column="edad_inicial", property="edadInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="edad_final", property="edadFinal", jdbcType=JdbcType.INTEGER),
		@Result(column="mal", property="mal", jdbcType=JdbcType.INTEGER),
		@Result(column="normal_inicial", property="normalInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="normal_final", property="normalFinal", jdbcType=JdbcType.INTEGER),
		@Result(column="bien_inicial", property="bienInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="bien_final", property="bienFinal", jdbcType=JdbcType.INTEGER),
		@Result(column="excelente", property="excelente", jdbcType=JdbcType.INTEGER),
		
	})
	FrecuenciaCardiaca obtenerFrecuenciaCardiaca(FrecuenciaCardiaca record);
	
	
	@Select({
		"select * from presion_arterial "
		+ "where sistolica_inicial <= #{sistolicaInicial,jdbcType=INTEGER} and "
		+ "sistolica_final >= #{sistolicaFinal,jdbcType=INTEGER} and "
		+ "diastolica_inicial <= #{diastolicaInicial,jdbcType=INTEGER} and "
		+ "diastolica_final >= #{diastolicaFinal,jdbcType=INTEGER} "
	})
	@Results({
		@Result(column="categoria", property="categoria", jdbcType=JdbcType.VARCHAR),
		@Result(column="sistolica_inicial", property="sistolicaInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="sistolica_final", property="sistolicaFinal", jdbcType=JdbcType.INTEGER),
		@Result(column="diastolica_inicial", property="diastolicaInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="diastolica_final", property="diastolicaFinal", jdbcType=JdbcType.INTEGER),
		
	})
	PresionArterial obtenerPresionArterialNoE(PresionArterial record);
	
	@Select({
		"select * from presion_arterial "
		+ "where sistolicaInicial <= #{sistolica_inicial,jdbcType=INTEGER} and "
		+ "sistolicaFinal >= #{sistolica_final,jdbcType=INTEGER} "
	})
	@Results({
		@Result(column="categoria", property="categoria", jdbcType=JdbcType.VARCHAR),
		@Result(column="sistolica_inicial", property="sistolicaInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="sistolica_final", property="sistolicaFinal", jdbcType=JdbcType.INTEGER),
		@Result(column="diastolica_inicial", property="diastolicaInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="diastolica_final", property="diastolicaFinal", jdbcType=JdbcType.INTEGER),
		
	})
	PresionArterial obtenerPresionArterialSis(PresionArterial record);
	
	@Select({
		"select * from presion_arterial "
		+ "where "
		+ "diastolicaInicial <= #{diastolica_inicial,jdbcType=INTEGER} and "
		+ "diastolicaFinal >= #{diastolica_final,jdbcType=INTEGER} "
	})
	@Results({
		@Result(column="categoria", property="categoria", jdbcType=JdbcType.VARCHAR),
		@Result(column="sistolica_inicial", property="sistolicaInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="sistolica_final", property="sistolicaFinal", jdbcType=JdbcType.INTEGER),
		@Result(column="diastolica_inicial", property="diastolicaInicial", jdbcType=JdbcType.INTEGER),
		@Result(column="diastolica_final", property="diastolicaFinal", jdbcType=JdbcType.INTEGER),
		
	})
	PresionArterial obtenerPresionArterialDia(PresionArterial record);

}
