-- Member.xml(회원가입, id중복체크, id로 memberDto 받아오기, 정보수정)

-- idConfirm
SELECT * FROM MEMBER WHERE mID='aaa';

-- joinMember
INSERT INTO MEMBER VALUES('bbb','1234','박과장','park@naver.com','12345','서울');

-- getMember
SELECT * FROM MEMBER WHERE mID='aaa';

-- modifyMember
UPDATE MEMBER SET mPW='1234',
                mNAME='정형돈',
                mMAIL='123@123.com',
                mPOST='111-112',
                mADDR='서울 어딘가'
        WHERE mID='aaa';




-- Book.xml(페이징없이 신규순 list, 페이징포함된 도서list(책이름순), 책갯수, 상세보기, 도서등록, 도서수정)

-- mainList
SELECT * FROM BOOK ORDER BY bRDATE;

-- bookList
SELECT * FROM (SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM BOOK ORDER BY bTITLE) A)
    WHERE RN BETWEEN 2 AND 10;

-- totCntBook
SELECT COUNT(*) TOTCNT FROM BOOK;

-- getDetailBook
SELECT * FROM BOOK WHERE bNUM=2;

-- registBook
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bIMG1, bIMG2, bINFO)
    VALUES(BOOK_SQ.NEXTVAL, 'jsp', '정형돈', 'noImg.png', 'noImg.png', 'jsp basic');

-- modifyBook
UPDATE BOOK SET bTITLE='aaa',
                bWRITER='aaa',
                bRDATE='2022/07/24',
                bIMG1='noImg.png',
                bIMG2='noImg.png',
                bINFO='aaaaaa'
        WHERE bNUM='3';


SELECT * FROM MEMBER;
SELECT * FROM BOOK;
COMMIT;
























