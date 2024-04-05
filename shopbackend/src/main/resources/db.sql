CREATE DATABASE shop_online;
USE shop_online;
CREATE TABLE users(
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      fullname VARCHAR(100) DEFAULT '',
                      phone_number VARCHAR(20) NOT NULL,
                      address VARCHAR(100) DEFAULT '',
                      passwords VARCHAR(100) NOT NULL,
                      created_at DATETIME,
                      update_at DATETIME,
                      is_active TINYINT DEFAULT 1,
                      date_of_brith DATE,
                      status_user INT NOT NULL
);
CREATE TABLE category(
                         id INT AUTO_INCREMENT  PRIMARY KEY ,
                         name VARCHAR(100) NOT NULL,
                         status int NOT NULL
);
CREATE TABLE products(
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         price float NOT NULL,
                         thumbnail VARCHAR(100) DEFAULT '',
                         description VARCHAR(100) NOT NULL,
                         created_at DATETIME,
                         update_at DATETIME,
                         discount int NOT NULL,
                         `quantity` int NOT NULL,
                         `status` int NOT NULL,
                         `category_id` int NULL,
                         constraint FKdujockiancjr5q3jqf74hc90h
                             foreign key (category_id) references category (id)
);
CREATE TABLE product_image(
                              id INT AUTO_INCREMENT  PRIMARY KEY ,
                              img_url VARCHAR(1000) NOT NULL,
                              `product_id` int NULL,
                              constraint FKdujockiancjr5q3jqf74hc90d
                                  foreign key (product_id) references products (id)
);
CREATE TABLE orders(
                       id INT AUTO_INCREMENT  PRIMARY KEY ,
                       fullname VARCHAR(100) NOT NULL,
                       email VARCHAR(50) NOT NULL,
                       phone_number VARCHAR(20) NOT NULL,
                       address VARCHAR(20) NOT NULL,
                       note VARCHAR(100) DEFAULT '',
                       order_date DATETIME,
                       status INT NOT NULL,
                       total_money FLOAT NOT NULL,
                       payment_method INT NOT NULL,
                       `user_id` int NULL,
                       constraint FKdujockiancjr5q3jqf74hc90i
                           foreign key (user_id) references users (id)
);
CREATE TABLE order_detail(
                             id INT AUTO_INCREMENT  PRIMARY KEY ,
                             price float NULL,
                             quantity int NULL,
                             total_money FLOAT NOT NULL,
                             order_id int NULL,
                             constraint FKdujockiancjr5q3jqf74hc90k
                                 foreign key (order_id) references orders (id),
                             product_id int NULL,
                             constraint FKg9du18dwb7uy1iyqj45sdwjrh
                                 foreign key (product_id) references products (id)
)

