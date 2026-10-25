package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ListaView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JButton btnNovoCadastro;
    private JButton btnEditar;
    private JButton btnExcluir;

    public ListaView() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Cadastrados");
        setSize(850, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBackground(new Color(20, 25, 35));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Modelo da tabela (não editável)
        modeloTabela = new DefaultTableModel(
                new String[]{"ID", "Nome", "E-mail", "Telefone"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Tabela
        tabela = new JTable(modeloTabela);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabela.setRowHeight(40);
        tabela.setBackground(new Color(30, 35, 50));
        tabela.setForeground(Color.WHITE);
        tabela.setSelectionBackground(new Color(40, 60, 100));
        tabela.setSelectionForeground(new Color(100, 180, 255));
        tabela.setGridColor(new Color(50, 60, 80));
        tabela.setShowGrid(true);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Cabeçalho da tabela
        JTableHeader header = tabela.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(25, 30, 45));
        header.setForeground(new Color(150, 170, 200));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(50, 60, 80)));

        // Renderizador das células
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        // Ajustar largura das colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(180);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(280);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(180);

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(50, 60, 80)));
        scrollPane.getViewport().setBackground(new Color(30, 35, 50));
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Painel dos botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        painelBotoes.setBackground(new Color(20, 25, 35));

        // Botão Novo Cadastro
        btnNovoCadastro = new JButton("+ Novo cadastro");
        btnNovoCadastro.setPreferredSize(new Dimension(160, 40));
        btnNovoCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnNovoCadastro.setBackground(new Color(35, 40, 55));
        btnNovoCadastro.setForeground(Color.WHITE);
        btnNovoCadastro.setFocusPainted(false);
        btnNovoCadastro.setBorder(BorderFactory.createLineBorder(new Color(60, 70, 90)));
        btnNovoCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnNovoCadastro);

        // Espaçador para empurrar Editar e Excluir para a direita
        JPanel espacador = new JPanel();
        espacador.setOpaque(false);
        espacador.setPreferredSize(new Dimension(300, 40));
        painelBotoes.add(espacador);

        // Botão Editar
        btnEditar = new JButton("\u270F Editar");
        btnEditar.setPreferredSize(new Dimension(120, 40));
        btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEditar.setBackground(new Color(35, 40, 55));
        btnEditar.setForeground(new Color(100, 180, 255));
        btnEditar.setFocusPainted(false);
        btnEditar.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 160)));
        btnEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnEditar);

        // Botão Excluir
        btnExcluir = new JButton("\uD83D\uDDD1 Excluir");
        btnExcluir.setPreferredSize(new Dimension(120, 40));
        btnExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnExcluir.setBackground(new Color(35, 40, 55));
        btnExcluir.setForeground(new Color(255, 100, 100));
        btnExcluir.setFocusPainted(false);
        btnExcluir.setBorder(BorderFactory.createLineBorder(new Color(160, 60, 60)));
        btnExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnExcluir);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);
    }

    // Getters
    public JTable getTabela() {
        return tabela;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    public JButton getBtnNovoCadastro() {
        return btnNovoCadastro;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }
}
