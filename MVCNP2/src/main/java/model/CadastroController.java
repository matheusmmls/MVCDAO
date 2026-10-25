package model;

import view.CadastroView;

import javax.swing.*;

public class CadastroController {

    private CadastroView view;
    private UsuarioDAO dao;
    private ListaController listaController;

    public CadastroController(CadastroView view, ListaController listaController) {
        this.view = view;
        this.dao = new UsuarioDAO();
        this.listaController = listaController;
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Evento do botão Salvar
        view.getBtnSalvar().addActionListener(e -> salvar());

        // Evento do botão Cancelar
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void salvar() {
        String nome = view.getTxtNome().getText().trim();
        String email = view.getTxtEmail().getText().trim();
        String telefone = view.getTxtTelefone().getText().trim();
        String senha = new String(view.getTxtSenha().getPassword()).trim();

        // Validação
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "Preencha todos os campos!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (view.getUsuarioId() == -1) {
                // Novo cadastro
                Usuario usuario = new Usuario(nome, email, telefone, senha);
                dao.cadastrar(usuario);
                JOptionPane.showMessageDialog(view,
                        "Usuário cadastrado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Edição
                Usuario usuario = new Usuario(view.getUsuarioId(), nome, email, telefone, senha);
                dao.editar(usuario);
                JOptionPane.showMessageDialog(view,
                        "Usuário atualizado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            // Atualizar lista se estiver aberta
            if (listaController != null) {
                listaController.atualizarTabela();
            }

            view.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao salvar: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
