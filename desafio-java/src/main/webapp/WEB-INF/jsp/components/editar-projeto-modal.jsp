<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="modal fade" id="modalEditarProjeto" tabindex="-1"  aria-labelledby="modalEditarProjetoLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalEditarProjetoLabel">Editar Projeto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editarProjetoForm">
                <input type="hidden" id="idProjeto" name="idProjeto"  />
                    <div class="form-group">
                        <label for="nome">Nome do Projeto</label>
                        <input type="text" class="form-control" id="nome" name="nome" required>
                    </div>
                    <div class="form-group">
                        <label for="dataInicio">Data de Início</label>
                        <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
                    </div>
                    <div class="form-group">
                        <label for="dataPrevisaoFim">Previsão de Término</label>
                        <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" required>
                    </div>
                    <div class="form-group">
                        <label for="orcamento">Orçamento Total (R$)</label>
                        <input type="number" class="form-control" id="orcamento" name="orcamento" step="0.01" required>
                    </div>

                    <div class="form-group">
                        <label for="idGerente">Gerente</label>
                        <select class="form-select" id="idGerente" required>
                            <option value="" disabled selected>Selecione um gerente</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="descricao">Descrição</label>
                        <textarea class="form-control" id="descricao" name="descricao" rows="3" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <select class="form-control" id="status" name="status" required>
                            <option value="" selected>Selecione o Status</option>
                                <option>Em Análise</option>
                                <option>Análise Realizada</option>
                                <option>Análise Aprovada</option>
                                <option>Iniciado</option>
                                <option>Planejado</option>
                                <option>Em Andamento</option>
                                <option>Encerrado</option>
                                <option>Cancelado</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="risco">Risco</label>
                        <select class="form-control" id="risco" name="risco" required>
                            <option value="" selected>Selecione o Risco</option>
                            <option>Baixo</option>
                            <option>Médio</option>
                            <option>Alto</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                <button type="button" class="btn btn-primary"  onclick="AlterarProjeto()">Salvar Alterações</button>
            </div>
        </div>
    </div>
</div>
