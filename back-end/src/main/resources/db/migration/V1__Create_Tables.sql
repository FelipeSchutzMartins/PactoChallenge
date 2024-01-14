CREATE TABLE IF NOT EXISTS user_account (
    id SERIAL PRIMARY KEY,
    username CHAR(50) NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS authority (
    id SERIAL PRIMARY KEY,
    authority CHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS authority_user_account (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    id_authority INT REFERENCES authority(id)
);

CREATE TABLE IF NOT EXISTS employer (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    company_name CHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS job_seeker (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    about CHAR(300) NOT NULL,
    phone CHAR(13) NOT NULL
);

CREATE TABLE IF NOT EXISTS skill (
    id SERIAL PRIMARY KEY,
    skill CHAR(50) NOT NULL,
    years_using CHAR(10) not null,
    id_job_seeker INT REFERENCES job_seeker(id)
);

CREATE TABLE IF NOT EXISTS experience (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    company CHAR(50) NOT NULL,
    responsabilities CHAR(300),
    work_position CHAR(50) NOT NULL,
    currently_working BOOLEAN,
    id_job_seeker INT REFERENCES job_seeker(id)
);

CREATE TABLE IF NOT EXISTS education (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    on_going BOOLEAN,
    institution CHAR(50) NOT NULL,
    kind_degree CHAR(50) NOT NULL,
    course_name CHAR(50),
    id_job_seeker INT REFERENCES job_seeker(id)
);

CREATE TABLE IF NOT EXISTS job_position (
    id SERIAL PRIMARY KEY,
    id_employer INT REFERENCES employer(id),
    position_title CHAR(50) NOT NULL,
    about_job CHAR(500) NOT NULL,
    posted_on DATE NOT NULL,
    work_from CHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS job_position_job_seeker (
    id SERIAL PRIMARY KEY,
    id_job_seeker INT REFERENCES job_seeker(id),
    id_position INT REFERENCES job_position(id),
    status CHAR(50) NOT NULL,
    applied_on DATE NOT NULL
);

