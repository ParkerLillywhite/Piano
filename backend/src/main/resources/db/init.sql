CREATE TABLE IF NOT EXISTS courses (
   id int PRIMARY KEY auto_increment,
   name VARCHAR,
);

CREATE TABLE IF NOT EXISTS reviews (
   id INTEGER PRIMARY KEY auto_increment,
   course_id INTEGER,
   rating INTEGER,
   comment VARCHAR,
   FOREIGN KEY(course_id) REFERENCES public.courses(id)
);

CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY auto_increment,
    user_name VARCHAR,
    password VARCHAR,
);