-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2019 at 09:45 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE `jenis` (
  `kode_jenis` char(5) NOT NULL,
  `jenis` varchar(15) NOT NULL,
  `barang` varchar(10) NOT NULL,
  `harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis`
--

INSERT INTO `jenis` (`kode_jenis`, `jenis`, `barang`, `harga`) VALUES
('Cuci1', 'Cuci', 'Pakaian', 2500),
('Cuci2', 'Cuci', 'Jas', 7500),
('Cuci3', 'Cuci', 'Boneka', 15000),
('pakt1', 'Komplit', 'Pakaian', 4500),
('pakt2', 'Komplit', 'Jas', 11500),
('pakt3', 'Komplit', 'Boneka', 11500),
('Strk1', 'Setrika', 'PAKAIAN', 2000),
('Strk2', 'Setrika', 'Jas', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_login` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_login`, `password`, `level`) VALUES
('admin1', 'admin1', 'admin1'),
('pemilik', 'pemilik', 'pemilik');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` char(5) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `telp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama`, `telp`) VALUES
('PG001', 'PIPUN ', '08567025542'),
('PG002', 'VINA ', '085709321221'),
('PG003', 'DEDE', '089312765843'),
('PG004', 'CANDRA', '085642753244');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` char(5) NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `tlp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `tlp`) VALUES
('P0001', 'DWI ARYANTI', 'MOJOGEDANG', '056642357122'),
('P0002', 'JAYA KUSNADI', 'MOJOSONGO', '08123765321'),
('P0003', 'DEDE FEMIL', 'SOLO BARU', '081123456789');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `no` char(5) NOT NULL,
  `tanggal_masuk` varchar(10) NOT NULL,
  `tanggal_keluar` varchar(10) NOT NULL,
  `id_pelanggan` char(5) NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `kode_jenis` char(5) NOT NULL,
  `jenis` varchar(15) NOT NULL,
  `barang` varchar(10) NOT NULL,
  `berat` int(5) NOT NULL,
  `harga` int(10) NOT NULL,
  `total` int(10) NOT NULL,
  `bayar` int(10) NOT NULL,
  `kembali` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`no`, `tanggal_masuk`, `tanggal_keluar`, `id_pelanggan`, `nama_pelanggan`, `alamat`, `kode_jenis`, `jenis`, `barang`, `berat`, `harga`, `total`, `bayar`, `kembali`) VALUES
('msk01', '13-07-2019', '16-07-2019', 'P0001', 'DWI ARYANTI', 'MOJOGEDANG, KARANGANYAR', 'Cuci1', 'Cuci', 'Pakaian', 4, 2500, 10000, 10000, 0),
('msk02', '14-07-2019', '16-07-2019', 'P0002', 'JAYA KUSNADI', 'MOJOSONGO', 'pakt2', 'Komplit', 'Jas', 3, 11500, 34500, 35000, 500);

-- --------------------------------------------------------

--
-- Table structure for table `transaksimasuk`
--

CREATE TABLE `transaksimasuk` (
  `no` char(5) NOT NULL,
  `tanggal_masuk` varchar(10) NOT NULL,
  `id_pegawai` char(5) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `id_pelanggan` char(5) NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `tlp` varchar(12) NOT NULL,
  `kode_jenis` char(5) NOT NULL,
  `jenis` varchar(15) NOT NULL,
  `barang` varchar(10) NOT NULL,
  `harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksimasuk`
--

INSERT INTO `transaksimasuk` (`no`, `tanggal_masuk`, `id_pegawai`, `nama`, `id_pelanggan`, `nama_pelanggan`, `alamat`, `tlp`, `kode_jenis`, `jenis`, `barang`, `harga`) VALUES
('msk01', '13-07-2019', 'PG001', 'PIPUN TRI WAHYUNI', 'P0001', 'DWI ARYANTI', 'MOJOGEDANG, KARANGANYAR', '056642357122', 'Cuci1', 'Cuci', 'Pakaian', 2500),
('msk02', '14-07-2019', 'PG003', 'DEDE', 'P0002', 'JAYA KUSNADI', 'MOJOSONGO', '08123765321', 'pakt2', 'Komplit', 'Jas', 11500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`kode_jenis`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD KEY `no` (`no`);

--
-- Indexes for table `transaksimasuk`
--
ALTER TABLE `transaksimasuk`
  ADD PRIMARY KEY (`no`),
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `kode_jenis` (`kode_jenis`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`no`) REFERENCES `transaksimasuk` (`no`);

--
-- Constraints for table `transaksimasuk`
--
ALTER TABLE `transaksimasuk`
  ADD CONSTRAINT `transaksimasuk_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`),
  ADD CONSTRAINT `transaksimasuk_ibfk_2` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `transaksimasuk_ibfk_3` FOREIGN KEY (`kode_jenis`) REFERENCES `jenis` (`kode_jenis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
