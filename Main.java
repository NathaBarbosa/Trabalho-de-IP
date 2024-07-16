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
        
        System.out.println(det1);
		System.out.println(det2);
		System.out.println(resultadoBaseLine);
        System.out.println(resultadoOtimizado);
	}

}
