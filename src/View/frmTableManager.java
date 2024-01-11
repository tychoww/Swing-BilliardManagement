package View;

import DAO.CategoryDAO;
import DAO.CustomerDAO;
import DAO.DishDAO;
import DAO.InvoiceDAO;
import DAO.InvoiceDetailDAO;
import DAO.InvoiceDetailTableDAO;
import DAO.TableDAO;
import DTO.Account;
import DTO.Category;
import DTO.Customer;
import DTO.Dish;
import DTO.Invoice;
import DTO.InvoiceDetailTable;
import DTO.Table;
import Helpers.CboCategoryItem;
import Helpers.CboDishItem;
import Helpers.DateTimeHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author https://github.com/tychoww
 */
public final class frmTableManager extends javax.swing.JFrame {
    private Account currentAccount; // Current user account
   
    /**
     * Getter for the current user account.
     * @return The current user account.
     */
    public Account getCurrentAccount() {
        return currentAccount;
    }
    
    /**
     * Setter for the current user account. Also triggers the `changeAccount` method.
     * @param value The new current user account.
     */
    public void setCurrentAccount(Account value) {
       currentAccount = value;
       changeAccount(currentAccount.getRole());
    }
    
    /**
     * Constructor for `frmTableManager` that takes an `Account` parameter.
     * Initializes the frame, sets the current account, and loads tables and categories.
     * @param acc The user account associated with this frame.
     */
//    public frmTableManager(Account acc) {
//        initComponents();
//        this.setCurrentAccount(acc);
//        loadTable();
//        loadCategory();
//    }
    
    /**
     * Default constructor for `frmTableManager`.
     * Initializes the frame, sets the current account to its current value, and loads tables and categories.
     */
    public frmTableManager() {
        initComponents();
        // this.setCurrentAccount(currentAccount);
        loadTable();
        loadCategory();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        txtTotalPriceForInvoice = new javax.swing.JTextField();
        btnPayForInvoice = new javax.swing.JButton();
        txtCustomerPhone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();
        txtTotalPriceForAllPlayTime = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        cboCategory = new javax.swing.JComboBox<>();
        cboDish = new javax.swing.JComboBox<>();
        btnAddDish = new javax.swing.JButton();
        spinDishQuantiy = new javax.swing.JSpinner();
        scrollPane1 = new java.awt.ScrollPane();
        flpTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvoiceDetail = new javax.swing.JTable();
        tableManagementMenu = new javax.swing.JMenuBar();
        adminTableItem = new javax.swing.JMenu();
        accountTableItem = new javax.swing.JMenu();
        updateAccountItem = new javax.swing.JMenuItem();
        logoutAccountItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý quán bi-a");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTotalPriceForInvoice.setEditable(false);
        txtTotalPriceForInvoice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotalPriceForInvoice.setText("0");

        btnPayForInvoice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPayForInvoice.setText("Thanh toán");
        btnPayForInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayForInvoiceActionPerformed(evt);
            }
        });

        txtCustomerPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomerPhoneFocusLost(evt);
            }
        });

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
                        .addComponent(txtTotalPriceForInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPayForInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerName)
                            .addComponent(txtCustomerAddress)
                            .addComponent(txtCustomerPhone))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 45, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPriceForInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPayForInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        btnCloseTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTableActionPerformed(evt);
            }
        });

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

        txtTableTiming.setEditable(false);
        txtTableTiming.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtTableTiming.setText("00:00:00");

        txtTablePrice.setEditable(false);
        txtTablePrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtTablePrice.setText("0");

        jLabel1.setText("Tổng tiền:");

        txtTotalPriceForAllPlayTime.setEditable(false);
        txtTotalPriceForAllPlayTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtTotalPriceForAllPlayTime.setText("0");
        txtTotalPriceForAllPlayTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

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
                        .addComponent(txtTimeCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                        .addComponent(txtTimeCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTableTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtDateCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCloseTable, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotalPriceForAllPlayTime))
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
                    .addComponent(txtTablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotalPriceForAllPlayTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoryItemStateChanged(evt);
            }
        });

        btnAddDish.setText("Đặt món");
        btnAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDishActionPerformed(evt);
            }
        });

        spinDishQuantiy.setValue(1);

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
                .addComponent(spinDishQuantiy, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddDish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnAddDish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(spinDishQuantiy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        tableInvoiceDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên món", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tableInvoiceDetail);

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
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Events">
    /**
     * Event: Logout AccountItem clicked.
     * Description: Handles the action when the "Logout" menu item is clicked. 
     *              Performs the following actions:
     *              - Closes the current form.
     *              - Opens the login form for the user to log in again.
     */
    private void logoutAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAccountItemActionPerformed
        dispose();
        frmLogin f = new frmLogin();
        f.setVisible(true);
    }//GEN-LAST:event_logoutAccountItemActionPerformed
    
    /**
     * Event: btnOpenTable (Open Table) button clicked.
     * Description: Handles the action when the "Open Table" button is clicked.
     *              Performs the following actions:
     *              1. Checks if a table is selected.
     *              2. If no table is selected, shows a message to select a table.
     *              3. If a table is selected:
     *                 a. Gets the ID of the selected table.
     *                 b. Checks if there is an unpaid invoice for the selected table.
     *                 c. If no invoice exists, creates a new invoice for the table.
     *                 d. Changes the status of the table to "occupied" after successful creation.
     *                 e. Updates the display status of the selected table.
     *                 f. Retrieves the unpaid invoice for the selected table.
     *              4. Sets the check-in date and time on the form based on the invoice information.
     */
    private void btnOpenTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenTableActionPerformed
        // Step 1: Check if a table is selected
        Table tableSelected = (Table) lblSelectedTable.getClientProperty("tag");
        if (tableSelected == null) {
            showMessageDialog(null, "Hãy chọn bàn!");
        } else {
            // Step 2: Get the ID of the selected table
            int tableID = tableSelected.getTableID();

            // Step 3: Check if there is an unpaid invoice for the selected table
            Invoice unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableID);

            // Step 3a: If no invoice exists, create a new invoice for the table
            if (unpaidInvoice == null) {
                InvoiceDAO.getInstance().createInvoice(tableID);

                // Step 3b: Change the status of the table to "occupied" in databse
                TableDAO.getInstance().changeStatusTable(tableID, "occupied");

                // Step 3c: Update the display status of the selected table in Interface
                changeTableStatus(tableID);

                // Step 3d: Retrieve the unpaid invoice for the selected table
                unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableID);
            }

            // Step 4: Set the check-in date and time on the form based on the invoice information
            LocalDateTime dateTimeCheckin = unpaidInvoice.getDateCheckin();
            txtDateCheckin.setText(DateTimeHelper.formatSqlDateShort(dateTimeCheckin));
            txtTimeCheckin.setText(DateTimeHelper.formatSqlTimeShort(dateTimeCheckin));
        }
    }//GEN-LAST:event_btnOpenTableActionPerformed
    
    /**
     * Event: cboCategory (Category ComboBox) item state changed.
     * Description: Handles the action when the selected item in the category ComboBox changes.
     *              Performs the following actions:
     *              1. Checks if the item state change is due to selecting an item.
     *              2. If an item is selected:
     *                 a. Retrieves the selected category item from the ComboBox.
     *                 b. Loads the list of dishes based on the selected category ID.
     * @param evt ItemEvent representing the change in the state of the ComboBox item.
     */
    private void cboCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoryItemStateChanged
        // Step 1: Check if the item state change is due to selecting an item
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Step 2: If an item is selected
            // Step 2a: Retrieve the selected category item from the ComboBox
            CboCategoryItem selectedCategoryItem = (CboCategoryItem) cboCategory.getSelectedItem();

            // Step 2b: Load the list of dishes based on the selected category ID
            loadDishListByCategoryID(selectedCategoryItem.getValue());
        }
    }//GEN-LAST:event_cboCategoryItemStateChanged
    
    /**
     * Event: btnAddDish (Add Dish Button) clicked.
     * Description: Handles the action when the user adds a dish to a table. 
     *              There are several scenarios:
     * 
     * - Scenario 1: The table does not have an existing invoice (Invoice):
     *   + Create a new invoice for the table.
     *   + Obtain the ID of the newly created invoice (Max Invoice ID).
     *   + Insert an Invoice Detail based on the newly created invoice ID (Max Invoice ID).
     * 
     * - Scenario 2: The table already has an invoice:
     *   + If the dish (Dish) already exists in the invoice detail, update the dish in the invoice detail.
     *   + If the dish (Dish) does not exist in the invoice detail, insert the dish in the invoice detail.
     * 
     * - Finally, change the status of the table to "Occupied".
     * - Update the interface of the table after adding the dish.
     * 
     * @param evt ActionEvent representing the user's action.
     */
    private void btnAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDishActionPerformed
        // The table data is stored in the object tag of lblSelectedTable
        Table tableSelected = (Table) lblSelectedTable.getClientProperty("tag");

        // If no table is selected
        if (tableSelected == null) {
            // Show notification: User must select a table before adding a dish
            showMessageDialog(null, "Hãy chọn bàn!");
        } else {
            // Get the table ID from the selected table
            int tableID = tableSelected.getTableID();
            // Declare variables
            int invoiceID, dishID, quantity;

            // Retrieve the CboDishItem object stored in cboDish and store it in the selectedDishItem variable
            CboDishItem selectedDishItem = (CboDishItem) cboDish.getSelectedItem();
            // Assign values to variables
            dishID = selectedDishItem.getValue();
            quantity = (int) spinDishQuantiy.getValue();

            // Retrieve unpaid invoices for the specified table ID
            Invoice unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableID);

            // If unpaidInvoice is null, the table already has an invoice
            if (unpaidInvoice == null) {
                
                // Create a new invoice for the table
                InvoiceDAO.getInstance().createInvoice(tableID);
                // Obtain the ID of the newly created invoice (Max Invoice ID)
                invoiceID = InvoiceDAO.getInstance().GetMaxInvoiceID();
                // Add dishes to the invoice details of the newly created invoice
                InvoiceDetailDAO.getInstance().addInvoiceDetail(invoiceID, dishID, quantity);
            }
            // If unpaidInvoice is not null, the table already has no invoice
            else {
                // Get the invoice ID of the selected table
                invoiceID = unpaidInvoice.getInvoiceID();
                // If this dish already exists in the invoice details, update the dish
                if (InvoiceDetailDAO.getInstance().isExistingDishInInvoiceDetail(invoiceID, dishID)) {
                    InvoiceDetailDAO.getInstance().updateInvoiceDetail(invoiceID, dishID, quantity);
                }
                // If this dish does not exist in the invoice details, insert the dish
                else {
                    InvoiceDetailDAO.getInstance().addInvoiceDetail(invoiceID, dishID, quantity);
                }
            }

            // Change the status of the table to "Occupied" in the database
            TableDAO.getInstance().changeStatusTable(tableID, "occupied"); 
            // Update the status in the interface
            changeTableStatus(tableID);
            loadInvoiceDetail(tableID);
        }
    }//GEN-LAST:event_btnAddDishActionPerformed

    private void btnCloseTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTableActionPerformed
        Table tableSelected = (Table) lblSelectedTable.getClientProperty("tag");
            if (tableSelected == null) {
            showMessageDialog(null, "Hãy chọn bàn!");
        } else {
            int tableID = tableSelected.getTableID();
            loadInvoiceDetail(tableID);
        }
    }//GEN-LAST:event_btnCloseTableActionPerformed

    private void txtCustomerPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerPhoneFocusLost
        String customerPhoneInput = txtCustomerPhone.getText();
        Customer foundCustomer = CustomerDAO.getInstance().getCustomerByPhone(customerPhoneInput);
        if(foundCustomer != null) {
            showMessageDialog(null, "Đã tìm thấy khách hàng trong hệ thống!");
            txtCustomerName.setText(foundCustomer.getCustomerName());
            txtCustomerAddress.setText(foundCustomer.getAddress());
        }
    }//GEN-LAST:event_txtCustomerPhoneFocusLost

    private void btnPayForInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayForInvoiceActionPerformed
        Table tableSelected = (Table) lblSelectedTable.getClientProperty("tag");
        if(tableSelected == null) {
            showMessageDialog(null, "Hãy chọn bàn!");
        }
        else {
            int tableID = tableSelected.getTableID();
            Invoice unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableSelected.getTableID());
            int invoiceID = unpaidInvoice.getInvoiceID();
            double totalPrice = Double.parseDouble(txtTotalPriceForInvoice.getText());
            
            if(unpaidInvoice.getDateCheckout() == null) {
                showMessageDialog(null, "Hãy đóng bàn trước khi thanh toán!");
            } else {        
                String customerPhoneInput = txtCustomerPhone.getText();
                String customerNameInput = txtCustomerName.getText();
                String customerAddressInput = txtCustomerAddress.getText();
                int customerID = 0;

                Customer foundCustomer = CustomerDAO.getInstance().getCustomerByPhone(customerPhoneInput);

                if(foundCustomer == null) { // The customer does not exist in the system
                    if(!customerPhoneInput.isEmpty() && !customerNameInput.isEmpty() && !customerAddressInput.isEmpty()) {               
                        CustomerDAO.getInstance().createCustomer(customerNameInput, customerAddressInput, customerPhoneInput);
                        customerID = CustomerDAO.getInstance().GetMaxCustomerID();
                    }
                }
                else {
                    customerID = CustomerDAO.getInstance().getCustomerByPhone(customerPhoneInput).getCustomerID();
                }
                // Make payments
                InvoiceDAO.getInstance().payForInvoice(invoiceID, customerID, totalPrice);

                // updates the state object of the selected table
                tableSelected.setStatus("available");
                lblSelectedTable.putClientProperty("tag", tableSelected);

                // Re-update the database
                TableDAO.getInstance().changeStatusTable(tableID, "available");      
                // Update the table interface status
                changeTableStatus(tableID);
                
                txtDateCheckin.setText("00/00/0000");
                txtTimeCheckin.setText("00:00:00");
                txtDateCheckout.setText("00/00/0000");
                txtTimeCheckout.setText("00:00:00");
                txtTableTiming.setText("00:00:00");
                txtTablePrice.setText("0");
                txtTotalPriceForAllPlayTime.setText("0");
                txtCustomerPhone.setText("");
                txtCustomerName.setText("");
                txtCustomerAddress.setText("");
                txtTotalPriceForInvoice.setText("0");
                
                loadInvoiceDetail(tableID);
            }
        }
    }//GEN-LAST:event_btnPayForInvoiceActionPerformed

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
    
    // <editor-fold defaultstate="collapsed" desc="Account">
    /**
     * Change the account role and update UI accordingly.
     * 
     * @param role The role of the account to be changed.
     */
    private void changeAccount(String role) {
        // Enable or disable the adminTableItem based on the role
        adminTableItem.setEnabled("admin".equals(role));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="InvoiceDetail">
    private void loadInvoiceDetail(int tableID) {
        double totalPriceForInvoice = 0; // Total amount payable for 1 invoice detail

        // Food table
        List<InvoiceDetailTable> invoiceDetailTableList = InvoiceDetailTableDAO.getInstance().getListInvoiceDetailByTableID(tableID);
        // Create a DefaultTableModel with column names
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Tên món", "Số lượng", "Đơn giá", "Thành tiền"}, 0);
        // Add data to the DefaultTableModel
        for (InvoiceDetailTable item : invoiceDetailTableList) {
            totalPriceForInvoice += item.getTotalPrice();
            Object[] rowData = {item.getDishName(), item.getQuantity(), item.getPrice(), item.getTotalPrice()};
            tableModel.addRow(rowData);
        }
        // Set the DefaultTableModel to the JTable
        tableInvoiceDetail.setModel(tableModel);

        // Play time table
        Invoice unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableID);
        if (unpaidInvoice != null) {
            Table tableSelected = (Table) lblSelectedTable.getClientProperty("tag");
            int invoiceID = unpaidInvoice.getInvoiceID();
            InvoiceDAO.getInstance().updateInvoiceCheckout(invoiceID);

            // cập nhật lại unpaidInvoice
            unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableID);

            LocalDateTime dateTimeCheckin = unpaidInvoice.getDateCheckin();
            LocalDateTime dateTimeCheckout = unpaidInvoice.getDateCheckout();
            txtDateCheckout.setText(DateTimeHelper.formatSqlDateShort(dateTimeCheckout));
            txtTimeCheckout.setText(DateTimeHelper.formatSqlTimeShort(dateTimeCheckout));

            if (dateTimeCheckin != null && dateTimeCheckout != null) {
                txtTableTiming.setText(DateTimeHelper.calculateDuration(dateTimeCheckin, dateTimeCheckout));

                long minutesPlayed = DateTimeHelper.calculateDurationToMinute(dateTimeCheckin, dateTimeCheckout);
                double tablePrice = tableSelected.getPrice();
                totalPriceForInvoice = totalPriceForInvoice + (double) minutesPlayed / 60 * tablePrice;
            }
        }

        txtTotalPriceForInvoice.setText(String.valueOf(totalPriceForInvoice));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Table">
    /**
     * Load table information into buttons and add them to the flpTable (FlowLayout) container.
     * Each button represents a table and displays its name, status, and occupancy information.
     */
    final void loadTable() {
        // Retrieve a list of all tables from the database
        List<Table> tableList = TableDAO.getInstance().getAllTableList();

        for (Table item : tableList) {
            JButton btn = new JButton();
            // Associate the Table object with the button using the "tag" property
            btn.putClientProperty("tag", item);
            btn.setPreferredSize(new Dimension(TableDAO.TableWidth, TableDAO.TableHeight));

            // Add ActionListener to handle button click events
            btn.addActionListener((ActionEvent e) -> {
                // Reset display fields
                txtDateCheckin.setText("00/00/0000");
                txtTimeCheckin.setText("00:00:00");
                txtDateCheckout.setText("00/00/0000");
                txtTimeCheckout.setText("00:00:00");
                txtTableTiming.setText("00:00:00");
                txtTablePrice.setText("0");
                txtTotalPriceForAllPlayTime.setText("0");
                txtCustomerPhone.setText("");
                txtCustomerName.setText("");
                txtCustomerAddress.setText("");
                txtTotalPriceForInvoice.setText("0");

                // Get the associated Table object from the button's "tag"
                Table table = (Table) btn.getClientProperty("tag");

                // Set selected table name
                lblSelectedTable.setText(table.getTableName());
                lblSelectedTable.putClientProperty("tag", table);

                // Set table price
                txtTablePrice.setText(Double.toString(table.getPrice()));

                // Set date check-in and date check-out if an unpaid invoice exists
                Invoice unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(item.getTableID());
                if (unpaidInvoice != null) {
                    LocalDateTime dateTimeCheckin = unpaidInvoice.getDateCheckin();
                    LocalDateTime dateTimeCheckout = unpaidInvoice.getDateCheckout();

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
                        
                        long minutesPlayed = DateTimeHelper.calculateDurationToMinute(dateTimeCheckin, dateTimeCheckout);
                        double tablePrice = table.getPrice();
                        double totalPriceForAllPlaytime = (double) minutesPlayed / 60 * tablePrice;
                        txtTotalPriceForAllPlayTime.setText(String.valueOf(totalPriceForAllPlaytime));
                    }
                    if (dateTimeCheckin != null && dateTimeCheckout == null) {
                        txtTableTiming.setText(DateTimeHelper.calculateDuration(dateTimeCheckin, LocalDateTime.now()));
                        
                        long minutesPlayed = DateTimeHelper.calculateDurationToMinute(dateTimeCheckin, LocalDateTime.now());
                        double tablePrice = table.getPrice();
                        double totalPriceForAllPlaytime = (double) minutesPlayed / 60 * tablePrice;
                        txtTotalPriceForAllPlayTime.setText(String.valueOf(totalPriceForAllPlaytime));
                    }
                }
                
                loadInvoiceDetail(table.getTableID());
            });

            // Customize button appearance based on table status
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

            // Add the button to the flpTable container
            flpTable.add(btn);
        }
    }
    
    /**
     * Find and return the JButton corresponding to the specified tableID from a list of buttons.
     *
     * @param buttons The list of buttons to search through.
     * @param tableID The ID of the table associated with the button to be found.
     * @return The JButton corresponding to the specified tableID, or null if not found.
     */
    private JButton findButtonByTableID(List<Component> buttons, int tableID) {
        Optional<JButton> optionalButton = buttons.stream()
                .filter(b -> b instanceof JButton)
                .map(b -> (JButton) b)
                .filter(b -> {
                    Table table = (Table) b.getClientProperty("tag");
                    return table != null && table.getTableID() == tableID;
                })
                .findFirst();

        return optionalButton.orElse(null);
    }
    
    /**
    * Change the status and appearance of a table button based on its invoice status.
    * If the table has an unpaid invoice, set the button background color to indicate it is occupied.
    * If the table does not have an unpaid invoice, set the button background color to indicate it is available.
    *
    * @param tableID The ID of the table for which the status and appearance will be changed.
    */
    private void changeTableStatus(int tableID) {
        // Step 1: Get the list of buttons in flpTable
        Component[] components = flpTable.getComponents();
        List<Component> buttonList = Arrays.asList(components);

        // Step 2: Find the button corresponding to the specified tableID
        JButton selectedButton = findButtonByTableID(buttonList, tableID);

        // Step 3: Change the status and appearance of the button based on the table's invoice status
        if (selectedButton != null) {
            Table table = (Table) selectedButton.getClientProperty("tag");

            Invoice unpaidInvoice = InvoiceDAO.getInstance().getUnpaidInvoiceByTableID(tableID);
            if (unpaidInvoice != null) {  // If the table has an unpaid invoice
                selectedButton.setBackground(Color.decode("#FFB6C1"));
                selectedButton.setText("<html>" + table.getTableName() + "<br>Có người</html>");
            } else {  // If the table does not have an unpaid invoice
                selectedButton.setBackground(Color.decode("#ADD8E6"));
                selectedButton.setText("<html>" + table.getTableName() + "<br>Trống</html>");
            }
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Category">
    /**
    * Load the list of categories from the database and populate them into the ComboBox.
    */
    private void loadCategory() {
        // Step 1: Retrieve the list of categories from the database
        List<Category> categoryList = CategoryDAO.getInstance().getAllCategories();

        // Step 2: Populate the retrieved categories into the ComboBox
        for (Category item : categoryList) {
            cboCategory.addItem(new CboCategoryItem(item.getCategoryName(), item.getCategoryID()));
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Dish">
    /**
    * Load the list of dishes based on the specified category ID and populate them into the ComboBox.
    * 
    * @param categoryID The ID of the selected category for filtering dishes.
    */
    void loadDishListByCategoryID(int categoryID) {
        // Step 1: Remove all existing items from the ComboBox
        cboDish.removeAllItems();

        // Step 2: Retrieve the list of dishes from the database based on the specified category ID
        List<Dish> dishList = DishDAO.getInstance().getDishListByCategoryID(categoryID);

        // Step 3: Populate the retrieved dishes into the ComboBox
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
    private javax.swing.JButton btnAddDish;
    private javax.swing.JButton btnCloseTable;
    private javax.swing.JButton btnOpenTable;
    private javax.swing.JButton btnPayForInvoice;
    private javax.swing.JComboBox<CboCategoryItem> cboCategory;
    private javax.swing.JComboBox<CboDishItem> cboDish;
    private javax.swing.JPanel flpTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblSelectedTable;
    private javax.swing.JMenuItem logoutAccountItem;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JSpinner spinDishQuantiy;
    private javax.swing.JTable tableInvoiceDetail;
    private javax.swing.JMenuBar tableManagementMenu;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JFormattedTextField txtDateCheckin;
    private javax.swing.JFormattedTextField txtDateCheckout;
    private javax.swing.JFormattedTextField txtTablePrice;
    private javax.swing.JFormattedTextField txtTableTiming;
    private javax.swing.JFormattedTextField txtTimeCheckin;
    private javax.swing.JFormattedTextField txtTimeCheckout;
    private javax.swing.JFormattedTextField txtTotalPriceForAllPlayTime;
    private javax.swing.JTextField txtTotalPriceForInvoice;
    private javax.swing.JMenuItem updateAccountItem;
    // End of variables declaration//GEN-END:variables
}
