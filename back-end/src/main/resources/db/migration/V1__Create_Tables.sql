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
    id_user_account INT REFERENCES user_account(id),
    id_authority INT REFERENCES authority(id)
);

CREATE TABLE IF NOT EXISTS employer (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    company_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS job_seeker (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    about VARCHAR(300) NOT NULL,
    phone VARCHAR(13) NOT NULL
);

CREATE TABLE IF NOT EXISTS skill (
    id SERIAL PRIMARY KEY,
    skill VARCHAR(50) NOT NULL,
    years_using VARCHAR(10) not null,
    id_job_seeker INT REFERENCES job_seeker(id)
);

CREATE TABLE IF NOT EXISTS experience (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    company VARCHAR(50) NOT NULL,
    responsibilities VARCHAR(300),
    work_position VARCHAR(50) NOT NULL,
    currently_working BOOLEAN,
    id_job_seeker INT REFERENCES job_seeker(id)
);

CREATE TABLE IF NOT EXISTS education (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    on_going BOOLEAN,
    institution VARCHAR(50) NOT NULL,
    kind_degree VARCHAR(50) NOT NULL,
    course_name VARCHAR(50),
    id_job_seeker INT REFERENCES job_seeker(id)
);

CREATE TABLE IF NOT EXISTS job_position (
    id SERIAL PRIMARY KEY,
    id_employer INT REFERENCES employer(id),
    position_title VARCHAR(50) NOT NULL,
    about_job VARCHAR(500) NOT NULL,
    posted_on DATE NOT NULL,
    work_from VARCHAR(50) NOT NULL,
    closed_on DATE
);

CREATE TABLE IF NOT EXISTS job_application (
    id SERIAL PRIMARY KEY,
    id_job_seeker INT REFERENCES job_seeker(id),
    id_position INT REFERENCES job_position(id),
    applied_on DATE NOT NULL,
    reason_closure VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS application_feedback (
    id SERIAL PRIMARY KEY,
    id_application INT REFERENCES job_application(id),
    send_on DATE NOT NULL,
    message VARCHAR(200) NOT NULL,
    id_job_seeker INT REFERENCES job_seeker(id),
    id_employer INT REFERENCES employer(id)
);

