public class Main{
		
	public static void main(String[] args){
		MatrizOtimizada mat1;
		int det1,det2, ordem;
		long inicioBaseLine ,inicioOtimizado, fimBaseLine,fimOtimizado, resultadoBaseLine, resultadoOtimizado;


        ordem = 11;

		mat1 = new MatrizOtimizada(ordem,ordem);
		mat1.inicializaRandomico(ordem);
		mat1.imprime();
        inicioBaseLine = System.currentTimeMillis();
        det1= mat1.determinanteBaseline();
        fimBaseLine= System.currentTimeMillis();
		resultadoBaseLine = fimBaseLine - inicioBaseLine;
        inicioOtimizado  = System.currentTimeMillis();
        det2 = mat1.determinanteOtimizado();
        fimOtimizado= System.currentTimeMillis();
		resultadoOtimizado = fimOtimizado - inicioOtimizado;
        
        System.out.println("resultado do determinante do ProgramaBase: " + det1);
		System.out.println("resultado do determinante do Programa otimizado: " + det2);
		System.out.println("tempo de execucao do programa base em milisegundos: " + resultadoBaseLine);
        System.out.println("tempo de execucao do programa otimizado em millisegundos: " + resultadoOtimizado);
	}

}