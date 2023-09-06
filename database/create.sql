-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-06 11:23:06.09

-- tables
-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    lesson_id int  NOT NULL,
    data bytea  NOT NULL,
    description varchar(255)  NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: lesson
CREATE TABLE lesson (
    id serial  NOT NULL,
    package_type_id int  NULL,
    technology_id int  NULL,
    name varchar(255)  NOT NULL,
    content bytea  NULL,
    status char(1)  NOT NULL,
    sequence int  NULL,
    CONSTRAINT lesson_pk PRIMARY KEY (id)
);

-- Table: package_type
CREATE TABLE package_type (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    price int  NOT NULL,
    CONSTRAINT package_type_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: technology
CREATE TABLE technology (
    id serial  NOT NULL,
    package_type_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    status char(1)  NULL,
    CONSTRAINT technology_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    package_type_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_lesson
CREATE TABLE user_lesson (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    lesson_id int  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_lesson_pk PRIMARY KEY (id)
);

-- Table: video
CREATE TABLE video (
    id serial  NOT NULL,
    lesson_id int  NOT NULL,
    link varchar(1000)  NOT NULL,
    description varchar(255)  NULL,
    CONSTRAINT video_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: image_lesson (table: image)
ALTER TABLE image ADD CONSTRAINT image_lesson
    FOREIGN KEY (lesson_id)
    REFERENCES lesson (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: lesson_package_type (table: lesson)
ALTER TABLE lesson ADD CONSTRAINT lesson_package_type
    FOREIGN KEY (package_type_id)
    REFERENCES package_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: lesson_technology (table: lesson)
ALTER TABLE lesson ADD CONSTRAINT lesson_technology
    FOREIGN KEY (technology_id)
    REFERENCES technology (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: technology_package_type (table: technology)
ALTER TABLE technology ADD CONSTRAINT technology_package_type
    FOREIGN KEY (package_type_id)
    REFERENCES package_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_lesson_lesson (table: user_lesson)
ALTER TABLE user_lesson ADD CONSTRAINT user_lesson_lesson
    FOREIGN KEY (lesson_id)
    REFERENCES lesson (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_lesson_user (table: user_lesson)
ALTER TABLE user_lesson ADD CONSTRAINT user_lesson_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_package_type (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_package_type
    FOREIGN KEY (package_type_id)
    REFERENCES package_type (id)  
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

-- Reference: video_lesson (table: video)
ALTER TABLE video ADD CONSTRAINT video_lesson
    FOREIGN KEY (lesson_id)
    REFERENCES lesson (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

