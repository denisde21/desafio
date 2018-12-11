package py.com.natura.desafio.model;

import java.util.List;


public class Paciente{
	
	private String ci;
	
	private String nombre;
	
	private Integer edad;
	
	private List<SignosVitales> signosVitales;
	
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<SignosVitales> getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(List<SignosVitales> signosVitales) {
		this.signosVitales = signosVitales;
	}

	@Override
	public String toString() {
		return "Paciente [ci=" + ci + ", nombre=" + nombre + ", edad=" + edad
				+ ", signosVitales=" + signosVitales + "]";
	}

}