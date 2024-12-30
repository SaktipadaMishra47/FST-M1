-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
INSERT ALL
    INTO orders VALUES(701, 50.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 70.65, TO_DATE('2024/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(12, 5.26, TO_DATE('2013/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(35, 10.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(7054007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(22, 200.6, TO_DATE('2024/07/27', 'YYYY/MM/DD'), 307, 5001)
    INTO orders VALUES(5, 570, TO_DATE('2024/08/15', 'YYYY/MM/DD'), 302, 5001)
    INTO orders VALUES(3454, 983.43, TO_DATE('2024/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(54, 280.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 309, 5003)
    INTO orders VALUES(565, 20.45, TO_DATE('2024/06/27', 'YYYY/MM/DD'), 308, 5002)
    INTO orders VALUES(4343, 5.29, TO_DATE('2024/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(343, 305.6, TO_DATE('2024/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;
