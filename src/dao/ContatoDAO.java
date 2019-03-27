package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Contato;
import vo.Operadora;


public class ContatoDAO {
	
	private static Connection con;
	private PreparedStatement ps;
	
	
public boolean inserir(Contato t) throws SQLException{
		
		//declara o sql
		String sql = "INSERT INTO contato VALUES (0,?,?,?,?)";
		
		//obtem a conexão
		con = ConnectionDB.getConnection();
		
		//prepara o sql
		ps = con.prepareStatement(sql);
		ps.setString(1, t.getNome());
		ps.setString(2, t.getTelefone());
		ps.setInt(3, t.getOperadora().getCodOperadora());
		
		//executa o sql e retorna o resultado
		return ps.executeUpdate() > 0;
		
	}

	public List<Contato> listarTodos() throws SQLException {

		//declara o sql
		String sql = " SELECT * FROM contato "
				+ " WHERE t.cod_operadora = o.cod_operadora; ";

		//obtem conexão
		con = ConnectionDB.getConnection();

		//prepara o sql
		ps = con.prepareStatement(sql);

		//executo o sql
		ResultSet rs = ps.executeQuery();
		
		List<Contato> contatos = new ArrayList<>();
		while (rs.next()) {
			//preenche um contato com as informações do banco
			Contato t = new Contato();
			t.setCodContato(rs.getInt("cod_contato"));
			t.setNome(rs.getString("c.nome"));
			t.setTelefone(rs.getString("telefone"));
			
			//preenche a operadora com as informações do banco
			Operadora op = new Operadora();
			op.setCodOperadora(rs.getInt("cod_operadora"));
			op.setNome(rs.getString("o.nome"));
			op.setCodigo(rs.getInt("o.codigo"));
			//coloca a operadora no contato
			 
			//adiciona o contato na lista
			contatos.add(t);
		}
		return contatos;
	}

}
