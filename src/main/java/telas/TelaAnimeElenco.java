/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import apoio.Mensagem;
import controladores.ControlaElenco;
import controladores.ControlaAnime;
import controladores.ControlaAnimeElenco;
import entidades.Elenco;
import entidades.Anime;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuc
 */
public class TelaAnimeElenco extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaAnimeElenco.class.getName());

    /**
     * Creates new form TelaFilmeElenco
     */
    private final ControlaAnime controladorAnime = new ControlaAnime();
    private final ControlaElenco controladorElenco = new ControlaElenco();
    private final ControlaAnimeElenco controladorAnimeElenco = new ControlaAnimeElenco();
    private ArrayList<Anime> animes = new ArrayList<>();

    public TelaAnimeElenco() {
        initComponents();
        setSize(707, 1058);
        setLocationRelativeTo(null);
        montaAnimes();

    }

    private void montaAnimes() {
        animes = controladorAnime.recuperarTodos();
        cbAnime.removeAllItems();

        for (int i = 0; i < animes.size(); i++) {
            Anime anime = animes.get(i);
            cbAnime.addItem(anime.getTitulo());
        }
    }

    private void montaTabelaElenco() {
        int indiceAnime = cbAnime.getSelectedIndex();

        if (indiceAnime < 0) {
            return;
        }

        int animeId = animes.get(indiceAnime).getCodigo();

        ArrayList<Elenco> integrantes = controladorAnimeElenco.listarPorAnime(animeId);

        String[] colunas = {"ID", "Nome", "Nacionalidade", "Data Nascimento"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (int i = 0; i < integrantes.size(); i++) {
            Elenco integrante = integrantes.get(i);

            Object[] linha = {
                integrante.getCodigo(),
                integrante.getNome(),
                integrante.getNacionalidade(),
                integrante.getDtNascimento()
            };
            modelo.addRow(linha);
        }
        tblElenco.setModel(modelo);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tblElenco.getColumnCount(); i++) {
            tblElenco.getColumnModel().getColumn(i).setCellRenderer(centralizador);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLanime = new javax.swing.JLabel();
        JLpesquisa = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        cbAnime = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        JLresultados = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblElenco = new javax.swing.JTable();
        JLelenco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLanime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLanime.setForeground(new java.awt.Color(255, 255, 255));
        JLanime.setText("Anime:");
        JLanime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLanimeMouseClicked(evt);
            }
        });

        JLpesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLpesquisa.setForeground(new java.awt.Color(255, 255, 255));
        JLpesquisa.setText("Pesquisar Integrante:");
        JLpesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLpesquisaMouseClicked(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(0, 0, 0));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(this::btnRemoverActionPerformed);

        btnPesquisar.setBackground(new java.awt.Color(153, 0, 0));
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(this::btnPesquisarActionPerformed);

        btnVoltar.setBackground(new java.awt.Color(204, 255, 204));
        btnVoltar.setForeground(new java.awt.Color(0, 0, 0));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        cbAnime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbAnime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAnime.addActionListener(this::cbAnimeActionPerformed);

        btnAdicionar.setBackground(new java.awt.Color(153, 0, 0));
        btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(this::btnAdicionarActionPerformed);

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        JLresultados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLresultados.setText("Resultados:");

        txtPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPesquisa.addActionListener(this::txtPesquisaActionPerformed);

        tblElenco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblElenco);

        JLelenco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLelenco.setText("Elenco:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLelenco)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLresultados)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(287, 287, 287))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JLpesquisa)
                                .addComponent(JLanime)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbAnime, javax.swing.GroupLayout.Alignment.LEADING, 0, 410, Short.MAX_VALUE)
                                    .addComponent(txtPesquisa, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(JLanime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(JLpesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(JLresultados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(JLelenco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLanimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLanimeMouseClicked
        cbAnime.requestFocus();
    }//GEN-LAST:event_JLanimeMouseClicked

    private void JLpesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLpesquisaMouseClicked
        txtPesquisa.requestFocus();
    }//GEN-LAST:event_JLpesquisaMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        this.dispose(); // fecha o menu atual
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cbAnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnimeActionPerformed
        montaTabelaElenco();
    }//GEN-LAST:event_cbAnimeActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String nome = txtPesquisa.getText();
        ArrayList<Elenco> integrantes = controladorElenco.pesquisarPorNome(nome);
        String[] colunas = {"ID", "Nome", "Nacionalidade", "Data Nascimento"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (int i = 0; i < integrantes.size(); i++) {
            Elenco integrante = integrantes.get(i);

            Object[] linha = {
                integrante.getCodigo(),
                integrante.getNome(),
                integrante.getNacionalidade(),
                integrante.getDtNascimento()
            };
            modelo.addRow(linha);

        }
        tblResultados.setModel(modelo);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        for (int i = 0; i < tblResultados.getColumnCount(); i++) {
            tblResultados.getColumnModel().getColumn(i).setCellRenderer(centralizador);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int indiceAnime = cbAnime.getSelectedIndex();

        if (indiceAnime < 0) {
            return;
        }
        int linhaSelecionada = tblResultados.getSelectedRow();

        if (linhaSelecionada < 0) {
            Mensagem.aviso("Selecione um integrante do elenco.");
            return;
        }
        int animeId = animes.get(indiceAnime).getCodigo();
        int elencoId = Integer.parseInt(
                String.valueOf(tblResultados.getValueAt(linhaSelecionada, 0))
        );

        controladorAnimeElenco.adicionar(animeId, elencoId);
        montaTabelaElenco();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int indiceAnime = cbAnime.getSelectedIndex();
        if (indiceAnime < 0) {
            return;
        }
        int linhaSelecionada = tblElenco.getSelectedRow();
        if (linhaSelecionada < 0) {
            Mensagem.aviso("Selecione um integrante do elenco.");
            return;
        }
        int animeId = animes.get(indiceAnime).getCodigo();
        int elencoId = Integer.parseInt(
                String.valueOf(tblElenco.getValueAt(linhaSelecionada, 0))
        );
        int confirmacao = Mensagem.confirmacao(
                "Deseja realmente remover este integrante do anime?"
        );
        if (confirmacao == 0) {
            controladorAnimeElenco.remover(animeId, elencoId);
            montaTabelaElenco();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaAnimeElenco().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLanime;
    private javax.swing.JLabel JLelenco;
    private javax.swing.JLabel JLpesquisa;
    private javax.swing.JLabel JLresultados;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbAnime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblElenco;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
