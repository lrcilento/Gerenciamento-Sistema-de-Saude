package Backend;
import java.util.Vector;

public class SistemaDeSaude {
	public static int totalLeitos = 0;
	public static int totalLeitosDisp = 0;
	public static Vector<Hospitais> hospitaisDisponiveis = new Vector<Hospitais>();
	public static Vector<Hospitais> hospitais = new Vector<Hospitais>();
	public static Vector<Paciente> pacientes = new Vector<Paciente>();
	public static Vector<Paciente> pacientesLivres = new Vector<Paciente>();
	public static Vector<Paciente> filaDeEspera = new Vector<Paciente>();	
}
