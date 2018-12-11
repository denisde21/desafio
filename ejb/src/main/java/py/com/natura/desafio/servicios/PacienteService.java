package py.com.natura.desafio.servicios;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;

import py.com.natura.desafio.model.EntradaSignosVitales;
import py.com.natura.desafio.model.FrecuenciaCardiaca;
import py.com.natura.desafio.model.Paciente;
import py.com.natura.desafio.model.PresionArterial;
import py.com.natura.desafio.model.SalidaSignosVitales;
import py.com.natura.desafio.model.SignosVitales;
import py.com.natura.desafio.model.mapeadores.PacienteMapper;
import py.com.natura.desafio.servicios.mybatis.PacienteSessionFactoryWrapper;


@Stateless(name = "PacineteService", description = "Servicios para la tabla PACIENTE")
public class PacienteService {
	
	ObjectMapper objectMapper;
	
	@Resource
	EJBContext ctx;
	
	
	@EJB
	private PacienteSessionFactoryWrapper factory;
	
	
	public Paciente obtnerPaciente(String ci) throws Exception {

		SqlSession sesion = null;
		try{
			sesion = factory.getSqlSession();
			PacienteMapper mapper = sesion.getMapper(PacienteMapper.class);
			Paciente resultado = mapper.obtenerPaciente(ci);
			if(resultado==null){
				return new Paciente();
			}
			PacienteMapper mapperFicha = sesion.getMapper(PacienteMapper.class);
			List<SignosVitales> ficha = mapperFicha.obtenerFichaPaciente(ci);
			resultado.setSignosVitales(ficha);
			return resultado;
			
		}catch(Exception e){
			
			throw new Exception(e.getMessage(), e);
		}finally {
			if(sesion != null){
				sesion.close();
			}
		}
	}
	
	public void insertarPaciente(Paciente paciente){
		SqlSession sesion = null;
		try{
			sesion = factory.getSqlSession();
			PacienteMapper mapper = sesion.getMapper(PacienteMapper.class);
			Paciente existePaciente = mapper.obtenerPaciente(paciente.getCi());
			paciente.getSignosVitales().get(0).setCi(paciente.getCi());
			if(existePaciente != null){
				mapper.insertFicha(paciente.getSignosVitales().get(0));
			}else{
				mapper.insertPaciente(paciente);
				mapper.insertFicha(paciente.getSignosVitales().get(0));
			}
			
			
		}catch(Exception e){
			throw e;
		}finally {
			if(sesion != null){
				sesion.close();
			}
		}
	}
	
	public void deletePaciente(String ci){
		SqlSession sesion = null;
		try{
			sesion = factory.getSqlSession();
			PacienteMapper mapper = sesion.getMapper(PacienteMapper.class);
			mapper.deletePaciente(ci);
			mapper.deleteFicha(ci);
			
		}catch(Exception e){
			throw e;
		}finally {
			if(sesion != null){
				sesion.close();
			}
		}
	}
	
	public void modificarPaciente(Paciente params){
		SqlSession sesion = null;
		try{
			sesion = factory.getSqlSession();
			PacienteMapper mapper = sesion.getMapper(PacienteMapper.class);
			mapper.update(params);
			
		}catch(Exception e){
			throw e;
		}finally {
			if(sesion != null){
				sesion.close();
			}
		}
	}
	
	public SalidaSignosVitales verSignosVitales(EntradaSignosVitales sv) throws Exception{
		SqlSession sesion = null;
		try{
			sesion = factory.getSqlSession();
			PacienteMapper mapper = sesion.getMapper(PacienteMapper.class);
			FrecuenciaCardiaca fcObtener  = new FrecuenciaCardiaca();
			fcObtener.setSexo(sv.getSexo());
			fcObtener.setEdadFinal(sv.getEdad());
			fcObtener.setEdadInicial(sv.getEdad());
			FrecuenciaCardiaca frecuencia = mapper.obtenerFrecuenciaCardiaca(fcObtener);
			String tipoFre = tipoFrecuencia(frecuencia, sv.getFrecuenciaCardiaca());
			PacienteMapper mapperFicha = sesion.getMapper(PacienteMapper.class);
			PresionArterial pa = new PresionArterial();
			String[] parts = sv.getPresionArterial().split("/");
			pa.setDiastolicaInicial(Integer.parseInt(parts[0]));
			pa.setDiastolicaFinal(Integer.parseInt(parts[1]));
			pa.setSistolicaInicial(Integer.parseInt(parts[0]));
			pa.setSistolicaFinal(Integer.parseInt(parts[1]));
			PresionArterial presion = mapperFicha.obtenerPresionArterialNoE(pa);
			if(presion == null){
				presion = mapperFicha.obtenerPresionArterialSis(pa);
				if(presion==null){
					presion = mapperFicha.obtenerPresionArterialDia(pa);
				}
			}
			SalidaSignosVitales salida = new SalidaSignosVitales();
			salida.setFrecuenciaCardiaca(tipoFre);
			salida.setPresionArterial(tipoPresionArterial(presion));
			
			return salida;
			
		}catch(Exception e){
			
			throw new Exception(e.getMessage(), e);
		}finally {
			if(sesion != null){
				sesion.close();
			}
		}
		
	}
	
	public String tipoFrecuencia(FrecuenciaCardiaca fc, Integer fr){
		if(fc.getMal() <= fr){
			return "MAL";
		}else if((fc.getNormalInicial() <= fr) && (fc.getNormalFinal() >= fr)){
			return "NORMAL";
		}else if((fc.getBienInicial() <= fr) && (fc.getBienFinal() >= fr)){
			return "BIEN";
		}else if(fc.getExcelente() >= fr){
			return "EXCELENTE";
		}
		return null;
	}
	
	public String tipoPresionArterial(PresionArterial pa){
		if(pa.getCategoria().equals("N")){
			return "NORMAL";
		}else if(pa.getCategoria().equals("E")){
			return "ELEVADA";
		}else if(pa.getCategoria().equals("CE")){
			return "HIPERTENSION";
		}else if(pa.getCategoria().equals("PA1")){
			return "PRESION_ARTERIAL_1";
		}else if(pa.getCategoria().equals("PA2")){
			return "PRESION_ARTERIAL_2";
		}
		
		return null;
	}
	
	
}
