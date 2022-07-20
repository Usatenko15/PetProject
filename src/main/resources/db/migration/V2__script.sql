INSERT INTO customer (customer_id, name) VALUES
    (1, 'customer1');
INSERT INTO customer (customer_id, name) VALUES
    (2, 'customer2');
INSERT INTO customer (customer_id, name) VALUES
    (3, 'customer3');

INSERT INTO order1 (order_id, description, is_done, created_at, updated_at, customer_id) VALUES
    (5, 'order1', false, current_timestamp, current_timestamp, 1);
INSERT INTO order1 (order_id, description, is_done, created_at, updated_at, customer_id) VALUES
    (6, 'order2', false, current_timestamp, current_timestamp, 1);
INSERT INTO order1 (order_id, description, is_done, created_at, updated_at, customer_id) VALUES
    (7, 'order3', false, current_timestamp, current_timestamp, 2);