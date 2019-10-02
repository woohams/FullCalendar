DROP TABLE TB_CUSTOMER;

CREATE TABLE TB_CUSTOMER(
	ID VARCHAR2(100) PRIMARY KEY,
	PASSWORD VARCHAR2(1000) NOT NULL,
	NAME VARCHAR2(100) NOT NULL
);

INSERT INTO TB_CUSTOMER VALUES('admin', 'admin1234', '관리자');

SELECT ID, PASSWORD, NAME FROM TB_CUSTOMER;

--------------------------------------------------------------------------------

DROP SEQUENCE CALENDAR_SEQ;
DROP TABLE CALENDAR;

CREATE SEQUENCE CALENDAR_SEQ;
CREATE TABLE CALENDAR(
	CALENDAR_SEQ NUMBER,
	ID VARCHAR2(20) NOT NULL,
	CALENDAR_CATEGORY VARCHAR2(20) NOT NULL,
	CALENDAR_TITLE VARCHAR2(20) NOT NULL,
	CALENDAR_CONTENT VARCHAR2(200),
	CALENDAR_BACKGROUNDCOLOR VARCHAR2(30),
	CALENDAR_START DATE NOT NULL,
	CALENDAR_END DATE NOT NULL,
	CALENDAR_ALLDAY VARCHAR2(10),
	
	CONSTRAINT CALENDAR_SEQ_CALENDAR_PK PRIMARY KEY(CALENDAR_SEQ),
	CONSTRAINT ID_CALENDAR_FK FOREIGN KEY(ID) REFERENCES TB_CUSTOMER(ID)
);

INSERT INTO CALENDAR VALUES(CALENDAR_SEQ.NEXTVAL, 'admin', '카테고리1', '일정 제목', '일정 내용', '#D25565',SYSDATE, SYSDATE, 'false');

SELECT * FROM CALENDAR;

--------------------------------------------------------------------------------

