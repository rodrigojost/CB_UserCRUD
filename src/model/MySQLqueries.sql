CREATE TABLE usuarios (
	id_user BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome_user VARCHAR(50) NOT NULL,
	sobrenome_user VARCHAR(50) NOT NULL,
	e_mail VARCHAR(50) UNIQUE NOT NULL,
	senha VARCHAR(50) NOT NULL);

CREATE TABLE modelos_cb (
	id_modelo BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	de_modelo VARCHAR(250) NOT NULL);

CREATE TABLE sensores (
	id_sensor BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome_sensor VARCHAR(50) UNIQUE NOT NULL,
	de_sensor VARCHAR(250));

CREATE TABLE modelos_sensores (
	id_mod_sensor BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	id_modelo BIGINT(20) NOT NULL,
	id_sensor BIGINT(20) NOT NULL,
	CONSTRAINT fk_modelo FOREIGN KEY (id_modelo) REFERENCES modelos_cb(id_modelo),
	CONSTRAINT fk_sensor FOREIGN KEY (id_sensor) REFERENCES sensores(id_sensor)
	);

CREATE TABLE cleanbox (
	id_cleanbox BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
	id_usuario BIGINT(20) NOT NULL,
	id_modelo BIGINT(20) NOT NULL,
	CONSTRAINT fk_modelo_cleanbox FOREIGN KEY (id_modelo) REFERENCES modelos_cb(id_modelo),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_user)
	);

CREATE TABLE gatos (
	id_gato BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome_gato VARCHAR(50) NOT NULL,
	de_gato VARCHAR(250),
	id_dono_a BIGINT(20) NOT NULL, 
	raca VARCHAR(50),
	genero VARCHAR(25) NOT NULL DEFAULT 'desconhecido',
	CONSTRAINT fk_usuario_gato FOREIGN KEY (id_dono_a) REFERENCES usuarios(id_user),
	CONSTRAINT ck_genero CHECK (genero = 'macho' OR genero = 'femea' OR genero = 'desconhecido')
	);

CREATE TABLE log_sensores (
	id_log BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	id_sensor BIGINT(20) NOT NULL,
	vl_sensor FLOAT(10,2),
	id_cleanbox BIGINT(20) NOT NULL,
	tempo_ini TIMESTAMP NOT NULL,
	tempo_fim TIMESTAMP NOT NULL,
	id_gato BIGINT(20),
	CONSTRAINT fk_cleanbox_log FOREIGN KEY (id_cleanbox) REFERENCES cleanbox(id_cleanbox),
	CONSTRAINT fk_gato FOREIGN KEY (id_gato) REFERENCES gatos(id_gato),
	UNIQUE (id_cleanbox, tempo_ini, tempo_fim)
	);

CREATE UNIQUE INDEX email_usuario_idx USING BTREE ON usuarios (e_mail, senha); 

CREATE UNIQUE INDEX log_cb_tempo_idx USING BTREE ON log_sensores (id_cleanbox);

CREATE UNIQUE INDEX nome_sensores_idx USING BTREE ON sensores (nome_sensor);

CREATE INDEX id_sensores_modelo_idx USING BTREE ON modelos_sensores (id_modelo);      

CREATE INDEX de_modelos_cb_idx USING BTREE ON modelos_cb (de_modelo);     

CREATE INDEX gatos_idx USING BTREE ON gatos (nome_gato, id_dono_a);               

CREATE INDEX dono_cb_idx USING BTREE ON cleanbox (id_usuario);     

INSERT INTO sensores (nome_sensor, de_sensor) VALUES ('DYP-ME003', 'sensor digital de movimento PIR');
INSERT INTO sensores (nome_sensor, de_sensor) VALUES ('ACS-712', 'sensor analogico de corrente efeito Hall');
INSERT INTO sensores (nome_sensor, de_sensor) VALUES ('barreira_laser_CB', 'sensor analogico barreira laser - 3 linhas laser x LDR');
INSERT INTO sensores (nome_sensor, de_sensor) VALUES ('E18-d80nk', 'sensor digital infravermelho de presen�a');
INSERT INTO sensores (nome_sensor, de_sensor) VALUES ('TC34725', 'sensor analogico de cor - Adafruit');
INSERT INTO sensores (nome_sensor) VALUES ('Extens�metro 25 kg @1 kohm');

INSERT INTO modelos_cb (de_modelo) VALUES ('CleanBox V2.0 - c/ fotosensor de presen�a');
INSERT INTO modelos_cb (de_modelo) VALUES ('CleanBox V2.1 - c/ barreira laser, PIR, corrente');
INSERT INTO modelos_cb (de_modelo) VALUES ('CleanBox V2.2 - c/ sensor de cor');

INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (1, 1);

INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (2, 1);
INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (2, 3);
INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (2, 9);

INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (3, 1);
INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (3, 3);
INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (3, 9);
INSERT INTO modelos_sensores (id_modelo, id_sensor) VALUES (3, 7);

INSERT INTO usuarios (nome_user, sobrenome_user, e_mail, senha) VALUES ('Nome', 'Sobrenome', 'e-mail', 'senha');

INSERT INTO cleanbox (id_usuario, id_modelo) VALUES (1, 2);	 
INSERT INTO cleanbox (id_usuario, id_modelo) VALUES (2, 3);

INSERT INTO gatos (nome_gato, id_dono_a, raca) VALUES ('Nome', 1, 'Raça');
INSERT INTO gatos (nome_gato, id_dono_a, genero) VALUES ('Nome', 2, 'sexo');

INSERT INTO log_sensores (id_sensor, vl_sensor, id_cleanbox, tempo_ini, tempo_fim, id_gato) VALUES (1, '1', 2, '2022-02-10 11:40:25', '2022-02-10 11:59:55', 1);
