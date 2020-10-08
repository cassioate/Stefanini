package br.com.tessaro.app.service.util;

public class CpfUtil {

	CpfUtil(){
		throw new IllegalStateException("Classe utilitária.");
	}

	public static boolean validarRegraCpf (String cpf) {
		boolean validade = false;
		
		if (cpf.length() == 11) {
			int a = Integer.parseInt(cpf.substring(0, 1));
			int b = Integer.parseInt(cpf.substring(1, 2));
			int c = Integer.parseInt(cpf.substring(2, 3));
			int d = Integer.parseInt(cpf.substring(3, 4));
			int e = Integer.parseInt(cpf.substring(4, 5));
			int f = Integer.parseInt(cpf.substring(5, 6));
			int g = Integer.parseInt(cpf.substring(6, 7));
			int h = Integer.parseInt(cpf.substring(7, 8));
			int i = Integer.parseInt(cpf.substring(8, 9));
			
			int j = ((a*10) + (b*9) + (c*8) + (d*7) + (e*6) + (f*5) + (g*4) + (h*3) + (i*2)) % 11;
			int validador1;
				if (j == 0 || j == 1) 
					{validador1 = 0;} 
					else 
					{validador1 = 11-j;}
			
			int validador2;
			int k = ((a*11) + (b*10) + (c*9) + (d*8) + (e*7) + (f*6) + (g*5) + (h*4) + (i*3) + (validador1*2)) % 11;
				if (k == 0 || k == 1) 
					{validador2 = 0;} 
					else 
					{validador2 = 11-k;}
			
			int verificador1 = Integer.parseInt(cpf.substring(9, 10));
			int verificador2 = Integer.parseInt(cpf.substring(10, 11));
			
				if (validador1 == verificador1 && validador2 == verificador2) {
					validade = true;
				}
		}
		
		return validade;
	}
	
}
