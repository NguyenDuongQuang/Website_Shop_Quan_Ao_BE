create database DATN_SHOP;
use DATN_SHOP;
CREATE TABLE `Account`(
                          `Id` int NOT NULL,
                          `Name` nvarchar(50) NULL,
                          `Email` varchar(50) NULL,
                          `PhoneNumber` varchar(15) NULL,
                          `Password` varchar(255) NULL,
                          `Birthday` datetime NULL,
                          `Avatar` varchar(255) NULL,
                          `CreateDate` datetime NULL,
                          `UpdateDate` datetime NULL,
                          `Status` int NULL,
                          `RoleId` int NULL,
                          PRIMARY KEY (`Id`)
);

CREATE TABLE `Address`(
                          `Id` int NOT NULL,
                          `SpecificAddress` nvarchar(50) NULL,
                          `Ward` nvarchar(50) NULL,
                          `District` nvarchar(50) NULL,
                          `City` nvarchar(50) NULL,
                          `CreateDate` datetime NULL,
                          `UpdateDate` datetime NULL,
                          `Status` int NULL,
                          `AccountId` int NULL,
                          PRIMARY KEY (`Id`)
);
CREATE TABLE `Bill`(
                       `Id` int NOT NULL,
                       `CustomerName` nvarchar(50) NULL,
                       `Address` nvarchar(100) NULL,
                       `PhoneNumber` nvarchar(15) NULL,
                       `Note` nvarchar(255) NULL,
                       `OrderDate` datetime NULL,
                       `PaymentDate` datetime NULL,
                       `ConfirmationDate` datetime NULL,
                       `ShippingDate` datetime NULL,
                       `ReceivedDate` datetime NULL,
                       `CompletionDate` datetime NULL,
                       `ShippingFee`  int NULL,
                       `Price` int NULL,
                       `DiscountAmount` int NULL,
                       `TotalPrice` int NULL,
                       `CreateDate` datetime NULL,
                       `UpdateDate` datetime NULL,
                       `Status` int NULL,
                       `AccountId` int NULL,
                       `CustomerId` int NULL,
                       `VoucherId` int NULL,
                       PRIMARY KEY (`Id`)
);
CREATE TABLE `BillDetail`(
                             `Id` int NOT NULL,
                             `Price` int NULL,
                             `Quantity` int NULL,
                             `Status` int NULL,
                             `BillId` int NULL,
                             `ProductDetailId` int NULL,
                             PRIMARY KEY (`Id`)
);
CREATE TABLE `BillHistory`(
                              `Id` int NOT NULL,
                              `Name` nvarchar(50) NULL,
                              `Describe` nvarchar(255) NULL,
                              `CreateDate` datetime NULL,
                              `UpdateDate` datetime NULL,
                              `Status` int NULL,
                              `BillId` int NULL,
                              `AccountId` int NULL,
                              PRIMARY KEY (`Id`)
);
CREATE TABLE `Brand`(
                        `Id` int NOT NULL,
                        `Name` nvarchar(50) NULL,
                        `CreateDate` datetime NULL,
                        `UpdateDate` datetime NULL,
                        `Status` int NULL,
                        PRIMARY KEY (`Id`)
);
CREATE TABLE `Cart`(
                       `Id` int NOT NULL,
                       `CreateDate` datetime NULL,
                       `AccountId` int NULL,
                       PRIMARY KEY (`Id`)
);
CREATE TABLE `CartDetail`(
                             `Id` int NOT NULL,
                             `Price` int NULL,
                             `Quantity` int NULL,
                             `CreateDate` datetime NULL,
                             `UpdateDate` datetime NULL,
                             `Status` int NULL,
                             `CartId` int NULL,
                             `ProductDetailId` int NULL,
                             PRIMARY KEY (`Id`)
);
CREATE TABLE `Category`(
                           `Id` int NOT NULL,
                           `Name` nvarchar(50) NULL,
                           `CreateDate` datetime NULL,
                           `UpdateDate` datetime NULL,
                           `Status` int NULL,
                           PRIMARY KEY (`Id`)
);
CREATE TABLE `Color`(
                        `Id` int NOT NULL,
                        `Name` nvarchar(50) NULL,
                        `CreateDate` datetime NULL,
                        `UpdateDate` datetime NULL,
                        `Status` int NULL,
                        PRIMARY KEY (`Id`)
);
CREATE TABLE `Form`(
                       `Id` int NOT NULL,
                       `Name` nvarchar(50) NULL,
                       `CreateDate` datetime NULL,
                       `UpdateDate` datetime NULL,
                       `Status` int NULL,
                       PRIMARY KEY (`Id`)
);
CREATE TABLE `Image`(
                        `Id` int NOT NULL,
                        `Name` varchar(255) NULL,
                        `CreateDate` datetime NULL,
                        `UpdateDate` datetime NULL,
                        `Status` int NULL,
                        `ProductId` int NULL,
                        PRIMARY KEY (`Id`)
);
CREATE TABLE `Material`(
                           `Id` int NOT NULL,
                           `Name` nvarchar(50) NULL,
                           `CreateDate` datetime NULL,
                           `UpdateDate` datetime NULL,
                           `Status` int NULL,
                           PRIMARY KEY (`Id`)
);
CREATE TABLE `PaymentMethod`(
                                `Id` int NOT NULL,
                                `Name` nvarchar(50) NULL,
                                `Money` int NULL,
                                `Description` nvarchar(50) NULL,
                                `Status` int NULL,
                                `BillId` int NULL,
                                PRIMARY KEY (`Id`)
);
CREATE TABLE `Product`(
                          `Id` int NOT NULL,
                          `Code` varchar(50) UNIQUE,
                          `Name` nvarchar(50) NULL,
                          `Description` nvarchar(255) NULL,
                          `Price` int NULL,
                          `CreateDate` datetime NULL,
                          `UpdateDate` datetime NULL,
                          `Status` int NULL,
                          `BrandId` int NULL,
                          `CategoryId` int NULL,
                          `FormId` int NULL,
                          `MaterialId` int NULL,
                          PRIMARY KEY (`Id`)
);
CREATE TABLE `ProductDetail`(
                                `Id` int NOT NULL,
                                `Code` varchar(50) UNIQUE,
                                `Quantity` int NULL,
                                `CreateDate` datetime NULL,
                                `UpdateDate` datetime NULL,
                                `Status` int NULL,
                                `ProductId` int NULL,
                                `SizeId` int NULL,
                                `ColorId` int NULL,
                                PRIMARY KEY (`Id`)
);
CREATE TABLE `Promotion`(
                            `Id` int NOT NULL,
                            `Code` varchar(255) NULL,
                            `Name` nvarchar(50) NULL,
                            `Type` bit NULL,
                            `Value` int NULL,
                            `StartDate` datetime NULL,
                            `EndDate` datetime NULL,
                            `CreateDate` datetime NULL,
                            `UpdateDate` datetime NULL,
                            `Status` int NULL,
                            PRIMARY KEY (`Id`)
);
CREATE TABLE `PromotionDetail`(
                                  `Id` int NOT NULL,
                                  `Name` nvarchar(50) NULL,
                                  `CreateDate` datetime NULL,
                                  `UpdateDate` datetime NULL,
                                  `Status` int NULL,
                                  `ProductId` int NULL,
                                  `PromotionId` int NULL,
                                  PRIMARY KEY (`Id`)
);
CREATE TABLE `Role`(
                       `Id` int NOT NULL,
                       `Name` nvarchar(50) NULL,
                       `CreateDate` datetime NULL,
                       `UpdateDate` datetime NULL,
                       `Status` int NULL,
                       PRIMARY KEY (`Id`)
);
CREATE TABLE `Size`(
                       `Id` int NOT NULL,
                       `Name` nvarchar(50) NULL,
                       `CreateDate` datetime NULL,
                       `UpdateDate` datetime NULL,
                       `Status` int NULL,
                       PRIMARY KEY (`Id`)
);
CREATE TABLE `Voucher`(
                          `Id` int NOT NULL,
                          `Code` varchar(50) NULL,
                          `Name` nvarchar(50) NULL,
                          `Type` bit NULL,
                          `Value` int NULL,
                          `Quantity` int NULL,
                          `MinimumPrice` int NULL,
                          `MaximumDiscount` int NULL,
                          `StartDate` datetime NULL,
                          `EndDate` datetime NULL,
                          `CreateDate` datetime NULL,
                          `UpdateDate` datetime NULL,
                          `Status` int NULL,
                          PRIMARY KEY (`Id`)
);
ALTER TABLE `Account`   ADD  CONSTRAINT `FKi9xmahyh65di7x2wn5fvt8lv3` FOREIGN KEY(`RoleId`)
    REFERENCES `Role` (`Id`);
ALTER TABLE `Address`   ADD  CONSTRAINT `FK3haj5uqn2j6ar58mcglooa5bp` FOREIGN KEY(`AccountId`)
    REFERENCES `Account` (`Id`);

ALTER TABLE `Bill`   ADD  CONSTRAINT `FK5mrre5s0gacpqu6737kfocwkl` FOREIGN KEY(`CustomerId`)
    REFERENCES `Account` (`Id`);
ALTER TABLE `Bill`   ADD  CONSTRAINT `FKdlpt4y8nuurj83nht236onfi6` FOREIGN KEY(`AccountId`)
    REFERENCES `Account` (`Id`);
ALTER TABLE `Bill`   ADD  CONSTRAINT `FK2hf3g6padqdy15tccpshmpxob` FOREIGN KEY(`VoucherId`)
    REFERENCES `Voucher` (`Id`);

ALTER TABLE `BillDetail`   ADD  CONSTRAINT `FK8sw1tfhht3q5xtdsyoe0r7jfd` FOREIGN KEY(`BillId`)
    REFERENCES `Bill` (`Id`);
ALTER TABLE `BillDetail`   ADD  CONSTRAINT `FKnt7lacod5l24jdnfgxfydqiu2` FOREIGN KEY(`ProductDetailId`)
    REFERENCES `ProductDetail` (`Id`);
ALTER TABLE `BillHistory`   ADD  CONSTRAINT `FKdwtgkov1ar5uki43w7okh9xqi` FOREIGN KEY(`BillId`)
    REFERENCES `Bill` (`Id`);
ALTER TABLE `BillHistory`   ADD  CONSTRAINT `FKowiek2xkcm34kzm23jlzms92j` FOREIGN KEY(`AccountId`)
    REFERENCES `Account` (`Id`);
ALTER TABLE `Cart`   ADD  CONSTRAINT `FK1w1km3ww10t0maawf2cymyx5i` FOREIGN KEY(`AccountId`)
    REFERENCES `Account` (`Id`);
ALTER TABLE `CartDetail`   ADD  CONSTRAINT `FK6unelr9lsy26gw9da5tuuxcsh` FOREIGN KEY(`CartId`)
    REFERENCES `Cart` (`Id`);
ALTER TABLE `CartDetail`   ADD  CONSTRAINT `FKepuvpwbykpahqt0gagvvdqoyn` FOREIGN KEY(`ProductDetailId`)
    REFERENCES `ProductDetail` (`Id`);
ALTER TABLE `Image`   ADD  CONSTRAINT `FKdtaisglfgjjj5j1a7g3fcev7c` FOREIGN KEY(`ProductId`)
    REFERENCES `Product` (`Id`);
ALTER TABLE `PaymentMethod`   ADD  CONSTRAINT `FKjity6x6p1194mtoli4abb3jgc` FOREIGN KEY(`BillId`)
    REFERENCES `Bill` (`Id`);
ALTER TABLE `Product`   ADD  CONSTRAINT `FK4cx1ir1xlnytlte2quullny9m` FOREIGN KEY(`FormId`)
    REFERENCES `Form` (`Id`);
ALTER TABLE `Product`   ADD  CONSTRAINT `FK6pnobu31k3yhhmk45s97imkui` FOREIGN KEY(`CategoryId`)
    REFERENCES `Category` (`Id`);
ALTER TABLE `Product`   ADD  CONSTRAINT `FKfc8uiunvrolmn3qa9ahrhmtrw` FOREIGN KEY(`MaterialId`)
    REFERENCES `Material` (`Id`);
ALTER TABLE `Product`   ADD  CONSTRAINT `FKnuw1iwpj73v904j79uc8qurgc` FOREIGN KEY(`BrandId`)
    REFERENCES `Brand` (`Id`);
ALTER TABLE `ProductDetail`   ADD  CONSTRAINT `FKik38y3bjry9u05majdn5u3egj` FOREIGN KEY(`ProductId`)
    REFERENCES `Product` (`Id`);
ALTER TABLE `ProductDetail`   ADD  CONSTRAINT `FK61xkqx42jtcc8we64hahp05pv` FOREIGN KEY(`SizeId`)
    REFERENCES `Size` (`Id`);
ALTER TABLE `ProductDetail`   ADD  CONSTRAINT `FKntlsi9s4irkogtc9mbw03s90y` FOREIGN KEY(`ColorId`)
    REFERENCES `Color` (`Id`);
ALTER TABLE `PromotionDetail`   ADD  CONSTRAINT `FKa83ktjk5axkasy5c9v2s1ukig` FOREIGN KEY(`ProductId`)
    REFERENCES `Product` (`Id`);
ALTER TABLE `PromotionDetail`   ADD  CONSTRAINT `FKos6ftbatvw4mk81km7xpkds5i` FOREIGN KEY(`PromotionId`)
    REFERENCES `Promotion` (`Id`);
-- SELECT * FROM Brand;
--     INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Reebok', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Asics', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Brooks', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Mizuno', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'New balance', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Puma', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Nike', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Skechers', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Under armour', GETDATE(), GETDATE(), 1)
-- INSERT INTO Brand (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Adidas', GETDATE(), GETDATE(), 1)


-- SELECT * FROM Category
--     INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Áo thun', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Áo khoác', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Áo ngắn tay', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Áo Polo', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Áo dài tay', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Quần bó', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Quần cạp cao', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Quần đùi', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Quần dài', GETDATE(), GETDATE(), 1)
-- INSERT INTO Category (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Quần legging', GETDATE(), GETDATE(), 1)

-- SELECT * FROM Material
--     INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Spandex', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Cotton', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Mesh', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Nylon', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Viscose', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Microfiber', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Linen', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Syntheic', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Polyester', GETDATE(), GETDATE(), 1)
-- INSERT INTO Material (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Fleece', GETDATE(), GETDATE(), 1)


-- SELECT * FROM Form
--     INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Bó', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Rộng', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Tank top', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Jogger', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Dài', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Ngắn', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Dày', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Mỏng', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Lưới', GETDATE(), GETDATE(), 1)
-- INSERT INTO Form (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Thiếu vải', GETDATE(), GETDATE(), 1)


-- SELECT * FROM Size
--     INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'28', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'29', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'30', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'31', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'32', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'XXL', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'XL', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'L', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'S', GETDATE(), GETDATE(), 1)
-- INSERT INTO Size (name, CreateDate, UpdateDate, Status)
-- VALUES (N'M', GETDATE(), GETDATE(), 1)


-- SELECT * FROM Color
--     INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Đen', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Đỏ', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Xanh dương', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Xanh lá', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Vàng', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Trắng', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Xám', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Ghi', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Nâu', GETDATE(), GETDATE(), 1)
-- INSERT INTO Color (name, CreateDate, UpdateDate, Status)
-- VALUES (N'Cam', GETDATE(), GETDATE(), 1)


-- SELECT * FROM Product
--     INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0001', N'Áo thun tay ngắn', N'vip pro', 123, GETDATE(), GETDATE(), 1, 1, 1, 1, 1);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0002', N'Áo khoác Flannel tay dài kháo kéo', N'Chiến thần', 234, GETDATE(), GETDATE(), 1, 2, 2, 2, 2);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0003', N'Áo khoác bomber Nylon', N'quá là áo', 345, GETDATE(), GETDATE(), 1, 3, 3, 3, 3);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0004', N'Áo len Polo', N'vip plus', 222, GETDATE(), GETDATE(), 1, 4, 4, 4, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0005', N'Áo Gile len', N'trên cả tuyệt vời', 33, GETDATE(), GETDATE(), 1, 5, 5, 5, 5);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0006', N'Áo Hoodie unisex', N'áo này đẹp lắm', 44, GETDATE(), GETDATE(), 1, 6, 6, 6, 6);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0007', N'Áo Polo vải gân', N'mua đi đừng ngại', 55, GETDATE(), GETDATE(), 1, 7, 7, 7, 7);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0008', N'Áo dài tay', N'mua đi nghèo lắm rồi', 678, GETDATE(), GETDATE(), 1, 8, 8, 8, 8);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0009', N'Áo Superman', N'mua đi đừng ngại', 789, GETDATE(), GETDATE(), 1, 9, 9, 9, 9);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0010', N'Áo Batman', N'mua đi nghèo lắm rồi',367, GETDATE(), GETDATE(), 1, 10, 10, 10, 10);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0011', N'Áo Hulk', N'mua đi nghèo lắm rồi', 112, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0012', N'Áo Hulk', N'mua đi nghèo lắm rồi', 493, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0013', N'Áo Hulk', N'mua đi nghèo lắm rồi', 236, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0014', N'Áo Hulk', N'mua đi nghèo lắm rồi', 567, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0015', N'Áo Hulk', N'mua đi nghèo lắm rồi', 777, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0016', N'Áo Hulk', N'mua đi nghèo lắm rồi', 900, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0017', N'Áo Hulk', N'mua đi nghèo lắm rồi', 121, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0018', N'Áo Hulk', N'mua đi nghèo lắm rồi', 351, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0019', N'Áo Hulk', N'mua đi nghèo lắm rồi', 684, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0020', N'Áo Hulk', N'mua đi nghèo lắm rồi', 686, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- INSERT INTO Product (code, name, Description, Price, CreateDate, UpdateDate, Status, BrandId, CategoryId, FormId, MaterialId)
-- VALUES ('SP0021', N'Áo Superman', N'mua đi nghèo lắm rồi', 686, GETDATE(), GETDATE(), 1, 1, 2,3, 4);
-- USE Nova_Store_DB
-- SELECT * FROM Product

-- SELECT * FROM ProductDetail
--     INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0001', 12, GETDATE(), GETDATE(), 1, 1, 1, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0002', 22, GETDATE(), GETDATE(), 1, 2, 2, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0003', 30, GETDATE(), GETDATE(), 1, 3, 1, 2);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0004', 40, GETDATE(), GETDATE(), 1, 4, 2, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0005', 31, GETDATE(), GETDATE(), 1, 5, 3, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0006', 12, GETDATE(), GETDATE(), 1, 6, 5, 6);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0007', 11, GETDATE(), GETDATE(), 1, 7, 7, 8);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0008', 60, GETDATE(), GETDATE(), 1, 8, 9, 10);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0009', 27, GETDATE(), GETDATE(), 1, 9, 2, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0010', 38, GETDATE(), GETDATE(), 1, 10, 4, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0011', 36, GETDATE(), GETDATE(), 1, 11, 4, 9);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0012', 18, GETDATE(), GETDATE(), 1, 12, 2, 7);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0013', 24, GETDATE(), GETDATE(), 1, 13, 3, 8);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0014', 44, GETDATE(), GETDATE(), 1, 14, 10, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0015', 55, GETDATE(), GETDATE(), 1, 15, 6, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0016', 46, GETDATE(), GETDATE(), 1, 16, 3, 5);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0017', 71, GETDATE(), GETDATE(), 1, 17, 1, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0018', 28, GETDATE(), GETDATE(), 1, 18, 9, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0019', 23, GETDATE(), GETDATE(), 1, 19, 10, 2);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0020', 26, GETDATE(), GETDATE(), 1, 20, 2, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0021', 2, GETDATE(), GETDATE(), 1, 21, 5, 8);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0022', 34, GETDATE(), GETDATE(), 1, 1, 2, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0023', 51, GETDATE(), GETDATE(), 1, 2, 3, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0024', 61, GETDATE(), GETDATE(), 1, 3, 2, 8);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0025', 73, GETDATE(), GETDATE(), 1, 4, 3, 5);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0026', 82, GETDATE(), GETDATE(), 1, 5, 2, 7);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0027', 23, GETDATE(), GETDATE(), 1, 6, 4, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0028', 73, GETDATE(), GETDATE(), 1, 7, 2, 2);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0029', 28, GETDATE(), GETDATE(), 1, 8, 5, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0030', 38, GETDATE(), GETDATE(), 1, 9, 3, 9);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0031', 128, GETDATE(), GETDATE(), 1, 10, 2, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0032', 38, GETDATE(), GETDATE(), 1, 11, 2, 9);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0033', 282, GETDATE(), GETDATE(), 1, 12, 5, 7);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0034', 382, GETDATE(), GETDATE(), 1, 13, 5, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0035', 311, GETDATE(), GETDATE(), 1, 14, 5, 5);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0036', 111, GETDATE(), GETDATE(), 1, 15, 9, 7);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0037', 112, GETDATE(), GETDATE(), 1, 16, 10, 10);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0038', 138, GETDATE(), GETDATE(), 1, 17, 5, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0039', 222, GETDATE(), GETDATE(), 1, 18, 6, 6);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0040', 100, GETDATE(), GETDATE(), 1, 19, 2, 10);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0041', 99, GETDATE(), GETDATE(), 1, 20, 1, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0042', 28, GETDATE(), GETDATE(), 1, 21, 2, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0043', 12, GETDATE(), GETDATE(), 1, 1, 1, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0044', 14, GETDATE(), GETDATE(), 1, 2, 2, 5);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0045', 223, GETDATE(), GETDATE(), 1, 3, 9, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0046', 333, GETDATE(), GETDATE(), 1, 4, 8, 3);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0047', 492, GETDATE(), GETDATE(), 1, 5, 2, 1);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0048', 389, GETDATE(), GETDATE(), 1, 6, 2, 4);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0049', 123, GETDATE(), GETDATE(), 1, 7, 1, 2);
-- INSERT INTO ProductDetail (code, quantity, CreateDate, UpdateDate, Status, ProductId, SizeId, ColorId)
-- VALUES ('CT0050', 324, GETDATE(), GETDATE(), 1, 8, 2, 3);
