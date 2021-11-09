const botonCalcular = document.getElementById("botonCalcular");

botonCalcular.addEventListener('click',calcular);

function calcular(){
const precioTotal = document.getElementById("precioTotal");
const cuotas = document.getElementById("cuotas");
const interes = document.getElementById("interes");


const precioTotalInt = parseInt(precioTotal.value);
const cuotasInt = parseInt(cuotas.value);
const interesFloat = parseFloat(interes.value);


const interesMensual = (interesFloat/100) / 12;
const total = precioTotalInt / (( (1 - (1 + interesMensual) ** -cuotasInt)) / interesMensual);

const totalFixed = parseFloat(total).toFixed(2);
const resultado = document.getElementById("resultado");
resultado.innerHTML = totalFixed + "€";
}

