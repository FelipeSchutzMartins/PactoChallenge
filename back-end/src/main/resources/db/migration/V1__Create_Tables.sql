CREATE SCHEMA IF NOT EXISTS pacto;

CREATE TABLE IF NOT EXISTS user_account (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS authority (
    id SERIAL PRIMARY KEY,
    authority VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS authority_user_account (
    id SERIAL PRIMARY KEY,
    user_account_id INT REFERENCES user_account(id),
    authority_id INT REFERENCES authority(id)
);

CREATE TABLE IF NOT EXISTS employer (
    id SERIAL PRIMARY KEY,
    user_account_id INT REFERENCES user_account(id),
    company_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS candidate (
    id SERIAL PRIMARY KEY,
    user_account_id INT REFERENCES user_account(id),
    candidate_name VARCHAR(30) NOT NULL,
    candidate_surname VARCHAR(30) NOT NULL,
    about VARCHAR(300) NOT NULL,
    phone VARCHAR(13) NOT NULL
);

CREATE TABLE IF NOT EXISTS skill (
    id SERIAL PRIMARY KEY,
    skill VARCHAR(50) NOT NULL,
    years_using VARCHAR(10) not null,
    candidate_id INT REFERENCES candidate(id)
);

CREATE TABLE IF NOT EXISTS experience (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    company VARCHAR(50) NOT NULL,
    responsibilities VARCHAR(300),
    work_position VARCHAR(50) NOT NULL,
    currently_working BOOLEAN,
    candidate_id INT REFERENCES candidate(id)
);

CREATE TABLE IF NOT EXISTS education (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    on_going BOOLEAN,
    institution VARCHAR(50) NOT NULL,
    kind_degree VARCHAR(50) NOT NULL,
    course_name VARCHAR(50),
    candidate_id INT REFERENCES candidate(id)
);

CREATE TABLE IF NOT EXISTS job_position (
    id SERIAL PRIMARY KEY,
    employer_id INT REFERENCES employer(id),
    position_title VARCHAR(50) NOT NULL,
    about_job VARCHAR NOT NULL,
    posted_on DATE NOT NULL,
    work_from VARCHAR(50) NOT NULL,
    closed_on DATE
);

CREATE TABLE IF NOT EXISTS job_application (
    id SERIAL PRIMARY KEY,
    candidate_id INT REFERENCES candidate(id),
    position_id INT REFERENCES job_position(id),
    applied_on DATE NOT NULL,
    reason_closure VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS application_feedback (
    id SERIAL PRIMARY KEY,
    application_id INT REFERENCES job_application(id),
    send_on DATE NOT NULL,
    message VARCHAR(200) NOT NULL,
    candidate_id INT REFERENCES candidate(id),
    employer_id INT REFERENCES employer(id)
);

