package py.com.natura.desafio.services;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.natura.desafio.model.EntradaSignosVitales;
import py.com.natura.desafio.model.Paciente;
import py.com.natura.desafio.model.SalidaSignosVitales;
import py.com.natura.desafio.servicios.PacienteService;

@Path("enfermeria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResourceImpl {
	
	@EJB
	PacienteService pacienteService;
	
	@POST
	@Path("/agregar")
	public Response insertarPaciente(Paciente params) throws Exception{
		
		pacienteService.insertarPaciente(params);
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/eliminar")
	public Response eliminarPaciente(@QueryParam("ci") String ci) throws Exception{
		pacienteService.deletePaciente(ci);
		return Response.ok().build();
		
	}
	
	@PUT
	@Path("/modificar")
	public Response eliminarPaciente(Paciente parms) throws Exception{
		pacienteService.modificarPaciente(parms);
		return Response.ok().build();
		
	}
	
	@GET
	@Path("/ver")
	public Response verPaciente(@QueryParam("ci") String ci) throws Exception{
		Paciente resultado = pacienteService.obtnerPaciente(ci);
		return Response.ok(resultado).build();
		
	}
	
	@POST
	@Path("/signos-vitales")
	public Response verSignosVitales(EntradaSignosVitales sv) throws Exception{
		SalidaSignosVitales resultado = pacienteService.verSignosVitales(sv);
		return Response.ok(resultado).build();
		
	}
}
