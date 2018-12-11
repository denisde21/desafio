package py.com.natura.desafio.model;


public class SignosVitales {
	
	private String ci;
	
	private Integer presionArterial;
	
	private String frecuenciaCardiaca;
	

	public Integer getPresionArterial() {
		return presionArterial;
	}

	public void setPresionArterial(Integer presionArterial) {
		this.presionArterial = presionArterial;
	}

	public String getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	@Override
	public String toString() {
		return "SignosVitales [presionArterial="
				+ presionArterial + ", frecuenciaCardiaca="
				+ frecuenciaCardiaca + "]";
	}

}
