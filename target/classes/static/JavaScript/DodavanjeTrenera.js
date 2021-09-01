$(document).on("submit", "#FormaTrenera", function (event) {
    event.preventDefault();


    let ime = $("#poljeImena").val();
    let prezime = $("#poljePrezimena").val();
    let korisnicko_ime = $("#poljeKime").val();
    let email = $("#poljeEmaila").val();
    let lozinka = $("#poljeLozinke").val();
    let datum_rodjenja = $("#poljeDatum").val();
    let kontakt = $("#poljeTelefona").val();
    let aktivan=true;



    let Trener = {
        korisnicko_ime,
        lozinka,
        ime,
        prezime,
        kontakt,
        email,
        datum_rodjenja,
        aktivan
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treneri",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(Trener),
        success: function (response) {
            console.log(response);

            alert("Uspesno ste se registrovali novog trenera!");
            window.location.href = "index.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});