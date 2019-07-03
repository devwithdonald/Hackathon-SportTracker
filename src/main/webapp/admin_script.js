function returnMessage(event){
    
    event.preventDefault();
    
    let team1Name = document.getElementById("team_1").value;
    let team2Name = document.getElementById("team_2").value;
    let team1Score = document.getElementById("team_1_score").value;
    let team2Score = document.getElementById("team_2_score").value;
    let winner = document.getElementById("winner").value;

    
    let game = new Game(team1Name, team2Name, team1Score, team2Score, winner)

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {
            alert(xhr.responseText);
        
        }
    }

   xhr.open("POST", "./AddGameServlet", true);

   xhr.send(JSON.stringify(game));
}

let Game = function (team1Name, team2Name, team1Score, team2Score, winner) {
    this.team1Name = team1Name;
    this.team2Name = team2Name;
    this.team1Score = team1Score;
    this.team2Score = team2Score;
    this.winner = winner;
}




window.onload = function() {
    

   document.getElementById("gameform").addEventListener("submit", returnMessage);
}