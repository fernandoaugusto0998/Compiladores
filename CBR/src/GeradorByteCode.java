import java.util.Scanner;

@SuppressWarnings("unused")
public class GeradorByteCode {

	public GeradorByteCode() {
		// TODO Auto-generated constructor stub
	}
	
	public String gerar(String linha) {
		String[] token = linha.split(" ");
		
		  if (token[0].equals("entier")){
			  return "int " + token[1]; 
			  } 
		  if (token[0].equals("analyse")) {
			  return "analyse " + token[1]; 
			  }
		  if (token[1].equals("=")) { 
			  return linha; 
		  } 
		  if (token[0].equals("pour")) {
			 return "for (" + token[1] + " " + token[2] + " " + token[3] + " " + token[4] + " " + token[5] + " " + token[6] + "){";
		  }
		  
		  if (token[0].equals("si")) {
			 return "if ( " + token[1] + " " + token[2] + " " + token[3] + " " + token[4] + " ){ ";
		  }
		  
		  if (token[0].equals("imprimer")) {
			 return "System.out.println( " +  token[1] + " " + token[2] + " " + token[3] + " )";
			  
		  }
		 
		  if (token[0].equals("finsi")) {
			  return " " + token[1];
			  
		  }
		  
		  if (token[0].equals("terminus")) {
			  return token[1];
		  }

		  if (token[0].equals("si")) {
				 return "if ( " + token[1] + " " + token[2] + " " + token[3] + " " + token[4] + " ){ ";
		  }
		  
		  if (token[0].equals("imprimer2")) {
				 return token[1];
		  }
		  
		  if (token[0].equals("finsi")) {
			  return  token[1];
		  } 
		  
		  if (token[0].equals("terminus")) {
			  return token[1];
		  }	
		  
		return "";
		
	}

}
