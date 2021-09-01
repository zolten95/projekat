$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/profil",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            $('#profil').find('tbody').children( 'tr:not(:first)').remove();
            for (let trening of response) {
                let row = "<tr>";
                row += "<td>" + trening.cena + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip + "</td>";
                row += "<td>" + trening.trajanje + "</td>";



                $('#profil').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function sortiraj(){


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/profil/sortCena",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            $('#profil').html(response);

            for (let trening of response) {
                let row = "<tr>";
                row += "<td>" + trening.cena + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip + "</td>";
                row += "<td>" + trening.trajanje + "</td>";



                $('#profil').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
};

$(document).on("submit","#Pretraga",function (event) {
    event.preventDefault();
    let naziv=$("#poljePretraga").val();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/profil/pretraga/"+naziv,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            $('#profil').html(response);
            for (let trening of response) {
                let row = "<tr>";
                row += "<td>" + trening.cena + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip + "</td>";
                row += "<td>" + trening.trajanje + "</td>";


                $('#profil').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});