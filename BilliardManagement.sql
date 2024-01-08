CREATE TABLE [Account] (
  [Email] VARCHAR(20) UNIQUE NOT NULL,
  [PassWord] VARCHAR(100) NOT NULL,
  [Role] VARCHAR(50) DEFAULT 'user'
)
GO

CREATE TABLE [Dish] (
  [DishID] integer PRIMARY KEY IDENTITY(1, 1),
  [DishName] NVARCHAR(255),
  [Price] DECIMAL(10, 2),
  [CategoryID] integer
)
GO

CREATE TABLE [Category] (
  [CategoryID] integer PRIMARY KEY IDENTITY(1, 1),
  [CategoryName] NVARCHAR(100)
)
GO

CREATE TABLE [Customer] (
  [CustomerID] integer PRIMARY KEY IDENTITY(1, 1),
  [CustomerName] NVARCHAR(255),
  [Address] NVARCHAR(255),
  [PhoneNumber] VARCHAR(20) UNIQUE
)
GO

CREATE TABLE [Table] (
  [TableID] integer PRIMARY KEY IDENTITY(1, 1),
  [TableName] NVARCHAR(255),
  [Status] VARCHAR(20) DEFAULT 'available',
  [Price] DECIMAL(10, 2)
)
GO

CREATE TABLE [Invoice] (
  [InvoiceID] integer PRIMARY KEY IDENTITY(1, 1),
  [CustomerID] integer,
  [TableID] integer NOT NULL,
  [DateCheckin] DATETIME DEFAULT (now()),
  [DateCheckout] DATETIME DEFAULT (now()),
  [Status] int NOT NULL DEFAULT (0),
  [TotalPrice] DECIMAL(10, 2)
)
GO

CREATE TABLE [Invoice_Detail] (
  [InvoiceID] integer,
  [DishID] integer,
  [Quantity] integer
)
GO

CREATE UNIQUE INDEX [Invoice_Detail_index_0] ON [Invoice_Detail] ("InvoiceID", "DishID")
GO

ALTER TABLE [Invoice] ADD FOREIGN KEY ([TableID]) REFERENCES [Table] ([TableID])
GO

ALTER TABLE [Invoice_Detail] ADD FOREIGN KEY ([InvoiceID]) REFERENCES [Invoice] ([InvoiceID])
GO

ALTER TABLE [Invoice_Detail] ADD FOREIGN KEY ([DishID]) REFERENCES [Dish] ([DishID])
GO

ALTER TABLE [Dish] ADD FOREIGN KEY ([CategoryID]) REFERENCES [Category] ([CategoryID])
GO

ALTER TABLE [Invoice] ADD FOREIGN KEY ([CustomerID]) REFERENCES [Customer] ([CustomerID])
GO
