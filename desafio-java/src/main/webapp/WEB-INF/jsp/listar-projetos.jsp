<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt_br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Desafio Java</title>


        <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
              rel="stylesheet">

    </head>
    <body>
        <%@ include file="components/navbar.jsp" %>

        <div class="container mt-4">

            <div class="row mb-3">
                <div class="col-md-4 offset-md-8">
                    <input type="text" id="searchInput" class="form-control" placeholder="Pesquisar projeto pelo nome..." onkeyup="filtroNomeProjeto()">
                </div>
            </div>

            <div class="card shadow-sm">
                <div class="card-header bg-dark text-white">
                    <h4 class="mb-0">Lista de Projetos</h4>
                </div>

                <div class="card-body">
                    <table class="table table-hover table-bordered">
                        <thead class="thead-dark">
                            <tr class="text-center">
                                <th class="d-none" >ID</th>
                                <th>Nome do Projeto</th>
                                <th>Data de Início</th>
                                <th>Gerente Responsável</th>
                                <th>Previsão de Término</th>
                                <th>Data Real de Término</th>
                                <th>Orçamento Total</th>
                                <th>Descrição</th>
                                <th>Status</th>
                                <th>Risco</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="projeto" items="${projetoList}">
                                <tr class="text-center align-middle">
                                    <input id="idItem" type="hidden" name="nomeDoCampo" value="${projeto.id}">
                                    <td class="d-none">${projeto.id}</td>
                                    <td class="text-left">${projeto.nome}</td>
                                    <td>${projeto.dataInicio}</td>
                                    <td data-value="${projeto.gerente.id}">${projeto.gerente.nome}</td>
                                    <td>${projeto.dataPrevisaoFim}</td>
                                    <td>${projeto.dataFim}</td>
                                    <td>R$ ${projeto.orcamento}</td>
                                    <td class="text-left">${projeto.descricao}</td>
                                    <td data-status="${projeto.status}">${projeto.status.value}</td>
                                    <td data-risco="${projeto.risco}">${projeto.risco.value}</td>
                                    <td>
                                        <button type="button" data-id="${projeto.id}" id="idItem" onclick="CarregarDadosParaEdicao(this);"
                                            class="btn btn-sm btn-primary mb-2" data-toggle="modal" data-target="#modalEditarProjeto">
                                            <i class="bi bi-pencil"></i> Editar
                                        </button>
                                        <button type="button"  id="delete" class="btn btn-sm btn-danger"
                                            onclick="DeletarProjeto(${projeto.id})">
                                            <i class="bi bi-trash"></i> Excluir
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Modal Editar Projeto -->
            <jsp:include page="components/editar-projeto-modal.jsp" />


    </body>
    <script>
    function teste() {
        console.log("teste");
    }
    </script>

    <script src="/static/js/filtro.js"></script>
    <script src="/static/js/projeto.js"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>
