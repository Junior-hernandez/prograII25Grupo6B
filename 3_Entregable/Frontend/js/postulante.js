const tableBody = document.getElementById("table-body");
document.getElementById("btn-add").addEventListener("click", () => { window.location.href = "postulanteAdd.html" });

const url = "http://localhost:8080/postulantes"; // Esta URL será reemplazada el el endpoint de la API real

fetch(url)
.then(response => {
    if(!response.ok) throw new Error("Error al obtener los datos desde la API");
    return response.json();
})
.then(lista => {
    lista.postulantes.forEach(postulante =>{
        const row = document.createElement("tr");
        
        // creamos las celdas de la fila
        const celdaId = document.createElement("td");
        celdaId.classList.add("td-id");
        celdaId.textContent = postulante.id;

        const celdaNombre = document.createElement("td");
        celdaNombre.textContent = postulante.nombre;

        const celdaBiografia = document.createElement("td");
        celdaBiografia.textContent = postulante.biografia;

        const celdaAcciones = document.createElement("td");
        celdaAcciones.classList.add("td-acciones")
        
        // creamos botones de la celda
        const btnEditar = document.createElement("button");
        btnEditar.classList.add("btn-editar");
        const iconoEditar = document.createElement("i");
        iconoEditar.classList.add("fa", "fa-edit")
        btnEditar.appendChild(iconoEditar);
        btnEditar.addEventListener("click", () => editarPostulante(postulante.id));
        
        const btnEliminar = document.createElement("button");
        btnEliminar.classList.add("btn-eliminar");
        const iconoEliminar = document.createElement("i");
        iconoEliminar.classList.add("fa", "fa-trash");
        btnEliminar.appendChild(iconoEliminar);
        btnEliminar.addEventListener("click", () => eliminarPostulante(postulante.id));
        

        // añadir iconos en botones
        celdaAcciones.appendChild(btnEditar);
        celdaAcciones.appendChild(btnEliminar);

        // añadimos las celdas a la fila (row)
        row.appendChild(celdaId);
        row.appendChild(celdaNombre);
        row.appendChild(celdaBiografia);
        row.appendChild(celdaAcciones);

        // añadimos la fila al cuerpo de la tabla
        tableBody.appendChild(row);

        // y somos felices
    });
})
.catch(error => console.error("Hubo un problema", error)); // sino somos infelices


// Funciones
function editarPostulante(id){
    window.location.href = `../pages/postulanteEdit.html?id=${id}`;
}

function eliminarPostulante(id){
    if(!confirm(`Se eliminaría el postulante con el ID: ${id}, ¿deseas continuar?`)){
        return;
    }

    fetch(`http://localhost:8080/postulantes/${id}`, {
        method: "DELETE"
    })
    .then(response => {
        if(!response.ok) throw new Error("Error al consultar la API");

        alert("Se eliminó el postulante exitosamente");
        window.location.href = "../pages/postulante.html";
    })
    .catch(error => console.error(error));
}