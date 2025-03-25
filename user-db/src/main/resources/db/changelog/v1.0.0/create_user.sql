--liquibase formatted sql
--changeset ilya.sh:1
CREATE TABLE IF NOT EXISTS app_user (
    id UUID PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    second_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    username VARCHAR(100) UNIQUE NOT NULL,
    password TEXT UNIQUE NOT NULL,
    age INTEGER NOT NULL,
    email VARCHAR(50),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--rollback DROP TABLE user;
