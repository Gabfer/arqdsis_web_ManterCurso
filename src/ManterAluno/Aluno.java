package ManterAluno;

import ManterAluno.AlunoDAO;
import ManterAluno.AlunoTO;

public class Aluno {
	private int id, rg, cpf, senha;
	private String nome, email, login;
	private String fone;

	public Aluno(int id, String nome, String fone, int rg, int cpf, int senha, String email, String login) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.rg = rg;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}	

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void criar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		to.setNome(nome);
		to.setFone(fone);
		to.setRg(rg);
		to.setCpf(cpf);
		to.setSenha(senha);
		to.setEmail(email);
		to.setLogin(login);
		dao.incluir(to);
	}

	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		to.setNome(nome);
		to.setFone(fone);
		to.setRg(rg);
		to.setCpf(cpf);
		to.setSenha(senha);
		to.setEmail(email);
		to.setLogin(login);
		dao.atualizar(to);
	}

	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar(id);
		nome = to.getNome();
		fone = to.getFone();
		rg = to.getRg();
		cpf = to.getCpf();
		email = to.getEmail();
		senha = to.getSenha();
		login = to.getLogin();
		
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", fone=" + fone + "]";
	}
}
