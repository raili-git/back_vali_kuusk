-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-12-01 07:22:54.038

-- tables
-- Table: address
CREATE TABLE address (
                         id serial  NOT NULL,
                         county_id int  NOT NULL,
                         street varchar(255)  NOT NULL,
                         CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         phone_number varchar(255)  NOT NULL,
                         email varchar(255)  NOT NULL,
                         first_name varchar(255)  NOT NULL,
                         last_name varchar(255)  NOT NULL,
                         address_id int  NOT NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county (
                        id serial  NOT NULL,
                        name varchar(255)  NOT NULL,
                        CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: delivery
CREATE TABLE delivery (
                          id serial  NOT NULL,
                          type varchar(255)  NOT NULL,
                          price int  NOT NULL,
                          CONSTRAINT delivery_pk PRIMARY KEY (id)
);

-- Table: height
CREATE TABLE height (
                        id serial  NOT NULL,
                        gap varchar(255)  NOT NULL,
                        CONSTRAINT height_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
                         id serial  NOT NULL,
                         delivery_id int  NOT NULL,
                         status char(1)  NOT NULL,
                         first_name varchar(255)  NOT NULL,
                         last_name varchar(255)  NOT NULL,
                         phone_number int  NOT NULL,
                         email varchar(255)  NOT NULL,
                         CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: order_product
CREATE TABLE order_product (
                               id serial  NOT NULL,
                               order_id int  NOT NULL,
                               product_id int  NOT NULL,
                               CONSTRAINT order_product_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         type_id int  NOT NULL,
                         address_id int  NOT NULL,
                         county_id int  NOT NULL,
                         height_id int  NOT NULL,
                         status char(1)  NOT NULL,
                         image_data bytea  NOT NULL,
                         price int  NOT NULL,
                         user_id int  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      type varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        contact_id int  NULL,
                        role_id int  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: address_county (table: address)
ALTER TABLE address ADD CONSTRAINT address_county
    FOREIGN KEY (county_id)
        REFERENCES county (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: contact_address (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_address
    FOREIGN KEY (address_id)
        REFERENCES address (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_delivery (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_delivery
    FOREIGN KEY (delivery_id)
        REFERENCES delivery (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_product_order (table: order_product)
ALTER TABLE order_product ADD CONSTRAINT order_product_order
    FOREIGN KEY (order_id)
        REFERENCES "order" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_product_product (table: order_product)
ALTER TABLE order_product ADD CONSTRAINT order_product_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_address (table: product)
ALTER TABLE product ADD CONSTRAINT product_address
    FOREIGN KEY (address_id)
        REFERENCES address (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_county (table: product)
ALTER TABLE product ADD CONSTRAINT product_county
    FOREIGN KEY (county_id)
        REFERENCES county (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_height (table: product)
ALTER TABLE product ADD CONSTRAINT product_height
    FOREIGN KEY (height_id)
        REFERENCES height (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_type (table: product)
ALTER TABLE product ADD CONSTRAINT product_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_user (table: product)
ALTER TABLE product ADD CONSTRAINT product_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.