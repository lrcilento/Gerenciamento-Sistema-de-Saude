package Backend;

public class Paciente {
	public String nome;
	public String cpf;
	public String dataNascimento;
	public String endereco;
	public String telefone;
	public String email;
	public int tipo = 0;
	public Hospitais localDeInternacao;
	public boolean filaDeEspera = false;
	
	public void adicionarFila() {
		this.filaDeEspera = true;
		SistemaDeSaude.filaDeEspera.add(this);
	}
	
	public void removerFila() {
		this.filaDeEspera = false;
		SistemaDeSaude.filaDeEspera.remove(this);
	}
}
