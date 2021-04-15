CREATE TABLE IF NOT EXISTS Prueba(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    nota_maxima INT,
    codigo_estudiante INT,
    nombre_estudiante VARCHAR(60),
    nota DOUBLE
);

CREATE TABLE IF NOT EXISTS Pregunta(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    imagen VARCHAR(255),
    id_prueba BIGINT NOT NULL,
    valoracion DOUBLE,
    respuesta_abierta VARCHAR(255),
    r_abierta_correcta BOOLEAN,
    r_unica_correcta INT,
    r_unica_estudiante INT,
    dtype VARCHAR(31),
    tipo_pregunta INT,
    respuestas_multiples_estudiantes VARCHAR(50),
    respuestas_multiples_correctas VARCHAR(50),    
    FOREIGN KEY (id_prueba) REFERENCES Prueba(id)
);

CREATE TABLE IF NOT EXISTS Respuestas_Posibles(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuestas_posibles VARCHAR(255),
    FOREIGN KEY (id_pregunta) REFERENCES Pregunta(id)
);