CREATE TABLE IF NOT EXISTS demo_user (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL DEFAULT NULL ,
  `age` INT(2) NOT NULL ,
  PRIMARY KEY (id)
)

insert demo_user VALUES(1,'yangzl',23)

select * from demo_user


