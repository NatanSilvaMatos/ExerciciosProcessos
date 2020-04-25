package SimuladorExecutar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExecutarController implements ActionListener{
	private JPanel contentPane;
	private JTextField textoArquivo;
	
	public ExecutarController(JTextField textoArquivo) {
		this.textoArquivo = textoArquivo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		validaArquivo();
	}
	
	
	public void validaArquivo() {
		try {
			Runtime.getRuntime().exec(textoArquivo.getText().trim());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
		}
		
	}
}
