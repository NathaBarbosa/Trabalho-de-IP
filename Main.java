
public class Main{
	
		
	public static void main(String[] args){
	
		MatrizOtimizada mat1;
		int det1,det2, ordem,contador, tamanho;
		long inicioBaseLine ,inicioOtimizado, fimBaseLine,fimOtimizado, resultadoBaseLine, resultadoOtimizado;
        int[] vetor = {3, 5, 7, 9, 11};
        tamanho = vetor.length;
        for(contador = 0; contador < tamanho; contador++){
        ordem = vetor[contador];

        
		mat1 = new MatrizOtimizada(ordem,ordem);
		mat1.inicializaRandomico(ordem * ordem);
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
        }
		
	}

}
