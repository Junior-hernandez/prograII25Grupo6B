package programaciondos.reclutadora;


import javax.persistence.Persistence;
import programaciondos.reclutadora.Presentation.Menus.Common.MenuPrincipal;

public class Reclutadora {

	
    public static void main(String[] args) {
		System.out.println("Hasta aqui todo bien");
		var  _emf = Persistence.createEntityManagerFactory("ProgramacionDos_Reclutadora_jar_1.0-SNAPSHOTPU");
		var menuPrincipal = new MenuPrincipal(_emf);
		
		menuPrincipal.mostrarMenu();
    }
}
