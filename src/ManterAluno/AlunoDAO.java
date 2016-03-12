package ManterAluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {
	
	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO cliente(id, nome, fone) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getFone());
			stm.setInt(4, to.getRg());
			stm.setInt(5, to.getCpf());
			stm.setInt(6, to.getSenha());
			stm.setString(7, to.getEmail());
			stm.setString(8, to.getLogin());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getFone());
			stm.setInt(3, to.getId());
			stm.setInt(4, to.getRg());
			stm.setInt(5, to.getCpf());
			stm.setInt(6, to.getSenha());
			stm.setString(7, to.getEmail());
			stm.setString(8, to.getLogin());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "SELECT nome, fone FROM Aluno WHERE aluno.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setFone(rs.getString("fone"));
					to.setRg(rs.getInt("RG"));
					to.setCpf(rs.getInt("CPF"));
					to.setSenha(rs.getInt("Senha"));
					to.setEmail(rs.getString("E-mail"));
					to.setLogin(rs.getString("Login"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
}
