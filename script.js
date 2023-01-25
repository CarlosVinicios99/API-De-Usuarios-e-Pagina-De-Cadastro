const formulario = document.querySelector("form")

const nome = document.querySelector(".nome")
const email = document.querySelector(".email")
const senha = document.querySelector(".senha")
const telefone = document.querySelector(".telefone")

function cadastrar(usuario){
    fetch("http://localhost:8080/cadastrar", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(usuario)
    })
    .then(function(res){
        console.log(res)
    })
    .catch(function(res){
        console.log(res)
    })
}

function limparFormulario(){
    nome = ""
    email = ""
    senha = ""
    telefone = ""
}

formulario.addEventListener("submit", function(event) {
    event.preventDefault()
    const usuario = {
        nome,
        email,
        senha,
        telefone
    }
    cadastrar(usuario)
    limparFormulario()
    
})