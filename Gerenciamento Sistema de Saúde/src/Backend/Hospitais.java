package Backend;
import java.util.Vector;

public class Hospitais {
	public String nomeHospital;
	public String enderecoHospital;
	public int numeroLeitos;
	public int numeroLeitosDisp;
	public Vector<Paciente> internados = new Vector<Paciente>();
	
	public Hospitais() {}
	
	public Hospitais(String nomeHospital, String enderecoHospital, int numeroLeitos, int numeroLeitosDisp) {
		this.nomeHospital = nomeHospital;
		this.enderecoHospital = enderecoHospital;
		this.numeroLeitos = numeroLeitos;
		this.numeroLeitosDisp = numeroLeitosDisp;
		SistemaDeSaude.totalLeitos += numeroLeitos;
		SistemaDeSaude.totalLeitosDisp += numeroLeitosDisp;
		if (numeroLeitosDisp > 0) {
			SistemaDeSaude.hospitaisDisponiveis.add(this);
		}
		SistemaDeSaude.hospitais.add(this);
	}
	
	public void liberarLeito(Paciente paciente) {
		if (internados.contains(paciente)) {
			internados.remove(paciente);
			paciente.localDeInternacao = null;
			SistemaDeSaude.pacientesLivres.add(paciente);
			if (numeroLeitosDisp >= numeroLeitos) {
				System.out.println("Número máximo de leitos atingidos.");
			}
			else {
				if (numeroLeitosDisp > 0) {
					numeroLeitosDisp++;
					SistemaDeSaude.totalLeitosDisp++;
				}
				else {
					if (!SistemaDeSaude.filaDeEspera.isEmpty()) {
						inserirPaciente(SistemaDeSaude.filaDeEspera.get(0));
						SistemaDeSaude.filaDeEspera.get(0).filaDeEspera = false;
						SistemaDeSaude.filaDeEspera.get(0).removerFila();;
					}
					else {
						SistemaDeSaude.hospitaisDisponiveis.add(this);
						numeroLeitosDisp++;
						SistemaDeSaude.totalLeitosDisp++;
					}
				}
			}
		}
		else {
			System.out.println("O paciente solicitado não está internado neste hospital.");
		}
	}
	
	public void inserirPaciente(Paciente paciente) {
		internados.add(paciente);
		SistemaDeSaude.pacientesLivres.remove(paciente);
		paciente.localDeInternacao = this;
		numeroLeitosDisp--;
		SistemaDeSaude.totalLeitosDisp--;
		if (numeroLeitosDisp == 0) {
			SistemaDeSaude.hospitaisDisponiveis.remove(this);
		}
	}
}
