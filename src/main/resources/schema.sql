CREATE TABLE IF NOT EXISTS note (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    raw_content TEXT NOT NULL,
    formatted_content TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS note_token (
    note_id     BIGINT       NOT NULL,
    token       VARCHAR(255) NOT NULL,
    frequency   INTEGER      NOT NULL DEFAULT 1,
    PRIMARY KEY (note_id, token),
    CONSTRAINT fk_note  FOREIGN KEY (note_id)  REFERENCES note(id) ON DELETE CASCADE
);
