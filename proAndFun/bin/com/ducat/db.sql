CREATE TABLE IF NOT EXISTS Emp (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  job varchar(50) NOT NULL,
  salary int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
$$
INSERT INTO Emp (name, job, salary) VALUES
('Amit', 'Trainee', 20000);
$$
INSERT INTO Emp (name, job, salary) VALUES
('Raman', 'DBA', 78000);
$$
CREATE DEFINER=javaSep19@localhost PROCEDURE 
getName(IN empId INT(11), OUT empName VARCHAR(50))
    READS SQL DATA
begin

select name into empName from Emp where id=empId;
end
$$
CREATE DEFINER=javaSep19@localhost FUNCTION 
getSalary(empId INT(11)) RETURNS int(11)
    READS SQL DATA
begin
declare sal int(11);
select salary into sal from Emp where id=empId;
return sal;
end