package Backend;

public class PacienteParticular extends Paciente {
	public String nomeConvenio;
	public String numeroConvenio;
	
	public PacienteParticular(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String nomeConvenio, String numeroConvenio) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.nomeConvenio = nomeConvenio;
		this.numeroConvenio = numeroConvenio;
		this.tipo = 2;
		SistemaDeSaude.pacientes.add(this);
		SistemaDeSaude.pacientesLivres.add(this);
	}
}
