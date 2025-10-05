package programaciondos.reclutadora.Presentation.Menus.Common;

import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import programaciondos.reclutadora.Application.DTOs.UsuariosDTOs.UsuarioLoginRequestDTO;
import programaciondos.reclutadora.Presentation.Controllers.AuthController;

public class MenuPrincipal {
	private static final Scanner input = new Scanner(System.in); 
	private final AuthController _auth;
	
	public MenuPrincipal(EntityManagerFactory emf){
		_auth = new AuthController(emf);
	}
	
	public void mostrarMenu(){
			
		do{
			try{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				
				System.out.println("\nB I E N V E N I D O");

				System.out.println(" 1. Registrarse \n 2. Iniciar sesion \n 3. Salir");

				System.out.print("\nElije una opcion: ");
				var option = Integer.parseInt(input.next());

				switch(option){
					case 1 -> registrar();
					case 2 -> {
						logIn();
						return;
					}
					case 3 -> {return;}
					default -> {
						System.out.println("Ingresa una opcion entre 1 y 3");
						input.next();
					}
				}
				
			}catch(NumberFormatException ex){
				System.out.println("Debe ingresar un numero entero");
			}
			catch(Exception ex){
				System.out.println("Algo salio mal");
				input.next();
			}
		}while(true);
	}
	
	public void registrar(){
		do{
			try{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("\nR E G I S T R A R S E");
				System.out.println("Que tipo de perfil quieres? \n 1. Postulante  |  2. Empresa");
				System.out.println("3. Salir");
				var option = Integer.parseInt(input.next());
				switch(option){
					case 1 -> {
						registrarPostulante();
						return;
					}
					case 2 ->{
						registrarEmpresa();
						return;
					}
					case 3 ->{return;}
					default->{
						System.out.println("Ingresa una opcion entre 1 y 3");
						input.next();
					}
				}
				
			}catch(NumberFormatException ex){
				System.out.println("Debe ingresar un numero entero");
				input.next();
			}catch(Exception ex){
				System.out.println("Algo salió mal intenta de nuevo");
				input.next();
			}
			
		}while(true);
	}
	
	
	public void registrarEmpresa(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("PU PI PU PI.-..--..... \nListo! ya estas registrado como empresa :D");
			input.next();
			
		}catch(Exception ex){
			
		}
	}
	
	public void registrarPostulante(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("PU PI PU PI.-..--..... \nListo! ya estas registrado como postulante :D");
			input.next();
			
		}catch(Exception ex){
			
		}
	}
	
	
	public void logIn(){
		do{
			try{
				input.nextLine();
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				
				System.out.println("I N I C I O   D E   S E S I O N");

				System.out.println("Ingresa tu correo: ");
				var email = input.nextLine();

				System.out.println("Ingresa tu contrasenia: "); 
				var contrasenia = input.nextLine();

				System.out.println("Iniciando sesion...");

				var usuarioLogin = new UsuarioLoginRequestDTO(email, contrasenia);
				
				_auth.iniciarSesion(usuarioLogin);
								
				
			}catch(Exception ex){
				System.out.println("Algo salio mal :c  vuelve a intentar");
				input.next();
			}
		}while(true);
		
	}
}
