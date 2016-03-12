package ManterAluno;

import ManterAluno.Aluno;

public class AlunoTeste {
	public static void main(String[] args) {
		Aluno aluno = new Aluno(3, "Bela Lugosi", null, 2, 4, 0, "", "");
		aluno.criar();
		aluno.carregar();
		System.out.println(aluno);
		aluno.setFone("123123333");
		aluno.atualizar();
		aluno.carregar();
		System.out.println(aluno);
		aluno.excluir();
		aluno.carregar();
		System.out.println(aluno);		
	}
}
