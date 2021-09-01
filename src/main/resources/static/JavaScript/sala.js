(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let sala of response) {

                let row = "<tr>";
                row += "<td>" + sala.kapacitet + "</td>";
                row += "<td>" + sala.oznaka + "</td>";
                row += "<td>" + sala.fitnesCentar.naziv + "</td>";
                btn = "<button class='btnDelete' data-id=" + sala.id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnAzuriraj' data-id=" + sala.id + ">Azuriraj</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#sale').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on("submit", "#dodaj", function (event) {
    event.preventDefault();

    let kapacitet= $("#kapField").val();
    let oznaka = $("#oznakaField").val();
    let naziv=$("#fitnesiiiField").val();




    let newSala= {
        kapacitet,
        oznaka,

    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sale/" +naziv,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (response) {
            console.log(response);

            alert("Uspesno dodata sala");
            window.location.href = "Sale.html";


        },
        error: function () {
            alert("Greška prilikom dodavanja!");
        }
    });
});