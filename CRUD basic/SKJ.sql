

CREATE TABLE THEATER_MEMBER (
    MEM_ID	        VARCHAR2(15),
    MEM_PASS	    VARCHAR2(15)   NOT NULL,
    MEM_NAME	    VARCHAR2(20)   NOT NULL,
    MEM_REGNO1	    CHAR(6)        NOT NULL,
    MEM_REGNO2	    CHAR(7)        NOT NULL,
    MEM_ADD1	    VARCHAR2(100)  NOT NULL,
    MEM_ADD2	    VARCHAR2(80)   NOT NULL,
    MEM_HP	        VARCHAR2(15),
    MEM_MAIL	    VARCHAR2(40)   NOT NULL,
    MEM_MILEAGE	    NUMBER(10,0) DEFAULT 0 NOT NULL,
    MEM_DELETE      CHAR(1) DEFAULT '0' NOT NULL,
    
    CONSTRAINT pk_theater_member PRIMARY KEY(MEM_ID))
    
INSERT INTO THEATER_MEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, MEM_REGNO2, MEM_ADD1, MEM_ADD2, MEM_HP,
                            MEM_MAIL)
                    VALUES ('shinkwang23', 'temppass', '신광진', '950130', '1111111', '대전광역시 홍도동', '홍도로 55번길 41 집현전 209호',
                            '010-5361-4713', 'shinkwang23@navercom');