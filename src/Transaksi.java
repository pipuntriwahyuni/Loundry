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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi extends javax.swing.JFrame {
     private DefaultTableModel model;
    
    //deklarasi variabel
    String no, tglmsk, id,nm,idp, nmp,almt,tlpp,kd, jns, brg ;
    int hrg;
    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
         model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        ttransaksi1.setModel(model);
        model.addColumn("NO.MASUK");
        model.addColumn("TANGGAL MASUK");
        model.addColumn("ID PEGAWAI");
        model.addColumn("NAMA PEGAWAI");
        model.addColumn("ID PELANGGAN");
        model.addColumn("NAMA PELANGGAN");
        model.addColumn("ALAMAT");
        model.addColumn("TELEON");
        model.addColumn("KODE JENIS");
        model.addColumn("JENIS LAUNDRY");
        model.addColumn("JENIS BARANG CUCIAN");
        model.addColumn("HARGA");
        
        
        //fungsi ambil data
        getTransaksi();
    }
    
    public void getTransaksi(){
        //kosongkan tabel
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //eksekusi koneksi dan kirimkan query ke database
        try{
            //tes koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
            
            //perintah sql untuk membaca data dari tabel kategori        
            String sql = "SELECT * FROM transaksimasuk";
            ResultSet res = stat.executeQuery(sql);
            
            //baca data
            while(res.next()){
                //membuat obyek berjenis array
                Object[] obj = new Object[12];
                obj[0]=res.getString("no");
                obj[1]=res.getString("tanggal_masuk");
                obj[2]=res.getString("id_pegawai");
                obj[3]=res.getString("nama");
                obj[4]=res.getString("id_pelanggan");
                obj[5]=res.getString("nama_pelanggan");
                obj[6]=res.getString("alamat");
                obj[7]=res.getString("tlp");
                obj[8]=res.getString("kode_jenis");
                obj[9]=res.getString("jenis");
                obj[10]=res.getString("barang");
                obj[11]=res.getString("harga");
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
            String sql = "SELECT * FROM pegawai WHERE id_pegawai = '"+ txtid.getText() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
               txtnama.setText(res.getString("nama"));
               
              
               
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void dataproduk2(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = '"+ txtidplg.getText() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
               txtidplg.setText(res.getString("id_pelanggan"));
               txtnmplg.setText(res.getString("nama_pelanggan"));
               txtalamat.setText(res.getString("alamat"));
               txttlpplg.setText(res.getString("tlp"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
      public void dataproduk3(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM JENIS WHERE kode_jenis = '"+ txtkode.getText() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
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

        txttanggal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtidplg = new javax.swing.JTextField();
        baru = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnmplg = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtkode = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtjenis = new javax.swing.JTextField();
        txtbarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttlpplg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ttransaksi1 = new javax.swing.JTable();
        UBAH = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("TRANSAKSI BARANG MASUK");

        jLabel2.setText("NO. MASUK");

        jLabel3.setText("TANGGAN MASUK");

        jLabel4.setText("ID PEGAWAI");

        jLabel5.setText("NAMA PEGAWAI");

        jLabel6.setText("ID PELANGGAN");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });

        txtidplg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidplgKeyReleased(evt);
            }
        });

        baru.setText("BARU");
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jLabel7.setText("NAMA PELANGGAN");

        jLabel9.setText("ALAMAT");

        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        txtkode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkodeKeyReleased(evt);
            }
        });

        jLabel10.setText("KODE JENIS");

        jLabel11.setText("JENIS LAUNDRY");

        jLabel12.setText("JENIS BARANG CUCIAN");

        txtjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjenisActionPerformed(evt);
            }
        });

        jLabel8.setText("TELEPON");

        ttransaksi1.setModel(new javax.swing.table.DefaultTableModel(
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
        ttransaksi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ttransaksi1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ttransaksi1);

        UBAH.setText("UBAH");
        UBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UBAHActionPerformed(evt);
            }
        });

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        jLabel13.setText("HARGA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtnmplg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtidplg, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtnama)
                                                .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txttanggal)
                                                .addComponent(txtno)
                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txttlpplg, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simpan)
                                .addGap(18, 18, 18)
                                .addComponent(baru, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus)
                                .addGap(18, 18, 18)
                                .addComponent(keluar))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel1)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtidplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnmplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttlpplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(baru)
                    .addComponent(UBAH)
                    .addComponent(hapus)
                    .addComponent(keluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public void loadDatatransaksi(){
        no= txtno.getText();
        tglmsk= txttanggal.getText();
        id= txtid.getText();
        nm= txtnama.getText();
        idp = txtidplg.getText();
        nmp = txtnmplg.getText();
        almt = txtalamat.getText();
        tlpp = txttlpplg.getText();
        kd= txtkode.getText();
        jns= txtjenis.getText();
        brg= txtbarang.getText();
        hrg = Integer.parseInt(txtharga.getText());
    }
    
    //memilih data saat baris pada tabel dipilih dengan mouse
    public void dataSelect(){
        //deklarasi variabel
        int i = ttransaksi1.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
        txtno.setText(""+model.getValueAt(i,0));
        txttanggal.setText(""+model.getValueAt(i,1));
        txtid.setText(""+model.getValueAt(i,2));
        txtnama.setText(""+model.getValueAt(i,3));
        txtidplg.setText(""+model.getValueAt(i,4));
        txtnmplg.setText(""+model.getValueAt(i,5));
        txtalamat.setText(""+model.getValueAt(i,6));
        txttlpplg.setText(""+model.getValueAt(i,7));
        txtkode.setText(""+model.getValueAt(i,8));
        txtjenis.setText(""+model.getValueAt(i,9));
        txtbarang.setText(""+model.getValueAt(i,10));
        txtharga.setText(""+model.getValueAt(i,11));
    
    }
     
    //mengosongkan form
    public void baru(){
        no ="";
        tglmsk ="";
        id="";
        nm="";
        idp = "";
        nmp = "";
        almt ="";
        tlpp = "";
        kd="";
        jns="";
        brg="";
        hrg = 0;
        
        txtno.setText(no);
        txttanggal.setText(tglmsk);
        txtid.setText(id);
        txtnama.setText(nm);
        txtidplg.setText(idp);
        txtnmplg.setText(nmp);
        txtalamat.setText(almt);
        txttlpplg.setText(tlpp);
        txtkode.setText(kd);
        txtjenis.setText(jns);
        txtbarang.setText(brg);
        txtharga.setText(Integer.toString(hrg));
    }
    
     public void simpantransaksi(){
        //panggil fungsi load data
        loadDatatransaksi();
        
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =   "INSERT INTO transaksimasuk(no,tanggal_masuk,id_pegawai,nama,id_pelanggan, "
                    + "nama_pelanggan , alamat, tlp,kode_jenis, jenis, barang, harga)" + "VALUES('"+ no +"','"+ tglmsk +"','"+ id +"'"
                    + ",'"+ nm +"','"+ idp +"','"+ nmp +"','"+ almt +"','"+ tlpp +"','"+ kd +"','"+ jns +"','"+ brg +"','"+ hrg +"')";
            PreparedStatement p = (PreparedStatement) koneksiKU.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getTransaksi();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     
     public void ubahtransaksi(){
        //fungsi load data kategori
        loadDatatransaksi();
        
        try{
            //uji koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
            
            //kirim perintah sql
            String sql = "UPDATE transaksimasuk SET tanggal = '"+ tglmsk +"'," + "id_pegawai = '"+ id +"'," + "nama = '"+ nm +"'," 
                    + " id_pelanggan = '"+ idp +"'"+ "nama_pelanggan = '"+ nmp +"'," + "alamat = '"+ almt +"'," + "tlp = '"+ tlpp +"'," 
                    +"kode_jenis = '"+ kd +"'," + "jenis = '"+ jns +"'," + "barang = '"+ brg +"'," + "harga = '"+ hrg +"'," + " WHERE no = '"+ no +"',"+"kode_jenis = '"+ kd +"'" ;
            PreparedStatement p =(PreparedStatement)koneksiKU.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getTransaksi();
            
            //kosongkan data
            baru();
            JOptionPane.showMessageDialog(null, "PERUBAHAN DATA BERHASIL");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     
     public void perbaruitransaksi(){
        //fungsi load data kategori
        loadDatatransaksi();
        
        try{
            //uji koneksi
            Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
            
            //kirim perintah sql
            String sql = "UPDATE transaksimasuk SET tanggal = '"+ tglmsk +"'," + "id_pegawai = '"+ id +"'," + "nama = '"+ nm +"'," 
                    + " id_pelanggan = '"+ idp +"'"+ "nama_pelanggan = '"+ nmp +"'," + "alamat = '"+ almt +"'," + "tlp = '"+ tlpp +"'," 
                    +"kode_jenis = '"+ kd +"'," + "jenis = '"+ jns +"'," + "barang = '"+ brg +"'," + "harga = '"+ hrg +"'," + " WHERE no = '"+ no +"',"+"kode_jenis = '"+ kd +"'" ;
            PreparedStatement p =(PreparedStatement)koneksiKU.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getTransaksi();
            
            //kosongkan data
            baru();
            JOptionPane.showMessageDialog(null, "PERUBAHAN DATA BERHASIL");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void hapusDatatransaksi(){
        //panggil fungsi ambil data
        loadDatatransaksi(); 
        
        //Beri peringatan sebelum melakukan penghapusan data
        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA"+ no +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);
        
        //jika pengguna memilih OK lanjutkan proses hapus data
        if(pesan == JOptionPane.OK_OPTION){
            //uji koneksi
            try{
                //buka koneksi ke database
                Statement stat = (Statement) koneksiKU.getKoneksi().createStatement();
                
                //perintah hapus data
                String sql = "DELETE FROM transaksimasuk WHERE no='"+ no +"'";
                PreparedStatement p =(PreparedStatement)koneksiKU.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                
                //fungsi ambil data
                getTransaksi();
                
                //fungsi reset data
                baru();
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        }
    }
    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        // TODO add your handling code here:
        baru();
    }//GEN-LAST:event_baruActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void txtjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjenisActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        simpantransaksi();
    }//GEN-LAST:event_simpanActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
         
    }//GEN-LAST:event_keluarActionPerformed

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtkodeActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtidActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        dataproduk1();
    }//GEN-LAST:event_txtidKeyReleased

    private void txtidplgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidplgKeyReleased
        // TODO add your handling code here:
        dataproduk2();
    }//GEN-LAST:event_txtidplgKeyReleased

    private void txtkodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyReleased
        // TODO add your handling code here:
        dataproduk3();
    }//GEN-LAST:event_txtkodeKeyReleased

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        hapusDatatransaksi();
    }//GEN-LAST:event_hapusActionPerformed

    private void UBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UBAHActionPerformed
        // TODO add your handling code here:
        ubahtransaksi();
    }//GEN-LAST:event_UBAHActionPerformed

    private void ttransaksi1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ttransaksi1MousePressed
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_ttransaksi1MousePressed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UBAH;
    private javax.swing.JButton baru;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton simpan;
    private javax.swing.JTable ttransaksi1;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtbarang;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidplg;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnmplg;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttlpplg;
    // End of variables declaration//GEN-END:variables
}
