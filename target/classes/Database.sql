use qlttnn;

create table thisinh(
	SBD varchar(10) not null ,
    ho nvarchar(20),
    ten nvarchar(30),
    gioitinh tinyint,
    ngaysinh DATE,
    noisinh nvarchar(30),
    cmnd varchar(20),
    ngaycap date,
    noicap nvarchar(30),
    sdt varchar(20),
    email varchar(30),
    phongthi varchar(10),
    khoathi varchar(10),
    primary key (SBD, khoathi)
);

create table phongthi(
	tenphong varchar(10) not null,
    khoathi varchar(10),
    primary key (tenphong,khoathi)
);

create table khoathi(
	tenkhoa varchar(10) not null primary key,
    ngaythi date 
);

create table diemthi(
	SBD varchar(10) not null,
    khoathi varchar(10),
    nghe float,
    noi float,
    doc float,
    viet float,
    primary key (SBD,khoathi)
);

alter table thisinh add foreign key (phongthi) references phongthi(tenphong);
alter table thisinh add foreign key (khoathi) references khoathi(tenkhoa);
alter table phongthi add foreign key (Khoathi) references khoathi(tenkhoa);
alter table diemthi add foreign key (SBD) references thisinh(SBD);
alter table diemthi add foreign key (khoathi) references khoathi(tenkhoa);

insert into khoathi values ('Khoa001','2021-11-11');
insert into khoathi values ('Khoa002','2021-12-12');
insert into khoathi values ('Khoa003','2022-02-14');
insert into phongthi values ('A2P01','Khoa001');
insert into phongthi values ('A2P02','Khoa001');
insert into phongthi values ('B1P03','Khoa001');
insert into phongthi values ('B1P04','Khoa001');
insert into phongthi values ('A2P01','Khoa002');
insert into phongthi values ('A2P02','Khoa002');
insert into phongthi values ('B1P03','Khoa002');
insert into phongthi values ('B1P04','Khoa002');
insert into phongthi values ('A2P01','Khoa003');
insert into phongthi values ('A2P02','Khoa003');
insert into phongthi values ('B1P03','Khoa003');
insert into phongthi values ('B1P04','Khoa003');
insert into `thisinh` values('A2001',N'Nguyễn',N'Thắng',1,'2000-03-23','HCM','0123456789','2015-01-11','HCM','0987654321','thang@gmail.com','A2P01','Khoa001');
insert into `thisinh` Values ('A2002',N'Trần',N'Thành',1,'2002-04-08','HCM','0123456789','2015-02-12','HCM','0987654321','thanh@gmail.com','A2P01','Khoa001');
insert into `thisinh` values('A2003',N'Nguyễn',N'Hằng',0,'2004-10-07','HN','0123456789','2015-03-13','HN','0987654321','hang@gmail.com','A2P02','Khoa001');
insert into `thisinh` values('B1001',N'Phương',N'Mai',0,'2012-10-27','HN','0123456789','2015-04-14','HN','0987654321','mai@gmail.com','B1P03','Khoa001');
insert into `thisinh` values('B1002',N'Lương',N'Nhân',1,'1997-03-17','HCM','0123456789','2015-05-15','HCM','0987654321','nhan@gmail.com','B1P04','Khoa001');
insert into `diemthi` values ('A2001','Khoa001',6,7.5,8,8.5);
insert into `diemthi` values ('A2002','Khoa001',9,8.5,8,8.5);
insert into `diemthi` values ('A2003','Khoa001',10,10,10,10);
insert into `diemthi` values ('B1001','Khoa001',8,8,6,7.5);
insert into `diemthi` values ('B1002','Khoa001',7,9.5,5,7.5);
