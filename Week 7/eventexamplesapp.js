import React, { useState } from 'react';

function App() {
  const [counter, setCounter] = useState(5);
  const [amount, setAmount] = useState(0);
  const [currency, setCurrency] = useState('Euro');

  // Increment counter and invoke multiple methods
  const handleIncrement = () => {
    setCounter(counter + 1);
    alert("Hello! Member1");
  };

  const handleDecrement = () => {
    setCounter(counter - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  // Synthetic event handler
  const onPress = (e) => {
    alert("I was clicked");
  };

  // Currency Converter Submit Handler
  const handleSubmit = (e) => {
    e.preventDefault();
    const convertedAmount = amount * 80; // Example conversion rate
    alert(`Converting to Euro Amount is ${convertedAmount}`);
  };

  return (
    <div style={{ padding: '20px' }}>
      <p>{counter}</p>
      <div>
        <button onClick={handleIncrement}>Increment</button>
      </div>
      <div>
        <button onClick={handleDecrement}>Decrement</button>
      </div>
      <div>
        <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      </div>
      <div>
        <button onClick={onPress}>Click on me</button>
      </div>

      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Amount: </label>
          <input 
            type="number" 
            value={amount} 
            onChange={(e) => setAmount(e.target.value)} 
          />
        </div>
        <div>
          <label>Currency: </label>
          <textarea 
            value={currency} 
            onChange={(e) => setCurrency(e.target.value)} 
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;