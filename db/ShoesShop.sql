USE [master]
GO
IF DB_ID('ShoesShop') IS NOT NULL
	DROP DATABASE ShoesShop
GO
CREATE DATABASE ShoesShop
GO
USE ShoesShop
GO
CREATE TABLE Users(
	Id			INT				IDENTITY	PRIMARY KEY,
	UserName	VARCHAR(100)	UNIQUE,
	Password	VARCHAR(200),
	Name		NVARCHAR(100),
	Create_Date	DATE DEFAULT	GETDATE(),
	Phone		VARCHAR(20)		UNIQUE,
	Address		NVARCHAR(MAX),
	Email		VARCHAR(100)	UNIQUE,
	Status		INT,
)
GO
INSERT INTO Users(UserName,Password,Name,Create_Date,Phone,Address,Email,Status) VALUES
	('admin','$2a$12$VLdwb5ROkR9KEqq/TJ1Zse3s1W/MVEtlcIiwizRVcRbNSqsgJ.Oee',N'Nguyễn Tiến Dũng','2020-01-01','0987111111',N'Hậu Lộc, Thanh Hóa','ntdung@gmail.com',1)

GO
CREATE TABLE [Type](
	Id			INT				IDENTITY	PRIMARY KEY,
	Name		NVARCHAR(100),
	Size_Min	INT,
	Size_Max	INT,
)
GO
INSERT INTO [Type](Name,Size_Min,Size_Max) VALUES
	('SNEAKER',29,43),
	('HEELS',29,43),
	('SANDALS',29,43)

GO

CREATE TABLE Color_Product(
	Id			INT				IDENTITY	PRIMARY KEY,
	Name		NVARCHAR(100),
)
GO
INSERT INTO Color_Product(Name) VALUES
	(N'WHITE'),
	(N'BLACK'),
	(N'Grey'),
	(N'PINK'),
	(N'BlUE')

CREATE TABLE Product(
	Id			INT				IDENTITY	PRIMARY KEY,
	Code		CHAR(20),
	Name		VARCHAR(100),
	Price		MONEY,
	Amonut		INT,
	Create_Date	DATETIME,
	Id_Color	INT
	FOREIGN KEY (Id_Color) REFERENCES Color_Product (Id),
	Status		TINYINT,	--	0:không bán , 1:mới , 2:bình thường
	Id_Type		INT
	FOREIGN KEY (Id_Type) REFERENCES [Type] (Id),
	LinkImg		NVARCHAR(MAX),
	IsDelete	BIT DEFAULT(1)
)
GO

GO
INSERT INTO Product(Code,Name,Price,Amonut,Create_Date,Id_Color,Status,Id_Type,LinkImg,IsDelete) VALUES
	('SNEAKER_1','SNEAKER_1_WHITE',10000000,100,'2022-10-05',1,1,1,'sneaker_1_white.webp',1),
	('SNEAKER_1','SNEAKER_1_BLACK',10000000,100,'2022-10-05',2,1,1,'sneaker_1_black.webp',1),
	('SNEAKER_2','SNEAKER_2_PINK',20000000,100,'2022-10-05',4,1,1,'sneaker_2_pink.webp',1),
	('SNEAKER_2','SNEAKER_2_BLUE',20000000,100,'2022-10-05',5,1,1,'sneaker_2_blue.webp',1),
	('SNEAKER_3','SNEAKER_3',30000000,100,'2022-10-05',3,1,1,'sneaker_3.webp',1),
	('SNEAKER_4','SNEAKER_4',40000000,100,'2022-10-05',1,1,1,'sneaker_4.webp',1),
	('SNEAKER_5','SNEAKER_5',50000000,100,'2022-10-05',3,1,1,'sneaker_5.webp',1)
GO

CREATE TABLE Image_Product_Detail(
	Id			INT				IDENTITY	PRIMARY KEY,
	Link		NVARCHAR(MAX),
	Id_Product	INT
	FOREIGN KEY (Id_Product) REFERENCES Product (Id),
)
GO
INSERT INTO Image_Product_Detail(Link,Id_Product) VALUES
	('sneaker_1_white.webp',1),
	('sneaker_1_1_white.webp',1),
	('sneaker_1_2_white.webp',1),
	('sneaker_1_3_white.webp',1),
	('sneaker_1_black.webp',2),
	('sneaker_1_1_black.webp',2),
	('sneaker_1_2_black.webp',2),
	('sneaker_1_3_black.webp',2),
	('sneaker_2_pink.webp',3),
	('sneaker_2_1_pink.webp',3),
	('sneaker_2_2_pink.webp',3),
	('sneaker_2_3_pink.webp',3),
	('sneaker_2_blue.webp',4),
	('sneaker_2_1_blue.webp',4),
	('sneaker_2_2_blue.webp',4),
	('sneaker_2_3_blue.webp',4)

GO
CREATE TABLE Image_Type(
	Id			INT				IDENTITY	PRIMARY KEY,
	Link		NVARCHAR(MAX),
	Id_Type	INT
	FOREIGN KEY (Id_Type) REFERENCES Type (Id),
)
GO
INSERT INTO Image_Type(Link,Id_Type) VALUES
	('type_sneakers.webp',1),
	('type_heels.webp',2),
	('type-sandals.webp',3)
GO
CREATE TABLE Bill(
	Id				INT				IDENTITY	PRIMARY KEY,	
	Total_Price		MONEY,
	Create_Date		DATETIME,
	RecipientName	NVARCHAR(100),
	DeliAddress		NVARCHAR(MAX),
	Phone			VARCHAR(15),
	Note			NVARCHAR(MAX),
	Id_User			INT
	FOREIGN KEY (Id_User) REFERENCES Users (Id),
	Status			INT, --1-đã xác nhận đơn, 0-đã hoàn thành đơn
)
GO

CREATE TABLE Bill_Detail (
  Id			INT				IDENTITY	PRIMARY KEY,
  Amount		INT,
  Size_Product	INT,
  Sum_Price		MONEY,
  Id_Product	INT,
  FOREIGN KEY (Id_Product) REFERENCES Product (Id),
  Id_Bill		INT,
  FOREIGN KEY (Id_Bill) REFERENCES Bill (Id),
)
GO

CREATE TABLE Banner(
	Id			INT				IDENTITY	PRIMARY KEY,
	Link		NVARCHAR(MAX),
)
GO
INSERT INTO Banner(Link) VALUES
	('banner1.jpg'),
	('banner2.jpg'),
	('banner3.jpg'),
	('banner4.jpg')
	
GO

SELECT *FROM Bill WHERE Id_User=1 ORDER BY Id DESC
SELECT *FROM Bill_Detail
SELECT MAX(Id) FROM Bill

CREATE TABLE Roles(
	Id			INT				IDENTITY	PRIMARY KEY,
	Name		NVARCHAR(100),
)
GO
CREATE TABLE Users_Roles(
	Id			INT				IDENTITY	PRIMARY KEY,
	IdUser		INT,
	FOREIGN KEY (IdUser) REFERENCES Users (Id),
	IdRole		INT,
	FOREIGN KEY (IdRole) REFERENCES Roles (Id),

)
select *from Product
