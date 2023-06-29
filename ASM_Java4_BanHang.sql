create database Assignment_Java4
go

create table [user](
	id int primary key identity,
	fullName nvarchar(100) not null,
	username varchar(20) unique not null,
	password varchar(20) not null,
	email varchar(100) unique not null,
	images varchar(200) null,
	isAdmin bit not null default 1,
	isActive bit not null default 1
)

update [user] set isAdmin = 1 where id = 3;
create table product(
	id int primary key identity,
	title nvarchar(100) not null,
	category nvarchar(100) not null,
	price money not null,
	quantity int not null,
	[view] int not null default 0,
	share int not null default 0,
	sold int not null default 0,
	poster varchar(1000) not null,
	describe nvarchar(500) not null,
	date_submitted datetime not null default getDate(),
	isActive bit not null default 1
)

create table cart(
	id int primary key identity,
	userId int foreign key references[user](id),
	productId int foreign key references product(id),
	quantity int not null,
	total_monay money not null
)

create table bill(
	id int primary key identity,
	userId int foreign key references[user](id),
	total_bill money not null,
	order_date datetime not null default getDate(),
)

create table detailed_invoice(
	id int primary key identity,
	bill int foreign key references bill(id),
	productId int foreign key references product(id),
	total_money money
)



insert into [user](fullName, username,password,email,isAdmin) values
(N'Đinh Văn Hoàng','hoangadmin','hoang14092003','hoangdvph22488@fpt.edu.vn', 1),
(N'Văn Hoàng','hoang','hoang14092003','hoang0903@gmail.com', 0)

insert into product values
('Giày', 'Áo', 3000,10,0,0,0,'ajac','Giày Jordan Cổ Thấp, Giày Jordan Paris Xám Xanh Bản + giày jordan panda Full Bill + Full Box ( tặng tất từ bản s.cấp)|',GETDATE(),1)

insert into cart values
(
	1,2,2,5000
)
insert into bill values
(2,12345,GETDATE()),
(1,1232345,GETDATE())

insert into bill values
(1,2,3000),(2,3,5000)

select * from [user]