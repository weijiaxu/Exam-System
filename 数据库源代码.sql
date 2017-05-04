create database JavaWebExamSystem

create table student (
sno varchar(15) primary key ,
sname varchar(50),
password varchar(15),
identify varchar(10),
loginstate varchar(20) check(loginstate in('notonline','online','finished'))
)

create table sinsel(
selectid int primary key,
stitle varchar(400),
optionA varchar(100),
optionB varchar(100),den
optionC varchar(100),
optionD varchar(100),
sanswer char,
sinselscore float
)

create table operation(
operationid smallint primary key,
otitle varchar(1000),
oanswer varchar(1000),
sinopescore float,
rank varchar(10) check(rank  in('easy','middle','difficult'))
)

create table grade(
sno varchar(15) primary key,
selid varchar(200),/*ѡ��������֮���ã�����*/
stuselanswer varchar(50),/*ѧ��ѡ�����*/
corselanswer varchar(50),/*ѡ������ȷ��*/
selscore float,
opeid varchar(10),
stuosanswer text,
opescore float,
sumscore float,
foreign key (sno) references student(sno) 
)



/*ִ�в������ݲ���*/


update student set identify='ѧ��'
insert into student(sno,sname,password,identify) values('1234567','��־ǿ','123654wzq','��ʦ')
update sinsel set sinselscore=1.5
update student set loginstate='notonline' where identify='ѧ��'



create trigger insert_sumscore on grade
for insert,update
as
if ((select selscore from grade where grade.sno=(select sno from inserted)) is not null)
begin  
update grade set sumscore=selscore+opescore  where grade.sno=(select sno from inserted) and selscore+opescore<=100;
end;
