package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;


public class RedesController {

	public String nomeOs() {
		String nome = System.getProperty("os.name");
		return nome;
	}

	public void retornaIp(String os) {
		if(os.equals("Windows 10")) {
			try {
				InetAddress ip = Inet4Address.getLocalHost(); //pega o ip do local host
				String mostraIp = ip.toString();
				int numero = mostraIp.indexOf("/"); //pegando o numero do indice da barra
				mostraIp = mostraIp.substring(numero + 1); //usando o indice da barra para cortar e mostrar apenas o numero do IP
				System.out.println("IP = " + mostraIp);
				try {
					NetworkInterface adaptador = NetworkInterface.getByInetAddress(ip); 
					StringBuffer adapter =  new StringBuffer(adaptador.getName());
					System.out.println("Adaptador = " + adapter.toString());
				} catch (SocketException e) {
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}

	public void ping(String os) {
		String command = "";
		if(os.equals("Windows 10")) {
			command = "PING -t10 www.google.com.br";
		}
		else if(os.equals("Linux")){
			command = "ping -t10 www.google.com.br";
		}
		try {
			Process p = Runtime.getRuntime().exec(command);
			InputStream is = p.getInputStream(); 
			InputStreamReader isp = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isp);
			String s = bf.readLine();
			try {
				s = bf.readLine();
				System.out.println(s);
				String auxiliar = bf.readLine().trim();
				int numero = auxiliar.lastIndexOf(":");
				for(int i = 0;i <= 9;i++) {
					s = bf.readLine(); 			
					System.out.println(s.trim().substring(numero + 2)); //cortando a String para aparecer somente o tempo em millisegundos
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	{
	}
}





