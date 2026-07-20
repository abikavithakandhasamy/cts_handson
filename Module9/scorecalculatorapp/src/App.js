import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Abikavitha"
        School="SKCT"
        Total={565}
        goal={6}
      />
    </div>
  );
}

export default App;