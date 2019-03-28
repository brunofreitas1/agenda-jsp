package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Agenda;
import controller.Mensagem;
import dao.OperadoraDAO;
import vo.Operadora;

@WebServlet("/ProcessaOperadora")
public class ProcessaOperadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessaOperadora() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Operadora op = new Operadora();
		OperadoraDAO opD = new OperadoraDAO();
		
		op.setNome("nOperadora");
		
		if(op.getNome().trim().equals("")){
			response.sendRedirect("inicial.jsp");
		}else{
			try {
				opD.inserir(op);
				Mensagem.addMensagem("Nova operadora adicionada");
				response.sendRedirect("inicial.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
