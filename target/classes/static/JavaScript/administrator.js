$(document).on("submit", "#Fitnesscentarform", function (event) {
    event.preventDefault();

    let naziv= $("#nazivField").val();
    let adresa = $("#adresaField").val();
    let broj_telefona = $("#brField").val();
    let email = $("#emailField").val();



    let newFitnessCentar = {
        naziv,
        adresa,
        broj_telefona,
        email,

    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fitnescentar",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCentar),
        success: function (response) {
            console.log(response);

            alert("Uspesno ste dodali fitness centar");
            window.location.href = "administrator.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja!");
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnescentar",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let fitnescentar of response) {
                let row = "<tr>";
                row += "<td>" + fitnescentar.naziv + "</td>";
                row += "<td>" + fitnescentar.adresa + "</td>";
                row += "<td>" + fitnescentar.email+ "</td>";
                row += "<td>" + fitnescentar.broj_telefona+ "</td>";

                btn = "<button class='btnDelete' data-id=" + fitnescentar.id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnUpdate' data-id=" + fitnescentar.id + ">Azuriraj</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#fitnessi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let FitnesID = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnescentar/" + FitnesID,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + FitnesID + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja fitnes centra!");
        }
    });
});




$(document).on('click','.btnUpdate',function () {
    let id = this.dataset.id;
    let naziv= $("#naziv").val();
    let adresa = $("#adresa").val();
    let broj_tel = $("#br").val();
    let email = $("#email").val();


    let fitnescentar={
        naziv,
        adresa,
        broj_tel,
        email
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/fitnescentar/" + id,
        dataType: "json",
        contentType:"application/json",
        data: JSON.stringify(fitnescentar),
        success: function (response) {
            console.log("SUCCESS:\n", response);
            window.location.href = "administrator.html";



        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});







