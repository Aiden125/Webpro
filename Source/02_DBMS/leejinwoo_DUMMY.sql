-- ----------OWNER DATA
INSERT INTO OWNER (OID, ONAME, OPW, OTEL, OEMAIL, OADDRESS, OBIRTH, OGENDER)
    VALUES ('owner2', '박사장', 1, '010-1111-1111', 'ownerPARK@naver.com', '서울시', '19900708', '여자');
INSERT INTO OWNER (OID, ONAME, OPW, OTEL, OEMAIL, OADDRESS, OBIRTH, OGENDER)
    VALUES ('owner3', '이사장', 1, '010-7777-7777', 'ownerLEE@naver.com', '전주시', '19991010', '남자');
INSERT INTO OWNER (OID, ONAME, OPW, OTEL, OEMAIL, OADDRESS, OBIRTH, OGENDER)
    VALUES ('owner4', '최사장', 1, '010-3333-3333', 'ownerCHOI@naver.com', '광명시', '19670812', '남자');
INSERT INTO OWNER (OID, ONAME, OPW, OTEL, OEMAIL, OADDRESS, OBIRTH, OGENDER)
    VALUES ('owner5', '윤사장', 1, '010-9999-9999', 'ownerYOON@naver.com', '천안시', '19910427', '여자');

SELECT * FROM OWNER;
-- ----------OWNERBOARD DATA
set sql_safe_updates=0;
INSERT INTO OWNERBOARD (BNO, OID, SNAME, BLOC, BTITLE, BCONTENT, BPHOTO1, BPHOTO2, BPHOTO3, BPHOTO4, BPHOTO5, BHIT, BDATE) 
    VALUES ((SELECT get_seq_ob('bno')) , 'owner2', '보승회관', '강남', '진상손님', '진상손님 많아요', 'img1.jpg', NULL, NULL, NULL, NULL, 0, current_timestamp());
INSERT INTO OWNERBOARD (BNO, OID, SNAME, BLOC, BTITLE, BCONTENT, BPHOTO1, BPHOTO2, BPHOTO3, BPHOTO4, BPHOTO5, BHIT, BDATE) 
    VALUES ((SELECT get_seq_ob('bno')) , 'owner3', '보배반점', '제주', '짜장면짱', '짬뽕도짱', 'img1.jpg', NULL, NULL, NULL, NULL, 0, current_timestamp());
INSERT INTO OWNERBOARD (BNO, OID, SNAME, BLOC, BTITLE, BCONTENT, BPHOTO1, BPHOTO2, BPHOTO3, BPHOTO4, BPHOTO5, BHIT, BDATE) 
    VALUES ((SELECT get_seq_ob('bno')) , 'owner4', '강식당', '건대', '내가게는', '음식내용', NULL, NULL, NULL, NULL, NULL, 0, current_timestamp());
INSERT INTO OWNERBOARD (BNO, OID, SNAME, BLOC, BTITLE, BCONTENT, BPHOTO1, BPHOTO2, BPHOTO3, BPHOTO4, BPHOTO5, BHIT, BDATE) 
    VALUES ((SELECT get_seq_ob('bno')) , 'owner5', '윤식당', '건대', '내가게는', '음식내용', NULL, NULL, NULL, NULL, NULL, 0, current_timestamp());

SELECT * FROM OWNERBOARD;

-- 페이징을 위한 나머지 DATA는 JAVA로 삽입
SELECT * FROM OWNER WHERE ONAME='이진우' AND OID='dlwlsdn11';
-- ----------BOARD_COMMENT DATA
INSERT INTO BOARD_COMMENT (CNO, BNO, OID, CCONTENT, CDATE)
    VALUES ((SELECT get_seq_bc('cno')), 3, 'owner5', '못살겠어요', current_timestamp());
INSERT INTO BOARD_COMMENT (CNO, BNO, OID, CCONTENT, CDATE)
    VALUES ((SELECT get_seq_bc('cno')), 4, 'owner2', '맞죠맞죠~', current_timestamp());
INSERT INTO BOARD_COMMENT (CNO, BNO, OID, CCONTENT, CDATE)
    VALUES ((SELECT get_seq_bc('cno')), 5, 'owner4', '볶음밥도 짱', current_timestamp());

commit;