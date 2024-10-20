function filtroTodosOsCampos() {
    const input = document.getElementById('searchInput');
    const filter = input.value.toLowerCase();
    const table = document.querySelector('.table');
    const rows = table.getElementsByTagName("tr");

    for (let i = 1; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName("td");
        let match = false;

        for (let j = 1; j < cells.length; j++) {
            if (cells[j].textContent.toLowerCase().includes(filter)) {
                match = true;
                break;
            }
        }

        rows[i].style.display = match ? "" : "none";
    }
}

function filtroNomeProjeto() {
    const input = document.getElementById('searchInput');
    const filter = input.value.toLowerCase();
    const table = document.querySelector('.table'); // Seleciona a tabela
    const rows = table.getElementsByTagName("tr"); // Obtém todas as linhas da tabela

    for (let i = 1; i < rows.length; i++) { // Começa em 1 para ignorar o cabeçalho
        const nomeCell = rows[i].getElementsByTagName("td")[1]; // Acessa a segunda coluna (index 1) que contém o nome do projeto
        if (nomeCell) {
            const textValue = nomeCell.textContent.toLowerCase();
            rows[i].style.display = textValue.includes(filter) ? "" : "none"; // Exibe a linha se houver correspondência ou esconde
        }
    }
}