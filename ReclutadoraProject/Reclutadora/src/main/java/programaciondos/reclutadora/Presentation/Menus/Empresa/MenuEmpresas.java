/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Presentation.Menus.Empresa;

import java.util.Scanner;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Empresas;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Ofertas;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;

/**
 *
 * @author Deyvid Hernandez
 */
public class MenuEmpresas {
	private final Usuarios _usuario;
	private final Empresas _empresa;
	
	private static final Scanner input = new Scanner(System.in);
	
	public MenuEmpresas(Usuarios usuario){
		_usuario = usuario;
		_empresa = usuario.getUsuarioEmpresaList().get(0).getIdEmpresa();
	}
	
	public void Principal(){
		var opcion = 0;
		do{
			try{
				System.out.println("Bienvenido " + _empresa.getNombre());

				System.out.println("1. Ver mis Ofertas");
				System.out.println("2. Ver Postulaciones");
				System.out.println("3. Editar Perfil");
				System.out.println("4. Mi Cuenta");
				System.out.println("5. Cerrar Sesión / Salir");
				System.out.print("Seleccione una opción: ");

				opcion = Integer.parseInt(input.next());
				switch(opcion) {
					case 1 -> misOfertas();
					case 2 -> Postulaciones();
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
	
	public void misOfertas(){
		var opcion = 0;
		do{
			try{
				System.out.println("Ofertas " + _empresa.getNombre());

				System.out.println("1. Ver mis Ofertas");
				System.out.println("2. crear una nueva");
				System.out.println("3. Editar una existente");
				System.out.println("4. Eliminar una existente");

				opcion = Integer.parseInt(input.next());
				switch(opcion) {
					case 1 -> {
						System.out.println("O F E R T A S ");
						
						var ofertas = _empresa.getOfertasList();
						for(Ofertas oferta : ofertas){
						System.out.println("------------------------------------------");
						System.out.println("Titulo: " + oferta.getTitulo());
						System.out.println("Salario: " + oferta.getSalario());
						System.out.println("Descripcion: " + oferta.getDescripcion() + "\n");
				}
					}
					
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
	
	public void Postulaciones(){
		var ofertas = _empresa.getOfertasList();
		for(var oferta : ofertas){
			var postulaciones = oferta.getPostulacionesList();
			for(var postulacion : postulaciones){
				System.out.println("La persona: " + postulacion.getIdPostulante().getNombre()
				+"\nSe postulo a la oferta " + postulacion.getIdOferta().getDescripcion());
			}
		}
	}

	private void editarPerfil() {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	private void verMiCuenta() {
		throw new UnsupportedOperationException("Not supported yet."); 
	}
}
