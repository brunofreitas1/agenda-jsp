package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Operadora;

public class OperadoraDAO {

	Connection con;
	PreparedStatement ps;
	
	public List<Operadora> listarTodas() throws SQLException{
		
		String sql = " SELECT * FROM operadora ";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Operadora> operadoras = new ArrayList<>();
		while(rs.next()){
			Operadora op = new Operadora();
			op.setCodOperadora(rs.getInt("cod_operadora"));
			op.setCodigo(rs.getInt("codigo"));
			op.setNome(rs.getString("nome"));
			
			operadoras.add(op);
			
		}
		
		return operadoras;
	}
	
	public boolean inserir(Operadora op) throws SQLException{
		
		String sql = "INSERT INTO usuarios VALUES (0,?)";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		//ps.setInt(1, op.getCodigo());
		ps.setString(2, op.getNome());
		
		int result = ps.executeUpdate();
		
		if(result > 0){
			return true;
		}
		
		return false;
		
	}
	
}
