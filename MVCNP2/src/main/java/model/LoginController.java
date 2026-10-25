package model;

import view.CadastroView;
import view.LoginView;

import javax.swing.*;

public class LoginController {

    private LoginView view;
    private UsuarioDAO dao;

    public LoginController(LoginView view) {
        this.view = view;
        this.dao = new UsuarioDAO();
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Evento do botão Entrar
        view.getBtnEntrar().addActionListener(e -> entrar());

        // Evento do botão Cadastrar-se
        view.getBtnCadastrar().addActionListener(e -> abrirCadastro());
    }

    private void entrar() {
        String email = view.getTxtUsuario().getText().trim();
        String senha = new String(view.getTxtSenha().getPassword()).trim();

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "Preencha todos os campos!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Usuario usuario = dao.login(email, senha);

            if (usuario != null) {
                JOptionPane.showMessageDialog(view,
                        "Bem-vindo(a), " + usuario.getNome() + "!",
                        "Login realizado",
                        JOptionPane.INFORMATION_MESSAGE);
                view.dispose();

                // Abrir tela de lista
                ListaController listaController = new ListaController();
                listaController.exibir();
            } else {
                JOptionPane.showMessageDialog(view,
                        "Usuário ou senha inválidos!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao conectar: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirCadastro() {
        CadastroView cadastroView = new CadastroView();
        new CadastroController(cadastroView, null);
        cadastroView.setVisible(true);
    }

    public void exibir() {
        view.setVisible(true);
    }
}
