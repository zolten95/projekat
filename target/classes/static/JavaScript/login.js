$(document).on("submit", "#login", function (event) {
    event.preventDefault();
    let korisnicko_ime = $("#poljeKime").val();
    let lozinka = $("#poljeLozinka").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/login2/" + korisnicko_ime + "/" + lozinka,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            localStorage.setItem('administrator', response.korisnicko_ime);
            window.location.href = "administrator.html";
        },


    });

});


$(document).on("submit", "#login", function (event) {
    event.preventDefault();
    let korisnicko_ime = $("#poljeKime").val();
    let lozinka = $("#poljeLozinka").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/login1/" + korisnicko_ime + "/" + lozinka,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            localStorage.setItem('trener', response.korisnicko_ime);
            window.location.href = "profilTrener.html";
        },

    });

});



$(document).on("submit", "#login", function (event) {
    event.preventDefault();
    let korisnicko_ime = $("#poljeKime").val();
    let lozinka = $("#poljeLozinka").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/login/" + korisnicko_ime + "/" + lozinka,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            localStorage.setItem('clan', response.korisnicko_ime);
            window.location.href = "profil.html";
        },


        });

});

