<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <label for="dataFim">Data Final</label>
                        <input type="date" class="form-control" id="dataFim" name="dataFim" required>
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
                                <label for="statusList" class="form-label">Status</label>
                                <form:select class="form-select" path="statusList" id="statusList" required="required">
                                    <form:option value="" label="Selecione uma opção"/>
                                    <form:options items="${statusList}" itemValue="name" itemLabel="value"/>
                                </form:select>
                    </div>
                    <div class="form-group">
                                <label for="riscoList" class="form-label">Risco</label>
                                <form:select class="form-select" path="riscoList" id="riscoList" required="required">
                                    <form:option value="" label="Selecione uma opção"/>
                                    <form:options items="${riscoList}" itemValue="name" itemLabel="value"/>
                                </form:select>
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
