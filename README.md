# ApplicationProgrammingInterface

Aplikacija je napravljena kako bi se mogla pokrenuti u Command Promptu ili IDE okruženju. <br>
Sadrži dvije klase, User i UserAddress te svaka sadrži svoja svojstva. <br>
U klasi Users, opisane su mogućnosti koje aplikacija nudi: registracija korisnika, dohvaćanje podataka o korisniku na temelju unesenog id-a, ažuriranje podataka o korisniku na temelju unesenog id-a te traženje korisnika po imenu, prezimenu, gradu ili adresi. <br>
U bazi su te dvije tablice povezane zajedničkim primarnim ključem id, a tablica User vanjski je ključ tablice UserAddress. <br>

Primjer putanje pomoću koje je moguće pokrenuti aplikaciju u Command Promptu, za vlastito pokretanje treba prilagoditi putanju ovisno o tome gdje se podaci preuzmu: C:\Users\UserName\Documents\ApplicationProgrammingInterface\ApplicationProgrammingInterface\bin\java api.Start <br>

Baza napravljena u SQL-u: <br>
drop database if exists databaseAPI; <br>
create database databaseAPI; <br>
use databaseAPI; <br>

create table user ( <br>
    id int not null primary key auto_increment, <br>
    firstname varchar(50) not null, <br>
    lastname varchar(50) not null, <br>
    email varchar(255) not null, <br>
    username varchar(50) not null, <br>
    password varchar(50) not null <br>
); <br> 

create table user_address ( <br>
id int not null primary key auto_increment, <br>
user_id int, <br>
city varchar(50) not null, <br>
street varchar(50) not null, <br>
number varchar(50) not null <br>
); <br> 

alter table user_address add foreign key(user_id) references user(id); <br>


