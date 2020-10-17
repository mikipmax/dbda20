import java.time.LocalDate;
import java.util.Date;

public class Cliente {
	private String codigo;
	private String nombres;
	private boolean sexo;
	private Date fechanac;
	private Date fechaing;
	private Date fechadesah;
	private double sueldomen;

	public Cliente() {
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public Date getFechaing() {
		return fechaing;
	}

	public void setFechaing(Date fechaing) {
		this.fechaing = fechaing;
	}

	public Date getFechadesah() {
		return fechadesah;
	}

	public void setFechadesah(Date fechadesah) {
		this.fechadesah = fechadesah;
	}

	public double getSueldomen() {
		return sueldomen;
	}

	public void setSueldomen(double sueldomen) {
		this.sueldomen = sueldomen;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombres=" + nombres + ", sexo=" + sexo + ", fechanac=" + fechanac
				+ ", fechaing=" + fechaing + ", fechadesah=" + fechadesah + ", sueldomen=" + sueldomen + "]";
	}

}
