-- FINAL DDL MYSQL

-- DROP
DROP TABLE admin_seq;
DROP TABLE ADMIN_L;
DROP TABLE ADMIN;

DROP TABLE QNA;
DROP TABLE MEMBER;
DROP TABLE qna_seq;
DROP TABLE member_seq;

DROP TABLE BOARD_COMMENT;
DROP TABLE OWNERBOARD;
DROP TABLE RESERVATION;

DROP TABLE seq_ob;
DROP TABLE seq_bc;
DROP TABLE seq_r;

DROP TABLE STORELIKE_SEQ;
DROP TABLE STORE_SEQ;
DROP TABLE STOREREVIEW_SEQ;
DROP TABLE REQUEST_SEQ;

DROP TABLE STORELIKE; 
DROP TABLE STOREREVIEW;
DROP TABLE REQUEST;
DROP TABLE STORE;

DROP TABLE OWNER;

-- 희석

-- Admin(mysql용)

-- 테이블 생성
CREATE TABLE admin_seq(
    id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_admin_seq;
DELIMITER $$
CREATE FUNCTION get_admin_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE admin_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO admin_seq VALUES(0, 'ano');


-- ADMIN LEVEL
CREATE TABLE ADMIN_L(
    alevel VARCHAR(10) PRIMARY KEY,
    alevel_name VARCHAR(50)
);

-- ADMIN LELVE DATA
INSERT INTO ADMIN_L VALUES(0, 'MANAGER');
INSERT INTO ADMIN_L VALUES(1, 'HEAD_MANAGER');
INSERT INTO ADMIN_L VALUES(2, 'MASTER');

CREATE TABLE ADMIN(
    ano int(2) PRIMARY KEY,
    aid VARCHAR(50) UNIQUE NOT NULL,
    apw VARCHAR(50) NOT NULL,
    aemail VARCHAR(50) NOT NULL,
    aname VARCHAR(50) NOT NULL,
    atel VARCHAR(50) NOT NULL,
    alevel VARCHAR(50) DEFAULT 0 REFERENCES ADMIN_L(aLEVEL),
    ardate DATETIME DEFAULT current_timestamp
);








-- 민우




CREATE TABLE QNA(
    qno VARCHAR(50) PRIMARY KEY, -- 글 번호
    qid VARCHAR(50) , -- 글쓴이 사용자 or 관리자
    qsubject VARCHAR(250) NOT NULL, -- 글 제목
    qcontent VARCHAR(4000) NOT NULL, -- 글 내용
    qhit int(8) DEFAULT 0, -- 조회수
    qgroup int(8), -- 글 그룹
    qstep int(8), -- 그룹내 출력 순서
    qrdate DATETIME DEFAULT current_timestamp, -- 등록 시점
    qsecret VARCHAR(10) default 'N',-- 비밀글 여부 
    qreplycheck VARCHAR(10) DEFAULT 0 -- 답변 없음 0, 답변 있음 1
);


-- 테이블 생성
CREATE TABLE qna_seq(
	id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작(qna 테이블 시퀀스)
DROP FUNCTION IF EXISTS get_qna_seq;
DELIMITER $$
CREATE FUNCTION get_qna_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE qna_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO qna_seq VALUES(0, 'qno');


-- 회원 테이블 생성
CREATE TABLE MEMBER (
    mid varchar(50) primary KEY, -- 고객 ID
    mname varchar(50) NOT NULL,  -- 고객 이름
    mpw varchar(50) NOT NULL,  -- 비밀번호
    mtel varchar(50) NOT NULL, -- 전화번호
    memail varchar(50) NOT NULL, -- 고객 이메일
    maddress varchar(250), -- 고객 주소 
    mgender varchar(10), -- 고객 성별
    mbirth DATE,  -- 생일   
    mprofile varchar(50)  DEFAULT 'noImg.png'
);







-- 진우


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

-- --------------------------------------------테이블


-- OWNER 테이블 생성
CREATE TABLE OWNER(
	oid VARCHAR(50) PRIMARY KEY,
    oname VARCHAR(50),
    opw VARCHAR(50),
    otel VARCHAR(50),
    oemail VARCHAR(50),
    oaddress VARCHAR(250),
    obirth DATE,
    ogender VARCHAR(10)
);

-- OWNERBOARD 테이블 생성
CREATE TABLE OWNERBOARD(
    bno INT(8) PRIMARY KEY,
    oid VARCHAR(50),
    sname VARCHAR(50),
    bloc VARCHAR(50),
    btitle VARCHAR(50),
    bcontent VARCHAR(4000),
    bphoto1 VARCHAR(250),
    bphoto2 VARCHAR(250),
    bphoto3 VARCHAR(250),
    bphoto4 VARCHAR(250),
    bphoto5 VARCHAR(250),
    bhit INT(8),
    bdate DATETIME DEFAULT current_timestamp,
    FOREIGN KEY (oid) REFERENCES OWNER(oid)
);

-- BOARD_COMMENT 테이블 생성
CREATE TABLE BOARD_COMMENT(
    cno INT(8) PRIMARY KEY,
    bno INT(8),
    oid VARCHAR(50),
    ccontent VARCHAR(2000),
    cdate DATETIME DEFAULT current_timestamp,
    FOREIGN KEY (bno) REFERENCES OWNERBOARD(bno),
    FOREIGN KEY (oid) REFERENCES OWNER(oid)
);



-- STORE TABLE AND STORE_SEQ


-- CREATE

CREATE TABLE STORE_SEQ (
			ID INT NOT NULL,
            SEQ_NAME VARCHAR(50)
		);
        
-- 함수제작

DROP FUNCTION IF EXISTS GET_STORE_SEQ;
DELIMITER $$
CREATE FUNCTION GET_STORE_SEQ(P_SEQ_NAME VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE STORE_SEQ SET ID = LAST_INSERT_ID(ID+1)
WHERE SEQ_NAME = P_SEQ_NAME;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO STORE_SEQ VALUES (0, 'SNO');

CREATE TABLE STORE (
            sno        INT(8) PRIMARY KEY, -- 가게 고유 번호
            oid        VARCHAR(50),
            simage1     VARCHAR(250) NOT NULL, -- 가게 사진
            simage2     VARCHAR(250) NOT NULL, -- 가게 사진
            simage3     VARCHAR(250) NOT NULL, -- 가게 사진
            sname       VARCHAR(100) NOT NULL, -- 가게 이름
            saddress    VARCHAR(250) NOT NULL, -- 가게 주소
            slocation   VARCHAR(50) NOT NULL, -- 가게 위치
            stel        VARCHAR(100) NOT NULL, -- 가게 전화번호
            stype      VARCHAR(100) NOT NULL, -- 가게 종류
            sprice      VARCHAR(100) NOT NULL, -- 가게 가격대
            stime       VARCHAR(100) NOT NULL, -- 가게 시간대
            sholiday    VARCHAR(100) NOT NULL, -- 가게 휴일
            smenu1     VARCHAR(100) NOT NULL, -- 가게 대표메뉴 1
            smenu1cost  VARCHAR(100) NOT NULL, -- 가게 대표메뉴 1 가격
            smenu2      VARCHAR(100), -- 가게 대표메뉴 2
            smenu2cost  VARCHAR(100), -- 가게 대표메뉴 2 가격
            smenu3      VARCHAR(100), -- 가게 대표메뉴 3
            smenu3cost  VARCHAR(100),  -- 가게 대표메뉴 3 가격
            ssearchtag  VARCHAR(100), -- 가게 검색용 태그
            sconfirm    CHAR(1) DEFAULT 'N', -- 가게 등록 여부
            sreplycnt   INT(8) DEFAULT 1,  -- 가게 리뷰 갯수
            sscore      INT(8) DEFAULT 5, -- 가게 평점
            sstart     INT(2) NOT NULL, -- 가게 여는 시간 (예약용)
            send       INT(2) NOT NULL, -- 가게 닫는 시간 (예약용)
            slati DOUBLE(20, 6) DEFAULT 37.57595770501166, -- 가게 위도 (지도용)
            slongti DOUBLE(20, 6) DEFAULT 126.97686668256979, -- 가게 경도 (지도용)
            FOREIGN KEY (oid) REFERENCES OWNER(oid) -- 사업자 아이디
            );
            

                  
-- STOREREVIEW TABLE 


CREATE TABLE STOREREVIEW_SEQ (
			id INT NOT NULL,
            SEQ_NAME VARCHAR(50)
		);
        
-- 함수제작
DROP FUNCTION IF EXISTS GET_STOREREVIEW_SEQ;
DELIMITER $$
CREATE FUNCTION GET_STOREREVIEW_SEQ(P_SEQ_NAME VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE STOREREVIEW_SEQ SET ID = LAST_INSERT_ID(ID+1)
WHERE SEQ_NAME = P_SEQ_NAME;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO STOREREVIEW_SEQ VALUES (0, 'srno');

                  
 
CREATE TABLE STOREREVIEW (
            srno         INT(8) PRIMARY KEY, -- 댓글 고유 번호
            sno			 INT(8),
            mid 		  VARCHAR(50) NOT NULL, -- 사용자 아이디
            mprofile     VARCHAR(1000) NOT NULL, -- 사용자 프로필 사진
            srcontent     VARCHAR(2000) NOT NULL, -- 리뷰 내용
            srimage1      VARCHAR(500), -- 리뷰 이미지 1
            srscore       INT(3) DEFAULT 0, -- 리뷰 별점
            srdate        DATETIME DEFAULT CURRENT_TIMESTAMP, -- 리뷰 등록 일시
            FOREIGN KEY (sno) REFERENCES STORE(sno), -- 가게 번호
            FOREIGN KEY (mid) REFERENCES MEMBER(mid) -- 사용자 아이디
    );  

SELECT * FROM STOREREVIEW;
    
-- REQUEST TABLE    


CREATE TABLE REQUEST_SEQ (
			id INT NOT NULL,
            SEQ_NAME VARCHAR(50)
		);
        
-- 함수제작
DROP FUNCTION IF EXISTS GET_REQUEST_SEQ;
DELIMITER $$
CREATE FUNCTION GET_REQUEST_SEQ(P_SEQ_NAME VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE REQUEST_SEQ SET ID = LAST_INSERT_ID(ID+1)
WHERE SEQ_NAME = P_SEQ_NAME;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO REQUEST_SEQ VALUES (0, 'rno');


CREATE TABLE REQUEST (
            rno          INT(8) PRIMARY KEY,--  요청 글 번호
            sno			 INT(8),
            oid			 VARCHAR(50) NOT NULL,
            aid          VARCHAR(50), -- 관리자 아이디
            sname        VARCHAR(100) NOT NULL, -- 요청한 가게 이름
            rdate        DATETIME DEFAULT CURRENT_TIMESTAMP, -- 요청 등록된 일시
            FOREIGN KEY(sno) REFERENCES STORE(sno), -- 요청한 가게 번호
            FOREIGN KEY(oid)  REFERENCES OWNER(oid) -- 요청한 사장님 아이디
    );     



-- STORELIKE TABLE 
CREATE TABLE STORELIKE_SEQ (
			id INT NOT NULL,
            seq_name VARCHAR(50)
		);
        
-- 함수제작
DROP FUNCTION IF EXISTS GET_STORELIKE_SEQ;
DELIMITER $$
CREATE FUNCTION GET_STORELIKE_SEQ(P_SEQ_NAME VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE STORELIKE_SEQ SET ID = LAST_INSERT_ID(ID+1)
WHERE SEQ_NAME = P_SEQ_NAME;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO STORELIKE_SEQ VALUES (0, 'slno');


CREATE TABLE STORELIKE (
            slno INT(8) PRIMARY KEY, -- 좋아요 번호
            sno INT(8),
            mid VARCHAR(50),
            sname VARCHAR(100) NOT NULL, -- 요청한 가게 이름 
            FOREIGN KEY (sno) REFERENCES STORE(sno), -- 요청한 가게 번호
            FOREIGN KEY(mid)  REFERENCES MEMBER(mid) -- 요청한 사용자 아이디 
            );







-- 진우

CREATE TABLE RESERVATION(
    rno INT(8) PRIMARY KEY,
    mid VARCHAR(50),
    sno INT(8),
    sname VARCHAR(50),
    rdate DATETIME NOT NULL,
    rtime INT(5) NOT NULL,
    rmember INT(5) NOT NULL,
    FOREIGN KEY (mid) REFERENCES MEMBER(mid),
    FOREIGN KEY (sno) REFERENCES STORE(sno)
);


























-- -------------------------------------------------------------------------------------------------------------