-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-22 12:16:21.986

-- tables
-- Table: address
CREATE TABLE address (
                         id serial  NOT NULL,
                         county varchar(255)  NOT NULL,
                         x int  NOT NULL,
                         y int  NOT NULL,
                         street varchar(255)  NOT NULL,
                         postalcode varchar(255)  NOT NULL,
                         seller_id int  NOT NULL,
                         customer_id int  NOT NULL,
                         county_id int  NOT NULL,
                         CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: cart
CREATE TABLE cart (
                      id serial  NOT NULL,
                      customer_id int  NOT NULL,
                      CONSTRAINT cart_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         phone_number varchar(255)  NOT NULL,
                         email varchar(255)  NOT NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county (
                        id serial  NOT NULL,
                        name varchar(255)  NOT NULL,
                        product_id int  NOT NULL,
                        CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
                          id serial  NOT NULL,
                          first_name varchar(255)  NOT NULL,
                          last_name varchar(255)  NOT NULL,
                          role_id int  NOT NULL,
                          contact_id int  NOT NULL,
                          CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: delivery
CREATE TABLE delivery (
                          id serial  NOT NULL,
                          type varchar(255)  NOT NULL,
                          cart_id int  NOT NULL,
                          CONSTRAINT delivery_pk PRIMARY KEY (id)
);

-- Table: height
CREATE TABLE height (
                        id serial  NOT NULL,
                        gap varchar(255)  NOT NULL,
                        product_id int  NOT NULL,
                        CONSTRAINT height_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         status char(1)  NOT NULL,
                         image int  NOT NULL,
                         price int  NOT NULL,
                         seller_id int  NOT NULL,
                         cart_id int  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      type varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: seller
CREATE TABLE seller (
                        id serial  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        first_name varchar(255)  NOT NULL,
                        last_name varchar(255)  NOT NULL,
                        user_id int  NOT NULL,
                        role_id int  NOT NULL,
                        contact_id int  NOT NULL,
                        CONSTRAINT seller_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      product_id int  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
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

-- Reference: address_customer (table: address)
ALTER TABLE address ADD CONSTRAINT address_customer
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: address_seller (table: address)
ALTER TABLE address ADD CONSTRAINT address_seller
    FOREIGN KEY (seller_id)
        REFERENCES seller (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: cart_customer (table: cart)
ALTER TABLE cart ADD CONSTRAINT cart_customer
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: county_product (table: county)
ALTER TABLE county ADD CONSTRAINT county_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: customer_contact (table: customer)
ALTER TABLE customer ADD CONSTRAINT customer_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: customer_role (table: customer)
ALTER TABLE customer ADD CONSTRAINT customer_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: delivery_cart (table: delivery)
ALTER TABLE delivery ADD CONSTRAINT delivery_cart
    FOREIGN KEY (cart_id)
        REFERENCES cart (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: height_product (table: height)
ALTER TABLE height ADD CONSTRAINT height_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_cart (table: product)
ALTER TABLE product ADD CONSTRAINT product_cart
    FOREIGN KEY (cart_id)
        REFERENCES cart (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_seller (table: product)
ALTER TABLE product ADD CONSTRAINT product_seller
    FOREIGN KEY (seller_id)
        REFERENCES seller (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: seller_contact (table: seller)
ALTER TABLE seller ADD CONSTRAINT seller_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: seller_role (table: seller)
ALTER TABLE seller ADD CONSTRAINT seller_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: seller_user (table: seller)
ALTER TABLE seller ADD CONSTRAINT seller_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: type_product (table: type)
ALTER TABLE type ADD CONSTRAINT type_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

