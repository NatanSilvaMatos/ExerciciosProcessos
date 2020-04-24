package Processos;


public class TesteProcesso {
	public static void main(String[] args) {
		
		ProcessoController p = new ProcessoController();
		
		String nome = p.retornaSO();
		
		p.mostraProcessos(nome);
		
		p.mataProcessoPID("Windows 10", 11444);
		
		p.mataProcessoNome("Windows 10", "notepad.exe");
	}
}
