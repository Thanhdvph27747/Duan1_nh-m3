CREATE DATABASE DB_Du_An_1
USE DB_Du_An_1
GO
-- Quan
CREATE TABLE Quan(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaQuan VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL
)


--NhanVien
CREATE TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ho NVARCHAR(50) DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
Sdt int DEFAULT NULL,
Email NVARCHAR(50) DEFAULT NULL,
GioiTinh NVARCHAR(50) DEFAULT NULL,
MaQuan UNIQUEIDENTIFIER null,
pass nvarchar(50)
)


-- HoaDon
CREATE TABLE HoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaHd VARCHAR(20) UNIQUE,
DateDi nchar(20) NULL,
DateDen nchar(20) NULL,
ViTriNgoi NVARCHAR(30) DEFAULT NULL,
Diem_Den NVARCHAR(10) DEFAULT NULL,
DiemDi NVARCHAR(10) DEFAULT NULL,
MoTa NVARCHAR(100) DEFAULT NULL,
IdUser nvarchar(50),
IdNhanVien UNIQUEIDENTIFIER,
IdChiTietVe UNIQUEIDENTIFIER,
IdSale UNIQUEIDENTIFIER,
TrangThai INT DEFAULT 0
)

-- User
CREATE TABLE NguoiDung(
Id nvarchar(50) PRIMARY KEY,
Ho VARCHAR(20)DEFAULT NULL ,
TenDem NVARCHAR(30),
Ten NVARCHAR(30) DEFAULT NULL,
Email NVARCHAR(30) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
GioiTinh INT DEFAULT 0,
SoCMND NVARCHAR(50) UNIQUE,
Pass NVARCHAR(50) DEFAULT NULL,
Image nvarchar(50)
)


--TrainTickets
CREATE TABLE TrainTickets(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
NgayDi DATE DEFAULT NULL,
Price  DECIMAL(20,0) DEFAULT 0 ,
GioKhoiHanh nchar(20)  NULL,
GioDen nchar(20)  NULL,
IdHangTau nvarchar(50) null,
Iduser nvarchar(50) null,
Thue float null,
DiemDen NVARCHAR(100) DEFAULT NULL,
DiemDi VARCHAR(30) DEFAULT NULL,
)


-- SanPham
CREATE TABLE Sale(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaGiamGia VARCHAR(20) UNIQUE,
soTienGiam  DECIMAL(20,0) DEFAULT 0
)


-- Tau
CREATE TABLE Tau(
Id nvarchar(50) primary key,
SoHieu VARCHAR(20) UNIQUE,
TenTau NVARCHAR(30) DEFAULT NULL,
Toa NVARCHAR(30) DEFAULT NULL,
vitri int null,
TrangThai INT DEFAULT 1,
)

-- HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
IdTRainTickets UNIQUEIDENTIFIER ,
IdHoaDon UNIQUEIDENTIFIER ,
soLuong int DEFAULT NULL ,
DonGia DECIMAL(20,0) DEFAULT 0,
ViTri NVARCHAR(30) DEFAULT NULL,
Primary key(IdTRainTickets,IdHoaDon)
)

--QuanHeGiuaCacBang
--HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNhanVien) REFERENCES NhanVien(Id)
--HoaDon - User
ALTER TABLE HoaDon ADD FOREIGN KEY (IdUser) REFERENCES NguoiDung(Id)
--HoaDonChiTiet - HoaDon
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdHoaDon) REFERENCES HoaDon(Id)
-- HoaDon - Sale
ALTER TABLE HoaDon ADD FOREIGN KEY (IdSale) REFERENCES Sale(Id)
-- NhanVien - Quan
ALTER TABLE NhanVien ADD FOREIGN KEY(MaQuan) REFERENCES Quan(id)
-- TrainTickets - User
ALTER TABLE TrainTickets ADD FOREIGN KEY(iduser) REFERENCES nguoidung(id)
--TrainTickets - Tau
ALTER TABLE TrainTickets ADD FOREIGN KEY(IdHangTau) REFERENCES Tau(Id)
-- ChoNgoi - Tau

--HoaDonChiTiet-TrainTickets
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY(IdTrainTickets) REFERENCES TrainTickets(Id)
 

 select NguoiDung.ten,NguoiDung.SoCMND,traintickets.id,ngaydi,TrainTickets.DiemDi,DiemDen,GioKhoiHanh,GioDen,tau.TenTau,tau.Toa,tau.vitri
 from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id 
 join nguoidung on traintickets.iduser = nguoidung.id 

 select * from NguoiDung
 select id from NguoiDung where SoCMND = ? 
 insert into NguoiDung(id) values('0')
 insert into TrainTickets(Iduser) values()
 select * from tau
  insert into tau(id,TrangThai) values(1,0)
  update tau set TrangThai=2 where tentau like 'Tàu1' and Toa like 'P' and vitri =1