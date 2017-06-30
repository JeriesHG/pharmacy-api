/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  JeriesHG
 * Created: Jun 27, 2017
 */

INSERT INTO Stock_element (price, cost, vendor) VALUES(10, 5, 'Bob Company');
INSERT INTO Stock_element (price, cost, vendor) VALUES(15, 10, 'John Company');
INSERT INTO Stock_element (price, cost, vendor) VALUES(20, 15, 'Agile Solutions');
INSERT INTO Stock_element (price, cost, vendor) VALUES(25, 20, 'Mack Company');
INSERT INTO Stock_element (price, cost, vendor) VALUES(30, 20, 'George Company');
INSERT INTO Stock_element (price, cost, vendor) VALUES(35, 35, 'Mary Company');

INSERT INTO Stock (quantity, id_stock_element) VALUES(15, 1);
INSERT INTO Stock (quantity, id_stock_element) VALUES(28, 2);
INSERT INTO Stock (quantity, id_stock_element) VALUES(32, 3);
INSERT INTO Stock (quantity, id_stock_element) VALUES(48, 4);
INSERT INTO Stock (quantity, id_stock_element) VALUES(64, 5);
INSERT INTO Stock (quantity, id_stock_element) VALUES(5, 6);

INSERT INTO Medicine (expiration_date, pr_name, id_stock_element, weight) VALUES('2017-06-30', 'Sudagrip',1, 0.5);
INSERT INTO Medicine (expiration_date, pr_name, id_stock_element, weight) VALUES('2017-07-01', 'Panadol',2, 0.2);
INSERT INTO Medicine (expiration_date, pr_name, id_stock_element, weight) VALUES('2017-07-15', 'Peptobismol',3, 1.2);

INSERT INTO Beauty_product (expiration_date, pr_name, id_stock_element) VALUES('2017-06-30', 'Pantene Shampoo',4);
INSERT INTO Beauty_product (expiration_date, pr_name, id_stock_element) VALUES('2017-07-01', 'Carolina Herrera Makeup',5);
INSERT INTO Beauty_product (expiration_date, pr_name, id_stock_element) VALUES('2017-07-30', 'Nautica Voyage',6);

INSERT INTO Market_research (rate, id_beauty_product) VALUES(1, 1);
INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.5, 1);
INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.7, 1);

INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.2, 2);
INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.5, 2);
INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.7, 2);

INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.1, 3);
INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.8, 3);
INSERT INTO Market_research (rate, id_beauty_product) VALUES(0.4, 3);
