insert into NguoiDung(id,ho,TenDem,ten,Email,Sdt,GioiTinh,SoCMND,Pass) values
 ('thanhdv27747',N'Đào',N'Văn',N'Thanh','Thanhdvph27747@fpt.edu.vn','0386079491',1,'001203051709','123'),
 ('lamhvph27851',N'Hoàng',N'Văn',N'Lâm','Lamhvph27851@fpt.edu.vn','0386079492',1,'001203051708','123'),
 ('linhnv27778',N'Nguyễn',N'Văn',N'Lịnh','Linhnvph2778@fpt.edu.vn','0386079493',1,'001203051707','123'),
 ('anhpxd27753',N'Phùng',N'Xuân Đức',N'Anh','Anhpxdph27753@fpt.edu.vn','0386079494',1,'001203051706','123'),
 ('longnt22123',N'Nguyễn',N'Thành',N'Long','Longntph22123@fpt.edu.vn','0386079495',1,'001203051705','123'),
 ('thanh22211',N'Nguyễn',N'Tiến',N'Thành','Thanhntph22211@fpt.edu.vn','0386079496',1,'001203051704','123')

 select * from TrainTickets
 update TrainTickets set Iduser = 'thanh22211' where id = 'DE015ADC-6D08-45DB-B81B-2B6E5A500DD2'
 select * from NguoiDung
 select id from nguoidung where socmnd like '001203051708'
