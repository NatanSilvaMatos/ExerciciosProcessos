package Redes;

import Redes.RedesController;

public class TesteRedes {
	public static void main(String[] args) {
		RedesController operacoes = new RedesController();

		String nome = operacoes.nomeOs();

		operacoes.retornaIp(nome);
		
		System.out.println();
		
		operacoes.ping(nome);
	}
}	
