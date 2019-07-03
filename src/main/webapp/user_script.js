function getResults(){
    let xhr = new XMLHttpRequest();
 
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 & xhr.status === 200){
            let requestArr = JSON.parse(xhr.responseText);
            appendToTable(requestArr);
        }
    }
 
    xhr.open("GET", "ViewAllGamesServlet", true);
 
    xhr.send();
 }
 
 function appendToTable(requestArr){
    const tableBody = document.getElementById('all-sports-results');
 
    tableBody.innerHTML = "";

    for (let i = 0; i < requestArr.length; i++){
        tableBody.innerHTML += `
        <tr>
            <td>${requestArr[i].team1Name}</td>
            <td>${requestArr[i].team2Name}</td>
            <td>${requestArr[i].team1Score}</td>
            <td>${requestArr[i].team2Score}</td>
            <td>${requestArr[i].winner}</td>
        </tr>
        `;
    }
 }


 function getResults2(){
    let xhr = new XMLHttpRequest();
 
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 & xhr.status === 200){
            let requestArr = JSON.parse(xhr.responseText);
            appendToTable2(requestArr);
        }
    }
 
    xhr.open("GET", "./ViewRecentGames", true);
 
    xhr.send();
 }
 
 function appendToTable2(requestArr){
    const tableBody = document.getElementById('my-sports-results');
 
    tableBody.innerHTML = "";

    for (let i = 0; i < requestArr.length; i++){
        tableBody.innerHTML += `
        <tr>
            <td>${requestArr[i].team1Name}</td>
            <td>${requestArr[i].team2Name}</td>
            <td>${requestArr[i].team1Score}</td>
            <td>${requestArr[i].team2Score}</td>
            <td>${requestArr[i].winner}</td>
        </tr>
        `;
    }
 }





window.onload = function() {

    getResults();
    
    getResults2();


}
 
