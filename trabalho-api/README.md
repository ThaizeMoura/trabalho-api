# Projeto JTI (Interação Tecnológica a Java) - Backend (trabalho-api)

## Descrição

A finalidade deste Sistema de Gerenciamento de Reservas é transformar a maneira como as reservas são
administradas, oferecendo uma solução digital e abrangente que centraliza todas as operações em um
único ambiente. O sistema é projetado para ser uma ferramenta indispensável para funcionários quando
para clientes finais, permitindo que ambos realizem, atualizem e acompanhem reservas de maneira
eficiente, minimizando erros e maximizando a produtividade.

## Tecnologias Utilizadas

- Java version "17.0.1" 2021-10-19 LTS
- Spring Boot
- JPA
- lombok

## Pré-requisitos

- JDK version 17
- Maven version 3.9.9

## Instalação

1. **Clone o repositório:**

   ```bash
   git clone https://link-do-repo.git
   ```

2. **Navegue até o diretório do projeto:**

   ```bash
   cd diretorio-do-projeto
   ```

3. **Configure o banco de dados:**

   Edite o arquivo [application.yaml](src/main/resources/application.yaml) com as configurações do seu banco de dados.

4. **Compile e execute o projeto:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   A API estará disponível em `http://localhost:8080`.

## Documentação da API (Swagger)

A documentação da API pode ser acessada por meio do Swagger. Após iniciar o backend, você pode acessar a documentação por meio da seguinte URL:

[/swagger-ui/index.html](http://localhost:8080//swagger-ui/index.html)

## Endpoints

Abaixo está a descrição dos principais endpoints da API:


### **1. GET /api/hospedes**

- **Descrição:** Retorna uma lista de hospedes.
- **Parâmetros de Consulta:**
    - `page` (opcional): Número da página.
    - `size` (opcional): Número de itens por página.
- **Resposta:**
    - **200 OK**
      ```json
      [
        {
          "id": 1,
          "name": "Maria",
          "email": "maria@exemplo.com",
          "quarto": "101",
          "dataEntrada": "2024-10-1",
          "dataSaida": "2024-10-15"
        }
      ]
      ```

### **2. POST /api/hospedes**

- **Descrição:** Cria um novo hospede.
- **Corpo da Requisição:**
  ```json
  {
    "name": "Mario",
    "email": "mario@exemplo.com",
    "quarto":"201", 
    "dataEntrada": "2024-10-9",
    "dataSaida": "2024-10-11"
  }
  ```
- **Resposta:**
    - **201 Created**
      ```json
      {
        "id": 2,
        "nome": "Mario",
        "email": "mario@exemplo.com",
        "quarto":"201", 
        "dataEntrada": "2024-10-9",
        "dataSaida": "2024-10-11"
      }
      ```

### **3. GET /api/hospedes/{id}**

- **Descrição:** Retorna um hospede específico pelo ID.
- **Parâmetros de Caminho:**
    - `id`: ID do usuário.
- **Resposta:**
    - **200 OK**
      ```json
      {
          "id": 1,
          "name": "Maria",
          "email": "maria@exemplo.com",
          "quarto": "101",
          "dataEntrada": "2024-10-1",
          "dataSaida": "2024-10-15"
      }
      ```
    - **404 Not Found** (se o hospede não for encontrado)

### **4. PUT /api/hospedes/{id}**

- **Descrição:** Atualiza um hospede existente.
- **Corpo da Requisição:**
  ```json
  {
        "name": "Maria Atualizada",
        "email": "mariaatualizada@exemplo.com",
        "quarto": "105",
        "dataEntrada": "2024-10-1",
        "dataSaida": "2024-10-19"
  }
  ```
- **Parâmetros de Caminho:**
    - `id`: ID do hospede.
- **Resposta:**
    - **200 OK**
      ```json
      {
        "id": 1,
        "name": "Maria Atualizada",
        "email": "mariaatualizada@exemplo.com",
        "quarto": "105",
        "dataEntrada": "2024-10-1",
        "dataSaida": "2024-10-19"
      }
      ```
    - **404 Not Found** (se o hospede não for encontrado)

### **5. DELETE /api/hospedes/{id}**

- **Descrição:** Remove um hospede pelo ID.
- **Parâmetros de Caminho:**
    - `id`: ID do hospede.
- **Resposta:**
    - **204 No Content**
    - **404 Not Found** (se o hospede não for encontrado)
