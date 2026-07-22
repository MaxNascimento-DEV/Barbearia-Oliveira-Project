# 💈 Barber Project

Sistema de Agendamento para Barbearia desenvolvido com **Java + Spring Boot**.

O projeto tem como objetivo permitir que clientes realizem agendamentos de forma simples, escolhendo o barbeiro, data e horário disponíveis, além de receber confirmações via WhatsApp.

Este projeto está sendo desenvolvido para fins de estudo, aplicando boas práticas de desenvolvimento Backend com Spring Boot.

---

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- MySQL
- Lombok
- Bean Validation
- Git e GitHub
- Postman

---

## 📂 Estrutura do Projeto

```
src
 └── main
      ├── controller
      ├── entity
      ├── repository

```

## 📌 Funcionalidades

### ✅ Usuários

- Cadastro de usuário
- Listagem de usuários

### ✅ Barbeiros

- Cadastro de barbeiros
- Listagem de barbeiros ativos
- Controle de barbeiros ativos/inativos

### 🚧 Em desenvolvimento

- Serviços
- Agendamentos
- Horários disponíveis
- Atualização de barbeiros
- Exclusão lógica
- DTOs
- Service Layer
- Tratamento de exceções
- Integração com WhatsApp
- Autenticação

---

## 🗄 Banco de Dados

O sistema utiliza **MySQL**.

Principais entidades:

- Usuário
- Barbeiro
- Serviço
- Agendamento

Relacionamentos:

- Um barbeiro pode possuir vários agendamentos.
- Um cliente pode realizar vários agendamentos.
- Cada agendamento possui apenas um barbeiro e um serviço.

---

## 🎯 Objetivos do Projeto

Este projeto está sendo desenvolvido para praticar:

- Programação Orientada a Objetos
- API REST
- Spring Boot
- Spring Data JPA
- Banco de Dados Relacional
- Arquitetura em Camadas
- Boas práticas de desenvolvimento Backend
- Versionamento com Git

---

## 👨‍💻 Autor

**Maxwell Oliveira**

Estudante de Análise e Desenvolvimento de Sistemas.

Desenvolvendo projetos para aprimorar conhecimentos em Java, Spring Boot e Backend.
