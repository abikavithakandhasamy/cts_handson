import React from "react";

function ListofPlayers() {

  const players = [
    { name: "Virat", score: 90 },
    { name: "Rohit", score: 82 },
    { name: "Gill", score: 75 },
    { name: "Rahul", score: 65 },
    { name: "Hardik", score: 88 },
    { name: "Jadeja", score: 55 },
    { name: "Ashwin", score: 72 },
    { name: "Bumrah", score: 40 },
    { name: "Shami", score: 68 },
    { name: "Siraj", score: 78 },
    { name: "Kuldeep", score: 60 }
  ];

  const lowScorePlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>

      <h3>All Players</h3>

      {players.map((player, index) => (
        <p key={index}>
          {player.name} - {player.score}
        </p>
      ))}

      <h3>Players with score below 70</h3>

      {lowScorePlayers.map((player, index) => (
        <p key={index}>
          {player.name} - {player.score}
        </p>
      ))}
    </div>
  );
}

export default ListofPlayers;