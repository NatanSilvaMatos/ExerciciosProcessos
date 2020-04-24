package Processos;

import java.io.IOException;

public class ProcessoController {

	public String retornaSO() {
		String nomeSo = System.getProperty("os.name");
		return nomeSo;
	}

	public void mostraProcessos(String nomeSo) {
		try {
			if(nomeSo.equals("Windows 10")) {
				Runtime.getRuntime().exec("cmd.exe /c start tasklist /fo table");
			}
			else if(nomeSo.equals("Linux")) {
				Runtime.getRuntime().exec("ps");
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void mataProcessoPID(String nomeSo, int pid) {
		if(nomeSo.equals("Windows 10")) {
			try {
				Runtime.getRuntime().exec("TASKKILL /PID " + pid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public void mataProcessoNome(String nomeSo, String nomeProcesso) {
		if(nomeSo.equals("Windows 10")) {
			try {
				Runtime.getRuntime().exec("TASKKILL /IM " + nomeProcesso);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}
