window.onload = function() {
    fetch('http://localhost:8080/api/product/Legacy/Model/auction')
    .then(function (response) {
    return response.json();
    })
    .then(function (data){
        cokolwiek(data);
    });
    function cokolwiek(data){

        for(var obj in data.content) {
            var i = Object.keys(data.content).indexOf(obj);
            let aukcja = document.createElement("div");
            aukcja.innerHTML = data.content[i].product.id + " " +
            data.content[i].product.name  + " " +
            data.content[i].userSeller.id + " " +
            data.content[i].userSeller.login + " " +
            data.content[i].price;
            document.body.appendChild(aukcja);
            var a = document.createElement("a"); 
            a.setAttribute('href',"auction.html?id=" + i);
            document.body.appendChild(a);
        };
    }

    

  };
