$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let termin of response) {
                console.log(termin);

                let row = "<tr>";
                row += "<td>" + termin.datum + "</td>";
                row += "<td>" + termin.trening.naziv + "</td>";
                row += "<td>" + termin.trening.cena + "</td>";
                row += "<td>" + termin.sala.oznaka + "</td>";



                btn = "<button class='btnBris' data-id=" + termin.id+ ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnUpdat' data-id=" + termin.id + ">Azuriraj</button>";
                row += "<td>" + btn + "</td>";

                row += "</tr>";

                $('#termini').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});




$(document).on("submit", "#terminform", function (event) {
    event.preventDefault();

    let datum= $("#datumiField").val();
    let naziv = $("#select1").val();
    let cena=$("#cenaField").val();
    let oznaka=$("#select3").val();



    let newTermin = {
        datum,
        naziv,
        cena,
        oznaka


    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termin",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (response) {
            console.log(response);

            alert("Uspesno dodat termin");
            window.location.href = "Trener.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja!");
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/profil",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {
                var text = trening.naziv;
                var value = trening.naziv;
                var option3 = new Option(text, value); $('#select1').append($(option3));
                var option2 = new Option(text, value); $('#select3').append($(option2));
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let sala of response) {
                var text = sala.oznaka;
                var value = sala.oznaka;
                var option = new Option(text, value); $('#select2').append($(option));
                var option1 = new Option(text, value); $('#select4').append($(option1));

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnBris', function () {
    let terminId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/termin/" + terminId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + terminId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja termina!");
        }
    });
});