import React from 'react';
import './App.css'; // Assume CSS classes textRed and textGreen are defined here

function App() {
  const element = "Office Space";
  // Placeholder image source
  const sr = "https://via.placeholder.com/300x200?text=Office+Space"; 
  const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;
  const ItemName = { Name: "DBS", Rent: 50000, Address: 'Chennai' };

  let colors = [];
  if (ItemName.Rent <= 60000) {
    colors.push('textRed');
  } else {
    colors.push('textGreen');
  }

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}
      <h1>Name: {ItemName.Name}</h1>
      {/* Applying the conditional CSS class for Rent */}
      <h3 className={colors.join(' ')}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>
    </div>
  );
}

export default App;