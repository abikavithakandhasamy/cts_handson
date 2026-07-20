import React, { Component } from "react";

// Guest Page
function GuestGreeting() {
  return (
    <div>
      <h2>Welcome Guest</h2>
      <h3>Flight Details</h3>
      <ul>
        <li>Flight: AI202</li>
        <li>From: Chennai</li>
        <li>To: Delhi</li>
        <li>Departure: 10:30 AM</li>
      </ul>
      <p>Please login to book your ticket.</p>
    </div>
  );
}

// User Page
function UserGreeting() {
  return (
    <div>
      <h2>Welcome User</h2>
      <h3>Ticket Booking Page</h3>
      <p>You can now book your flight tickets.</p>
    </div>
  );
}

// Greeting Component
function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;

  if (isLoggedIn) {
    return <UserGreeting />;
  }

  return <GuestGreeting />;
}

// Login Button
function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

// Logout Button
function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  handleLogoutClick = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {

    const isLoggedIn = this.state.isLoggedIn;

    let button;

    if (isLoggedIn) {
      button = (
        <LogoutButton onClick={this.handleLogoutClick} />
      );
    } else {
      button = (
        <LoginButton onClick={this.handleLoginClick} />
      );
    }

    return (
      <div style={{ padding: "20px" }}>
        <Greeting isLoggedIn={isLoggedIn} />
        <br />
        {button}
      </div>
    );
  }
}

export default App;