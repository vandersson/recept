function getSuggestions(str) {
    var searchSugestion = document.getElementById("searchSugestionList");
    if (str.length == 0) {
        searchSugestion.innerHTML = "";
        searchSugestion.style.border = "0px";
    }
    else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var sugestions = JSON.parse(xmlhttp.responseText);
                var sugestionList = document.getElementById("searchSugestionList");
                sugestionList.innerHTML = sugestions.reduce(function (p_val, sugestion, i, arr) {
                    return p_val + '<li><a href="' + sugestion.href + '">' + sugestion.text + '</a></li>';

                }, '');
                sugestionList.style.border = "1px solid #A5ACB2";
            }
        }
        xmlhttp.open("GET", "/search?q=" + str, true);
        xmlhttp.setRequestHeader("Accept", "application/json");
        xmlhttp.send();
    }
}
