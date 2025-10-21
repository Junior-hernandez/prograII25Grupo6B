const tableBody = document.getElementById("table-body");

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
        const celdaNombre = document.createElement("td");
        const celdaBiografia = document.createElement("td");
        const celdaDireccion = document.createElement("td");

        celdaId.textContent = empresa.idEmpresa;
        celdaNombre.textContent = empresa.nombre;
        celdaBiografia.textContent = empresa.biografia;
        celdaDireccion.textContent = empresa.direccion;

        row.appendChild(celdaId);
        row.appendChild(celdaNombre);
        row.appendChild(celdaBiografia);
        row.appendChild(celdaDireccion);

        tableBody.appendChild(row);

    });
})
.catch(error => console.log("Hubo un error al ejecutar la función", error));