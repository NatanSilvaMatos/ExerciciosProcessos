package View;

import Controller.RedesController;

public class TesteRedes {
	public static void main(String[] args) {
		RedesController operacoes = new RedesController();

		String nome = operacoes.nomeOs();

		operacoes.retornaIp(nome);
		
		operacoes.ping(nome);
	}
}	
