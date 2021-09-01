$(document).ready(function () {
    let clanId = localStorage.getItem('clan');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clan/prikazi/" + clanId,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            let row = "<tr>";
            row += "<td>" + response.ime + "</td>";
            row += "<td>" + response.prezime + "</td>";
            row += "<td>" + response.korisnicko_ime + "</td>";
            row += "<td>" + response.email + "</td>";
            row += "<td>" + response.lozinka + "</td>";
            row += "<td>" + response.datum_rodjenja + "</td>";
            row += "<td>" + response.kontakt + "</td>";


            $('#pregledaj').append(row);

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});