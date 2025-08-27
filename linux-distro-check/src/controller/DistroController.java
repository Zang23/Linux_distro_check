package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	
	
	public DistroController() {
		super();
	}
	
	private String os () {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void exibeDistro(String proc) {
		String os = os();
		String[] vetProc = proc.split(" ");
		if(os.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec(vetProc);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader  buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("PRETTY")) {
						String[] vetPName = linha.split("=");
						System.out.println("Nome completo: " + vetPName[1]);
					}
					
					if(linha.contains("NAME=") && linha.contains("Ubu")) {
						String[] vetName = linha.split("=");
						System.out.println("Nome: " + vetName[1]);
					}
					
					if(linha.contains("VERSION") && linha.contains("LTS")) {
						String[] vetVersion = linha.split("=");
						System.out.println("Versão: " + vetVersion[1]);
					}
					
					linha = buffer.readLine();
				}
				
				
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}else {
			System.err.println("Sistema Operacional não permitido");
		}
	}
}
