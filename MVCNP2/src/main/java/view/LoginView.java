package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;

    public LoginView() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(new Color(30, 30, 30));

        // Título
        JLabel lblTitulo = new JLabel("Acesso ao sistema", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 20, 400, 40);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        painelPrincipal.add(lblTitulo);

        // Label Usuário
        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setBounds(40, 80, 320, 20);
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUsuario.setForeground(Color.WHITE);
        painelPrincipal.add(lblUsuario);

        // Campo Usuário
        txtUsuario = new JTextField();
        txtUsuario.setBounds(40, 105, 310, 35);
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setBackground(new Color(50, 50, 50));
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        painelPrincipal.add(txtUsuario);

        // Label Senha
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(40, 150, 320, 20);
        lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenha.setForeground(Color.WHITE);
        painelPrincipal.add(lblSenha);

        // Campo Senha
        txtSenha = new JPasswordField();
        txtSenha.setBounds(40, 175, 310, 35);
        txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSenha.setBackground(new Color(50, 50, 50));
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setCaretColor(Color.WHITE);
        txtSenha.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        painelPrincipal.add(txtSenha);

        // Painel dos botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        painelBotoes.setBounds(40, 240, 310, 45);
        painelBotoes.setOpaque(false);

        // Botão Entrar
        btnEntrar = new JButton("Entrar");
        btnEntrar.setPreferredSize(new Dimension(130, 38));
        btnEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEntrar.setBackground(new Color(50, 50, 50));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnEntrar);

        // Botão Cadastrar-se
        btnCadastrar = new JButton("Cadastrar-se");
        btnCadastrar.setPreferredSize(new Dimension(130, 38));
        btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCadastrar.setBackground(new Color(50, 50, 50));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painelBotoes.add(btnCadastrar);

        painelPrincipal.add(painelBotoes);

        add(painelPrincipal);
    }

    // Getters
    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }
}
