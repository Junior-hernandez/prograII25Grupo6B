const tableBody = document.getElementById("table-body");

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
        const celdaNombre = document.createElement("td");
        const celdaBiografia = document.createElement("td");
        
        // llenamos las celdas con los datos del postulante de la iteración
        celdaId.textContent = postulante.idPostulante;
        celdaNombre.textContent = postulante.nombre;
        celdaBiografia.textContent = postulante.biografia;

        // añadimos las celdas a la fila (row)
        row.appendChild(celdaId);
        row.appendChild(celdaNombre);
        row.appendChild(celdaBiografia);

        // añadimos la fila al cuerpo de la tabla
        tableBody.appendChild(row);

        // y somos felices
    });
})
.catch(error => console.error("Hubo un problema", error)); // sino somos infelices
