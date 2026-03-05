CREATE TABLE IF NOT EXISTS note (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    raw_content TEXT NOT NULL,
    formatted_content TEXT NOT NULL
);



CREATE TABLE IF NOT EXISTS token (
    token VARCHAR(255) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS note_token (
    note_id     BIGSERIAL    NOT NULL,
    token_id    VARCHAR(255) NOT NULL,
    frequency   INTEGER     NOT NULL DEFAULT 1,
    PRIMARY KEY (note_id, token_id),
    CONSTRAINT fk_note  FOREIGN KEY (note_id)  REFERENCES note(id) ON DELETE CASCADE,
    CONSTRAINT fk_token FOREIGN KEY (token_id) REFERENCES token(token) ON DELETE CASCADE
);
