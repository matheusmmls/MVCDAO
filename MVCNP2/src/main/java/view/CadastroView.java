package view;

import javax.swing.*;
import java.awt.*;

public class CadastroView extends JFrame {

    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JPasswordField txtSenha;
    private JButton btnSalvar;
    private JButton btnCancelar;

    private int usuarioId = -1; // -1 significa novo cadastro

    public CadastroView() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Cadastro");
        setSize(430, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(new Color(30, 30, 30));

        // Label Nome
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(30, 20, 360, 20);
        lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNome.setForeground(Color.WHITE);
        painelPrincipal.add(lblNome);

        // Campo Nome
        txtNome = new JTextField();
        txtNome.setBounds(30, 45, 350, 35);
        estilizarCampo(txtNome);
        painelPrincipal.add(txtNome);

        // Label E-mail
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(30, 90, 360, 20);
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblEmail.setForeground(Color.WHITE);
        painelPrincipal.add(lblEmail);

        // Campo E-mail
        txtEmail = new JTextField();
        txtEmail.setBounds(30, 115, 350, 35);
        estilizarCampo(txtEmail);
        painelPrincipal.add(txtEmail);

        // Label Telefone
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(30, 160, 360, 20);
        lblTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTelefone.setForeground(Color.WHITE);
        painelPrincipal.add(lblTelefone);

        // Campo Telefone
        txtTelefone = new JTextField();
        txtTelefone.setBounds(30, 185, 350, 35);
        estilizarCampo(txtTelefone);
        painelPrincipal.add(txtTelefone);

        // Label Senha
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(30, 230, 360, 20);
        lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenha.setForeground(Color.WHITE);
        painelPrincipal.add(lblSenha);

        // Campo Senha
        txtSenha = new JPasswordField();
        txtSenha.setBounds(30, 255, 350, 35);
        txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSenha.setBackground(new Color(50, 50, 50));
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setCaretColor(Color.WHITE);
        txtSenha.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        painelPrincipal.add(txtSenha);

        // Painel dos botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        painelBotoes.setBounds(30, 320, 350, 45);
        painelBotoes.setOpaque(false);

        // Botão Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setPreferredSize(new Dimension(120, 38));
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCancelar.setBackground(new Color(50, 50, 50));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnCancelar);

        // Botão Salvar
        btnSalvar = new JButton("Salvar");
        btnSalvar.setPreferredSize(new Dimension(120, 38));
        btnSalvar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSalvar.setBackground(new Color(50, 50, 50));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
        btnSalvar.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
        btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnSalvar);

        painelPrincipal.add(painelBotoes);

        add(painelPrincipal);
    }

    private void estilizarCampo(JTextField campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBackground(new Color(50, 50, 50));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    // Getters
    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtTelefone() {
        return txtTelefone;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
