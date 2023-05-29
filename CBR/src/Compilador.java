import java.io.IOException;
import java.util.List;

public class Compilador {

	public List<String> alfabeto;
	public List<String> exemplo;
	public List<String> expressoes;
	public List<String> dicionario;
	
	public Compilador() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void Iniciar() throws IOException {
		String linha;
		System.out.println("Iniciando o compilador...");
		
		LerArquivo leitor = new LerArquivo();
		alfabeto = leitor.ler("C:\\Users\\Informatica\\eclipse-workspace\\CBR\\alfabeto.txt");
		exemplo = leitor.ler("C:\\Users\\Informatica\\eclipse-workspace\\CBR\\exemplo.txt");
		expressoes = leitor.ler("C:\\Users\\Informatica\\eclipse-workspace\\CBR\\expressoes.txt");
		dicionario = leitor.ler("C:\\Users\\Informatica\\eclipse-workspace\\CBR\\dicionario.txt");
		for( int i =0; i < alfabeto.size();i++) {
			System.out.println(alfabeto.get(i));
		}
		System.out.println("--------------");
		
		AnalisadorLexico lexico = new AnalisadorLexico();
		for( int i =0; i < exemplo.size();i++) {
			linha = exemplo.get(i);
			lexico.analisar(linha, alfabeto);
		}
		System.out.println("\nAnalise lexica bem sucedida!\n");
		
		System.out.println("--------------");
		
		System.out.println("\nAnalisando sintaticamente:\n");
		AnalisadorSintatico sintatico = new AnalisadorSintatico();
		for( int i =0; i < exemplo.size();i++) 
		{
			linha = exemplo.get(i);
			sintatico.analisar(linha, expressoes);
		}
		System.out.println("\nFim da analise sintatica!\n");
		System.out.println("Analise sintatica realizada com Sucesso!\n");
		System.out.println("--------------");
		System.out.println("Analisando semanticamente:");
		AnalisadorSemantico semantico = new AnalisadorSemantico();		
		for( int i =0; i < exemplo.size();i++) 
		{
			linha = exemplo.get(i);
			semantico.Analisar(linha, expressoes);
		}
		System.out.println("\nFim da analise semantica!");
		
		System.out.println("\nAnalise semantica realizada com Sucesso!\n");
		System.out.println("--------------");
		
		GeradorByteCode gerador = new GeradorByteCode();
        System.out.println("Gerando bytecode das linhas do arquivo de exemplo:");
        String exemploJava = "public class Main {\n  public static void main(String[] args) {\n";
        for (int i = 0; i < exemplo.size(); i++) {
            linha = exemplo.get(i);
            String bytecode = gerador.gerar(linha);
            System.out.println("Bytecode gerado: " + bytecode);
            exemploJava = exemploJava + "    " + bytecode + "\n";
        }
        System.out.println("\nBytecodes gerados com Sucesso!");
	}
}

