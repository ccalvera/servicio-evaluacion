CREATE TABLE IF NOT EXISTS Prueba(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    nota_maxima INT,
    codigo_estudiante INT,
    nombre_estudiante VARCHAR(60)
);

CREATE TABLE IF NOT EXISTS Pregunta(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    imagen VARCHAR(255),
    id_prueba BIGINT NOT NULL,
    valoracion FLOAT,
    respuesta_abierta VARCHAR(255),
    r_abierta_correcta BOOLEAN, 
    r_unica_correcta INT,
    r_unica_estudiante INT,
    tipo_pregunta INT,
    FOREIGN KEY (id_prueba) REFERENCES Prueba(id)
);

CREATE TABLE IF NOT EXISTS Respuestas_Posibles(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuesta_posible INT,    
    FOREIGN KEY (id_pregunta) REFERENCES Pregunta(id)
);

CREATE TABLE IF NOT EXISTS Respuestas_Estudiante(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuesta_dada_multiple INT,
    FOREIGN KEY (id_pregunta) REFERENCES Pregunta(id)
);

CREATE TABLE IF NOT EXISTS Respuestas_Multiples_Correctas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuestas_correctas INT,
    FOREIGN KEY (id_pregunta) REFERENCES Pregunta(id)
);