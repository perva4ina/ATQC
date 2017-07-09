use OnlineShop;
Create Table Orders(
OrderID INT NOT NULL IDENTITY(1,1),
CustomerID INT NOT NULL,
CONSTRAINT PK_OrderID PRIMARY KEY(OrderID),
CONSTRAINT FK_Orders_CustomerID FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID)
)
