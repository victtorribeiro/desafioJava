# Desafio Programador Java
Teste para programador Fullstack 


Abaixo segue o que será necessário para a realização do teste, possibilitando que você deixe tudo preparado para o dia marcado:
<br/> <br/>
<b>Ferramentas</b>:
<li>JDK 8 ou posterior</li>
<li>IDE de sua preferencia</li> 
<li>Maven</li> 

<br/>
<b>Frameworks</b>:
<li>Spring Boot / Data </li> 
<li>Hibernate </li> 
<li>Interface web com Bootstrap </li> 
<li>Pode utilizar https://start.spring.io/ para agilizar o processo </li>
<li>JUnit 5</li>
<br/>
<b>Banco de Dados</b>:
<li>Postgres</li> 
<br/>
<b>Entrega</b>:
 <li>O teste deverá ser enviado em um e-mail contento o link para o repositório deste projeto em sua conta pessoal no GitHub.</li>
 
Outras informações serão enviadas no e-mail juntamente com o teste.

# Script do banco de dados:

* Este script criará as tabelas necessárias.

`-- -----------------------------------------------------`<br/>
`-- Table Pessoa`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE pessoa`<br/>
`( id bigserial NOT NULL,`<br/>
`nome character varying(100) NOT NULL,`<br/>
`datanascimento date,`<br/>
`cpf character varying(14),`<br/>
`funcionario boolean,`<br/>
`gerente boolean,`<br/>
`CONSTRAINT pk_pessoa PRIMARY KEY (id));`<br/>


`-- -----------------------------------------------------`<br/>
`-- Table Projeto`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE  projeto (`<br/>
`  id bigserial NOT NULL,`<br/>
`  nome VARCHAR(200) NOT NULL,`<br/>
`  data_inicio DATE ,`<br/>
`  data_previsao_fim DATE ,`<br/>
`  data_fim DATE ,`<br/>
`  descricao VARCHAR(5000) ,`<br/>
`  status VARCHAR(45) ,`<br/>
`  orcamento FLOAT ,`<br/>
`  risco VARCHAR(45) ,`<br/>
`  idgerente bigint NOT NULL,`<br/>
`  CONSTRAINT pk_projeto PRIMARY KEY (id),`<br/>
`  CONSTRAINT fk_gerente FOREIGN KEY (idgerente)`<br/>
`  REFERENCES pessoa (id) MATCH SIMPLE`<br/>
`  ON UPDATE NO ACTION ON DELETE NO ACTION) `<br/>


`-- -----------------------------------------------------`<br/>
`-- Table Membros`<br/>
`-- -----------------------------------------------------`<br/>

` CREATE TABLE IF NOT EXISTS public.membro` <br/>
` (` <br/>
`     id bigint NOT NULL DEFAULT nextval('membro_id_seq'::regclass),` <br/>
`     idpessoa bigint,` <br/>
`     idprojeto bigint,` <br/>
`     CONSTRAINT membro_pkey PRIMARY KEY (id),` <br/>
`     CONSTRAINT fk14e1iadjrpdifol42j76vovmj FOREIGN KEY (idprojeto)` <br/>
`         REFERENCES public.projeto (id) MATCH SIMPLE` <br/>
`         ON UPDATE NO ACTION` <br/>
`         ON DELETE NO ACTION,` <br/>
`     CONSTRAINT fk31n4uk4b1qo688ibg0j82wm4h FOREIGN KEY (idpessoa)` <br/>
`         REFERENCES public.pessoa (id) MATCH SIMPLE` <br/>
`         ON UPDATE NO ACTION` <br/>
`         ON DELETE NO ACTION` <br/>
` )` <br/>


https://raw.githubusercontent.com/acelant/testeBiblioteca/master/TesteProjetos.png
