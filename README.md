# 🛒 Procurement Service — mini-fusion

Sistema de gestão de compras corporativas desenvolvido com **Spring Boot**, **JWT Authentication** e **PostgreSQL**.

---

## 🚀 Tecnologias

- **Java 21** + **Spring Boot 3**
- **Spring Security** + **JWT**
- **Spring Data JPA** + **Hibernate**
- **PostgreSQL**
- **Maven**

---

## 📦 Funcionalidades

- ✅ Cadastro e gestão de **Fornecedores (Suppliers)**
- ✅ Criação de **Requisições de Compra (Purchase Requests)**
- ✅ Fluxo de **Aprovação (Approval)**
- ✅ Geração de **Ordens de Compra (Purchase Orders)**
- ✅ **Autenticação JWT** com controle de acesso
- ✅ **DTOs** para transferência segura de dados
- 🔲 Exception Handler + Validações globais
- 🔲 Frontend React
- 🔲 Deploy (Railway + Vercel)

---

## 🗂️ Estrutura do Projeto

```
procurement-service/
├── src/
│   └── main/
│       └── java/
│           └── com/minifusion/procurement/
│               ├── controller/
│               ├── service/
│               ├── repository/
│               ├── model/
│               ├── dto/
│               └── security/
├── pom.xml
└── README.md
```

---

## ⚙️ Como rodar localmente

### Pré-requisitos

- Java 21+
- Maven
- PostgreSQL rodando localmente

### Passos

```bash
# Clone o repositório
git clone https://github.com/DiogoBarbosa07/procurement-service.git
cd procurement-service

# Configure o banco de dados em src/main/resources/application.properties
# spring.datasource.url=jdbc:postgresql://localhost:5432/procurement
# spring.datasource.username=seu_usuario
# spring.datasource.password=sua_senha

# Rode o projeto
mvn clean spring-boot:run
```

A API estará disponível em `http://localhost:8080`

---

## 🔐 Autenticação

A API utiliza **JWT Bearer Token**. Para acessar os endpoints protegidos:

1. Faça login e obtenha o token
2. Inclua no header de cada requisição:

```
Authorization: Bearer <seu_token>
```

---

## 📌 Endpoints principais

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/suppliers` | Lista todos os fornecedores |
| POST | `/suppliers` | Cadastra novo fornecedor |
| GET | `/purchase-requests` | Lista requisições de compra |
| POST | `/purchase-requests` | Cria nova requisição |
| POST | `/approvals` | Aprova/rejeita uma requisição |
| GET | `/purchase-orders` | Lista ordens de compra |

---

## 🛣️ Roadmap

- [x] Supplier CRUD
- [x] Purchase Request
- [x] Approval Flow
- [x] Purchase Order
- [x] JWT Authentication
- [x] DTOs
- [ ] Exception Handler + Validações
- [ ] Frontend React
- [ ] Deploy (Railway + Vercel)

---

## 👨‍💻 Autor

**Diogo Barbosa** — [GitHub](https://github.com/DiogoBarbosa07)

---

> Projeto em desenvolvimento 🚧
