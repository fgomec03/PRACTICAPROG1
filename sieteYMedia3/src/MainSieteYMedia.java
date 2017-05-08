import java.util.Scanner;


public class MainSieteYMedia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean seguir=true;
		String jugada;
		float puntosJugador=0;
		float puntosBanca=0;
		int nuevaCartaJugador;
		int nuevaCartaBanca;
		int[] cartasJugador={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] cartasBanca={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int posicion=0;
		String nombreJugador="Lidia";
		mostrarCartas(puntosJugador,puntosBanca,nombreJugador, cartasJugador, cartasBanca);
		Scanner escaner=new Scanner(System.in);
		while(seguir){
			System.out.println("----------");
			System.out.println("Siguiente jugada: P (plantarse), O (otra carta), S (salir)");
			//jugada es donde se guarda el escaner
			jugada=escaner.next();
			if(jugada.equals("P")){
				while(puntosJugador>=puntosBanca && puntosJugador<7.5){
					nuevaCartaBanca=(int)(Math.random() * (10 - 1) + 1);
					cartasBanca[posicion]=nuevaCartaBanca;
					if(nuevaCartaBanca<8){
						puntosBanca+=nuevaCartaBanca;
					}
					else{
						puntosBanca+=0.5;
					}
					seguir=preguntarSiMayor(puntosJugador,puntosBanca,nombreJugador);
					mostrarCartas(puntosJugador,puntosBanca,nombreJugador, cartasJugador, cartasBanca);
				}
				mostrarCartas(puntosJugador,puntosBanca,nombreJugador,cartasJugador, cartasBanca);
				seguir=mostrarCartasFinal(puntosJugador,puntosBanca);
			}
			else if(jugada.equals("O")){
				nuevaCartaJugador=(int)(Math.random() * (10 - 1) + 1);
				cartasJugador[posicion]=nuevaCartaJugador;
				if(nuevaCartaJugador<8){
					puntosJugador+=nuevaCartaJugador;
				}
				else{
					puntosJugador+=0.5;
				}
				seguir=preguntarSiMayor(puntosJugador,puntosBanca, nombreJugador);
				if(puntosJugador<=7.5){
					nuevaCartaBanca=(int)(Math.random() * (10 - 1) + 1);
					cartasBanca[posicion]=nuevaCartaBanca;
					if(nuevaCartaBanca<8){
						puntosBanca+=nuevaCartaBanca;
					}
					else{
						puntosBanca+=0.5;
					}
					seguir=preguntarSiMayor(puntosJugador,puntosBanca,nombreJugador);
				}
				
				mostrarCartas(puntosJugador,puntosBanca,nombreJugador, cartasJugador, cartasBanca);
			}
			else if(jugada.equalsIgnoreCase("s")){
				seguir=false;
			}
			posicion++;
		}	
	}

	private static void mostrarCartas(float puntosJugador, float puntosBanca, String nombreJugador, int[] cartasJugador, int[] cartasBanca) {
		System.out.println("Cartas de "+nombreJugador+":");
		if(cartasJugador[0]==0){
			System.out.println("(Ninguna)");
		}
		else{
			
		}
		System.out.println("Total = "+puntosJugador+" puntos");
		
		System.out.println("----------");
		System.out.println("Cartas de la banca:");
		if(cartasBanca[0]==0){
			System.out.println("(Ninguna)");
		}
		else{
			
		}
		System.out.println("Total = "+puntosBanca+" puntos");
		
	}

	private static boolean preguntarSiMayor(float puntosJugador, float puntosBanca, String nombreJugador) {
		if(puntosJugador >7.5 && puntosBanca >7.5){
			//mensaje de empate
			System.out.println("----------");
			System.out.println("Tablas");
			return false;
		}
		else if(puntosJugador >7.5){
			//mensaje perder
			System.out.println("----------");
			System.out.println("Gana la banca");
			return false;
		}
		else if(puntosBanca >7.5){
			//mensaje victoria
			System.out.println("----------");
			System.out.println("Gana Jugador");
			return false;
		}
		return true;
	}

	private static boolean mostrarCartasFinal(float puntosJugador, float puntosBanca) {
		if(puntosJugador == puntosBanca){
			//mensaje de empate
			System.out.println("----------");
			System.out.println("Tablas");
			return false;
		}
		else if(puntosBanca > puntosJugador){
			//mensaje perder
			System.out.println("----------");
			System.out.println("Gana la banca");
			return false;
		}
		else if(puntosJugador > puntosBanca){
			//mensaje victoria
			System.out.println("----------");
			System.out.println("Gana Jugador");
			return false;
		}
		return true;
	}

}

	


