-- Chèn dữ liệu vào bảng [Customer]
INSERT INTO [Customer] (CustomerName, Address, PhoneNumber)
VALUES 
  (N'Nguyễn Duy Tiến', N'14 Trần Bình', '0972182918'),
  (N'Nguyễn Duy Toàn', N'30 Trần Cung', '0987654321');

-- Chèn dữ liệu vào bảng [Category]
INSERT INTO [Category] (CategoryName)
VALUES 
  (N'Lẩu'),
  (N'Nướng'),
  (N'Đồ uống');

-- Chèn dữ liệu vào bảng [Table]
INSERT INTO [Table] (TableName, Price)
VALUES 
  (N'Bàn 1', 50000),
  (N'Bàn 2', 50000),
  (N'Bàn 3', 50000),
  (N'Bàn 4', 50000),
  (N'Bàn 5', 50000),
  (N'Bàn 6', 50000),
  (N'Bàn 7', 50000),
  (N'Bàn 8', 50000),
  (N'Bàn 9', 50000),
  (N'Bàn 10', 50000),
  (N'Bàn 11', 50000),
  (N'Bàn 12', 50000),
  (N'Bàn 13', 50000),
  (N'Bàn 14', 50000),
  (N'Bàn 15', 50000),
  (N'Bàn 16', 50000),
  (N'Bàn 17', 50000),
  (N'Bàn 18', 50000),
  (N'Bàn 19', 50000),
  (N'Bàn 20', 50000);

-- Chèn dữ liệu vào bảng [Account]
INSERT INTO [Account] (Email, PassWord, Role)
VALUES 
  (N'admin@gmail.com', 1, 'admin'),
  (N'user@gmail.com', 1, 'user');

-- Chèn dữ liệu vào bảng [Dish]
INSERT INTO [Dish] (DishName, Price, CategoryID)
VALUES 
  (N'Lẩu hải sản', 300000, 1),
  (N'Dê nướng', 200000, 2),
  (N'Pepsi', 25000, 3);
