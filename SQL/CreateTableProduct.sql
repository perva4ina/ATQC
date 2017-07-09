use OnlineShop;
Create Table Product(
ProductID INT IDENTITY(1,1),
Naming nvarchar(30) NOT NULL,
Price numeric,
ProductDescription nvarchar(1000),
Available int NOT NULL,
CONSTRAINT PK_ProductID PRIMARY KEY(ProductID));
