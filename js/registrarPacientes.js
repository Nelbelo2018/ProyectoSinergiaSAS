$(document).ready(function() {


});


async function registrarPaciente(){
    let datos={};
    datos.tipoDocumentoId= document.getElementById('txtTipoDocumento').value;
    datos.numeroDocumento= document.getElementById('txtNumeroDocumento').value;
    datos.firstName= document.getElementById('txtPrimerNombre').value;
    datos.secondName= document.getElementById('txtSegundoNombre').value;
    datos.firstLastName= document.getElementById('txtPrimerApellido').value;
    datos.secondLastName= document.getElementById('txtSegundoApellido').value;

  const request = await fetch('api/paciente/New', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      body: JSON.stringify(datos)
  });


  window.location.href='registrarPacientes.html'

}