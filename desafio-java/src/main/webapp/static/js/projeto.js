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

function CarregarDadosParaEdicao(button) {
    const row = button.closest('tr');

    const id = row.cells[0].textContent; // ID, d-none
    const nome = row.cells[1].textContent; // Nome do Projeto
    const dataInicio = row.cells[2].textContent; // Data de Início
    const gerente = row.cells[3].getAttribute('data-value');; // Gerente Responsável
    const previsaoFim = row.cells[4].textContent; // Previsão de Término
    const dataFim = row.cells[5].textContent; // Data Real de Término
    const orcamento = row.cells[6].textContent.replace('R$ ', '').replace(',', '.'); // Orçamento Total
    const descricao = row.cells[7].textContent; // Descrição
    const status = row.cells[8].textContent; // Status
    const risco = row.cells[9].textContent; // Risco

    // Preenche os campos do modal
    document.getElementById('nome').value = nome;
    document.getElementById('dataInicio').value = dataInicio;
    document.getElementById('dataPrevisaoFim').value = previsaoFim;
    document.getElementById('orcamento').value = orcamento;
    document.getElementById('descricao').value = descricao;

    // Preenche os selects do modal
    document.getElementById('idGerente').value = gerente;
    document.getElementById('status').value = status;
    document.getElementById('risco').value = risco;

    document.getElementById('idProjeto').value = id;

}
