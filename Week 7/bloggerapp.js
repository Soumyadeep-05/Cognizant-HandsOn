import React from 'react';
import './App.css'; 

// Data Source
export const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 },
];

function App() {
  // Mapping through the books array to render list items dynamically
  const bookdet = (
    <ul style={{ listStyleType: 'none', padding: 0 }}>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  // Static content for Blog Details
  const content = (
    <div>
      <h2>React Learning</h2>
      <h4>Stephen Biz</h4>
      <p>Welcome to learning React!</p>
      <h2>Installation</h2>
      <h4>Schewzdenier</h4>
      <p>You can install React from npm.</p>
    </div>
  );

  // Static content for Course Details
  const coursedet = (
    <div>
      <h2>Angular</h2>
      <h4>4/5/2021</h4>
      <h2>React</h2>
      <h4>6/3/2021</h4>
    </div>
  );

  return (
    <div style={{ display: 'flex', justifyContent: 'space-around', textAlign: 'center', marginTop: '20px' }}>
      <div className="mystyle1">
        <h1>Course Details</h1>
        {coursedet}
      </div>
      
      {/* Visual separator as seen in the mockup */}
      <div style={{ borderLeft: '4px solid green', height: '500px' }}></div>

      <div className="st2">
        <h1>Book Details</h1>
        {bookdet}
      </div>

      <div style={{ borderLeft: '4px solid green', height: '500px' }}></div>

      <div className="v1">
        <h1>Blog Details</h1>
        {content}
      </div>
    </div>
  );
}

export default App;