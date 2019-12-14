
CREATE DATABASE QuanLyDiemSinhVien
GO
USE QuanLyDiemSinhVien
GO 
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO





---TẠO BẢNG ĐĂNG NHẬP---
CREATE TABLE DangNhap(
	TenDangNhap nvarchar(50) NOT NULL,
	MatKhau nvarchar(20) NOT NULL,
	HoTen nvarchar(50) NULL,
	Email nvarchar(50) NOT NULL,
 CONSTRAINT PK_DangNhap PRIMARY KEY CLUSTERED (TenDangNhap ASC)
 WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 GO
 INSERT INTO DangNhap VALUES ('thang','123',N'Nguyễn Viết Thắng','thang@gmail.com')
 INSERT INTO DangNhap VALUES ('chau','123',N'Nguyễn Tấn Châu','chau@gmail.com')
 INSERT INTO DangNhap VALUES ('truong','123',N'Nguyễn Đan Trường','truong@gmail.com')
 ---Sửa bảng đăng nhập---
UPDATE DangNhap SET MatKhau='?', HoTen='?', Email='?' WHERE TenDangNhap='?'
---xóa Khỏi bảng đăng nhập---
DELETE FROM DangNhap WHERE TenDangNhap='?'
---xem dữ liệu---
SELECT * FROM DangNhap





---TẠO BẢNG MÔN HỌC---
 CREATE TABLE MonHoc(
	MaMH nvarchar(10) NOT NULL,
	TenMH nvarchar(20) NOT NULL,
	SoTrinh int NULL,
	HinhThucThi nvarchar(20) NULL,
	HocKy int NULL,
	PhongHoc nvarchar(10) NULL,
 CONSTRAINT PK_MonHoc PRIMARY KEY CLUSTERED (MaMH ASC)
 WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 GO
 INSERT INTO MonHoc VALUES ('MH01',N'JAVA','5',N'Thi Thực Hành','6','P308')
 INSERT INTO MonHoc VALUES ('MH02',N'WEB','5',N'Thi Thực Hành','6','P308')
 INSERT INTO MonHoc VALUES ('MH03',N'DATABASE','5',N'Thực Hành','6','P301')
 INSERT INTO MonHoc VALUES ('MH04',N'ENGLISH','16',N'Thi Vấn Đáp','6','P302')
 INSERT INTO MonHoc VALUES ('MH05',N'MARKETING','5',N'Thi Thực Hành','6','P201')
 SELECT * FROM MonHoc
---Sửa bảng môn học---
UPDATE MonHoc SET TenMH='?', SoTrinh='?', HinhThucThi='?', HocKy='?', PhongHoc='?' WHERE MaMH='?'
---xóa Khỏi bảng môn học---
DELETE FROM MonHoc WHERE MaMH ='?'
---xem dữ liệu---
SELECT * FROM MonHoc





---TẠO BẢNG KHOA---
 CREATE TABLE Khoa(
	MaKhoa nvarchar(10) NOT NULL,
	TenKhoa nvarchar(50) NOT NULL,
	SDT nvarchar(15) NULL,
 CONSTRAINT PK_Khoa PRIMARY KEY CLUSTERED (MaKhoa ASC)
 WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 GO
 INSERT INTO Khoa VALUES ('CNTT',N'Công nghệ thông tin','0378299654')
 INSERT INTO Khoa VALUES ('LP',N'Luật Pháp','1230546987')
 INSERT INTO Khoa VALUES ('MKS',N'Marketing Sale','0369852369')
 INSERT INTO Khoa VALUES ('SP',N'Spa Làm Đẹp','0321569847')
 INSERT INTO Khoa VALUES ('TCSK',N'Tổ Chức Sự Kiện','0358741256')
---Sửa bảng khoa---
UPDATE Khoa SET TenKhoa = '?', SDT='?' WHERE MaKhoa='?'
---xóa Khỏi bảng khoa---
DELETE FROM Khoa WHERE MaKhoa = '?'
---xem dữ liệu---
SELECT * FROM Khoa





 ---TẠO BẢNG GIẢNG VIÊN---
 CREATE TABLE GiangVien(
	MaGV nvarchar(10) NOT NULL,
	HoTenGV nvarchar(50) NOT NULL,
	Email nvarchar(50) NULL,
	MaMH nvarchar(10) NOT NULL,
	NgaySinh datetime NULL,
	DiaChi nvarchar(70) NULL,
	GioiTinh bit NULL,	
	SDT nvarchar(10) NULL,
 CONSTRAINT PK_GiangVien PRIMARY KEY CLUSTERED (MaGV ASC)
 WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 GO
ALTER TABLE GiangVien  WITH CHECK ADD  CONSTRAINT FK_GiangVien_MonHoc FOREIGN KEY(MaMH)
REFERENCES MonHoc (MaMH)
GO
ALTER TABLE GiangVien CHECK CONSTRAINT FK_GiangVien_MonHoc
GO
INSERT INTO GiangVien VALUES ('GV01',N'Vũ Thị Thanh Huyền','huyen@gmail.com','MH01','08-15-1990',N'Đà Nẵng','0','0345987123')
INSERT INTO GiangVien VALUES ('GV02',N'Nguyễn Ngọc Anh','anh@gmail.com','MH02','08-12-1989',N'Đà Nẵng','1','0389526321')
INSERT INTO GiangVien VALUES ('GV03',N'Nguyễn Văn A','vana@gmail.com','MH03','07-05-1987',N'Quảng Nam','1','0389578254')
INSERT INTO GiangVien VALUES ('GV04',N'Nguyễn Xuân B','xuanb@gmail.com','MH05','03-17-1989',N'Đà Nẵng','1','0396325651')
INSERT INTO GiangVien VALUES ('GV05',N'Lê Thanh Vân','van@gmail.com','MH04','03-12-1990',N'Quảng Trị','0','0378288721')
---Sửa bảng giảng viên---
UPDATE GiangVien SET HoTenGV='?', Email='?', MaMH='?', NgaySinh='?', DiaChi='?', GioiTinh='?', SDT='?' WHERE MaMH='?'
---xóa Khỏi bảng giảng viên---
DELETE FROM GiangVien WHERE MaGV ='?'
---xem dữ liệu---
SELECT * FROM GiangVien





---TẠO BẢNG LỚP---
CREATE TABLE Lop(
	MaLop nvarchar(10) NOT NULL,
	TenLop nvarchar(50) NOT NULL,
	MaKhoa nvarchar(10) NOT NULL,
 CONSTRAINT PK_Lop PRIMARY KEY CLUSTERED (MaLop ASC)
 WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE Lop  WITH CHECK ADD  CONSTRAINT FK_Lop_Khoa FOREIGN KEY(MaKhoa)
REFERENCES Khoa (MaKhoa)
GO
ALTER TABLE Lop CHECK CONSTRAINT FK_Lop_Khoa
GO
INSERT INTO Lop VALUES ('PT14305',N'UDPM05','CNTT')
INSERT INTO Lop VALUES ('PT14301',N'UDPM01','CNTT')
INSERT INTO Lop VALUES ('PT14302',N'MOB08','CNTT')
INSERT INTO Lop VALUES ('PT14303',N'SPA02','SP')
INSERT INTO Lop VALUES ('PT14304',N'MKS01','MKS')
---Sửa bảng lớp---
UPDATE Lop SET TenLop='?', MaKhoa='?' WHERE MaLop='?'
---xóa Khỏi bảng lớp---
DELETE FROM Lop WHERE MaLop ='?'
---xem dữ liệu---
SELECT * FROM Lop





---TẠO BẢNG SINH VIÊN---
CREATE TABLE SinhVien(
	MaSV nvarchar(10) NOT NULL,
	HoTen nvarchar(50) NOT NULL,
	MaLop nvarchar(10) NOT NULL,
	HeDaoTao nvarchar(50) NOT NULL,
	NgaySinh datetime NULL,
	DiaChi nvarchar(100) NULL,
	GioiTinh bit NULL,
	SDT nvarchar(15) NULL,
 CONSTRAINT PK_SinhVien PRIMARY KEY CLUSTERED (MaSV ASC)
 WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 GO
ALTER TABLE SinhVien  WITH CHECK ADD  CONSTRAINT FK_SinhVien_Lop FOREIGN KEY(MaLop)
REFERENCES Lop (MaLop)
GO
ALTER TABLE SinhVien CHECK CONSTRAINT FK_SinhVien_Lop
GO
INSERT INTO SinhVien VALUES ('PD03169',N'Nguyễn Tấn Châu','PT14305',N'Chính quy','9-6-2000',N'Đà Nẵng','1','0169456987')
INSERT INTO SinhVien VALUES ('PD03196',N'Nguyễn Viết Thắng','PT14305',N'Chính quy','8-31-1999',N'Quảng Trị','1','0378288721')
INSERT INTO SinhVien VALUES ('PD03192',N'Nguyễn Đan Trường','PT14301',N'Chính quy','6-15-2000',N'Quảng Nam','1','0369852147')
INSERT INTO SinhVien VALUES ('PD03188',N'Nguyễn Thu Thảo','PT14303',N'Chính quy','9-6-2000',N'Đà Nẵng','0','0365489516')
INSERT INTO SinhVien VALUES ('PD03166',N'Nguyễn Thanh Vân','PT14304',N'Chính quy','3-12-2001',N'Quảng Trị','0','0369852456')
---Sửa bảng sinh viên---
UPDATE SinhVien SET HoTen='?', MaLop='?', HeDaoTao='?', NgaySinh='?', DiaChi='?', GioiTinh='?', SDT='?' WHERE MaSV='?'
---xóa Khỏi bảng sinh viên---
DELETE FROM SinhVien WHERE MaSV ='?'
---xem dữ liệu---
SELECT * FROM SinhVien





---TẠO BẢNG ĐIỂM---
CREATE TABLE Diem(
	MaSV nvarchar(10) NOT NULL,
	MaMH nvarchar(10) NOT NULL,
	LanThi tinyint NOT NULL,
	HeSo tinyint NULL,
	Diem float NULL,
	TrangThai bit NULL,
)
ALTER TABLE Diem  WITH CHECK ADD  CONSTRAINT FK_Diem_MonHoc FOREIGN KEY(MaMH)
REFERENCES MonHoc (MaMH)
GO
ALTER TABLE Diem CHECK CONSTRAINT FK_Diem_MonHoc
GO
ALTER TABLE Diem  WITH CHECK ADD  CONSTRAINT FK_Diem_SinhVien FOREIGN KEY(MaSV)
REFERENCES SinhVien (MaSV)
GO
ALTER TABLE Diem CHECK CONSTRAINT FK_Diem_SinhVien
GO
---xem dữ liệu---
SELECT * FROM Diem
