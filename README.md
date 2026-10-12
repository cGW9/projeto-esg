# Projeto - Cidades ESGinteligentes

![Status do Pipeline](https://github.com/cGW9/projeto-esg/actions/workflows/ci-cd.yml/badge.svg)

---

## Como executar localmente com Docker

1. Certifique-se de ter o **Docker Desktop** instalado e em execução na máquina.
2. Copie o ficheiro de variáveis de ambiente de exemplo:
   ```bash
   cp .env.example .env

1. Suba a aplicação e a base de dados com o Docker Compose:
    
    docker compose up -d --build

2. Aceda à aplicação no navegador através do endereço: http://localhost:8080.

## Pipeline CI/CD
O pipeline de Integração e Entrega Contínua foi implementado utilizando o GitHub Actions (.github/workflows/ci-cd.yml).

### Ferramenta: GitHub Actions

### Etapas do Pipeline:

Build e Testes: Executado a cada push ou pull request. Configura o ambiente Java 17 (Eclipse Temurin), compila o projeto com Maven (mvn clean compile) e executa a suíte de testes automatizados (mvn test).

Deploy Staging: Disparado automaticamente quando há alterações integradas na ramificação staging.

Deploy Produção: Disparado automaticamente quando alterações são integradas na ramificação principal main.

## Containerização
### Dockerfile (Multi-Stage Build):

Estágio de Build: Utiliza a imagem maven:3.9.6-eclipse-temurin-17 para compilar o código e gerar o artefato .jar.

Estágio de Execução: Utiliza a imagem leve eclipse-temurin:17-jre-alpine para rodar a aplicação.

Segurança: O container é executado sob um usuário sem privilégios de root (spring).

### Orquestração (docker-compose.yml):

Gerencia os containers da API (esg_app) na porta 8080 e da base de dados PostgreSQL (esg_db) na porta 5432.

Inclui verificação de saúde (healthcheck com pg_isready) no PostgreSQL, garantia de persistência de dados com volume (postgres_data) e rede isolada (esg_network).

Prints do funcionamento
1. Containers em execução no Docker Desktop
<img width="769" height="376" alt="image" src="https://github.com/user-attachments/assets/d0515675-07ad-447a-afc6-57b300c38ede" />


2. Resposta da Aplicação (Localhost 8080)
<img width="475" height="181" alt="image" src="https://github.com/user-attachments/assets/f4e4dff9-12c5-41bc-828e-a44d6ac54e8b" />


3. Pipeline CI/CD (GitHub Actions)
<img width="928" height="389" alt="image" src="https://github.com/user-attachments/assets/a6d984b3-a1ba-4d6d-8a2d-17c9c5284c5d" />


## Tecnologias utilizadas
Linguagem / Framework: Java 17 / Spring Boot 3.2.3

Gerenciador de Dependências: Maven

Banco de Dados: PostgreSQL 15

Containerização: Docker e Docker Compose

CI/CD: GitHub Actions

Controle de Versão: Git / GitHub
