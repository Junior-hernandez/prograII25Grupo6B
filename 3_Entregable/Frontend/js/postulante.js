const tableBody = document.getElementById("table-body");
document.getElementById("btn-add").addEventListener("click", () => { window.location.href = "postulanteAdd.html" });

const url = "../src/mockData/postulantes.json"; // Esta URL será reemplazada el el endpoint de la API real

fetch(url)
.then(response => {
    if(!response.ok) throw new Error("Error al obtener los datos desde la API");
    return response.json();
})
.then(postulantes => {
    postulantes.forEach(postulante =>{
        const row = document.createElement("tr");
        
        // creamos las celdas de la fila
        const celdaId = document.createElement("td");
        celdaId.classList.add("td-id");
        celdaId.textContent = postulante.idPostulante;

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
        btnEditar.addEventListener("click", () => editarPostulante(postulante.idPostulante));
        
        const btnEliminar = document.createElement("button");
        btnEliminar.classList.add("btn-eliminar");
        const iconoEliminar = document.createElement("i");
        iconoEliminar.classList.add("fa", "fa-trash");
        btnEliminar.appendChild(iconoEliminar);
        btnEliminar.addEventListener("click", () => eliminarPostulante(postulante.idPostulante));
        

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
    alert(`Aqui se editaría el postulante con id: ${id}`);
}

function eliminarPostulante(id){
    alert(`Aquí se eliminaría el postulante con el id: ${id}`);
}