package Backend;

public class PacienteSUS extends Paciente {
	public String numeroCadastroSUS;
	
	public PacienteSUS(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String numeroCadastroSUS) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.numeroCadastroSUS = numeroCadastroSUS;
		this.tipo = 1;
		SistemaDeSaude.pacientes.add(this);
		SistemaDeSaude.pacientesLivres.add(this);
	}
}
