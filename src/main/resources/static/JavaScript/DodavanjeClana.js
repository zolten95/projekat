$(document).on("submit", "#FormaClana", function (event) {
    event.preventDefault();

    let ime = $("#poljeImena").val();
    let prezime = $("#poljePrezimena").val();
    let korisnicko_ime = $("#poljekIme").val();
    let email = $("#poljeEmaila").val();
    let lozinka = $("#poljeLozinke").val();
    let datum_rodjenja = $("#poljeDatuma").val();
    let kontakt = $("#poljeTelefona").val();


    let Clan = {
        korisnicko_ime,
        lozinka,
        ime,
        prezime,
        kontakt,
        email,
        datum_rodjenja,
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/clan",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(Clan),
        success: function (response) {
            console.log(response);

            alert("Uspesna ste registrovali novog clana!");
            window.location.href = "index.html";
        },
        error: function () {
            alert("Greska!");
        }
    });
});