package py.com.natura.desafio.model;

public class PresionArterial {
	
	private String categoria;
	
	private Integer sistolicaInicial;
	
	private Integer sistolicaFinal;
	
	private Integer diastolicaInicial;
	
	private Integer diastolicaFinal;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getSistolicaInicial() {
		return sistolicaInicial;
	}

	public void setSistolicaInicial(Integer sistolicaInicial) {
		this.sistolicaInicial = sistolicaInicial;
	}

	public Integer getSistolicaFinal() {
		return sistolicaFinal;
	}

	public void setSistolicaFinal(Integer sistolicaFinal) {
		this.sistolicaFinal = sistolicaFinal;
	}

	public Integer getDiastolicaInicial() {
		return diastolicaInicial;
	}

	public void setDiastolicaInicial(Integer diastolicaInicial) {
		this.diastolicaInicial = diastolicaInicial;
	}

	public Integer getDiastolicaFinal() {
		return diastolicaFinal;
	}

	public void setDiastolicaFinal(Integer diastolicaFinal) {
		this.diastolicaFinal = diastolicaFinal;
	}

}
