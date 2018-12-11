 create table paciente (
  ci varchar(30),
  nombre varchar(30),
  edad Integer
 );

 create table ficha_paciente(
  ci varchar(30),
  presion_arterial Integer,
  frecuencia_cardiaca varchar(7)
 );


 create table frecuencia_cardiaca(
  sexo varchar(1),
  edad_inicial Integer,
  edad_final Integer,
  mal Integer,
  normal_inicial Integer,
  normal_final Integer,
  bien_inicial Integer,
  bien_final Integer,
  excelente Integer
 );

insert into frecuencia_cardiaca values('H',20,29,86,70,84,62,68,60);
insert into frecuencia_cardiaca values('H',30,39,86,72,84,64,70,62);
insert into frecuencia_cardiaca values('H',40,49,90,74,88,66,74,64);
insert into frecuencia_cardiaca values('H',50,200,90,76,88,68,74,66);

insert into frecuencia_cardiaca values('M',20,29,96,78,94,72,76,70);
insert into frecuencia_cardiaca values('M',30,39,98,80,96,72,78,70);
insert into frecuencia_cardiaca values('M',40,49,100,80,98,74,78,72);
insert into frecuencia_cardiaca values('M',50,200,104,84,102,76,82,74);


 create table presion_arterial(
  categoria varchar(3),
  sistolica_inicial Integer,
  sistolica_final Integer,
  diastolica_inicial Integer,
  diastolica_final Integer
 );

insert into presion_arterial values ('N',0,120,0,80);
insert into presion_arterial values ('E',120,129,0,80);
insert into presion_arterial values ('PA1',130,139,80,89);
insert into presion_arterial values ('PA2',140,180,90,120);
insert into presion_arterial values ('CE',180,1000,120,1000);

