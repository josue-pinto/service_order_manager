# Service Order Manager - Backend

API REST para gerenciamento de ordens de servico tecnico, construida com Spring Boot e PostgreSQL.

## Tecnologias

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Data JPA** - persistencia de dados
- **Spring Security** - seguranca da API
- **Spring Validation** - validacao de dados
- **PostgreSQL** (Neon) - banco de dados na nuvem
- **Maven** - gerenciamento de dependencias
- **Docker** - containerizacao

## Arquitetura

```
src/main/java/com/example/service_order_manager/
├── config/
│   └── SecurityConfig.java        # Configuracao do Spring Security
├── controller/
│   └── OrdemServicoController.java # Endpoints REST
├── model/
│   └── OrdemServico.java           # Entidade JPA
├── repository/
│   └── OrdemServicoRepository.java # Repositorio JPA
└── ServiceOrderManagerApplication.java
```

## Endpoints da API

| Metodo | Endpoint   | Descricao                        |
|--------|------------|----------------------------------|
| GET    | `/api/os`  | Lista todas as ordens de servico |
| POST   | `/api/os`  | Cria uma nova ordem de servico   |

### Exemplo de Request (POST /api/os)

```json
{
  "cliente": "Joao Silva",
  "equipamento": "Notebook Dell Inspiron",
  "descricao": "Tela piscando ao abrir programas"
}
```

### Exemplo de Response

```json
{
  "id": 1,
  "cliente": "Joao Silva",
  "equipamento": "Notebook Dell Inspiron",
  "descricao": "Tela piscando ao abrir programas",
  "status": "ABERTA",
  "dataEntrada": "2026-02-17",
  "dataSaida": null
}
```

## Configuracao Local

### Pre-requisitos

- Java 21+
- PostgreSQL (local ou Neon)

### Variaveis de Ambiente

| Variavel            | Descricao                      | Padrao    |
|---------------------|--------------------------------|-----------|
| `DATABASE_URL`      | URL JDBC do PostgreSQL         | localhost |
| `DATABASE_USERNAME` | Usuario do banco               | postgres  |
| `DATABASE_PASSWORD` | Senha do banco                 | postgres  |
| `PORT`              | Porta do servidor              | 8080      |

### Executar localmente

```bash
./mvnw spring-boot:run
```

### Build

```bash
./mvnw clean package -DskipTests
java -jar target/*.jar
```

## Deploy

- **Hosting:** [Render](https://render.com)
- **Banco de dados:** [Neon](https://neon.tech) (PostgreSQL serverless)
- **URL de producao:** https://service-order-manager.onrender.com

## Frontend

O frontend Vue 3 esta em um repositorio separado:
[atendimento-frontend](https://github.com/josue-pinto/atendimento-frontend)

## Licenca

Este projeto e de uso academico/pessoal.
