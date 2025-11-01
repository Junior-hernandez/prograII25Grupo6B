
package gt.edu.umg.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author biron
 */

@Entity
@Table(name = "Postulantes")
public class Postulante implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="IdPostulante")
	private  int id;

    @Column(name = "Nombre", nullable = false, columnDefinition = "nvarchar(50)")
    private String nombre;

    @Column(name = "Biografia", nullable = false, columnDefinition = "nvarchar(250)")
    private String biografia;
    
   
    public Postulante() {
    }

    public Postulante(String nombre, String biografia) {
        this.nombre = nombre;
        this.biografia = biografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
