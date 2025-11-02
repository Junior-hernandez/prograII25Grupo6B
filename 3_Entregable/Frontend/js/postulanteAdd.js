document.getElementById("form-postulante").addEventListener("submit", async function(e){
    e.preventDefault(); // evitar recargar la pagina

    // obtener los valores del formulario
    const nombre = document.getElementById("nombre").value.trim();
    
    const biografia = document.getElementById("biografia").value.trim();
    
    const postulante = {
        nombre: nombre,
        biografia: biografia
    };

    // consulta fetch
        
    const url = "http://localhost:8080/postulantes"
    try{
        const response = await fetch(url, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(postulante)
        });

        if(!response.ok) throw new Error("Error al consultar la API");

        alert("Postulante creado exitosamente!");
        window.location.href = "../pages/postulante.html";
        
    }catch(error){
        console.log("Hubo un error.", error);
        alert("Chales, no se pudo guardar el postulante que querías :c")
    }
});