CREATE TABLE odf_example (
  id varchar(64)  NOT NULL,
  user_code varchar(64) DEFAULT NULL,
  user_name varchar(256) DEFAULT NULL,
  create_time date DEFAULT NULL,
  create_name varchar(64) DEFAULT NULL,
  remarks varchar(2000) DEFAULT NULL,
  PRIMARY KEY (id)
) 


