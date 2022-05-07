// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarPaciente();
  $('#pacientes').DataTable();
});


async function cargarPaciente(){
  const request = await fetch('api/paciente/pacientes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const pacientes = await request.json();

  let listadoHtml ='';
  for(let Paciente of pacientes){
    let botonEliminar = '<a href="#" onclick="eliminarPaciente('+Paciente.id+')" class="btn btn-danger btn-circle btn-sn"><i class="fas fa-trash"></i></a>';
    let pacienteHtml  =  '<tr><td>'+Paciente.id+'</td><td>'+ Paciente.tipoDocumentoId +'</td><td>'+ Paciente.numeroDocumento
                        +'</td><td>'+Paciente.firstName+'</td><td>'+Paciente.secondName
                        +'</td><td>'+Paciente.firstLastName +'</td><td>'+Paciente.secondLastName+'</td><td>'+botonEliminar+'</td></tr>';
    listadoHtml += pacienteHtml;
  }

document.querySelector('#pacientes tbody').outerHTML=listadoHtml;


}



async function eliminarPaciente(id){
    if(!confirm('¿ Desea Eliminar El Paciente Del Sistema ?')){
        return;
    }

  const request = await fetch('api/paciente/Delete/'+ id ,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload()
}

