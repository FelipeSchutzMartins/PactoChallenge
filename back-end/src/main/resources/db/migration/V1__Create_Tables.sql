CREATE TABLE IF NOT EXISTS user_account (
    id SERIAL PRIMARY KEY,
    username CHAR(50) NOT NULL,
    password CHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
    id SERIAL PRIMARY KEY,
    authority CHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities_user_account (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    id_authority INT REFERENCES authorities(id)
);

CREATE TABLE IF NOT EXISTS employers (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    company_name CHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS job_seekers (
    id SERIAL PRIMARY KEY,
    id_user_account INT REFERENCES user_account(id),
    about CHAR(300) NOT NULL,
    phone CHAR(13) NOT NULL
);

CREATE TABLE IF NOT EXISTS skills (
    id SERIAL PRIMARY KEY,
    skill CHAR(50) NOT NULL,
    years_using CHAR(10) not null,
    id_job_seeker INT REFERENCES job_seekers(id)
);

CREATE TABLE IF NOT EXISTS experiences (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    company CHAR(50) NOT NULL,
    responsabilities CHAR(300),
    work_position CHAR(50) NOT NULL,
    currently_working BOOLEAN,
    id_job_seeker INT REFERENCES job_seekers(id)
);

CREATE TABLE IF NOT EXISTS education (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    on_going BOOLEAN,
    institution CHAR(50) NOT NULL,
    kind_degree CHAR(50) NOT NULL,
    course_name CHAR(50),
    id_job_seeker INT REFERENCES job_seekers(id)
);

CREATE TABLE IF NOT EXISTS positions (
    id SERIAL PRIMARY KEY,
    id_employer INT REFERENCES employers(id),
    position_title CHAR(50) NOT NULL,
    about_job CHAR(500) NOT NULL,
    posted_on DATE NOT NULL,
    work_from CHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS positions_job_seekers (
    id SERIAL PRIMARY KEY,
    id_job_seeker INT REFERENCES job_seekers(id),
    id_position INT REFERENCES positions(id),
    status CHAR(50) NOT NULL,
    applied_on DATE NOT NULL
);

