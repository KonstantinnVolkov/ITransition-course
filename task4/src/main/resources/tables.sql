CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       regDate TIMESTAMP,
                       lastLogin TIMESTAMP,
                       role VARCHAR(25) NOT NULL,
                       status VARCHAR(25) NOT NULL
);

CREATE TABLE messages (
                          id SERIAL PRIMARY KEY,
                          sender VARCHAR(255) NOT NULL,
                          receiver VARCHAR(255) NOT NULL,
                          theme TEXT NOT NULL,
                          text TEXT NOT NULL
);