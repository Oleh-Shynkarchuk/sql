CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    dob DATE,
    primary_skill VARCHAR(255),
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP
);

-- Create the phone table
CREATE TABLE phone (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    number VARCHAR(50),
    FOREIGN KEY (student_id)
        REFERENCES student(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Create the subject table
CREATE TABLE subject (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    tutor VARCHAR(255)
);

-- Create the exam_result table
CREATE TABLE exam_result (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject_id INT,
    mark SMALLINT,
    FOREIGN KEY (student_id)
        REFERENCES student(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (subject_id)
        REFERENCES subject(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);