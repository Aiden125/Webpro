-- ryu ddl store / storere /request table create and drop
-- create database fourman character set=utf8;
-- USE fourman;

-- DROP
commit;
-- STORE TABLE and store_seq
drop table storeLike_seq;
drop table store_seq;
drop table storereview_seq;
drop table request_seq;

drop table StoreLike; 
drop table storereview;
drop table request;
drop table store;

-- CREATE

create table store_seq (
			id int NOT NULL,
            seq_name VARCHAR(50)
		);
        
-- 함수제작

DROP FUNCTION IF EXISTS get_store_seq;
DELIMITER $$
CREATE FUNCTION get_store_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE store_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
set sql_safe_updates = 0;
INSERT INTO store_seq VALUES (0, 'sno');

-- 시퀀스 호출
SELECT get_store_seq('sno');

create table store (
            sNo        int(8) PRIMARY KEY, -- 가게 고유 번호
            oId 		VARCHAR(50) not null, -- 사업자 아이디
            sImage1     VARCHAR(250) not null, -- 가게 사진
            sImage2     VARCHAR(250) not null, -- 가게 사진
            sImage3     VARCHAR(250) not null, -- 가게 사진
            sName       VARCHAR(100) not null, -- 가게 이름
            sAddress    VARCHAR(250) not null, -- 가게 주소
            sLocation   VARCHAR(50) not null, -- 가게 위치
            sTel        VARCHAR(100) not null, -- 가게 전화번호
            sType       VARCHAR(100) not null, -- 가게 종류
            sPrice      VARCHAR(100) not null, -- 가게 가격대
            sTime       VARCHAR(100) not null, -- 가게 시간대
            sHoliday    VARCHAR(100) not null, -- 가게 휴일
            sMenu1      VARCHAR(100) not null, -- 가게 대표메뉴 1
            sMenu1cost  VARCHAR(100) not null, -- 가게 대표메뉴 1 가격
            sMenu2      VARCHAR(100), -- 가게 대표메뉴 2
            sMenu2cost  VARCHAR(100), -- 가게 대표메뉴 2 가격
            sMenu3      VARCHAR(100), -- 가게 대표메뉴 3
            sMenu3cost  VARCHAR(100),  -- 가게 대표메뉴 3 가격
            sSearchtag  VARCHAR(100), -- 가게 검색용 태그
            sConfirm    char(1) default 'N', -- 가게 등록 여부
            sReplycnt   int(8) default 1,  -- 가게 리뷰 갯수
            sScore      int(8) default 5, -- 가게 평점
            sStart     int(2) NOT NULL, -- 가게 여는 시간 (예약용)
            sEnd       int(2) NOT NULL, -- 가게 닫는 시간 (예약용)
            sLati double(20, 6) Default 37.57595770501166, -- 가게 위도 (지도용)
            sLongti double(20, 6) Default 126.97686668256979, -- 가게 경도 (지도용)
            foreign key (oId) REFERENCES OWNER(OID) -- 사업자 아이디
            );
            

                  
-- STOREREVIEW TABLE 


create table storereview_seq (
			id int NOT NULL,
            seq_name VARCHAR(50)
		);
        
-- 함수제작
DROP FUNCTION IF EXISTS get_storereview_seq;
DELIMITER $$
CREATE FUNCTION get_storereview_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE storereview_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
set sql_safe_updates = 0;
INSERT INTO storereview_seq VALUES (0, 'srno');

-- 시퀀스 호출
SELECT get_storereview_seq('srno');
                  
 
create table storereview (
            srNo         int(8) PRIMARY KEY, -- 댓글 고유 번호
            sNo			 int(8),
            mId 		  VARCHAR(50) not null, -- 사용자 아이디
            mProfile      VARCHAR(1000) not null, -- 사용자 프로필 사진
            srContent     VARCHAR(2000) not null, -- 리뷰 내용
            srImage1      VARCHAR(500), -- 리뷰 이미지 1
            srScore       int(3) default 0, -- 리뷰 별점
            srDate        DATETIME DEFAULT current_timestamp, -- 리뷰 등록 일시
            FOREIGN KEY (sNo) REFERENCES store(sno), -- 가게 번호
            FOREIGN KEY (mId) REFERENCES MEMBER(MID) -- 사용자 아이디
    );  

select * from storereview;
    
-- REQUEST TABLE    


create table request_seq (
			id int NOT NULL,
            seq_name VARCHAR(50)
		);
        
-- 함수제작
DROP FUNCTION IF EXISTS get_request_seq;
DELIMITER $$
CREATE FUNCTION get_request_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE request_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
set sql_safe_updates = 0;
INSERT INTO request_seq VALUES (0, 'rno');

-- 시퀀스 호출
SELECT get_request_seq('rno');

 
create table request (
            rNo          int(8) PRIMARY KEY,--  요청 글 번호
            sNo			 int(8),
            oId			 VARCHAR(50) not null,
            aId          VARCHAR(50), -- 관리자 아이디
            sName        VARCHAR(100) not null, -- 요청한 가게 이름
            rDate        DATETIME DEFAULT current_timestamp, -- 요청 등록된 일시
            FOREIGN KEY(sNo) REFERENCES store(sno), -- 요청한 가게 번호
            FOREIGN KEY(oId)  REFERENCES OWNER(OID) -- 요청한 사장님 아이디
    );     

SELECT * FROM request;
select * from store; 

SELECT * FROM request; 

-- STORELIKE TABLE 


create table storeLike_seq (
			id int NOT NULL,
            seq_name VARCHAR(50)
		);
        
-- 함수제작
DROP FUNCTION IF EXISTS get_storeLike_seq;
DELIMITER $$
CREATE FUNCTION get_storeLike_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE storeLike_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
set sql_safe_updates = 0;
INSERT INTO storeLike_seq VALUES (0, 'slno');

-- 시퀀스 호출
SELECT get_storeLike_seq('slno');


create Table StoreLike (
            slNo int(8) PRIMARY KEY, -- 좋아요 번호
            sNo int(8),
            mId VARCHAR(50),
            sName VARCHAR(100) not null, -- 요청한 가게 이름 
            FOREIGN KEY (sNo) REFERENCES store(sno), -- 요청한 가게 번호
            FOREIGN KEY(mId)  REFERENCES MEMBER(MID) -- 요청한 사용자 아이디 
            );

commit;




















 

