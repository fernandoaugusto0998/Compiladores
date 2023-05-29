import java.util.ArrayList;
import java.util.List;

public class AnalisadorSemantico {

	public List<String> tabelaSimbolos;
	
	public AnalisadorSemantico() {
		tabelaSimbolos = new ArrayList<String>();
		}
	
	public void Analisar(String linha, List<String> dicionario) {
		linha = linha.replace(";","");
		String[] token = linha.split(" ");
		
		if (token[0].equals("entier")) {
			if (token[1].matches("a-zA-Z][a-zA-Z0-9]*")) {
			// adicionar na tabela de simbolos
			if (estaNaTabelaSimbolos(token[1])) {
				System.out.println("Variavel ja declarada:"+token[1]);
				return;
				}
			tabelaSimbolos.add(token[1]);
						
		}  else {
           // System.out.println("Nome inválido para a variável: " + token[1]);
			}
		} else if (token[0].equals("texte")) {
			if (token[1].startsWith("'") && token[1].endsWith("'")) {
				return;
			}
		}
		
		if (!estaNaTabelaSimbolos(token[1])) {
			//System.out.println("Variável não declarada: " + token[1]);
			
		} else {
			for (String token1 : token) {
				if(ehVariavel(token1, dicionario)) {
					if(!estaNaTabelaSimbolos(token1)) {
						System.out.println("Variável não declarada: " + token1);
					}
				}
			}
		}
		
		
		// percorre todas as palavras da linha
		for(int i=0;i<token.length;i++) {
			// verificar se � uma vari�vel
			if (ehVariavel(token[i].toString(), dicionario)) {
				if (estaNaTabelaSimbolos(token[i].toString())) {
					return;
				} else {
					System.out.println("Variavel nao declarada:"+token[i]);
				}
			}
		}
	}
	
	public Boolean ehVariavel(String palavra, List<String> dicionario) {
		
		if(palavra.matches("[a-z][a-z0-9]{0,9}")) {
			 for (String s : dicionario) {
	                if (s.equals(palavra)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	public Boolean estaNaTabelaSimbolos(String palavra) {
		
		for(int i=0;i<tabelaSimbolos.size();i++) {
			if (tabelaSimbolos.get(i).toString().equals(palavra)){
				return true;
			}
		}
		return false;
	}
}
