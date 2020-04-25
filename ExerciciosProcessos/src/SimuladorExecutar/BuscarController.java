package SimuladorExecutar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BuscarController implements ActionListener {
	private JTextField textoArquivo;
	private String caminhoArquivo = "";

	
	public BuscarController(JTextField textoArquivo) {
		this.textoArquivo = textoArquivo;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		procurarArquivo();
	}	
	
	public void procurarArquivo() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Execut�veis", "exe"); //filtro para selecionar apenas arquivos .exe
		String diretorio = System.getProperty("user.home") + "/Desktop"; //caminho at� chegar na area de trabalho do usuario
		File dir = new File(diretorio);
		
		JFileChooser escolha = new JFileChooser();
		escolha.setCurrentDirectory(dir); //diretorio padr�o, no caso o desktop
		escolha.setFileSelectionMode(JFileChooser.FILES_ONLY); //configurando para selecionar apenas arquivos
		escolha.setAcceptAllFileFilterUsed(false); //desabilitar a op��o de escolha para "todos os arquivos"
		escolha.addChoosableFileFilter(filter); //passando a varivel para aceitar apenas os arquivos executaveis
		
		//Configurando para que o nome do arquivo apare�a no JTextField quando o usuario selecionar o arquivo clicando no mesmo
		int retorno = escolha.showOpenDialog(null); //habilita o bot�o de abrir 
		if(retorno == JFileChooser.APPROVE_OPTION) { //caso tenha clicado no bot�o "abrir"
			caminhoArquivo = escolha.getSelectedFile().getAbsolutePath(); //recebe o caminho do arquivo
			textoArquivo.setText(caminhoArquivo);
		}
		
	}

}
