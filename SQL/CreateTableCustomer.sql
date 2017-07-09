use OnlineShop;
Create Table Customer(
CustomerID INT IDENTITY(1,1),
FirstName nvarchar(30) NOT NULL,
LastName nvarchar(30) NOT NULL,
Email nvarchar(30) NOT NULL,
Country nvarchar(30),
Oblast nvarchar(30),
City nvarchar(30),
Pass nvarchar(20) NOT NULL,
CONSTRAINT PK_CustomerID PRIMARY KEY(CustomerID))
