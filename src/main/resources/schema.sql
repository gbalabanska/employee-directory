DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE IF NOT EXISTS department (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS employee (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    first_name varchar(255) DEFAULT NULL,
    last_name varchar(255) DEFAULT NULL,
    email varchar(255) DEFAULT NULL,
    department_id bigint(20) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE members (
    user_id varchar(50) NOT NULL,
    pw varchar(88) NOT NULL,
    active tinyint NOT NULL,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE roles (
    user_id varchar(50) NOT NULL,
    role varchar(50) NOT NULL,
    UNIQUE KEY authorities5_idx_1 (user_id,role),
    CONSTRAINT authorities5_ibfk_1 FOREIGN KEY (user_id) REFERENCES members (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
