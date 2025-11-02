/**
 ====================== JS para editar un postulante. ======================
 - se llenan los campos del postulante con el id especificado (GET a al API)
 - luego al guardarse se envía una petición a la API para guardarlo
 - y finalmente se redirige a la página de postulantes
 ============================================================================
*/


// Obtenemos el id del postulante desde los parámetros de la URL
const params = new URLSearchParams(location.search);
const idPostulante = params.get("id");

if(!idPostulante){
    alert("No se pasó el id del postulante");
    window.location.href = "../pages/postulante.html";
}


const nombre = document.getElementById("nombre");
const biografia = document.getElementById("biografia");

// Obtenemos el postulante desde la API
const url = `http://localhost:8080/postulantes/${idPostulante}`;
fetch(url)
.then(response =>{
    if(!response.ok) {
        alert("No se pudo obtener el postulante");
        window.location.href = "../pages/postulante.html";

        throw new Error("Error al consultar la API");  
    }

    return response.json();
})
.then(postulante => {
    nombre.value = postulante.nombre;
    biografia.value = postulante.biografia;
})
.catch(error => console.log("Error al obtener el postulante", error));


// Cambiar el background-color del input al modificar algún campo
[nombre, biografia].forEach(input => {
    input.addEventListener("change", item => 
        item.target.style.backgroundColor = "#aaf0c0ff");
});



// Eperamos a que se envíe el formulario
document.getElementById("form-postulante-edit").addEventListener("submit", async function(e){
    e.preventDefault(); // Evitamos que la página se recargue

    const postulante = {
        id: parseInt(idPostulante),
        nombre: nombre.value.trim(),
        biografia: biografia.value.trim()
    };
    
    // Hacemos el PUT en la API
    try{

        const url = `http://localhost:8080/postulantes/`;

        const response = await fetch(url, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(postulante)
        });

        if(!response.ok) throw new Error("No se pudo editar el postulante");
        
        alert("Postulante editado excitantemente!");
        window.location.href = "../pages/postulante.html";

    }catch(error){
        console.error("Error al editar el postulante", error);
        alert("Lo sentimos, no se pudo editar el postulante");
    }
});
