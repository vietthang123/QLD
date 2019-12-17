/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.GiaoVienDAO;
import INTER.IGiaoVienDAO;
import INTER.IMonHocDAO;
import MODEL.Check;
import MODEL.GiaoVien;
import MODEL.MonHoc;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anonymous
 */
public class frmGiaoVien extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    ArrayList<MonHoc> listmh = null;
    ArrayList<GiaoVien> listgv = null;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

    public frmGiaoVien() {
        try {
            initComponents();
            dcbm = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("DAO.MonHocDAO").newInstance();
            listmh = monHocDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbm.addElement(mh.getMamh());
            }
            cbgiangday.setModel(dcbm);

            dtm.addColumn("ID Giáo Viên");
            dtm.addColumn("Họ Tên");
            dtm.addColumn("Email");
            dtm.addColumn("Môn Giảng Dạy");
            dtm.addColumn("Ngày Sinh");
            dtm.addColumn("Địa Chỉ");
            dtm.addColumn("Giới Tính");
            dtm.addColumn("Số ĐT");
            loaddata();
            // loaddata();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loaddata() {
        try {
            IGiaoVienDAO giaoVienDAO = (IGiaoVienDAO) Class.forName("DAO.GiaoVienDAO").newInstance();
            listgv = new GiaoVienDAO().getAll();
            for (GiaoVien gv : listgv) {
                dtm.addRow(toObjectsData(gv));
            }
            tblgiaovien.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Object[] toObjectsData(GiaoVien gv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(gv.getNgaysinh());
        boolean flag = gv.isGioitinh();
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }

        Object[] objectsData = {gv.getMagv(), gv.getHotengv(), gv.getEmail(), gv.getMamh(), date, gv.getDiachi(), gioitinh, gv.getSdt()};
        return objectsData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblngaysinh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JTextField();
        lblMaGV = new javax.swing.JTextField();
        lblDienThoai = new javax.swing.JTextField();
        rdbsex = new javax.swing.JRadioButton();
        lblDiachi = new javax.swing.JTextField();
        cbgiangday = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnnew = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblgiaovien = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 153));

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("Ngày Sinh");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Giới Tính");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("Điện Thoại");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("Email");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Địa Chỉ");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Mã Giảng Viên");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Họ Tên");

        rdbsex.setText("Nam/Nữ");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Môn Giảng Dạy");

        jLabel3.setText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(lblMaGV, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(cbgiangday, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdbsex)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(lblDiachi)
                    .addComponent(lblDienThoai))
                .addGap(0, 172, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdbsex)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbgiangday)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(204, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("GIÁO VIÊN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnnew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnew.setForeground(new java.awt.Color(255, 0, 0));
        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Add.png"))); // NOI18N
        btnnew.setText("New");
        btnnew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });
        jPanel1.add(btnnew);

        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 0, 0));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Upload.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.setEnabled(false);
        btnupdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate);

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 0, 0));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Delete.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.setEnabled(false);
        btndelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btndelete.setIconTextGap(2);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete);

        btnreset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreset.setForeground(new java.awt.Color(255, 0, 0));
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Refresh.png"))); // NOI18N
        btnreset.setText("Reset");
        btnreset.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        tblgiaovien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã GV", "Họ Tên", "Email", "Môn Dạy", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblgiaovien.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblgiaovien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblgiaovienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblgiaovien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(lblMaGV.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblMaGV.setText("");
            lblMaGV.requestFocus();
            return false;
        } else if (!c.checkSpace(lblHoTen.getText()) || !c.check(lblHoTen.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblHoTen.setText("");
            lblHoTen.requestFocus();
            return false;

        } else if (!c.checkSpace(lblEmail.getText()) || !c.check(lblEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Email nhập sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblEmail.setText("");
            lblEmail.requestFocus();
            return false;

        } else if (!c.checkSpace(lblDiachi.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập địa chỉ sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblDiachi.setText("");
            lblDiachi.requestFocus();
            return false;

        } else if (!c.checkSpace(lblDienThoai.getText()) || !c.checkPhone(lblDienThoai.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập phone sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblDienThoai.setText("");
            lblDienThoai.requestFocus();
            return false;
        }
        return true;
    }
    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed

        String magv = lblMaGV.getText();
        String hoten = lblHoTen.getText();
        String email = lblEmail.getText();
        String mamh = listmh.get(cbgiangday.getSelectedIndex()).getMamh();
        String ngaysinh = lblngaysinh.getText();
        String diachi = lblDiachi.getText();
        boolean gioitinh = rdbsex.isSelected();
        String sdt = lblDienThoai.getText();

        Check c = new Check();
        if (!checkinfo()) {
            return;
        }
        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblngaysinh.setText("");
            lblngaysinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        GiaoVien giaoVien = new GiaoVien(magv, hoten, d, gioitinh, email, diachi, sdt, mamh);
        ArrayList<GiaoVien> listCheck = new GiaoVienDAO().CheckID(magv);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            lblMaGV.setText("");
            lblMaGV.requestFocus();

        } else {
            GiaoVien insert = new GiaoVienDAO().addNew(giaoVien);
            if (insert != null) {
                showAll();
            }
        }
        loaddata();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String magv = lblMaGV.getText();
        String hoten = lblHoTen.getText();
        String email = lblEmail.getText();
        String mamh = listmh.get(cbgiangday.getSelectedIndex()).getMamh();
        String ngaysinh = lblngaysinh.getText();
        String diachi = lblDiachi.getText();
        boolean gioitinh = rdbsex.isSelected();
        String sdt = lblDienThoai.getText();

        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            lblngaysinh.setText("");
            lblngaysinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        GiaoVien giaoVien = new GiaoVien(magv, hoten, d, gioitinh, email, diachi, sdt, mamh);
        GiaoVien update = new GiaoVienDAO().updateByID(giaoVien);
        if (update != null) {
            showAll();
        }
        btnnew.setEnabled(true);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        lblMaGV.setEnabled(true);
        loaddata();
    }//GEN-LAST:event_btnupdateActionPerformed
    public void resetForm() {
        lblMaGV.setText("");
        lblHoTen.setText("");
        lblEmail.setText("");
        lblDiachi.setText("");
        lblDienThoai.setText("");
        lblngaysinh.setText("");
        lblMaGV.requestFocus();
    }
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {

            String magv = lblMaGV.getText();
            try {
                new GiaoVienDAO().deleteIDGV(magv);
            } catch (SQLException ex) {
                Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            loaddata();
            btnnew.setEnabled(true);
            btnupdate.setEnabled(false);
            btndelete.setEnabled(false);
            lblMaGV.setEnabled(true);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        this.resetForm();
    }//GEN-LAST:event_btnresetActionPerformed

    private void tblgiaovienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblgiaovienMouseClicked
        // TODO add your handling code here:
        lblMaGV.setText(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 0).toString());
        lblHoTen.setText(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 1).toString());
        lblEmail.setText(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 2).toString());
        cbgiangday.setSelectedItem(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 3).toString());
        lblngaysinh.setText(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 4).toString());
        lblDiachi.setText(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 5).toString());
        lblDienThoai.setText(tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 7).toString());
        String sex = tblgiaovien.getValueAt(tblgiaovien.getSelectedRow(), 6).toString();
        if (sex.equals("true")) {
            rdbsex.setSelected(true);
        } else {
            rdbsex.setSelected(false);
        }
        btnnew.setEnabled(false);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        lblMaGV.setEnabled(false);
    }//GEN-LAST:event_tblgiaovienMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox cbgiangday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblDiachi;
    private javax.swing.JTextField lblDienThoai;
    private javax.swing.JTextField lblEmail;
    private javax.swing.JTextField lblHoTen;
    private javax.swing.JTextField lblMaGV;
    private javax.swing.JTextField lblngaysinh;
    private javax.swing.JRadioButton rdbsex;
    private javax.swing.JTable tblgiaovien;
    // End of variables declaration//GEN-END:variables

    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        int selectedIndex = cbgiangday.getSelectedIndex();
        MonHoc getmh = listmh.get(selectedIndex);
        ArrayList<GiaoVien> list = new GiaoVienDAO().findByIDMonHoc(getmh.getMamh());
        for (GiaoVien gv : list) {
            Vector vector = new Vector();
            vector.add(gv.getMagv());
            vector.add(gv.getHotengv());
            vector.add(gv.getMamh());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(gv.getNgaysinh()));
            if (gv.isGioitinh() == true) {
                vector.add("Nam");
            } else {
                vector.add("Nữ");
            }
            vector.add(gv.getEmail());
            vector.add(gv.getDiachi());
            vector.add(gv.getSdt());
            dtm.addRow(vector);
        }
        resetForm();

    }
}
