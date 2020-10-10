/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", function() {
  document.getElementById("formulario").addEventListener('submit', validate); 
});

function validate(evento){
    evento.preventDefault();
    var name = document.getElementById("usuario").value;
    let result = 0;
    name.split('').forEach(letter => {
        result += 1;
    });
    if(result < 5){
        alert("El nombre es demasiado pequeño.");
        return;
    }
    result = 0;
    let passwordlenght = document.getElementById("contra").value.length;
    while(passwordlenght > 0){
        result += 1;
        passwordlenght -= 1;
    }
    if(result < 8){
        alert("La contraseña es muy corta. Al menos deben de ser caracteres.");
    }
}

