/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.bean.AgendaConsulta;
import modelo.bean.Consulta;
import modelo.bean.Medico;
import modelo.dao.AgendaConsultaDAO;
import modelo.dao.MedicoDAO;

/**
 *
 * @author ASUSX451
 */
public class TelaAgendaConsulta extends javax.swing.JInternalFrame {
        private Consulta AgendaConsulta;
        private Medico especialidade;
    private Object consulta;
    
    
    /**
     * Creates new form TelaAluguelRoupa2
     */
    public TelaAgendaConsulta() {
        initComponents();
    }
    
    public void readTable() throws Exception {
        DefaultTableModel telaAgendaConsulta = (DefaultTableModel) jtAgendaConsulta.getModel();
        AgendaConsultaDAO rd = new  AgendaConsultaDAO();

        for (AgendaConsulta consulta : rd.ler()) {
            modelo.addRow(new Object[]{
                
                consulta.getData(),
                consulta.getHora(),
                consulta.getMedico(),
                consulta.getEspecialidade(),
                consulta.getNome_Paciente(),
                
            });

        }
    }

    public void buscar() throws Exception {
        int cod = Integer.parseInt(jtfCodigoPequisarConsultasAgendadas.getText());
        DefaultTableModel procurar = (DefaultTableModel) jtAgendaConsulta.getModel();
        AgendaConsultaDAO dao = new AgendaConsultaDAO();
        for (AgendaConsulta consulta1 : dao.buscarConsultaTabela(cod)) {
            procurar.addRow(new Object[]{
                consulta1.getData(),
                consulta1.getHora(),
                consulta1.getMedico(),
                consulta1.getEspecialidade(),
                consulta1.getNome_Paciente(),
                
            });
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtfCodigoPequisarConsultasAgendadas = new javax.swing.JTextField();
        jbPesquisarConsultasAgendadas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAgendaConsulta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbAgendar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(112, 159, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Consultas Agendadas\n"));

        jtfCodigoPequisarConsultasAgendadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoPequisarConsultasAgendadasActionPerformed(evt);
            }
        });

        jbPesquisarConsultasAgendadas.setBackground(new java.awt.Color(112, 159, 255));
        jbPesquisarConsultasAgendadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search.png"))); // NOI18N
        jbPesquisarConsultasAgendadas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbPesquisarConsultasAgendadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarConsultasAgendadasActionPerformed(evt);
            }
        });

        jLabel1.setText("  Prontuario do Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigoPequisarConsultasAgendadas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jbPesquisarConsultasAgendadas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoPequisarConsultasAgendadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jbPesquisarConsultasAgendadas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(112, 159, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados das Consultas"));

        jtAgendaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtAgendaConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jtAgendaConsulta);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Agendamentos para Hoje");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(112, 159, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/success.png"))); // NOI18N
        jbAgendar.setText("Alugar");
        jbAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgendarActionPerformed(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jbAgendar)
                .addGap(98, 98, 98)
                .addComponent(jbCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgendar)
                    .addComponent(jbCancelar))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(306, 0, 610, 616);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarConsultasAgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarConsultasAgendadasActionPerformed
        try {

            buscar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar:\n " + e);
        }
    }//GEN-LAST:event_jbPesquisarConsultasAgendadasActionPerformed

    private void jbAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgendarActionPerformed

        try {

            AgendaConsulta = new Consulta();
            consulta.setNome_Paciente((String) jtAgendaConsulta.getValueAt(jtAgendaConsulta.getSelectedRow(), 0));
            consulta.setData(jftfData.getText());
            //            aluguel.setDtEntrega(jftfDataEntrega.getText());  Repetitivo
            consulta.setHora(jftfHora.getText());
            consulta.setMedico(Double.parseDouble(jtfMedico.getText()));
           consulta.setEspecialidade(Double.parseDouble(jtfEspecialidade.getText()));
            
            int quantidade1, quantidade2;

            quantidade1 = ((int) jsQuantidade.getValue());
            quantidade2 = ((int) (jtAgenda.getValueAt(jtAgenda.getSelectedRow(), 7)));

            System.out.println("q1: " + quantidade1);
            System.out.println("q2: " + quantidade2);
            consulta = new Medico();

            if (quantidade1 == 0) {
                JOptionPane.showMessageDialog(this, "Selecione a quantidade de roupas!!");

                if (((quantidade2) != 0) && (quantidade2 >= quantidade1)) {

                    roupa.setCodigo_roupa((int) jtAgenda.getValueAt(jtAgenda.getSelectedRow(), 0));
                    roupa.setQuantidade((int) jtAgenda.getValueAt(jtAgenda.getSelectedRow(), 7) - (quantidade1));
                    if (quantidade1 != 0) {

                        System.out.println(roupa.toString());
                        MedicoDAO roupaDAO = new MedicoDAO();
                        roupaDAO.alterarQuantidade(roupa);
                        
                        System.out.println(aluguel.getQuantidade());
                        AgendaConsultaDAO aluguelDAO = new AgendaConsultaDAO();
                        aluguelDAO.incluirAluguel(aluguel);
                        JOptionPane.showMessageDialog(this, "Roupa alugada com sucesso!");

                        // AINDA PRECISA SER REFINADO
                        jtfCodigoPequisarConsultasAgendadas.setText("");
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
                roupa.setCodigo_roupa((int) jtAgenda.getValueAt(jtAgenda.getSelectedRow(), 0));
                roupa.setQuantidade((int) jtAgenda.getValueAt(jtAgenda.getSelectedRow(), 7) - (quantidade1));

                MedicoDAO roupaDAO = new MedicoDAO();
                roupaDAO.alterarQuantidade(roupa);

                AgendaConsultaDAO aluguelDAO = new AgendaConsultaDAO();
                aluguelDAO.incluirAluguel(aluguel);
                JOptionPane.showMessageDialog(this, "Roupa alugada com sucesso!");

                // AINDA PRECISA SER REFINADO
                jtfCodigoPequisarConsultasAgendadas.setText("");
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

    }//GEN-LAST:event_jbAgendarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jtfCodigoPequisarConsultasAgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoPequisarConsultasAgendadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoPequisarConsultasAgendadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAgendar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbPesquisarConsultasAgendadas;
    private javax.swing.JTable jtAgendaConsulta;
    private javax.swing.JTextField jtfCodigoPequisarConsultasAgendadas;
    // End of variables declaration//GEN-END:variables
}
