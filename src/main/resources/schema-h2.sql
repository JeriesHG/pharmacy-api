/**
 * Author:  JeriesHG
 * Created: Jun 27, 2017
 */
DROP TABLE IF EXISTS Stock_element;
CREATE TABLE Stock_element (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(10,2) not null,
    cost DECIMAL(10,2) not null,
    vendor VARCHAR(32) not null
);

DROP TABLE IF EXISTS Stock;
CREATE TABLE Stock (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantity INT not null,
    id_stock_element INT not null,
    UNIQUE (id_stock_element)
);

DROP TABLE IF EXISTS Medicine;
CREATE TABLE Medicine (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pr_name VARCHAR(64) not null,
    expiration_date DATE not null,
    id_stock_element INT not null,
    weight DECIMAL (10,2) not null,
    UNIQUE (id_stock_element)
);

DROP TABLE IF EXISTS Beauty_product;
CREATE TABLE Beauty_product (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pr_name VARCHAR(64) not null,
    expiration_date DATE not null,
    id_stock_element INT not null,
    UNIQUE (id_stock_element)
);

DROP TABLE IF EXISTS Market_research;
CREATE TABLE Market_research (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rate Decimal(10,4) not null,
    id_beauty_product INT not null,
    FOREIGN KEY (id_beauty_product) REFERENCES Beauty_product(Id)
);