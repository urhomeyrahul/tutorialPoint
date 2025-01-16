
CREATE TABLE IF NOT EXISTS courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    username VARCHAR(255) NOT NULL
);

-- INSERT INTO courses (description, username) values (
--     "Learn Full stack with Spring Boot and Angular", "Urhomey.Rahul"
-- );

-- INSERT INTO courses (description, username) values (
--     "Learn Full stack with Spring Boot and React", "Urhomey.Rahul"
-- );

-- INSERT INTO courses (description, username) values (
--     "Master Microservices with Spring Boot and Spring Cloud", "Urhomey.Rahul"
-- );

-- INSERT INTO courses (description, username) values (
--     "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes", "Urhomey.Rahul" 
-- );