$(document).ready(function() {


});


async function registrarUsuario(){
    let datos={};
    datos.name= document.getElementById('txtNombre').value;
    datos.lastName= document.getElementById('txtApellido').value;
    datos.documento= document.getElementById('txtDocumento').value;
    datos.contraseña= document.getElementById('txtContraseña').value;

    let repetirContraseña = document.getElementById('txtrepetirContraseña').value;

    if(repetirContraseña != datos.contraseña){
        alert ('¡La Contraseña Es Diferente!');
        return;
    }

  const request = await fetch('api/usuario/New', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      body: JSON.stringify(datos)
  });


  window.location.href='login.html'
}
