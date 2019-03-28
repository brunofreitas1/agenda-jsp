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
import dao.ContatoDAO;
import vo.Contato;
import vo.Operadora;

@WebServlet("/ProcessaContato")
public class ProcessaContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessaContato() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Contato c = new Contato();
		ContatoDAO cD = new ContatoDAO();
		
		c.setNome(request.getParameter("nome"));
		c.setTelefone(request.getParameter("telefone"));
		Operadora op = new Operadora();
		op.setCodigo(Integer.valueOf(request.getParameter("operadora")));
		c.setOperadora(op);
		
		if(c.getNome().trim().equals("") || c.getTelefone().trim().equals("")
				|| c.getOperadora().equals("")){
			Mensagem.addMensagem("Todos os campos são o brigatórios");
			response.sendRedirect("inicial.jsp");
		}else{
				try {
					cD.inserir(c);
					Mensagem.addMensagem("Contato salvo com sucesso");
					response.sendRedirect("inicial.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

}












