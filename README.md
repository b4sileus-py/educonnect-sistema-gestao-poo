# EduConnect – Sistema de Gestão Educacional (POO)

Projeto desenvolvido como trabalho final da disciplina Imersão em Programação Orientada a Objetos, aplicando conceitos fundamentais de POO e Arquitetura em Camadas.

---

## Descrição Geral

O sistema EduConnect é um protótipo de Sistema de Gestão Educacional (SGE) capaz de gerenciar:

- Alunos  
- Professores  
- Cursos (EAD e Presencial)  
- Turmas  
- Matrículas  
- Avaliações  
- Relatórios automatizados via Polimorfismo  

Toda a arquitetura foi construída seguindo boas práticas, utilização correta de pacotes, separação de responsabilidades e aplicação consistente dos pilares de POO.

---

## Arquitetura do Sistema

A aplicação foi estruturada conforme o padrão solicitado:

```
src/
 ├── model/        (Entidades do sistema)
 ├── repository/   (Armazenamento em listas)
 ├── service/      (Regras de negócio)
 └── ui/           (Menu e interação com usuário)
```

A classe `Main` faz a integração entre as camadas e controla o fluxo principal do sistema.

---

## Tecnologias Utilizadas

- Java 17+
- Programação Orientada a Objetos
- Arquitetura em Camadas
- Coleções (List, ArrayList)
- Polimorfismo
- Encapsulamento
- Interfaces e Classes Abstratas
- Tratamento de entrada via Scanner

---

## Funcionalidades Implementadas

### Alunos
- Cadastro  
- Associação a curso  
- Matrícula em turma  
- Consulta de avaliações  

### Professores
- Cadastro  
- Associação a turma  
- Registro de avaliações  

### Cursos
- Presenciais (com sala)  
- EAD (com plataforma)  
- Relatórios específicos  

### Turmas
- Criação  
- Atribuição de professor  
- Matrícula de alunos  
- Relatório consolidado  

### Relatórios (Fase 6)

Os relatórios são gerados utilizando polimorfismo, por meio do método `gerarRelatorio()`, implementado em:

- Aluno  
- Professor  
- Curso  

Os relatórios gerais são exibidos no menu administrativo.

---

## Menu Interativo (Fase Final)

O sistema permite:

- Cadastrar alunos, professores e cursos  
- Criar turmas e vincular professores  
- Matricular alunos  
- Registrar avaliações  
- Gerar relatórios completos  
- Alternar usuário (login/logout)  
- Testar cenários de sucesso e falha  

Cada tipo de usuário acessa somente funcionalidades compatíveis com seu perfil.

---

## Testes de Cenário

Foram avaliados e validados:

- Login com credenciais válidas e inválidas  
- Cadastro de entidades  
- Matrícula de alunos em turmas  
- Registro de avaliações em alunos  
- Relatórios populados e vazios  
- Controle de acesso baseado no perfil do usuário  

---

## Link do Repositório

https://github.com/b4sileus-py/educonnect-sistema-gestao-poo

---

## Autor

Roberto Siqueira  
RA: 24411202-5  
Curso: Análise e Desenvolvimento de Sistemas

