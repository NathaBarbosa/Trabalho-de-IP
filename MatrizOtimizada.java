import java.util.Random;

class Matriz{
	private int[][] mat;
	private int tamLinha;
	private int tamColuna;

	Matriz(){
		mat = new int[6][6];
		this.setTamanhoLinha(6);	
		this.setTamanhoColuna(6);
	}

	Matriz(int numLinhas, int numColunas){
		mat = new int[numLinhas][numColunas];
		this.setTamanhoLinha(numLinhas);	
		this.setTamanhoColuna(numColunas);
	}


	public int getValor(int indiceI,int indiceJ){
		return mat[indiceI][indiceJ];
	}	
	
	public void setValor(int indiceI,int indiceJ, int novoValor){
		mat[indiceI][indiceJ] = novoValor;
	}

	public int getTamanhoLinha(){
		return tamLinha;
	}	
	
	public int getTamanhoColuna(){
		return tamColuna;
	}	

	private void setTamanhoLinha(int novoValor){
		tamLinha = novoValor;
	}

	private void setTamanhoColuna(int novoValor){
		tamColuna = novoValor;
	}

	public void imprime(){
		int conti,contj;	
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			System.out.println();
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				System.out.print(this.getValor(conti,contj) + " ");
			}
		}
		System.out.println();	
	}

	public void inicializaRandomico(int max_rand){
		int conti,contj, novoValor;
		Random gerador = new Random();
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				novoValor = gerador.nextInt(max_rand);
				this.setValor(conti,contj,novoValor);
			}
		}
	}

	// caso matriz nao quadrada, retorna -1
	public int retorneOrdem(){
		int numL, numC, ordem;

		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		ordem = -1;
		if(numL == numC){
			ordem = numL;
		}

		return ordem;
	}	

	private int detOrdem1(Matriz mat){
		return mat.getValor(0,0);
	}
	
	private int detOrdem2(Matriz mat){
		int diagonalP, diagonalI;

		diagonalP = mat.getValor(0,0) * mat.getValor(1,1);		
		diagonalI = mat.getValor(1,0) * mat.getValor(0,1);		

		return (diagonalP - diagonalI);
	}

	private int calculaSinal(int indiceL, int indiceC){
		int sinal;

		sinal = -1;

		if( ((indiceL + indiceC)% 2) == 0 ){
			sinal = 1;
		}

		return sinal;		
	}

	public void copiaMatrizMaiorParaMenor(Matriz maior,Matriz menor,int isqn,int jsqn){
		int contAi,contAj,contBi,contBj,temp,numL,numC;
		numL = menor.getTamanhoLinha();
		numC = menor.getTamanhoColuna();

		contAi = 0;
		for(contBi = 0; contBi < numL; contBi++){
			if(contAi == isqn){
				contAi++;
			}
			contAj = 0;
			for(contBj = 0; contBj < numC; contBj++){
				if(contAj == jsqn){
					contAj++;
				}
				temp = maior.getValor(contAi,contAj);
				menor.setValor(contBi,contBj,temp);
				contAj++;
			}
			contAi++;
		}
	}
	//metodo para verficar qual linha possue mais zeros:
	public int verificaLinha(){
		int zerosLinha = 0;
		int zerosAtuais = 0;
		for(int contadorLinha = 0; contadorLinha < this.getTamanhoLinha(); contadorLinha++){
			int quantidadeDeZeros = 0;
				for(int contadorColuna = 0; contadorColuna < this.getTamanhoColuna(); contadorColuna++){
					if(this.getValor(contadorLinha , contadorColuna) == 0){
						quantidadeDeZeros++;
					}
				if(quantidadeDeZeros >= zerosAtuais){
					zerosAtuais = quantidadeDeZeros;
					zerosLinha = contadorLinha;
				}
			}
		}
		return zerosLinha;
	}
	public int verificaColuna(){
		int zerosColuna = 0;
		int numeroMZeros = 0;
		for(int contadorColuna = 0; contadorColuna < this.getTamanhoColuna(); contadorColuna++){
			int numeroDeZeros = 0;
			for(int contadorLinha = 0; contadorLinha < this.getTamanhoLinha(); contadorLinha++){
				if(this.getValor(contadorColuna, contadorLinha) == 0){
					numeroDeZeros++;
				}
				if(numerosDeZeros > numeroMZeros){
					numeroMZeros = numeroDeZeros;
					zerosColuna = contadorColuna;
				}
			}
		}
		return zerosColuna;
	}
	public boolean UsaLinha(int zerosLinha, int zeroColuna){
		boolean ehLinha = true;
		if(zerosLinha >= zerosColuna){
			ehLinha = true;
		}else {
			ehLinha = false;
		}
		return ehLinha;
	}

	private int detOrdemN(Matriz mat, int parametro, boolean ehLinha){
		int sinal,cofator,detTemp,resposta,contC,numL,numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		resposta = 0;
			if(ehLinha){
				for(contC = 0; contC < parametro; contC++){
					cofator = mat.getValor(0,contC);
					sinal = this.calculaSinal(0,contC);
					matmenor = new Matriz(numL-1,numC-1);
					this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
					detTemp = matmenor.determinante();
					resposta = resposta + (cofator * sinal * detTemp);
				}
				return (resposta);
			}else {
				for(contC = 0; contC < parametro; contC++){
					cofator = mat.getValor(0,contC);
					sinal = this.calculaSinal(0,contC);
					matmenor = new Matriz(numL-1,numC-1);
					this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
					detTemp = matmenor.determinante();
					resposta = resposta + (cofator * sinal * detTemp);
				}
				return (resposta);

			}
		
	}
	public int determinante(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemN(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

}
