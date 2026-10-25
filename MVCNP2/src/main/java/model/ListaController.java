package model;

import view.CadastroView;
import view.ListaView;

import javax.swing.*;
import java.util.List;

public class ListaController {

    private ListaView view;
    private UsuarioDAO dao;

    public ListaController() {
        this.view = new ListaView();
        this.dao = new UsuarioDAO();
        inicializarEventos();
        atualizarTabela();
    }

    private void inicializarEventos() {
        // Evento do botão Novo Cadastro
        view.getBtnNovoCadastro().addActionListener(e -> novoCadastro());

        // Evento do botão Editar
        view.getBtnEditar().addActionListener(e -> editar());

        // Evento do botão Excluir
        view.getBtnExcluir().addActionListener(e -> excluir());
    }

    public void atualizarTabela() {
        try {
            // Limpar tabela
            view.getModeloTabela().setRowCount(0);

            // Buscar todos os usuários
            List<Usuario> usuarios = dao.listarTodos();

            for (Usuario u : usuarios) {
                view.getModeloTabela().addRow(new Object[]{
                        u.getId(),
                        u.getNome(),
                        u.getEmail(),
                        u.getTelefone()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao carregar dados: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void novoCadastro() {
        CadastroView cadastroView = new CadastroView();
        new CadastroController(cadastroView, this);
        cadastroView.setVisible(true);
    }

    private void editar() {
        int linhaSelecionada = view.getTabela().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view,
                    "Selecione um usuário para editar!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Pegar dados da linha selecionada
        int id = (int) view.getModeloTabela().getValueAt(linhaSelecionada, 0);
        String nome = (String) view.getModeloTabela().getValueAt(linhaSelecionada, 1);
        String email = (String) view.getModeloTabela().getValueAt(linhaSelecionada, 2);
        String telefone = (String) view.getModeloTabela().getValueAt(linhaSelecionada, 3);

        // Abrir tela de cadastro com os dados preenchidos
        CadastroView cadastroView = new CadastroView();
        cadastroView.setTitle("Editar Cadastro");
        cadastroView.setUsuarioId(id);
        cadastroView.getTxtNome().setText(nome);
        cadastroView.getTxtEmail().setText(email);
        cadastroView.getTxtTelefone().setText(telefone);
        // Senha fica em branco por segurança, usuário precisa digitar novamente

        new CadastroController(cadastroView, this);
        cadastroView.setVisible(true);
    }

    private void excluir() {
        int linhaSelecionada = view.getTabela().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view,
                    "Selecione um usuário para excluir!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) view.getModeloTabela().getValueAt(linhaSelecionada, 0);
        String nome = (String) view.getModeloTabela().getValueAt(linhaSelecionada, 1);

        int confirmacao = JOptionPane.showConfirmDialog(view,
                "Deseja realmente excluir o usuário \"" + nome + "\"?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                dao.deletar(id);
                JOptionPane.showMessageDialog(view,
                        "Usuário excluído com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view,
                        "Erro ao excluir: " + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void exibir() {
        view.setVisible(true);
    }
}
