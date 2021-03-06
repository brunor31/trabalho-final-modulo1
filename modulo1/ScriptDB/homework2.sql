CREATE TABLE HOTEL(
ID_HOTEL INTEGER PRIMARY KEY NOT NULL,
NOME VARCHAR2(100) NOT NULL,
CIDADE VARCHAR2(100) NOT NULL,
TELEFONE VARCHAR2(14) NOT NULL,
CLASSIFICACAO INTEGER NOT NULL
);

CREATE SEQUENCE SEQ_HOTEL
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE TABLE QUARTO(
ID_QUARTO INTEGER PRIMARY KEY NOT NULL, 
ID_HOTEL INTEGER NOT NULL,
NUMERO INTEGER NOT NULL,
TIPO INTEGER NOT NULL,
DISPONIBILIDADE INTEGER NOT NULL,
PRECO_DIARIA DECIMAL(10,2) NOT NULL,
CONSTRAINT FK_QUARTO_ID_HOTEL FOREIGN KEY (ID_HOTEL) REFERENCES HOTEL(ID_HOTEL) ON DELETE CASCADE
);

CREATE SEQUENCE SEQ_QUARTO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE TABLE CLIENTE(
ID_CLIENTE INTEGER PRIMARY KEY NOT NULL,
NOME VARCHAR2(100) NOT NULL,
CPF CHAR(11) UNIQUE NOT NULL,
TELEFONE VARCHAR2(14) NOT NULL,
EMAIL VARCHAR2(100) NOT NULL,
SENHA VARCHAR2(100) NOT NULL
);

CREATE SEQUENCE SEQ_CLIENTE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE TABLE RESERVA(
ID_RESERVA INTEGER PRIMARY KEY NOT NULL,
ID_HOTEL INTEGER NOT NULL,
ID_QUARTO INTEGER NOT NULL,
ID_CLIENTE INTEGER NOT NULL,
DATA_ENTRADA DATE NOT NULL,
DATA_SAIDA DATE NOT NULL,
TIPO INTEGER NOT NULL,
VALOR_RESERVA DECIMAL(20,2) NOT NULL,
CONSTRAINT FK_RESERVA_ID_HOTEL FOREIGN KEY (ID_HOTEL) REFERENCES HOTEL(ID_HOTEL) ON DELETE CASCADE,
CONSTRAINT FK_RESERVA_ID_QUARTO FOREIGN KEY (ID_QUARTO) REFERENCES QUARTO(ID_QUARTO) ON DELETE CASCADE,
CONSTRAINT FK_RESERVA_ID_CLIENTE FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE)
);

CREATE SEQUENCE SEQ_RESERVA
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO HOTEL (ID_HOTEL, NOME, CIDADE, TELEFONE, CLASSIFICACAO)
VALUES (SEQ_HOTEL.nextval, 'Ibis', 'Porto Alegre', '5135458100', 5);

INSERT INTO HOTEL (ID_HOTEL, NOME, CIDADE, TELEFONE, CLASSIFICACAO)
VALUES (SEQ_HOTEL.nextval, 'Light Aurora Resort', 'Florianópolis', '493541000', 5);

INSERT INTO HOTEL (ID_HOTEL, NOME, CIDADE, TELEFONE, CLASSIFICACAO)
VALUES (SEQ_HOTEL.nextval, 'Quality Suites', 'São Paulo', '1140112549', 4);

INSERT INTO HOTEL (ID_HOTEL, NOME, CIDADE, TELEFONE, CLASSIFICACAO)
VALUES (SEQ_HOTEL.nextval, 'Primme Hotel', 'Rio de Janeiro', '2136481111', 5);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 1, 101, 1, 1, 200.00);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 1, 201, 2, 1, 350.49);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 2, 102, 1, 1, 220.50);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 2, 202, 2, 1, 330.78);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 3, 103, 1, 1, 210.00);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 3, 203, 2, 1, 399.00);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 4, 104, 1, 1, 300.00);

INSERT INTO QUARTO (ID_QUARTO, ID_HOTEL, NUMERO, TIPO, DISPONIBILIDADE, PRECO_DIARIA)
VALUES (SEQ_QUARTO.nextval, 4, 204, 2, 1, 550.00);

INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, TELEFONE, EMAIL, SENHA)
VALUES (SEQ_CLIENTE.nextval, 'Bruno Rodrigues', '00041578169', '51996031653', 'brunor@gmail.com', '12345678');

INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, TELEFONE, EMAIL, SENHA)
VALUES (SEQ_CLIENTE.nextval, 'Bruno Nogueira', '02648794100', '51995429246', 'brunon@gmail.com', '45678945');

INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, TELEFONE, EMAIL, SENHA)
VALUES (SEQ_CLIENTE.nextval, 'Mateus Machado', '00414751198', '51995416781', 'mateusm@gmail.com', '10102417');

INSERT INTO RESERVA (ID_RESERVA, ID_HOTEL, ID_QUARTO, ID_CLIENTE, DATA_ENTRADA, DATA_SAIDA, TIPO, VALOR_RESERVA)
VALUES (SEQ_RESERVA.nextval, 1, 1,1, to_date('25/08/2022', 'dd/mm/yyyy'), to_date('30/08/2022', 'dd/mm/yyyy'), 0, 1000.00);

INSERT INTO RESERVA (ID_RESERVA, ID_HOTEL, ID_QUARTO, ID_CLIENTE, DATA_ENTRADA, DATA_SAIDA, TIPO, VALOR_RESERVA)
VALUES (SEQ_RESERVA.nextval, 2, 2,2, to_date('10/09/2022', 'dd/mm/yyyy'), to_date('20/09/2022', 'dd/mm/yyyy'), 1, 3154.41);

INSERT INTO RESERVA (ID_RESERVA, ID_HOTEL, ID_QUARTO, ID_CLIENTE, DATA_ENTRADA, DATA_SAIDA, TIPO, VALOR_RESERVA)
VALUES (SEQ_RESERVA.nextval, 3, 3, 3, to_date('25/10/2022', 'dd/mm/yyyy'), to_date('05/11/2022', 'dd/mm/yyyy'), 0, 2425.50);