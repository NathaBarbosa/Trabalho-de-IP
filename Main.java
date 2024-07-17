
import java.util.Scanner; 
public class Main{
	
		
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		MatrizOtimizada mat1;
		int det1,det2, ordem;
		long inicioBaseLine ,inicioOtimizado, fimBaseLine,fimOtimizado, resultadoBaseLine, resultadoOtimizado;

		System.out.println("Informe a ordem que a matriz possuira: [3, 5, 7, 9 ou 11] ");
        ordem = ler.nextInt();
		if(ordem == 3 || ordem== 5 || ordem == 7 || ordem == 9 || ordem == 11 ){
			mat1 = new MatrizOtimizada(ordem,ordem);
		mat1.inicializaRandomico(ordem);
		mat1.imprime();
        inicioBaseLine = System.nanoTime();
        det1 = mat1.determinanteBaseline();
        fimBaseLine= System.nanoTime();
		resultadoBaseLine = fimBaseLine - inicioBaseLine;
        inicioOtimizado  = System.nanoTime();
        det2 = mat1.determinanteOtimizado();
        fimOtimizado= System.nanoTime();
		resultadoOtimizado = fimOtimizado - inicioOtimizado;
        
        System.out.println("resultado do determinante do ProgramaBase: " + det1);
		System.out.println("resultado do determinante do Programa otimizado: " + det2);
		System.out.println("tempo de execucao do programa base em nanosegundos: " + resultadoBaseLine);
        System.out.println("tempo de execucao do programa otimizado em nanosegundos: " + resultadoOtimizado);
		
			
		}else {
			System.out.println("por favor, informe um valor valido");
		}
	}

}