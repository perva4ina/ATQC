use OnlineShop;
Create Table OrderProduct(
OrderProductID INT NOT NULL IDENTITY(1,1),
ProductID INT NOT NULL,
OrderID INT NOT NULL,
Quantity INT NOT NULL
CONSTRAINT PK_OrderProductID PRIMARY KEY(OrderProductID),
CONSTRAINT FK_OrderProduct_ProductID FOREIGN KEY(ProductID) REFERENCES Product(ProductID),
CONSTRAINT FK_OrderProduct_OrderID FOREIGN KEY(OrderID) REFERENCES Orders(OrderID)
)
