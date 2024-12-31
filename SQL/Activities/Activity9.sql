-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

//Write an SQL statement to know which salesman are working for which customer.

select c.customer_name , s.salesman_name from customers c
    inner join salesman s on
      c.salesman_id = s.salesman_id;

//Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.

select * from customers c left outer join 
     salesman s on s.salesman_id=c.salesman_id where c.grade < 300 order by c.customer_id ;

//Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.

SELECT c.customer_name , s.salesman_name, s.commission FROM customers c
 INNER JOIN salesman s ON c.salesman_id=s.salesman_id 
 WHERE s.commission>12;

//Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and commission rate he gets for an order.

SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_name , c.salesman_name, c.commission FROM orders o 
INNER JOIN customers c ON c.customer_id=o.customer_id 
INNER JOIN salesman c ON c.salesman_id=o.salesman_id;


