package main;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
        setResizable(false);
        startButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        absolutePathPDFFile = new javax.swing.JTextField();
        absolutePathCSVFile = new javax.swing.JTextField();
        absolutePathOutDir = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("Absolute Path CSV File:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        absolutePathPDFFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absolutePathPDFFileActionPerformed(evt);
            }
        });
        absolutePathPDFFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                absolutePathPDFFileKeyReleased(evt);
            }
        });

        absolutePathCSVFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absolutePathCSVFileActionPerformed(evt);
            }
        });
        absolutePathCSVFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                absolutePathCSVFileKeyReleased(evt);
            }
        });

        absolutePathOutDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absolutePathOutDirActionPerformed(evt);
            }
        });
        absolutePathOutDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                absolutePathOutDirKeyReleased(evt);
            }
        });

        startButton.setText("Execute");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setText("Auto-Template");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Absolute Path PDF File:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Absolute Path CSV File:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Out Directory:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(absolutePathPDFFile, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(absolutePathCSVFile)
                                    .addComponent(absolutePathOutDir)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(absolutePathPDFFile, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(absolutePathCSVFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(absolutePathOutDir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void absolutePathCSVFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absolutePathCSVFileActionPerformed
        this.verificarCamposTexto();

    }//GEN-LAST:event_absolutePathCSVFileActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        AutoTemplate template = new AutoTemplate();
        template.start(absolutePathPDFFile.getText(), absolutePathCSVFile.getText(), absolutePathOutDir.getText()); 
    }//GEN-LAST:event_startButtonActionPerformed

    private void absolutePathPDFFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absolutePathPDFFileActionPerformed
       this.verificarCamposTexto();
    }//GEN-LAST:event_absolutePathPDFFileActionPerformed

    private void absolutePathOutDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absolutePathOutDirActionPerformed
        this.verificarCamposTexto();
    }//GEN-LAST:event_absolutePathOutDirActionPerformed

    private void absolutePathPDFFileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_absolutePathPDFFileKeyReleased
        this.verificarCamposTexto();
    }//GEN-LAST:event_absolutePathPDFFileKeyReleased

    private void absolutePathCSVFileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_absolutePathCSVFileKeyReleased
        this.verificarCamposTexto();
    }//GEN-LAST:event_absolutePathCSVFileKeyReleased

    private void absolutePathOutDirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_absolutePathOutDirKeyReleased
        this.verificarCamposTexto();
    }//GEN-LAST:event_absolutePathOutDirKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
    
    private void verificarCamposTexto() {
        String absolutePathCSVFileTextBox = absolutePathCSVFile.getText().trim();
        String absolutePathOutDirTextBox = absolutePathOutDir.getText().trim();
        String absolutePathPDFFileTextBox = absolutePathPDFFile.getText().trim();

        if (!absolutePathCSVFileTextBox.isEmpty() && !absolutePathOutDirTextBox.isEmpty() && !absolutePathPDFFileTextBox.isEmpty() ) {
            startButton.setEnabled(true);
        } else {
            startButton.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField absolutePathCSVFile;
    private javax.swing.JTextField absolutePathOutDir;
    private javax.swing.JTextField absolutePathPDFFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
