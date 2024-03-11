import logo from './logo.svg';
import { useEffect, useState } from "react";
import './App.css';

function App() {
  const [allAccounts, setAllAccounts] = useState([]);
  const [balance, setBalance] = useState(0.0);

  function createNewAccount(e) {
    e.preventDefault();
    const accountName = document.getElementsByName("name")[0].value;
    const accountType = document.getElementsByName("accountType")[0].value;
    const balance = document.getElementsByName("balance")[0].value;
    const newAccountSignup = {
      "name": accountName,
      "balance": balance,
      "accountType": accountType
    };
    fetch("/api/account/", {
      method: "POST",
      "headers": {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newAccountSignup)
    }).then((resp) => {
      console.log(resp);
    })
  }
  async function getAllAccounts() {
    const urlStr = "/api/account/all";
    const resp = await fetch(urlStr);
    const responseJson = await resp.json();
    console.log(responseJson);
    setAllAccounts(responseJson.data);
  }

  async function deleteAccount(id) {
    console.log(`Received query to delete -> ${id}`);
    const urlStr = `/api/account/${id}`;
    fetch(urlStr, {
      method: "DELETE",
    }).then((resp) => {
      console.log("Deleting successfull");
      console.log(resp);
      getAllAccounts();
    })
  }

  return (
    <div className="App">
      <h1> Welcome to Spring Boot react template app</h1>
      <p> where you to create and manage your bank accounts </p>
      <div id="addAccountForm" style={{ display: 'flex', flexDirection: 'column' }}>
        <form onSubmit={createNewAccount}>
          <h3> Add account </h3>
          <div id="nameFields">
            <p>
              Name: <input type='text' name='name' />
            </p>
          </div>
          <div id="balanceFields">
            <p>
              Balance: <input type='number' name='balance' />
            </p>

          </div>
          <div id="accountType">
            <p>
              Type: <input type='text' name='accountType' />
            </p>
          </div>
          <div>
            <button className="btn btn-sm btn-success" type="submit">
              {" "}
              Add{" "}
            </button>
          </div>
        </form>
      </div>
      <div id="listAccounts">
        <h4> Update and delete functionality to be added here</h4>
        <button onClick={getAllAccounts}> Fetch Accounts</button>
        {allAccounts.map((account) => (
          <div key={account.accountId} style={{display: 'flex', flexDirection:"row", justifyContent: "center", padding: 8}}>
            <div style={{padding: 3}}>Name: <b>{account.name}</b> </div>
            <div style={{padding: 3}}>Balance: <b>{account.balance}</b> </div>
            <div style={{padding: 3}}>Account Type: <b>{account.accountType} </b></div>
            <div style={{padding: 3}}><button onClick={() => deleteAccount(account.accountId)}> delete</button></div>
          </div>
            
        ))}
      </div>
      <div id="accountDetails">

      </div>
    </div>
  );
}

export default App;
