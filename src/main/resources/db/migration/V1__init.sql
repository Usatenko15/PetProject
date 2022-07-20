CREATE TABLE customer
(
    customer_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE order1
(
    order_id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    description VARCHAR(255)                            NOT NULL,
    is_done     BOOLEAN                                 NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE             NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    customer_id BIGINT,
    CONSTRAINT pk_order1 PRIMARY KEY (order_id)
);

ALTER TABLE order1
    ADD CONSTRAINT FK_ORDER1_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);