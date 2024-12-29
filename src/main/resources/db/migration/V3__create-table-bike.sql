CREATE TABLE bike (
    id VARCHAR(36) PRIMARY KEY,
    estacao_id VARCHAR(36) NOT NULL,
    localizacao VARCHAR(255),
    referencia VARCHAR(255),
    estado BOOLEAN NOT NULL,
    CONSTRAINT fk_estacao FOREIGN KEY (estacao_id) REFERENCES estacao(id) ON DELETE CASCADE
);