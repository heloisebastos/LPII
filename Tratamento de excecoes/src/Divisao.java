
public class Divisao {
	public static void main(String[] args) {
		int a =Teclado.lerInteiro("valor 1:");
		int b =Teclado.lerInteiro("valor 2:");
		try{
			System.out.println("result:"+a/b);
			
		}catch (ArithmeticException divisao) {
				System.out.println("valor invalido digite novamente");
				
			}finally{
				main(null);
			}
	
	}


}
