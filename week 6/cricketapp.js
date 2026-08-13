import React from 'react';

// 1. Declare the arrays with player details and scores
const players = [
  { name: 'Jack', score: 50 },
  { name: 'Michael', score: 70 },
  { name: 'John', score: 40 },
  { name: 'Ann', score: 61 },
  { name: 'Elisabeth', score: 61 },
  { name: 'Sachin', score: 95 },
  { name: 'Dhoni', score: 100 },
  { name: 'Virat', score: 84 },
  { name: 'Jadeja', score: 64 },
  { name: 'Raina', score: 75 },
  { name: 'Rohit', score: 80 }
];

const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];
const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

// Merge arrays using the ES6 spread operator
const mergedIndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

// 2. Component: ListofPlayers using ES6 map() and arrow functions
export function ListofPlayers({ players }) {
  return (
    <div>
      {players.map((item, index) => (
        <div key={index}>
          <li>Mr. {item.name} <span>{item.score}</span></li>
        </div>
      ))}
    </div>
  );
}

// 3. Component: Scorebelow70 using ES6 filter() and arrow functions
export function Scorebelow70({ players }) {
  // Using filter is the standard ES6 approach over pushing to an empty array
  const players70 = players.filter(item => item.score <= 70);
  return (
    <div>
      {players70.map((item, index) => (
        <div key={index}>
          <li>Mr. {item.name} <span>{item.score}</span></li>
        </div>
      ))}
    </div>
  );
}

// 4. Component: OddPlayers using ES6 Destructuring
export function OddPlayers({ team }) {
  const [first, , third, , fifth] = team;
  return (
    <div>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </div>
  );
}

// Component: EvenPlayers using ES6 Destructuring
export function EvenPlayers({ team }) {
  const [, second, , fourth, , sixth] = team;
  return (
    <div>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </div>
  );
}

// Component: ListofIndianPlayers (Merged arrays)
export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <div>
      {IndianPlayers.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </div>
  );
}

// 5. Main App Component with conditional rendering (if/else flag)
function App() {
  const flag = true; // Change this to 'false' to view the other components

  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Odd Players</h1>
        <OddPlayers team={IndianTeam} />
        <hr />
        <h1>Even Players</h1>
        <EvenPlayers team={IndianTeam} />
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <ListofIndianPlayers IndianPlayers={mergedIndianPlayers} />
      </div>
    );
  }
}

export default App;