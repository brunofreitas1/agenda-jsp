package controller;

import java.util.ArrayList;
import java.util.List;

import vo.Contato;
import vo.Operadora;

public class Agenda {

	private static List<Contato> agenda = new ArrayList<>();
	private static List<Operadora> operadoras = new ArrayList<>();

	public static List<Operadora> getOperadoras() {
		if (operadoras.isEmpty()) {
			Operadora op = new Operadora();
			op.setCodigo(1);
			op.setNome("VIVO");
			op.setCodOperadora(015);
			operadoras.add(op);
		}
		return operadoras;
	}

	public static void setOperadoras(List<Operadora> operadoras) {
		Agenda.operadoras = operadoras;
	}

	public static List<Contato> getAgenda() {
		return agenda;
	}

	public static void setAgenda(List<Contato> agenda) {
		Agenda.agenda = agenda;
	}

}
