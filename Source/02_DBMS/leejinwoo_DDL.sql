-- create database fourman
-- character set=utf8;
-- USE fourman;

DROP TABLE BOARD_COMMENT;
DROP TABLE OWNERBOARD;
DROP TABLE OWNER;
DROP TABLE RESERVATION;
DROP TABLE seq_ob;
DROP TABLE seq_bc;
DROP TABLE seq_r;
-- --------------------------------------------시퀀스 생성

-- seq_ob 테이블 생성
CREATE TABLE seq_ob(
	id INT NOT NULL,
	seq_name VARCHAR(50)
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_seq_ob;
DELIMITER $$
CREATE FUNCTION get_seq_ob(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE seq_ob SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO seq_ob VALUES(0, 'bno');

-- 이걸로 시퀀스 호출
SELECT get_seq_ob('bno');

-- seq_bc 테이블 생성
CREATE TABLE seq_bc(
   id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_seq_bc;
DELIMITER $$
CREATE FUNCTION get_seq_bc(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE seq_bc SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO seq_bc VALUES(0, 'cno');

-- 이걸로 시퀀스 호출
SELECT get_seq_ob('cno');

-- seq_r 테이블 생성
CREATE TABLE seq_r(
   id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_seq_r;
DELIMITER $$
CREATE FUNCTION get_seq_r(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE seq_r SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO seq_r VALUES(0, 'rno');

-- 이걸로 시퀀스 호출
SELECT get_seq_r('rno');
-- --------------------------------------------테이블

SELECT * FROM OWNER;

-- OWNER 테이블 생성
CREATE TABLE OWNER(
    OID VARCHAR(50) PRIMARY KEY,
    ONAME VARCHAR(50),
    OPW VARCHAR(50),
    OTEL VARCHAR(50),
    OEMAIL VARCHAR(50),
    OADDRESS VARCHAR(250),
    OBIRTH DATE,
    OGENDER VARCHAR(10)
);

-- OWNERBOARD 테이블 생성
CREATE TABLE OWNERBOARD(
    BNO INT(8) PRIMARY KEY,
    OID VARCHAR(50),
    SNAME VARCHAR(50),
    BLOC VARCHAR(50),
    BTITLE VARCHAR(50),
    BCONTENT VARCHAR(4000),
    BPHOTO1 VARCHAR(250),
    BPHOTO2 VARCHAR(250),
    BPHOTO3 VARCHAR(250),
    BPHOTO4 VARCHAR(250),
    BPHOTO5 VARCHAR(250),
    BHIT INT(8),
    BDATE DATETIME DEFAULT current_timestamp,
    FOREIGN KEY (OID) REFERENCES OWNER(OID)
);
-- BOARD_COMMENT 테이블 생성
CREATE TABLE BOARD_COMMENT(
    CNO INT(8) PRIMARY KEY,
    BNO INT(8),
    OID VARCHAR(50),
    CCONTENT VARCHAR(2000),
    CDATE DATETIME DEFAULT current_timestamp,
    FOREIGN KEY (BNO) REFERENCES OWNERBOARD(BNO),
    FOREIGN KEY (OID) REFERENCES OWNER(OID)
);
    
-- RESERVATION 테이블 생성
CREATE TABLE RESERVATION(
    RNO INT(8) PRIMARY KEY,
    MID VARCHAR(50),
    SNO INT(8),
    SNAME VARCHAR(50),
    RDATE DATETIME NOT NULL,
    RTIME INT(5) NOT NULL,
    RMEMBER INT(5) NOT NULL,
    FOREIGN KEY (MID) REFERENCES MEMBER(MID),
    FOREIGN KEY (SNO) REFERENCES store(sNo)
);