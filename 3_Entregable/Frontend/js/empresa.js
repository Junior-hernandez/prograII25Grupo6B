const tableBody = document.getElementById("table-body");

document.getElementById("btn-add").addEventListener("click", () => window.location.href = "../pages/empresaAdd.html");

const url = "../src/mockData/empresas.json";

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
        celdaId.textContent = empresa.idEmpresa;
        
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
        btnEditar.addEventListener("click", () => editarEmpresa(empresa.idEmpresa));

        const btnEliminar = document.createElement("button");
        btnEliminar.classList.add("btn-eliminar");
        const iconoEliminar = document.createElement("i");
        iconoEliminar.classList.add("fa", "fa-trash");
        btnEliminar.appendChild(iconoEliminar);

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