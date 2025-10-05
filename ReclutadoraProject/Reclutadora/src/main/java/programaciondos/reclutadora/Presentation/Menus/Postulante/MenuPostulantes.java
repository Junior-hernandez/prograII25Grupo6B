package programaciondos.reclutadora.Presentation.Menus.Postulante;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import programaciondos.reclutadora.Application.Services.OfertasService;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Ofertas;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;

/**
 *
 * @author Junior Hernandez
 */
public class MenuPostulantes {
	private final EntityManager _em;
	private final Usuarios _usuario;
	private final Postulantes _postulante;
	private static final Scanner input = new Scanner(System.in);
	
	public MenuPostulantes(Usuarios usuario, EntityManagerFactory _emf){
		_usuario = usuario;
		_postulante = usuario.getUsuarioPostulanteList().get(0).getIdPostulante();
		_em = _emf.createEntityManager();
	}
	
	public void Principal(){
	
		var opcion = 0;
		do{
			try{
				System.out.println("Bienvenido " + _postulante.getNombre());

				System.out.println("1. Ver Ofertas");
				System.out.println("2. Mis Postulaciones");
				System.out.println("3. Editar Perfil");
				System.out.println("4. Mi Cuenta");
				System.out.println("5. Cerrar Sesión / Salir");
				System.out.print("Seleccione una opción: ");

				opcion = Integer.parseInt(input.next());
				switch(opcion) {
					case 1 -> verOfertas();
					case 2 -> misPostulaciones();
					case 3 -> editarPerfil();
					case 4 -> verMiCuenta();
					case 5 -> System.out.println("Cerrando sesión...");
					default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
				}
			}catch(NumberFormatException ex){
				System.out.println("Ingrese un numero entero");
			}catch(Exception ex){
				System.out.println("Algo salio mal");
			}
		}while(opcion != 5);
	}
	
	public void verOfertas(){
		var opcion = 0;
		do{
			try{
				System.out.println("O F E R T A S ");
				
				var ofertas = OfertasService.GetfertasList(_em);
				for(Ofertas oferta : ofertas){
					System.out.println("------------------------------------------");
					System.out.println("Titulo: " + oferta.getTitulo());
					System.out.println("Salario: " + oferta.getSalario());
					System.out.println("Descripcion: " + oferta.getDescripcion() + "\n");
				}
						
				System.out.println("1. postularse");
				System.out.println("2 Salir");

				opcion = Integer.parseInt(input.next());
				switch(opcion) {
					case 1 -> System.out.println("Postulandose xd");
					case 2 -> System.out.println("saliendo...");
					default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
				}
			}catch(NumberFormatException ex){
				System.out.println("Ingrese un numero entero");
			}catch(Exception ex){
				System.out.println(ex.getMessage() + ex.getStackTrace());
				System.out.println("Algo salio mal");
				opcion = 0;
			}
		}while(opcion != 2);
	}
	
	public void misPostulaciones(){
		
	}

	private void editarPerfil() {
		System.out.println("1. Editar Nombre: " + _postulante.getNombre());
		System.out.println("2. Editar biografia: " + _postulante.getBiografia());
	}

	private void verMiCuenta() {
		throw new UnsupportedOperationException("Not supported yet."); 
	}
	
}
