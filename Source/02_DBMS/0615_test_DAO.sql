-- ★★★ 고객(CUSTOMER) 테이블 DAO ★★★
-- 1. 중복체크
SELECT * FROM CUSTOMER WHERE cID='aaa';

-- 2. 회원가입
INSERT INTO CUSTOMER(cID, cPW, cNAME, cEMAIL, cIMAGE, cBIRTH, cADDRESS)
    VALUES('aaa', '1234', '홍길동', 'hong@n.com', null, '1995-12-12', '서울시 강남구');
    
-- 3. 로그인
SELECT * FROM CUSTOMER WHERE cID='aaa' AND cPW='1234';

-- (별도) 로그인 후 세션에 담기위한 정보 넣을 때 필요한 쿼리
SELECT * FROM CUSTOMER WHERE cID='aaa';

-- 4. 회원 정보 수정
UPDATE CUSTOMER SET cPW='1234',
                    cNAME='홍길동',
                    cEMAIL='222@222',
                    cIMAGE='232',
                    cBIRTH='1992-12-12',
                    cADDRESS='서울'
                WHERE cID='aaa';
                
-- 5. 로그아웃(session을 통해 jsp에서 실행 session.invalidate)

SELECT * FROM CUSTOMER;
COMMIT;



-- ★★★ 게시판(BBS) 테이블 DAO ★★★
-- 1. 글쓰기
INSERT INTO BBS(bNO, bID, bTITLE, bCONTENT, bFILENAME,
        bREF, bRE_STEP, bRE_INDENT, bIP)
    VALUES(BBS_SQ.NEXTVAL, 'aaa', '제목', '본문', '파일명',
        0, 0, 0, '122.123.123.111');

-- 1-1. 답변글 쓰기 전 STEP A
UPDATE BBS SET bRE_STEP = bRE_STEP + 1
    WHERE bREF=5 AND bRE_STEP>0;

-- 1-2. 답변글 쓰기
INSERT INTO BBS(bNO, bID, bTITLE, bCONTENT, bFILENAME,
        bREF, bRE_STEP, bRE_INDENT, bIP)
    VALUES(BBS_SQ.NEXTVAL, 'aaaa', '글1-1', '답글', NULL,
        5, 1, 1, '123.121.121.111');


-- 2. 글목록(startRow ~ endRow)
-- 서브쿼리
SELECT bNO, cNAME, bTITLE, bREADCOUNT, bCURRENT, bIP
    FROM CUSTOMER C, BBS B
    WHERE C.cID=B.bID
    ORDER BY bREF DESC, bRE_STEP;

-- 메인쿼리
SELECT *
    FROM ( SELECT ROWNUM RN, A.*
        FROM (SELECT bNO, cNAME, bTITLE, bREADCOUNT, bCURRENT, bIP
                                FROM CUSTOMER C, BBS B
                                WHERE C.cID=B.bID
                                ORDER BY bREF DESC, bRE_STEP) A )
        WHERE RN BETWEEN 3 AND 6;


-- 3. 글상세보기
SELECT B.*, cNAME, cEMAIL
    FROM BBS B, CUSTOMER C
    WHERE B.bID=C.cID AND bNO=1;
    
    
-- 4. 글수정
UPDATE BBS SET bTITLE = '수정된 제목',
                bCONTENT = '수정 본문',
                bFILENAME = NULL
            WHERE bNO=1;
          
            
-- 5. 글삭제
DELETE FROM BBS WHERE bNO=2;


-- 커밋
SELECT * FROM BBS;
COMMIT;



-- ★★★ 관리자(MANAGER) 테이블 DAO ★★★

-- 1. 관리자 등록
INSERT INTO MANAGER VALUES('aaaa', '1234', '관리자1');

-- 2. 관리자 로그인(중복 확인)
SELECT * FROM MANAGER WHERE mID='aaaa';

-- 3. 로그인
SELECT * FROM MANAGER WHERE mID='aaaa' AND mPW='1234';

-- (별도) 로그인 후 세션에 담기위한 정보 넣을 때 필요한 쿼리
SELECT * FROM MANAGER WHERE mID='aaaa';

-- 커밋
SELECT * FROM MANAGER;
COMMIT;
