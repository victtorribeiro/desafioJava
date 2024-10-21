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

function AlterarProjeto() {
    // Cria o objeto com os dados do projeto
    const idProjeto = document.getElementById('idProjeto').value;
    const projetoData = {
        nome: document.getElementById('nome').value,
        dataInicio: document.getElementById('dataInicio').value,
        dataPrevisaoFim: document.getElementById('dataPrevisaoFim').value,
        orcamento: document.getElementById('orcamento').value,
        idGerente: document.getElementById('idGerente').value,
        descricao: document.getElementById('descricao').value,
        status: document.getElementById('status').value,
        risco: document.getElementById('risco').value
    }

// Envia uma requisição AJAX para atualizar o projeto
    fetch(`http://127.0.0.1:8080/projeto/atualizarProjeto/${idProjeto}`, {
        method: 'PUT', // Método HTTP PUT para atualizar
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(projetoData)
    })
        .then(response => {
        if (response.ok) {
            alert('Projeto atualizado com sucesso!');
            location.reload(); // Recarrega a página após a atualização
        } else {
            return response.json().then(error => {
                throw new Error(error.message || 'Erro ao atualizar projeto');
            });
        }
    })
        .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao atualizar o projeto: ' + error.message);
    });

}

function DeletarProjeto(idProjeto) {
    fetch(`http://127.0.0.1:8080/projeto/deletarProjeto/${idProjeto}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
        if (response.ok) {
            alert("Projeto  excluído com sucesso!");

            location.reload();
        } else {
            alert("Erro ao excluir projeto! Verifique se não está com Status: Iniciado, Em andamento ou Encerrado.")
        }
    })
        .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao deletar o projeto: ' + error.message);
    });

}
