 Sistema de Gerenciamento de Funcionários e Departamentos

O ProjetoRH é um sistema de gerenciamento de recursos humanos desenvolvido com **Java** e **Spring Boot**. Ele permite realizar operações básicas de cadastro, consulta, atualização e exclusão (CRUD) de funcionários e departamentos, além de funcionalidades de filtragem e organização. O objetivo é ajudar empresas de pequeno e médio porte a gerenciar seus recursos humanos de forma eficiente e organizada.

---

## 🛠️ Principais Funcionalidades
1. **Funcionários**:
   - Criar, listar, atualizar e excluir funcionários.
   - Filtrar funcionários por nome, ID ou departamento.

2. **Departamentos**:
   - Criar, listar, atualizar e excluir departamentos.
   - Filtrar departamentos por nome ou ID.

---

## 🛠️ Tecnologias Utilizadas
- **Backend**: Java com Spring Boot
  - Spring Data JPA
  - Spring Web
  - Spring Validation
- **Banco de Dados**: MySQL
- **Ferramenta de Build**: Maven

---

## 📋 Pré-Requisitos
Para executar o projeto, você precisará de:
- **Java 17** ou superior instalado.
- **MySQL** instalado e configurado.
- **Maven** instalado para gerenciar dependências.

---

## Estruturas de Pastas

```
src/
├── controller/
│   ├── FuncionariosController.java
|   ├── DepartamentosController.java
├── model/
│   ├── Funcionarios.java
│   ├── Departamentos.java
├── repository/
│   ├── FuncionarioRepository.java
│   ├── DepartamentoRepository.java
```