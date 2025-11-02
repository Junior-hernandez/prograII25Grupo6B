const formEmpresa = document.getElementById("form-empresa");
formEmpresa.addEventListener("submit", async function(e){
    e.preventDefault(); // Evitamos que la página se recargue

    // Obtenemos los campos y creamos la emrpesa
    const name = document.getElementById("nombre").value.trim();
    const biography = document.getElementById("biografia").value.trim();
    const address = document.getElementById("direccion").value.trim();

    const empresa = {
        nombre: name,
        biografia: biography,
        direccion: address
    };

    // Hacemos la petición a la API
    
    const url =  "http://localhost:8080/empresas";

    try{
        const response = await fetch(url, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(empresa)
        });

        if(!response.ok) throw new Error("Hubo un error al consultar la API");

        alert("Empresa agregada excitantemente!");
        window.location.href = "../pages/empresa.html";
    }catch(error){
        console.log("Hubo un error al consultar la API", error);
        alert("Lo sentimos, no se pudo agregar la empresa :c");
    }

});