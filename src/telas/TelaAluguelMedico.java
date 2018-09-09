/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.bean.Consulta;
import modelo.bean.Medico;
import modelo.dao.ConsultaDAO;
import modelo.dao.MedicoDAO;

/**
 *
 * @author ASUSX451
 */
public class TelaAluguelMedico extends javax.swing.JInternalFrame {
        private Consulta aluguel;
        private Medico roupa;
    
    
    /**
     * Creates new form TelaAluguelRoupa2
     */
    public TelaAluguelMedico() {
        initComponents();
    }
    
    public void readTable() throws Exception {
        DefaultTableModel modelo = (DefaultTableModel) jtAluguel.getModel();
        MedicoDAO rd = new MedicoDAO();

        for (Medico roupa : rd.ler()) {
            modelo.addRow(new Object[]{
                roupa.getCodigo_roupa(),
                roupa.getCategoria(),
                roupa.getModelo(),
                roupa.getCor(),
                roupa.getTamanho(),
                roupa.getPreco(),
                roupa.getDescricao(),
                roupa.getQuantidade()
            });

        }
    }

    public void buscar() throws Exception {
        int cod = Integer.parseInt(jtfCodigoPequisaRoupa.getText());
        DefaultTableModel procurar = (DefaultTableModel) jtAluguel.getModel();
        MedicoDAO dao = new MedicoDAO();
        for (Medico roupa1 : dao.buscarRoupaTabela(cod)) {
            procurar.addRow(new Object[]{
                roupa1.getCodigo_roupa(),
                roupa1.getCategoria(),
                roupa1.getModelo(),
                roupa1.getCor(),
                roupa1.getTamanho(),
                roupa1.getPreco(),
                roupa1.getDescricao(),
                roupa1.getQuantidade()
            });
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfCodigoPequisaRoupa = new javax.swing.JTextField();
        jbPesquisarRoupa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jftfDataDevolucao = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jftfDataAluguel = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jftfCpfCliente = new javax.swing.JFormattedTextField();
        jtfValorEntrada = new javax.swing.JTextField();
        jtfValorRestante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jsQuantidade = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAluguel = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbAlugar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(112, 159, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar roupa"));

        jbPesquisarRoupa.setBackground(new java.awt.Color(112, 159, 255));
        jbPesquisarRoupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search.png"))); // NOI18N
        jbPesquisarRoupa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbPesquisarRoupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarRoupaActionPerformed(evt);
            }
        });

        jLabel1.setText("Código da Roupa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigoPequisaRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jbPesquisarRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoPequisaRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jbPesquisarRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(112, 159, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do aluguel"));

        jLabel3.setText("Data do aluguel");

        jLabel4.setText("Data da devolução");

        try {
            jftfDataDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Valor Restante");

        try {
            jftfDataAluguel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Valor de entrada");

        jLabel7.setText("CPF");

        try {
            jftfCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Quantidade");

        jsQuantidade.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jtAluguel.setBackground(new java.awt.Color(112, 159, 255));
        jtAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Modelo", "Cor", "Tamanho", "Preço", "Descrição", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtAluguel);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfDataAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfValorRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jftfDataAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jftfDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jtfValorRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        jPanel2.setBackground(new java.awt.Color(112, 159, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAlugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/success.png"))); // NOI18N
        jbAlugar.setText("Alugar");
        jbAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlugarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jbAlugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlugar)
                    .addComponent(jbCancelar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(306, 0, 610, 616);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarRoupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarRoupaActionPerformed
        try {

            buscar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar:\n " + e);
        }
    }//GEN-LAST:event_jbPesquisarRoupaActionPerformed

    private void jbAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlugarActionPerformed

        try {

            aluguel = new Consulta();
            aluguel.setCodigo_roupa((int) jtAluguel.getValueAt(jtAluguel.getSelectedRow(), 0));
            aluguel.setDtAluguel(jftfDataAluguel.getText());
            //            aluguel.setDtEntrega(jftfDataEntrega.getText());  Repetitivo
            aluguel.setDtDevolucao(jftfDataDevolucao.getText());
            aluguel.setValorEntrada(Double.parseDouble(jtfValorEntrada.getText()));
            aluguel.setValorRestante(Double.parseDouble(jtfValorRestante.getText()));
            aluguel.setCpf(jftfCpfCliente.getText());
            aluguel.setQuantidade(Integer.parseInt(jsQuantidade.getValue().toString()));

            int quantidade1, quantidade2;

            quantidade1 = ((int) jsQuantidade.getValue());
            quantidade2 = ((int) (jtAluguel.getValueAt(jtAluguel.getSelectedRow(), 7)));

            System.out.println("q1: " + quantidade1);
            System.out.println("q2: " + quantidade2);
            roupa = new Medico();

            if (quantidade1 == 0) {
                JOptionPane.showMessageDialog(this, "Selecione a quantidade de roupas!!");

                if (((quantidade2) != 0) && (quantidade2 >= quantidade1)) {

                    roupa.setCodigo_roupa((int) jtAluguel.getValueAt(jtAluguel.getSelectedRow(), 0));
                    roupa.setQuantidade((int) jtAluguel.getValueAt(jtAluguel.getSelectedRow(), 7) - (quantidade1));
                    if (quantidade1 != 0) {

                        System.out.println(roupa.toString());
                        MedicoDAO roupaDAO = new MedicoDAO();
                        roupaDAO.alterarQuantidade(roupa);
                        
                        System.out.println(aluguel.getQuantidade());
                        ConsultaDAO aluguelDAO = new ConsultaDAO();
                        aluguelDAO.incluirAluguel(aluguel);
                        JOptionPane.showMessageDialog(this, "Roupa alugada com sucesso!");

                        // AINDA PRECISA SER REFINADO
                        jtfCodigoPequisaRoupa.setText("");
                        jftfDataAluguel.setText("");
                        //                        jftfDataEntrega.setText(""); motivo informado acima
                        jftfDataDevolucao.setText("");
                        jtfValorEntrada.setText("");
                        jtfValorRestante.setText("");
                        jftfCpfCliente.setText("");
                        jsQuantidade.setValue(0);

                    }
                }
            } else if (quantidade2 >= quantidade1) {
                roupa.setCodigo_roupa((int) jtAluguel.getValueAt(jtAluguel.getSelectedRow(), 0));
                roupa.setQuantidade((int) jtAluguel.getValueAt(jtAluguel.getSelectedRow(), 7) - (quantidade1));

                MedicoDAO roupaDAO = new MedicoDAO();
                roupaDAO.alterarQuantidade(roupa);

                ConsultaDAO aluguelDAO = new ConsultaDAO();
                aluguelDAO.incluirAluguel(aluguel);
                JOptionPane.showMessageDialog(this, "Roupa alugada com sucesso!");

                // AINDA PRECISA SER REFINADO
                jtfCodigoPequisaRoupa.setText("");
                jftfDataAluguel.setText("");
                //              jftfDataEntrega.setText(""); motivo informado acima
                jftfDataDevolucao.setText("");
                jtfValorEntrada.setText("");
                jtfValorRestante.setText("");
                jftfCpfCliente.setText("");
                jsQuantidade.setValue(0);

            } else {
                JOptionPane.showMessageDialog(this, "Quantidade insulficiente em estoque!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alugar roupa:  " + e);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jbAlugarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlugar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbPesquisarRoupa;
    private javax.swing.JFormattedTextField jftfCpfCliente;
    private javax.swing.JFormattedTextField jftfDataAluguel;
    private javax.swing.JFormattedTextField jftfDataDevolucao;
    private javax.swing.JSpinner jsQuantidade;
    private javax.swing.JTable jtAluguel;
    private javax.swing.JTextField jtfCodigoPequisaRoupa;
    private javax.swing.JTextField jtfValorEntrada;
    private javax.swing.JTextField jtfValorRestante;
    // End of variables declaration//GEN-END:variables
}
