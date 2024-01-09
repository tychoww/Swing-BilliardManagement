package View;

import DAO.CategoryDAO;
import DAO.DishDAO;
import DAO.InvoiceDAO;
import DAO.TableDAO;
import DTO.Account;
import DTO.Category;
import DTO.Dish;
import DTO.Invoice;
import DTO.Table;
import Helpers.CboCategoryItem;
import Helpers.CboDishItem;
import Helpers.DateTimeHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author Tychow
 */
public final class frmTableManager extends javax.swing.JFrame {
//    private Account currentAccount;
//    
//    public Account getCurrentAccount() {
//        return currentAccount;
//    }
//    
//    public void setCurrentAccount(Account value) {
//        currentAccount = value;
//        changeAccount(currentAccount.getRole());
//    }
    
//    public frmTableManager(Account acc) {
//        initComponents();
//        // this.setCurrentAccount(acc);
//        loadTable();
//    }
    
    public frmTableManager() {
        initComponents();
        // this.setCurrentAccount(acc);
        loadTable();
        loadCategory();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblSelectedTable = new javax.swing.JLabel();
        btnOpenTable = new javax.swing.JButton();
        btnCloseTable = new javax.swing.JButton();
        txtDateCheckin = new javax.swing.JFormattedTextField();
        txtTimeCheckin = new javax.swing.JFormattedTextField();
        txtDateCheckout = new javax.swing.JFormattedTextField();
        txtTimeCheckout = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTableTiming = new javax.swing.JFormattedTextField();
        txtTablePrice = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        cboCategory = new javax.swing.JComboBox<>();
        cboDish = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        scrollPane1 = new java.awt.ScrollPane();
        flpTable = new javax.swing.JPanel();
        tableManagementMenu = new javax.swing.JMenuBar();
        adminTableItem = new javax.swing.JMenu();
        accountTableItem = new javax.swing.JMenu();
        updateAccountItem = new javax.swing.JMenuItem();
        logoutAccountItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý quán bi-a");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("12120120102");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Thanh toán");

        jLabel2.setText("Số điện thoại khách hàng:");

        jLabel3.setText("Tên khách hàng:");

        jLabel4.setText("Địa chỉ khách hàng:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tổng tiền: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 45, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSelectedTable.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSelectedTable.setText("Bàn");

        btnOpenTable.setText("Mở bàn");
        btnOpenTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenTableActionPerformed(evt);
            }
        });

        btnCloseTable.setText("Đóng bàn");

        txtDateCheckin.setEditable(false);
        txtDateCheckin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDateCheckin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtDateCheckin.setText("00/00/0000");

        txtTimeCheckin.setEditable(false);
        txtTimeCheckin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimeCheckin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtTimeCheckin.setText("00:00:00");

        txtDateCheckout.setEditable(false);
        txtDateCheckout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDateCheckout.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtDateCheckout.setText("00/00/0000");

        txtTimeCheckout.setEditable(false);
        txtTimeCheckout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimeCheckout.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtTimeCheckout.setText("00:00:00");

        jLabel6.setText("Thời gian sử dụng:");

        jLabel7.setText("Số tiền 1 giờ chơi:");

        txtTableTiming.setBackground(new java.awt.Color(242, 242, 242));
        txtTableTiming.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtTableTiming.setText("00:00:00");

        txtTablePrice.setBackground(new java.awt.Color(242, 242, 242));
        txtTablePrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtTablePrice.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnOpenTable, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimeCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTableTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimeCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCloseTable, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(lblSelectedTable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblSelectedTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOpenTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDateCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimeCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCloseTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDateCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimeCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtTableTiming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoryItemStateChanged(evt);
            }
        });

        jButton1.setText("Đặt món");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCategory, 0, 298, Short.MAX_VALUE)
                    .addComponent(cboDish, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))))
        );

        flpTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        flpTable.setLayout(new java.awt.GridLayout(7, 3));
        scrollPane1.add(flpTable);

        adminTableItem.setText("Admin");
        tableManagementMenu.add(adminTableItem);

        accountTableItem.setText("Thông tin tài khoản");

        updateAccountItem.setText("Cập nhật");
        accountTableItem.add(updateAccountItem);

        logoutAccountItem.setText("Đăng xuất");
        logoutAccountItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutAccountItemActionPerformed(evt);
            }
        });
        accountTableItem.add(logoutAccountItem);

        tableManagementMenu.add(accountTableItem);

        setJMenuBar(tableManagementMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Events">
    private void logoutAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAccountItemActionPerformed
        dispose();
        frmLogin f = new frmLogin();
        f.setVisible(true);
    }//GEN-LAST:event_logoutAccountItemActionPerformed

    private void btnOpenTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenTableActionPerformed
        Table tableSelected = (Table) lblSelectedTable.getClientProperty("tag");
        if (tableSelected == null) {
            showMessageDialog(null, "Hãy chọn bàn!");
        } else {
            int tableID = tableSelected.getTableID();
            List<Invoice> invoiceList = InvoiceDAO.getInstance().getUnpaidInvoiceListByTableID(tableID);
            // Nếu inovoice của bàn này chưa tạo => tạo mới
            if(invoiceList.isEmpty()) {
                InvoiceDAO.getInstance().createInvoice(tableID);
                loadTable();
                // Lấy lại danh sách invoice sau khi tạo mới
                invoiceList = InvoiceDAO.getInstance().getUnpaidInvoiceListByTableID(tableID);
            }
            LocalDateTime dateTimeCheckin = invoiceList.get(0).getDateCheckin();
            txtDateCheckin.setText(DateTimeHelper.formatSqlDateShort(dateTimeCheckin));
            txtTimeCheckin.setText(DateTimeHelper.formatSqlTimeShort(dateTimeCheckin));
        }
    }//GEN-LAST:event_btnOpenTableActionPerformed

    private void cboCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoryItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            CboCategoryItem selectedItem = (CboCategoryItem) cboCategory.getSelectedItem();
            loadDishListByCategoryID(selectedItem.getValue());
        }
    }//GEN-LAST:event_cboCategoryItemStateChanged
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
    
    // <editor-fold defaultstate="collapsed" desc="Account">
    private void changeAccount(String role) {
        adminTableItem.setEnabled("admin".equals(role));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Invoice">
    private void resetDateField(boolean checkin, boolean checkout, boolean during) {
        if (checkin) {
            txtDateCheckin.setText("00/00/0000");
            txtTimeCheckin.setText("00:00:00");
        }
        if (checkout) {
            txtDateCheckout.setText("00/00/0000");
            txtTimeCheckout.setText("00:00:00");
        }
        if (during) {
            txtDateCheckout.setText("00/00/0000");
            txtTimeCheckout.setText("00:00:00");
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Table">
    final void loadTable() {
        List<Table> tableList = TableDAO.getInstance().getAllTableList();
        for (Table item : tableList) {
            JButton btn = new JButton();
            btn.putClientProperty("tag", item); // Lưu data vào tag của button
            btn.setPreferredSize(new Dimension(TableDAO.TableWidth, TableDAO.TableHeight));
            btn.addActionListener((ActionEvent e) -> {
                // Reset display
                resetDateField(true, true, true);
                
                Table table = (Table) btn.getClientProperty("tag");
                
                // Logic khi click vào table
                // Lưu dữ liệu vào label table để các components khác sử dụng
                lblSelectedTable.putClientProperty("tag", table); 
                
                // Set table name
                lblSelectedTable.setText(table.getTableName());
                // Set table price
                txtTablePrice.setText(Double.toString(table.getPrice()));
                // Set date checkin
                List<Invoice> invoiceList = InvoiceDAO.getInstance().getUnpaidInvoiceListByTableID(item.getTableID());
                if (!invoiceList.isEmpty()) {
                    LocalDateTime dateTimeCheckin = invoiceList.get(0).getDateCheckin();
                    LocalDateTime dateTimeCheckout = invoiceList.get(0).getDateCheckout();
                    
                    if (dateTimeCheckin != null) {
                        txtDateCheckin.setText(DateTimeHelper.formatSqlDateShort(dateTimeCheckin));
                        txtTimeCheckin.setText(DateTimeHelper.formatSqlTimeShort(dateTimeCheckin));
                    }
                    if (dateTimeCheckout != null) {
                        txtDateCheckout.setText(DateTimeHelper.formatSqlDateShort(dateTimeCheckout));
                        txtTimeCheckout.setText(DateTimeHelper.formatSqlTimeShort(dateTimeCheckout));
                    }
                    if (dateTimeCheckin != null && dateTimeCheckout != null) {
                        txtTableTiming.setText(DateTimeHelper.calculateDuration(dateTimeCheckin, dateTimeCheckout));
                    }
                    if (dateTimeCheckin != null && dateTimeCheckout == null) {
                        txtTableTiming.setText(DateTimeHelper.calculateDuration(dateTimeCheckin, LocalDateTime.now()));
                    }
                }
            });
            switch (item.getStatus()) {
                case "occupied" -> {
                    btn.setBackground(Color.decode("#FFB6C1"));
                    btn.setText("<html>" + item.getTableName() + "<br>Có người</html>");
                }
                case "available" -> {
                    btn.setBackground(Color.decode("#ADD8E6"));
                    btn.setText("<html>" + item.getTableName() + "<br>Trống</html>");
                }
                default -> {
                    btn.setBackground(Color.decode("#ADD8E6"));
                    btn.setText("<html>" + item.getTableName() + "<br>Trống</html>");
                }
            }
            flpTable.add(btn);
        } 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Category">
    private void loadCategory() {
        List<Category> categoryList = CategoryDAO.getInstance().getAllCategories();

        for (Category item : categoryList) {
            cboCategory.addItem(new CboCategoryItem(item.getCategoryName(), item.getCategoryID()));
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Dish">
    void loadDishListByCategoryID(int categoryID) {
        cboDish.removeAllItems();
        
        List<Dish> dishList = DishDAO.getInstance().getDishListByCategoryID(categoryID);
        
        for (Dish item : dishList) {
            cboDish.addItem(new CboDishItem(item.getDishName(), item.getDishID()));
        }
    }

    // </editor-fold>
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Running">
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
            java.util.logging.Logger.getLogger(frmTableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmTableManager().setVisible(true);
        });
    }
    // </editor-fold>
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu accountTableItem;
    private javax.swing.JMenu adminTableItem;
    private javax.swing.JButton btnCloseTable;
    private javax.swing.JButton btnOpenTable;
    private javax.swing.JComboBox<CboCategoryItem> cboCategory;
    private javax.swing.JComboBox<CboDishItem> cboDish;
    private javax.swing.JPanel flpTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblSelectedTable;
    private javax.swing.JMenuItem logoutAccountItem;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JMenuBar tableManagementMenu;
    private javax.swing.JFormattedTextField txtDateCheckin;
    private javax.swing.JFormattedTextField txtDateCheckout;
    private javax.swing.JFormattedTextField txtTablePrice;
    private javax.swing.JFormattedTextField txtTableTiming;
    private javax.swing.JFormattedTextField txtTimeCheckin;
    private javax.swing.JFormattedTextField txtTimeCheckout;
    private javax.swing.JMenuItem updateAccountItem;
    // End of variables declaration//GEN-END:variables
}
