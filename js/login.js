$(document).ready(function() {

});

async function iniciarSesion(){
    let datos={};
    datos.documento= document.getElementById('txtDocumento').value;
    datos.contraseña= document.getElementById('txtContraseña').value;


  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if(respuesta == 'OK'){

      window.location.href='pacientes.html'

  }else{
      alert("las credenciales son incorrectas. intente nuevamente.");
  }


}
