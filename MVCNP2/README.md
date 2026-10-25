# CRUD Java/Swing - Projeto MVC

Sistema de cadastro de usuários com Java/Swing, seguindo a arquitetura MVC (Model-View-Controller) e conexão com banco de dados MySQL.

## 📁 Estrutura do Projeto

```
src/
├── Main.java                      # Classe principal
├── model/
│   └── Usuario.java               # Modelo de dados do usuário
├── view/
│   ├── LoginView.java             # Tela de login
│   ├── CadastroView.java          # Tela de cadastro/edição
│   └── ListaView.java             # Tela de listagem (CRUD)
├── controller/
│   ├── LoginController.java       # Controlador do login
│   ├── CadastroController.java    # Controlador do cadastro/edição
│   └── ListaController.java       # Controlador da listagem
├── dao/
│   └── UsuarioDAO.java            # Acesso ao banco de dados
└── connection/
    └── ConexaoBD.java             # Conexão com o banco de dados
```

## 🛠️ Tecnologias

- Java
- Swing (interface gráfica)
- MySQL (banco de dados)
- JDBC (conexão com banco)
- Arquitetura MVC

## 🗄️ Configuração do Banco de Dados

1. Crie o banco de dados executando o arquivo `banco.sql`
2. Configure os dados de conexão no arquivo `src/connection/ConexaoBD.java`

## ▶️ Como Executar

1. Configure o banco de dados MySQL
2. Adicione o driver JDBC do MySQL ao classpath
3. Compile e execute a classe `Main.java`

## 📋 Funcionalidades

- **Login**: Autenticação com e-mail e senha
- **Cadastro**: Registro de novos usuários (nome, e-mail, telefone, senha)
- **Visualização**: Listagem de todos os usuários cadastrados em uma tabela
- **Edição**: Alteração dos dados de um usuário existente
- **Exclusão**: Remoção de um usuário com confirmação
