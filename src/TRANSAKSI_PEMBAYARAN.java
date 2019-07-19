/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author W10
 */
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksiKU;

public class TRANSAKSI_PEMBAYARAN extends javax.swing.JFrame {
    private DefaultTableModel model;
    
    String no, idp, nmp,almt,tglmsk,tglklr,kd, jns, brg ;
    int hrg, brt;
  int tot,ubar,kmbl;

    /**
     * Creates new form TRANSAKSI_1
     */
    public TRANSAKSI_PEMBAYARAN() {
        initComponents();
        
        
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        tabelpembayaran.setModel(model);
        model.addColumn("NO.MASUK");
        model.addColumn("ID PELANGGAN");
        model.addColumn("NAMA PELANGGAN");
        model.addColumn("ALAMAT");
        model.addColumn("TANGGAL MASUK");
        model.addColumn("TANGGAL PENGAMBILAN");
        model.addColumn("KODE JENIS");
        model.addColumn("JENIS LAUNDRY");
        model.addColumn("JENIS BARANG CUCIAN");
        model.addColumn("HARGA");
        model.addColumn("BERAT");
        model.addColumn("TOTAL BAYAR");
        model.addColumn("UANG BAYAR");
        model.addColumn("KEMBALIAN");
        
        /*fungsi ambil data
        getTRANSAKSI();*/
    }
    
   
    public void getTRANSAKSI_PEMBAYARAN(){
        //kosongkan tabel
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //eksekusi koneksi dan kirimkan query ke database
        try{
            //tes koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
            
            //perintah sql untuk membaca data dari tabel kategori        
            //String sql = "SELECT * FROM JENIS WHERE kode_jenis";
             String sql = "SELECT * FROM pembayaran";
            ResultSet res = stat.executeQuery(sql);
            
            //baca data
            while(res.next()){
                //membuat obyek berjenis array
               /* txtjenis.setText(res.getString("kode_jenis"));
                txtbarang.setText(res.getString("barang"));
                txtharga.setText(res.getString("harga"));*/
                Object[] obj = new Object[15];
                obj[0]=res.getString("no");
                obj[1]=res.getString("tanggal_masuk");
                obj[2]=res.getString("tanggal_keluar");
                obj[3]=res.getString("id_pelanggan");
                obj[4]=res.getString("nama_pelanggan");
                obj[5]=res.getString("alamat");
                obj[6]=res.getString("kode_jenis");
                obj[7]=res.getString("jenis");
                obj[8]=res.getString("barang");
                obj[9]=res.getString("harga");
                obj[10]=res.getString("berat");
                obj[11]=res.getString("total");
                obj[12]=res.getString("bayar");
                obj[13]=res.getString("kembali");
                model.addRow(obj);
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void dataproduk1(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM transaksimasuk WHERE no = '"+ txtno.getText() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
               txttanggal.setText(res.getString("tanggal_masuk"));
               txtidplg.setText(res.getString("id_pelanggan"));
               txtnmplg.setText(res.getString("nama_pelanggan"));
               txtalamat.setText(res.getString("alamat"));
               txtkode.setText(res.getString("kode_jenis"));
               txtjenis.setText(res.getString("jenis"));
               txtbarang.setText(res.getString("barang"));
               txtharga.setText(res.getString("harga"));
               
              
               
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtidplg = new javax.swing.JTextField();
        txtnmplg = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        txtkode = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        txtbarang = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtberat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembali = new javax.swing.JTextField();
        txttglkmbl = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpembayaran = new javax.swing.JTable();
        SIMPAN = new javax.swing.JButton();
        UBAH = new javax.swing.JButton();
        bhitung = new javax.swing.JButton();
        bkembali = new javax.swing.JButton();
        KELUAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TRANSAKSI PEMBAYARAN");

        jLabel2.setText("NO. MASUK");

        jLabel3.setText("ID PELANGGAN");

        jLabel4.setText("NAMA PELANGGAN");

        jLabel5.setText("ALAMAT");

        jLabel6.setText("TANGGAL MASUK");

        jLabel7.setText("KODE LAUNDRY");

        jLabel8.setText("TANGGAL PENGAMBILAN");

        jLabel9.setText("JENIS LAUNDRY");

        jLabel10.setText("JENIS BARANG CUCIAN");

        jLabel11.setText("HARGA  / Kg");

        jLabel12.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel12.setText("BERAT");

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel13.setText("TOTAL BAYAR");

        txtno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnoKeyReleased(evt);
            }
        });

        txtnmplg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmplgActionPerformed(evt);
            }
        });

        txtharga.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txthargaInputMethodTextChanged(evt);
            }
        });

        txtberat.setFont(new java.awt.Font("Prestige Elite Std", 1, 14)); // NOI18N
        txtberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberatActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel14.setText("UANG BAYAR");

        jLabel15.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel15.setText("KEMBALIAN");

        txttotal.setFont(new java.awt.Font("Prestige Elite Std", 1, 14)); // NOI18N

        txtbayar.setFont(new java.awt.Font("Prestige Elite Std", 1, 14)); // NOI18N

        txtkembali.setFont(new java.awt.Font("Prestige Elite Std", 1, 14)); // NOI18N

        jLabel16.setText("JASA LAUNDRY");

        jLabel17.setText("WANGI ARUM");

        tabelpembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelpembayaran);

        SIMPAN.setText("SIMPAN");
        SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIMPANActionPerformed(evt);
            }
        });

        UBAH.setText("BARU");
        UBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UBAHActionPerformed(evt);
            }
        });

        bhitung.setText("HITUNG TOTAL");
        bhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhitungActionPerformed(evt);
            }
        });

        bkembali.setText("HITUNG KEMBALIAN");
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        KELUAR.setText("KELUAR");
        KELUAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KELUARMouseClicked(evt);
            }
        });
        KELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KELUARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(273, 273, 273))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(361, 361, 361)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SIMPAN)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnmplg, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidplg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel15)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel14)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttotal)
                                            .addComponent(txtbayar)
                                            .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(UBAH)
                                .addGap(30, 30, 30)
                                .addComponent(bhitung)
                                .addGap(18, 18, 18)
                                .addComponent(bkembali)))
                        .addGap(103, 103, 103)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(KELUAR)
                                        .addComponent(jLabel11)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(55, 55, 55)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbarang)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(txttglkmbl, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(605, 605, 605))
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txttglkmbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtidplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtnmplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtalamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SIMPAN)
                    .addComponent(UBAH)
                    .addComponent(bhitung)
                    .addComponent(bkembali)
                    .addComponent(KELUAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void loadDatatransaksibayar(){
        no= txtno.getText();
        idp = txtidplg.getText();
        nmp = txtnmplg.getText();
        almt = txtalamat.getText();
        tglmsk= txttanggal.getText();
        tglklr= txttglkmbl.getText();
        kd= txtkode.getText();
        jns= txtjenis.getText();
        brg= txtbarang.getText();
        hrg = Integer.parseInt(txtharga.getText());
        brt = Integer.parseInt(txtberat.getText());
        tot = Integer.parseInt(txttotal.getText());
        ubar = Integer.parseInt(txtbayar.getText());
        kmbl = Integer.parseInt(txtkembali.getText());
    }

public void dataSelect(){
        //deklarasi variabel
        int i = tabelpembayaran.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
        txtno.setText(""+model.getValueAt(i,0));
        txtidplg.setText(""+model.getValueAt(i,1));
        txtnmplg.setText(""+model.getValueAt(i,2));
        txtalamat.setText(""+model.getValueAt(i,3));
        
        txttanggal.setText(""+model.getValueAt(i,4));
        txttglkmbl.setText(""+model.getValueAt(i,5));
        txtkode.setText(""+model.getValueAt(i,6));
        txtjenis.setText(""+model.getValueAt(i,7));
        txtbarang.setText(""+model.getValueAt(i,8));
        txtharga.setText(""+model.getValueAt(i,9));
        txtberat.setText(""+model.getValueAt(i,10));
        txttotal.setText(""+model.getValueAt(i,11));
        txtbayar.setText(""+model.getValueAt(i,12));
        txtkembali.setText(""+model.getValueAt(i,13));
    
    }

public void hitung(){
    int xtotal,total;
    
    int hrg = Integer.parseInt(txtharga.getText());
    int berat = Integer.parseInt(txtberat.getText());
    
    xtotal = hrg*berat;
    txttotal.setText(Integer.toString(xtotal));
   
    
}
public void hitunngkembalian(){
    int total,bayar,hitung;
    
    total = Integer.parseInt(txttotal.getText());
    bayar = Integer.parseInt(txtbayar.getText());
    
    hitung = bayar - total;
    txtkembali.setText(Integer.toString(hitung));
    
}


//mengosongkan form
    public void baru(){
        no ="";
        idp = "";
        nmp = "";
        almt ="";
        tglmsk ="";
        tglklr="";
        kd="";
        jns="";
        brg="";
        hrg = 0;
        brt = 0;
        tot = 0;
        ubar = 0;
        kmbl = 0;
        
        
        txtno.setText(no);
        txttanggal.setText(tglmsk);
        txttglkmbl.setText(tglklr);
        txtidplg.setText(idp);
        txtnmplg.setText(nmp);
        txtalamat.setText(almt);
        txtkode.setText(kd);
        txtjenis.setText(jns);
        txtbarang.setText(brg);
        txtharga.setText(Integer.toString(hrg));
        txtberat.setText(Integer.toString(brt));
        txttotal.setText(Double.toString(tot));
        txtbayar.setText(Double.toString(ubar));
        txtkembali.setText(Double.toString(kmbl));
    }

   
    
    public void simpantransaksi_pembayaran(){
        //panggil fungsi load data
    loadDatatransaksibayar();
        
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =  "INSERT INTO pembayaran (no,id_pelanggan, "
                    + "nama_pelanggan , alamat,tanggal_masuk,tanggal_keluar,kode_jenis, jenis, barang, harga,berat,total, bayar, kembali)" + "VALUES('"+ no +"','"
                    +idp +"','"+ nmp +"','"+ almt +"','"+ tglmsk +"','"+ tglklr +"','"+ kd +"','"+ jns +"','"+ brg +"','"+ hrg +"','"+ brt +"','"
                    + tot +"','"+ ubar +"','"+ kmbl +"')";
            PreparedStatement p = (PreparedStatement) koneksiKU.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getTRANSAKSI_PEMBAYARAN();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

     
    private void txtnmplgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmplgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmplgActionPerformed

    private void SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIMPANActionPerformed
        // TODO add your handling code here:
        simpantransaksi_pembayaran();
    }//GEN-LAST:event_SIMPANActionPerformed

    private void UBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UBAHActionPerformed
        // TODO add your handling code here:
        baru();
    }//GEN-LAST:event_UBAHActionPerformed

    private void txtnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoKeyReleased
        // TODO add your handling code here:
        dataproduk1();
    }//GEN-LAST:event_txtnoKeyReleased

    private void txtberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberatActionPerformed
     
    }//GEN-LAST:event_txtberatActionPerformed

    private void bhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhitungActionPerformed
        hitung();
    }//GEN-LAST:event_bhitungActionPerformed

    private void txthargaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txthargaInputMethodTextChanged
        
    }//GEN-LAST:event_txthargaInputMethodTextChanged

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        hitunngkembalian();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void KELUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KELUARActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_KELUARActionPerformed

    private void KELUARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KELUARMouseClicked
        this.dispose();
    }//GEN-LAST:event_KELUARMouseClicked

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
            java.util.logging.Logger.getLogger(TRANSAKSI_PEMBAYARAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_PEMBAYARAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_PEMBAYARAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_PEMBAYARAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TRANSAKSI_PEMBAYARAN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KELUAR;
    private javax.swing.JButton SIMPAN;
    private javax.swing.JButton UBAH;
    private javax.swing.JButton bhitung;
    private javax.swing.JButton bkembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelpembayaran;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtbarang;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtidplg;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnmplg;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttglkmbl;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}