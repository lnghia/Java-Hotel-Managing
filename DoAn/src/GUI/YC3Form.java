/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAL.DataProvider;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huyen
 */
public class YC3Form extends javax.swing.JFrame {
    private static final int BY_MAPH=0;
    private static final int BY_TINHTRANG=3;
    private static final int BY_LOAIPH=1;
    private static final int BY_DONGIA=2;
    
    DefaultTableModel tableModel;
    DefaultComboBoxModel<String> roomTypesCbModel, roomStatesCbModel;
    ArrayList<HashMap<String, String>> data, roomTypes, roomStates, roomPrices;
    
    private int filteredBy;
    /**
     * Creates new form YC3Form
     */
    public YC3Form() {
        initComponents();
        
        filteredBy=0;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        filterTypeSetActionListener();
        initSearchInput();
        
        data=new ArrayList<>();
        roomTypes=new ArrayList<>();
        roomStates=new ArrayList<>();
        roomTypesCbModel=new DefaultComboBoxModel<>();
        roomStatesCbModel=new DefaultComboBoxModel<>();
        initUI();
    }
    
    private void initUI(){
//        initSearchResult();
//        displaySearchResult();
//        fillRoomStatesCb();
//        fillRoomTypesCb();

        fillRoomTypesCb();
        fillRoomUnitPriceCb();
        initialData();
        loaiPhongActionListener();
        donGiaActionListener();
    }
    
    public void initialData(){
        String query="select MAPHONG, a.MALOAIPHONG, DONGIA, TINHTRANG from PHONG a, LOAIPHONG b where b.MALOAIPHONG=a.MALOAIPHONG";
        
        data=DataProvider.getInstance().executeQuery(query, new String[]{});
        feedDataTable();
    }
    
    public void initSearchResult(){
        data=DataProvider.getInstance().executeQuery("select * from PHONG where TrangThai = ?", new String[]{"true"});
    }
    
    public void initSearchInput(){
        valueToSearchTxt.setEnabled(true);
        valueToSearchTxt.setText("");
        loaiPhToSearch.setEnabled(false);
        donGiaToSearch.setEnabled(false);
        valueActionListener();
    }
    
    public void filterTypeSetActionListener(){
        filterTypeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(filterTypeCombo.getSelectedIndex()){
                    case BY_MAPH:
                        filteredBy=BY_MAPH;
                        valueToSearchTxt.setEnabled(true);
                        valueToSearchTxt.setText("");
                        loaiPhToSearch.setEnabled(false);
                        donGiaToSearch.setEnabled(false);
                        break;
                    case BY_LOAIPH:
                        filteredBy=BY_LOAIPH;
                        valueToSearchTxt.setEnabled(false);
                        valueToSearchTxt.setText("");
                        loaiPhToSearch.setEnabled(true);
                        donGiaToSearch.setEnabled(false);
                        break;
                    case BY_DONGIA:
                        filteredBy=BY_DONGIA;
                        valueToSearchTxt.setEnabled(false);
                        valueToSearchTxt.setText("");
                        loaiPhToSearch.setEnabled(false);
                        donGiaToSearch.setEnabled(true);
                        break;
                    case BY_TINHTRANG:
                        filteredBy=BY_TINHTRANG;
                        valueToSearchTxt.setEnabled(true);
                        valueToSearchTxt.setText("");
                        loaiPhToSearch.setEnabled(false);
                        donGiaToSearch.setEnabled(false);
                        break;
                }
            }
        });
    }
    
    public void searchFor(){
        if(data!=null && !data.isEmpty()){
            data.clear();
        }
        
        String query="select MAPHONG, a.MALOAIPHONG, DONGIA, TINHTRANG from PHONG a, LOAIPHONG b where MAPHONG like '%" + valueToSearchTxt.getText() + "%' and b.MALOAIPHONG=a.MALOAIPHONG";
        
        if(filteredBy==BY_LOAIPH){
            query="select MAPHONG, a.MALOAIPHONG, DONGIA, TINHTRANG from PHONG a, LOAIPHONG b where a.MALOAIPHONG='"+loaiPhToSearch.getSelectedItem()+"' and b.MALOAIPHONG=a.MALOAIPHONG";
        }
        else if(filteredBy==BY_DONGIA){
            query="select MAPHONG, a.MALOAIPHONG, DONGIA, TINHTRANG from PHONG a, LOAIPHONG b where b.MALOAIPHONG=a.MALOAIPHONG and DONGIA='"+donGiaToSearch.getSelectedItem().toString()+"'";
        }
        else if(filteredBy==BY_TINHTRANG){
            query="select MAPHONG, a.MALOAIPHONG, DONGIA, TINHTRANG from PHONG a, LOAIPHONG b where TINHTRANG='" + valueToSearchTxt.getText() + "' and b.MALOAIPHONG=a.MALOAIPHONG";
        }
        
        data=DataProvider.getInstance().executeQuery(query, new String[]{});
    }
    
    public void valueActionListener(){
        valueToSearchTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFor();
                feedDataTable();
            }
        });
    }
    
    public void donGiaActionListener(){
        donGiaToSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFor();
                feedDataTable();
            }
        });
    }
    
    public void loaiPhongActionListener(){
        loaiPhToSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFor();
                feedDataTable();
            }
        });
    }
    
    public void feedDataTable(){
        DefaultTableModel tmp=(DefaultTableModel)jTable1.getModel();
        int i=0;
        
        tmp.setRowCount(0);
        for(HashMap<String, String> row : data){
            String[] _row=new String[5];
            
            _row[0]=Integer.toString(++i);
            _row[1]=row.get("MAPHONG");
            _row[2]=row.get("MALOAIPHONG");
            _row[3]=row.get("DONGIA");
            _row[4]=row.get("TINHTRANG");
            
            tmp.addRow(_row);
        }
        
        jTable1.setModel(tmp);
    }
    
    public void reload(){
        searchFor();
        feedDataTable();
    }
    
    public void fillRoomTypesCb(){
        loaiPhToSearch.removeAllItems();
        roomTypes=new ArrayList<>();
        roomTypesCbModel=new DefaultComboBoxModel<>();
        
        roomTypes=DataProvider.getInstance().executeQuery("select * from LOAIPHONG", new String[]{});
    
        roomTypesCbModel.addElement(null);
        for(HashMap<String, String> row : roomTypes){
            roomTypesCbModel.addElement(row.get("MALOAIPHONG"));
        }
        
        loaiPhToSearch.setModel(roomTypesCbModel);
    }
    
    public void fillRoomUnitPriceCb(){
        roomPrices=new ArrayList<>();
        
        roomPrices=DataProvider.getInstance().executeQuery("select DONGIA from LOAIPHONG", new String[]{});
        
        for(HashMap<String, String> i : roomPrices){
            donGiaToSearch.addItem(i.get("DONGIA"));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filterTypeCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        valueToSearchTxt = new javax.swing.JTextField();
        donGiaToSearch = new javax.swing.JComboBox<>();
        loaiPhToSearch = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(203, 234, 237));

        jPanel2.setBackground(new java.awt.Color(211, 219, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DANH SÁCH PHÒNG TÌM ĐƯỢC");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phòng", "Loại phòng", "Đơn giá", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Tìm phòng theo:");

        filterTypeCombo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        filterTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên phòng", "Loại phòng", "Đơn giá", "Tình trạng" }));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Giá trị:");

        valueToSearchTxt.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        donGiaToSearch.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        donGiaToSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donGiaToSearchActionPerformed(evt);
            }
        });

        loaiPhToSearch.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        loaiPhToSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiPhToSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Loại phòng:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Đơn giá:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(donGiaToSearch, 0, 85, Short.MAX_VALUE)
                    .addComponent(filterTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 150, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueToSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loaiPhToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(filterTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(valueToSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(donGiaToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loaiPhToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(240, 236, 227));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(89, 110, 121));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TRA CỨU PHÒNG");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 515, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void donGiaToSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donGiaToSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_donGiaToSearchActionPerformed

    private void loaiPhToSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiPhToSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiPhToSearchActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YC3Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YC3Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YC3Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YC3Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YC3Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> donGiaToSearch;
    private javax.swing.JComboBox<String> filterTypeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> loaiPhToSearch;
    private javax.swing.JTextField valueToSearchTxt;
    // End of variables declaration//GEN-END:variables
}
