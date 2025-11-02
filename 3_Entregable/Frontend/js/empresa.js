const tableBody = document.getElementById("table-body");

document.getElementById("btn-add").addEventListener("click", () => window.location.href = "../pages/empresaAdd.html");

const url = "http://localhost:8080/empresas";

fetch(url)
.then(response =>{
    if(!response.ok) throw new Error("Error al consultar la API");
    return response.json();
})
.then(empresas =>{
    empresas.forEach(empresa => {

        const row = document.createElement("tr");
        
        const celdaId = document.createElement("td");
        celdaId.classList.add("td-id");
        celdaId.textContent = empresa.id;
        
        const celdaNombre = document.createElement("td");
        celdaNombre.textContent = empresa.nombre;
        
        const celdaBiografia = document.createElement("td");
        celdaBiografia.textContent = empresa.biografia;

        const celdaDireccion = document.createElement("td");
        celdaDireccion.textContent = empresa.direccion;

        const celdaAcciones = document.createElement("td");
        celdaAcciones.classList.add("td-acciones");

        const btnEditar = document.createElement("button");
        btnEditar.classList.add("btn-editar");
        const iconoEditar = document.createElement("i");
        iconoEditar.classList.add("fa", "fa-edit");
        btnEditar.appendChild(iconoEditar);
        btnEditar.addEventListener("click", () => editarEmpresa(empresa.id));

        const btnEliminar = document.createElement("button");
        btnEliminar.classList.add("btn-eliminar");
        const iconoEliminar = document.createElement("i");
        iconoEliminar.classList.add("fa", "fa-trash");
        btnEliminar.appendChild(iconoEliminar);
        btnEliminar.addEventListener("click", () => eliminarEmpresa(empresa.id));

        celdaAcciones.appendChild(btnEditar);
        celdaAcciones.appendChild(btnEliminar);
        

        row.appendChild(celdaId);
        row.appendChild(celdaNombre);
        row.appendChild(celdaBiografia);
        row.appendChild(celdaDireccion);
        row.appendChild(celdaAcciones);

        tableBody.appendChild(row);

    });
})
.catch(error => console.log("Hubo un error al ejecutar la función", error));


function editarEmpresa(id){
    window.location.href = `../pages/empresaEdit.html?id=${id}`;
}

function eliminarEmpresa(id){

    //Confirmación de eliminación
    if(!confirm("Estas seguro de que quieres eliminar la empresa?, Esta acción no se puede deshacer")){
        return;
    }

    fetch(`http://localhost:8080/empresas/${id}`, {
        method: "DELETE"
    }).then(response => {
        if(!response.ok) throw new Error("Error al consultar la API");
    
        alert("Empresa eliminada con exito");
        window.location.href = "/pages/empresa.html";
    }).catch(error => {
        console.error(error);
        alert("Lo sentimos no se pudo eliminar la empresa :c");
    });
}