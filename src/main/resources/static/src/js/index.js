const botao = document.querySelector(".btn-parqueParceiro");
const elementoPlataformas = document.querySelector(".btn-parqueParceiro .parques");

botao.addEventListener("click", () => {
    elementoPlataformas.classList.toggle("ativo");
});


