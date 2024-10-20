<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Projetos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
    <%@ include file="components/navbar.jsp" %>

    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-dark text-white">
                <h4 class="mb-0">Cadastro de Projeto</h4>
            </div>
            <div class="card-body">

                <form >
                    <div class="mb-3">
                        <label for="nome" class="form-label">Nome do Projeto</label>
                        <input type="text" class="form-control" id="nome" required>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="dataInicio" class="form-label">Data de Início</label>
                            <input type="date" class="form-control" id="dataInicio" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="dataPrevisaoFim" class="form-label">Previsão de Término</label>
                            <input type="date" class="form-control" id="dataPrevisaoFim" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="dataFim" class="form-label">Data Final</label>
                            <input type="date" class="form-control" id="dataFim">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="listaGerentes" class="form-label">Gerente</label>
                            <select class="form-select" id="idGerente" required>
                                <option value="" disabled selected>Selecione um gerente</option>
                             </select>
                        </div>
                    </div>


                    <div class="mb-3">
                        <label for="orcamentoTotal" class="form-label">Orçamento Total (R$)</label>
                        <div class="input-group">
                            <span class="input-group-text">R$</span>
                            <input type="number" step="0.01" class="form-control" id="orcamento" required>
                        </div>
                    </div>



                    <div class="mb-3">
                        <label for="descricao" class="form-label">Descrição</label>
                        <textarea class="form-control" id="descricao" rows="3" required></textarea>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="status" class="form-label">Status</label>
                            <select class="form-select" id="status" required>
                                <option value="" selected>Selecione uma Opção</option>
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
                        <div class="col-md-6 mb-3">
                            <label for="risco" class="form-label">Risco</label>
                            <select class="form-select" id="risco" required>
                                <option value="" selected>Selecione uma Opção</option>
                                <option>Baixo</option>
                                <option>Médio</option>
                                <option>Alto</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success" onclick="Cadastro()" >Cadastrar</button>
                </form>
            </div>
        </div>
    </div>
    <script src="/static/js/projeto.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
