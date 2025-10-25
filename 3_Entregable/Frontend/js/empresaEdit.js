/**
 * =================== JS para editar empresas. =====================
 * - Se cargan los datos actuales de la empresa desde la API (GET)
 * - al editarse y guardar se mandan a la API (PUT) para guardar
 * - y finalmente se redirecciona a la pagina anterior
 * ==================================================================
*/


const params = new URLSearchParams(location.search);
const id = params.get("id");

if(!id){
    alert("No se envió el ID de la empresa");
    window.location.href = "../pages/empresa.html";
}

const nombre = document.getElementById("nombre");
const biografia = document.getElementById("biografia");
const direccion = document.getElementById("direccion");

// Consultamos la empresa por su ID

const url = "../src/mockData/empresa.json"; // `http://localhost:8080/empresa/${id}`;

fetch(url)
.then(response => {
    if(!response.ok) throw new Error("Error al consultar la API");
    return response.json();
})
.then(empresa => {

    // Cargamos los datos de la empresa    
    nombre.value = empresa.nombre;
    biografia.value = empresa.biografia;
    direccion.value = empresa.direccion;
})
.catch(error => console.error("No se pudieron cargar los datos", error));

// Cambiamos el background-color del input cuando un dato cambia
[nombre, biografia, direccion].forEach(input => {
    input.addEventListener("change", item => 
        item.target.style.backgroundColor = "#aaf0c0ff");
});

// Al hacer submit se envían los datos hacia la API (PUT)

document.getElementById("form-empresa-edit").addEventListener("submit", async function(e){
    e.preventDefault();

    const empresa = {
        idEmpresa: parseInt(id),
        nombre: nombre.value.trim(),
        biografia: biografia.value.trim(),
        direccion: direccion.value.trim()
    };

    try{

        const url = "API's URL"; // `http://localhost:8080/empresa/${id}`;

        const response = await fetch(url, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(empresa)
        });

        if(!response.ok){
            alert("Lo sentimos, no se pudo editar la empresa");
            throw new Error("Error consultar la API (PUT)");
        }

        alert("Empresa editada exitosamente!");
        window.location.href = "../pages/empresa.html";

    }catch(error){
        console.error("Error al editar la empresa", error);
    }
    
});