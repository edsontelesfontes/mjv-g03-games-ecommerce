# MJV Projeto Final - Source
API para prover recursos para nossa plataforma de Ecommerce de games

### Autor

- [José Edson Teles Fontes Junior](https://www.linkedin.com/in/edsontelesfontes/)

Repositório contendo o código fonte do projeto Ecommerce de Jogos

# Demonstração

Foi nos solicitados a construção de um ecommerce de jogos, a partir disso começamos a desenhar um sistema de jogos online
aos moldes da famosa plataforma e lider de mercado Steam.

O fluxo principal da plataforma ecommerce steam consiste em um sistema de market e biblioteca(onde os jogos adquiridos serão colocados),
abaixo um exemplo da plataforma.

<img src="https://steamcdn-a.akamaihd.net/steamcommunity/public/images/clans/27766192/ac26dea63042eec4886d5fa27854517ce374b11e.jpg">


A Arquitetura da nossa plataforma é constituida por:
#### Diagrama de classe

<img src ="https://imgur.com/cZV9idi.png">

**Pacotes:**

| Pacote     | Definição                                                                                                 |
|------------|-----------------------------------------------------------------------------------------------------------|
| enum       | Existência das classes para manter a integridade do negócio                                               |
| model      | Classes e entidades com base nas diretivas do negócio da aplicação                                        |
| repository | Intefarces para persistências de dados com base no Spring Data JPA                                        |
| service    | Classes contendo todas as regras de negócio da aplicação                                                  |
| controller | Recursos HTTPs para disponibilizar o acesso as funcionalidades da aplicação                               |
| Mapper     | Recursos para mapeamento de dtos e entidades para criar uma "blindagem" gerando consistência da nossa API |
| Utils      | Recursos para utilidades do sistema, como classes para consumos de api, formatações, etc...               |

**Módulos:**

| Módulo     | Definição                                                                                 |
|------------|-------------------------------------------------------------------------------------------|
| usuario    | Módulo contendo as classes necessárias para o registro de novos usuários                  |
| produtos   | Módulo para etapa de inclusão de novos jogos                                              |
| pedido     | Módulo que permite o gerenciamento do sistema de compras                                  |
| biblioteca | Módulo que permite o gerenciamento de confirmação de pagamentos e adição de jogos a conta |

##### Tecnologias

* Java
* JPA Hibernate
* MySQL
* Spring Boot
* Swagger
* Map Struct
* Postman
* Via CEP consumido via rest template.

Para a nossa demonstração estamos interagindo com nossa api diretamente atrvés do postman, mas também pode ser acessada através do swagger confome url:
```
http://localhost:8080/swagger-ui/index.html
```

##### Endpoints
* Usuário

<img src= "https://imgur.com/CeBbkcL.png">

* Pedido
<img src = "https://imgur.com/GrquuyO.png">
  
* Pedido item
<img src = "https://imgur.com/cY5GQud.png">

* Biblioteca 
<img src = "https://imgur.com/PCf66py.png">

### 1° Etapa - Cadastramento de usuarios.

1. Adicionando um usuario

```
POST:/usuario/
```
```
{
  "nome": "string",
  "senha": "string",
  "dataDeRegistro": "2022-11-03",
  "email": "string",
  "endereco": {
    "logradouro": "string",
    "cep": "string",
    "numero": 0,
    "localidade": "string",
    "bairro": "string",
    "complemento": "string",
    "uf": "string",
  },
  "cpf": "string"
}
```
O Endereço do usuário também pode ser adicionado somente passando o cep e o número da casa.
```
{
  "nome": "string",
  "senha": "string",
  "dataDeRegistro": "2022-11-03",
  "email": "string",
  "endereco": {
    "cep": "string",
    "numero": 0,
  },
  "cpf": "string"
}
```
2. Consultando a lista de usuários com ID do banco de dados.
```
GET:/usuarios/{id}
```
3. Deletando o usuário
```
DELETE:/usuario/{id}
```
```
Retorno void
```
## 2° Etapa - Cadastramento de Jogos.

1. Adicionando um jogo
```
POST:/jogos/
```
```
{
  "nome": "string",
  "descricao": "string",
  "preco": 0,
  "desenvolvedora": "string"
}
```
2. Procurando um jogo
```
GET:/jogos/
```
```
Retorna todos os jogos
```
Pesquisando um jogo através de um nome
```
GET:/jogos/filtro/like
```
```
?nome=xxxx
```
Atualizando o produto passando por exemplo o valor.
```
PATCH:/jogos/atualizar
```
```
PATCH: jogos/atualizar?id=1&preco=50.0
```

## 3° Etapa - Criando um pedido
1. Busncando um pedido

Retorna todos os pedidos
```
GET:localhost:8080/pedido/
```
2. Criando um pedido

Deverar passar o id do usuário via parametro
```
POST :/pedido/novopedido?idUsuario=1
```

3. Populando um pedido

Devera informar um id de pedido e id de produto para popular os itens
```
POST:/items/?pedidoId=X&produtoId=X
```

## 4° Etapa - Criando uma biblioteca


1. Atualizando uma biblioteca com um pedido de pagamento confirmado

Deverá receber um id de da biblioteca e id do pedido para adicionar o jogo a biblioteca
```
PATCH: /biblioteca/1?pedido=1
```

