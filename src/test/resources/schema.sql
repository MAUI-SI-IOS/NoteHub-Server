CREATE TABLE IF NOT EXISTS note (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    raw_content TEXT NOT NULL,
    formatted_content TEXT NOT NULL

);