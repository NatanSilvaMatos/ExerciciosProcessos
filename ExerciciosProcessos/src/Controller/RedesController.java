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
		if(os.equals("Windows 10") || os.equals("Linux")) {
			try {
				InetAddress ip = Inet4Address.getLocalHost(); //pega o ip do local host
				System.out.println("IP = " + ip.toString().substring(16));
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
		if(os.equals("Windows 10")) {
			String command = "PING -t10 www.google.com.br";
			Process p;
			try {
				p = Runtime.getRuntime().exec(command);
				InputStream is = p.getInputStream(); 
				InputStreamReader isp = new InputStreamReader(is);
				BufferedReader bf = new BufferedReader(isp);
				String s = bf.readLine();
				try {
					s = bf.readLine();
					System.out.println(s);
					for(int i = 0;i <= 9;i++) {
						s = bf.readLine();
						System.out.println(s.substring(37)); //cortando a String para aparecer somente o tempo em millisegundos
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
}
