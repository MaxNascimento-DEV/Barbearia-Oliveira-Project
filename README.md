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
     ├── enums
     ├── repository
     └── service

```

## 📌 Funcionalidades

### ✅ Usuários

- Cadastro de usuário
- Listagem de usuários
-

### ✅ Barbeiros

- Cadastro de barbeiros
- Atualização de barbeiros
- Listagem de barbeiros ativos
- Controle de barbeiros ativos/inativos (Soft Delete)

### ✅ Serviços

- Cadastro e atualização de serviços
- Listagem de todos os serviços e apenas serviços ativos
- Ativação e desativação de serviços
- Validações de negócio (nome duplicado, preço inválido, duração)

### ✅ Agendamentos (Núcleo do Sistema)

- Cadastro de agendamentos com validação de conflito de horários
- Verificação automática de integridade (se barbeiro e serviço estão ativos)
- Cálculo automático da dataFim baseado na duração do serviço escolhido
- Atualização de agendamentos (revalidando disponibilidade de agenda)
- Máquina de estados (Confirmar, Finalizar, Cancelar) protegida por regras de negócio
- Buscas personalizadas (por Barbeiro, por Usuário e por Status)

### 🚧 Em desenvolvimento (Próximos Passos)

- Implementação de DTOs (Request / Response)
- Tratamento global de exceções (@ControllerAdvice) e validações avançadas
- Testes automatizados (JUnit e Mockito)
- Autenticação e Autorização (Spring Security e JWT)
- Integração com WhatsApp para notificações automáticas de confirmação

---

## 🗄 Banco de Dados

O sistema utiliza MySQL.

Principais entidades:

Usuário
Barbeiro
Serviço
Agendamento

Relacionamentos:

Um barbeiro pode possuir vários agendamentos (@ManyToOne).
Um cliente pode realizar vários agendamentos (@ManyToOne).
Cada agendamento possui apenas um barbeiro e um serviç

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

**Maxwell Nascimento**

Estudante de Análise e Desenvolvimento de Sistemas.

Desenvolvendo projetos para aprimorar conhecimentos em Java, Spring Boot e Backend.
