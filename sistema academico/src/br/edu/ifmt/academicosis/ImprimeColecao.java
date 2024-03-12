package br.edu.ifmt.academicosis;
import java.util.Iterator;

public class ImprimeColecao {
	Iterator colecao;

	public ImprimeColecao(IColecaoGenerica colecaoGenerica) {
		this.colecao = colecaoGenerica.getIterator();
	}
	
	public void imprimir () {
		int x=0;
		System.out.println("\n\n");
		while (colecao.hasNext()) {
			IPossuiNome objeto = (IPossuiNome) colecao.next();
			System.out.println((++x)+"-"+ objeto.getNome());
		}
		System.out.println("\n\n");
	}
}
