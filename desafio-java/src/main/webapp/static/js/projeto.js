window.onload = buscarGerenteList;

function Cadastro() {
    const urlCadastrarProjeto = `http://127.0.0.1:8080/projeto/cadastrarProjeto/`;
    const projeto = getProjeto();

    try {
        fetch(urlCadastrarProjeto, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(projeto)
        });
        alert('Projeto cadastrado com sucesso!')
        if (response.ok) {
            location.reload();
        } else {
            const errorData = response.json();
            console.log(errorData);
        }
    } catch (error) {
        console.error(error);
    }
}

function getProjeto() {
    return {
        nome: document.getElementById('nome').value,
        dataInicio: document.getElementById('dataInicio').value,
        dataPrevisaoFim: document.getElementById('dataPrevisaoFim').value,
        dataFim: document.getElementById('dataFim').value,
        descricao: document.getElementById('descricao').value,
        status: document.getElementById('status').value,
        orcamento: document.getElementById('orcamento').value,
        risco: document.getElementById('risco').value,
        idGerente: document.getElementById('idGerente').value
    };
}

function buscarGerenteList(){
    const urlBuscarGerenteList = `http://127.0.0.1:8080/pessoa/listGerente`
    try {
        fetch(urlBuscarGerenteList)
            .then(response => response.json())
            .then(gerentes => {
            listarGerentes(gerentes)
        })
    } catch (error){
        console.error(error);
    }
}

function listarGerentes(gerentes){
    const listaGerentes = document.getElementById('idGerente');
    listaGerentes.innerHtml = '';
    gerentes.forEach(gerente => {
        const listaItem = document.createElement('option');
        listaItem.value = gerente.id;
        listaItem.textContent = `${gerente.nome}`;
        listaGerentes.appendChild(listaItem);
    });
}