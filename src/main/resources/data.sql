INSERT INTO FITNES_CENTAR (naziv, adresa, br_telefona, email) VALUES ('Fit', 'Vrsacka 5', '065123456', 'fit@fit.com');
INSERT INTO FITNES_CENTAR (naziv, adresa, br_telefona, email) VALUES ('Fit2', 'Kosovska 2', '062675323', 'fit2@fit.com');

INSERT INTO CLAN (ime, prezime, korisnicko_ime, lozinka, email, kontakt, datum_rodjenja, uloga, aktivan, fitnes_centar_id) VALUES ('Pera', 'Peric', 'pera', 'pera123', 'pera@fit.com', '065987654', '12-12-1995', 'Clan', true, 1);
INSERT INTO CLAN (ime, prezime, korisnicko_ime, lozinka, email, kontakt, datum_rodjenja, uloga, aktivan, fitnes_centar_id) VALUES ('Nemanja', 'Nemanjic', 'neca', 'neca123', 'neca@fit.com', '065987123', '01-01-1997', 'Clan', true, 1);

INSERT INTO TRENER(aktivan, datum_rodjenja, email, ime, kontakt, korisnicko_ime, lozinka, obrisan, prezime, uloga, fitnes_centar_id) VALUES (true,'09-09-1998' ,'nikola@trener', 'Nikola', '062345987', 'nikola', 'nikola123',false , 'Nikolic', 'trener', 1);
INSERT INTO TRENER(aktivan, datum_rodjenja, email, ime, kontakt, korisnicko_ime, lozinka, obrisan, prezime, uloga, fitnes_centar_id) VALUES (true,'01-01-1997', 'milos@trener', 'Milos', '062346087', 'milos', 'milos123',false , 'Milosevic', 'trener', 2);

INSERT INTO TRENING (cena, naziv, opis, tip, trajanje, trener_id) VALUES (350.0, 'cardio', 'bodycombat', 'tip1', 45,1);
INSERT INTO TRENING (cena, naziv, opis, tip, trajanje, trener_id) VALUES (250.0, 'strength', 'bodypump', 'tip2', 80,1);
INSERT INTO TRENING (cena, naziv, opis, tip, trajanje, trener_id) VALUES (300.0, 'booty-lift', 'adfjadfonadg', 'tip3', 60,2);
INSERT INTO TRENING (cena, naziv, opis, tip, trajanje, trener_id) VALUES (500.0, 'cardio', 'bodyattack', 'tip1', 45,1);
INSERT INTO TRENING (cena, naziv, opis, tip, trajanje, trener_id) VALUES (350.0, 'crossfit', 'crossfit2', 'tip4', 50,2);

INSERT INTO ADMINISTRATOR(aktivan, datum_rodjenja, email, ime, kontakt, korisnicko_ime, lozinka, prezime, uloga) VALUES (true,'09-09-1998' ,'nikola@trener', 'Sima', '062345987', 'sima', 'sima123', 'Simic', 'administrator' );

INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (300, 1, 1);
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (200, 2, 2);
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (100, 3, 1);

INSERT INTO TERMIN (datum, fitnes_centar_id, sala_id, trener_id,trening_id) VALUES ('1-2-3', 1, 1, 1, 1);
INSERT INTO TERMIN (datum, fitnes_centar_id, sala_id, trener_id,trening_id) VALUES ('1-3-3', 2, 1, 2, 3);