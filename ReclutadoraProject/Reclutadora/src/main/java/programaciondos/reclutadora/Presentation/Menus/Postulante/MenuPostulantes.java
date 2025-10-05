package programaciondos.reclutadora.Presentation.Menus.Postulante;

import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;

/**
 *
 * @author Junior Hernandez
 */
public class MenuPostulantes {
	private final Usuarios _usuario;
	private final Postulantes _postulante;
	
	public MenuPostulantes(Usuarios usuario){
		_usuario = usuario;
		_postulante = usuario.getUsuarioPostulanteList().get(0).getIdPostulante();
	}
	
	public void Principal(){
		System.out.println("Si ves esto\n"
				+ "significa que estas en el menu principal\n"
				+ "de postulantes y estas logeado correctamente");
	}
	
}
