package py.com.natura.desafio.model;

public class SalidaSignosVitales {
	
	private String presionArterial;
	
	private String frecuenciaCardiaca;

	public String getPresionArterial() {
		return presionArterial;
	}

	public void setPresionArterial(String presionArterial) {
		this.presionArterial = presionArterial;
	}

	public String getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	@Override
	public String toString() {
		return "SalidaSignosVitales [presionArterial=" + presionArterial
				+ ", frecuenciaCardiaca=" + frecuenciaCardiaca + "]";
	}
	
}
