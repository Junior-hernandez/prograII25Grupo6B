/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Presentation.Postulante;

/**
 *
 * @author biron
 */

import java.util.Scanner;
import programaciondos.reclutadora.Application.Services.PostulantesService;
import programaciondos.reclutadora.Application.Services.UsuariosService;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;


public class MenuPostulante {

    private final PostulantesService postulantesService;
    private final UsuariosService usuariosService;
    private final Scanner scanner;

    private Usuarios usuarioLogueado;
    private Postulantes perfilPostulante;

   
    public MenuPostulante(PostulantesService postulantesService, UsuariosService usuariosService, Usuarios usuarioLogueado) {
        this.postulantesService = postulantesService;
        this.usuariosService = usuariosService;
        this.usuarioLogueado = usuarioLogueado;
        
//		this.perfilPostulante = this.postulantesService.GetById(usuarioLogueado.getId());
        
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;
        while (opcion != 5) {
            System.out.println("\n--- MENÚ POSTULANTE ---");
            System.out.println("Bienvenido, " + usuarioLogueado.getNombre());
            System.out.println("1. Ver Ofertas");
            System.out.println("2. Mis Postulaciones");
            System.out.println("3. Editar Perfil");
            System.out.println("4. Mi Cuenta");
            System.out.println("5. Cerrar Sesión / Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        verOfertas();
                        break;
                    case 2:
                        verMisPostulaciones();
                        break;
                    case 3:
                        editarPerfil();
                        break;
                    case 4:
                        verMiCuenta();
                        break;
                    case 5:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                opcion = -1; 
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
        }
    }
    
    private void verOfertas() {
        System.out.println("\n--- OFERTAS DISPONIBLES ---");
        System.out.println("Funcionalidad aún no implementada.");
    }

    private void verMisPostulaciones() {
        System.out.println("\n--- MIS POSTULACIONES ---");
        System.out.println("Funcionalidad aún no implementada.");
    }

    private void editarPerfil() {
        System.out.println("\n--- EDITAR PERFIL ---");
        
        System.out.println("Nombre actual: " + usuarioLogueado.getNombre());
        System.out.print("Nuevo nombre (deje en blanco para no cambiar): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.trim().isEmpty()) {
            usuarioLogueado.setNombre(nuevoNombre);
        }

        System.out.println("Biografía actual: " + perfilPostulante.getBiografia());
        System.out.print("Nueva biografía (deje en blanco para no cambiar): ");
        String nuevaBiografia = scanner.nextLine();
        if (!nuevaBiografia.trim().isEmpty()) {
            perfilPostulante.setBiografia(nuevaBiografia);
        }

        try {
            usuariosService.Edit(usuarioLogueado);
            postulantesService.Edit(perfilPostulante);
            System.out.println("Perfil actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el perfil: " + e.getMessage());
            // Sería buena idea recargar los datos del usuario desde la BD para deshacer cambios locales.
        }
    }
    
    private void verMiCuenta() {
        System.out.println("\n--- DATOS DE MI CUENTA ---");
        System.out.println("Correo Electrónico: " + usuarioLogueado.getEmail());
        System.out.println("Contraseña: ********");
        
        System.out.print("¿Desea cambiar su contraseña? (si/no): ");
        String cambiar = scanner.nextLine();
        if (cambiar.equalsIgnoreCase("si")) {
            System.out.print("Ingrese nueva contraseña: ");
            String nuevaContrasena = scanner.nextLine();
            
            if(nuevaContrasena.trim().isEmpty()){
                System.out.println("La contraseña no puede estar vacía.");
                return;
            }
            
            usuarioLogueado.setContrasenia(nuevaContrasena);
            try {
                usuariosService.Edit(usuarioLogueado);
                System.out.println("Contraseña actualizada correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cambiar la contraseña: " + e.getMessage());
            }
        }
    }
}
