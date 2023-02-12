# ApplicationProgrammingInterface

Aplikacija je napravljena kako bi se mogla pokrenuti u Command Promptu ili IDE okruženju. 
Sadrži dvije klase, User i UserAddress te svaka sadrži svoja svojstva. 
U klasi Users, opisane su mogućnosti koje aplikacija nudi: registracija korisnika, dohvaćanje podataka o korisniku na temelju unesenog id-a, ažuriranje podataka o korisniku na temelju unesenog id-a te traženje korisnika po imenu, prezimenu, gradu ili adresi. 
U bazi su te dvije tablice povezane zajedničkim primarnim ključem id, a tablica User vanjski je ključ tablice UserAddress. 

Primjer putanje pomoću koje je moguće pokrenuti aplikaciju u Command Promptu, za vlastito pokretanje treba prilagoditi putanju ovisno o tome gdje se podaci preuzmu: C:\Users\UserName\Documents\ApplicationProgrammingInterface\ApplicationProgrammingInterface\bin\java api.Start

Baza napravljena u SQL-u: 
drop database if exists databaseAPI;
create database databaseAPI;
use databaseAPI;

create table user (
    id int not null primary key auto_increment,
    firstname varchar(50) not null,
    lastname varchar(50) not null, 
    email varchar(255) not null,
    username varchar(50) not null,
    password varchar(50) not null
);

create table user_address (
id int not null primary key auto_increment,
user_id int,
city varchar(50) not null,
street varchar(50) not null,
number varchar(50) not null
);

alter table user_address add foreign key(user_id) references user(id);


