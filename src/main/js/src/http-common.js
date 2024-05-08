import axios from "axios";

const seguranca = axios.create({
  //baseURL: "http://sistemas.tre-ce.jus.br/api/seguranca",
  //baseURL: "http://10.7.130.20:8080/api",
  baseURL: "http://localhost:8080/api",
  headers: {
    "Content-type": "application/json"
  }
});

//seguranca.defaults.validateStatus

const regulus_api = axios.create({
  //baseURL: "http://homologa.tre-ce.gov.br/regulus-ds/api",
  //baseURL: "http://10.7.130.20:8080/api", 
  baseURL: "http://localhost:8080/api", 
  //baseURL: "http://"+window.location.hostname+":8080/api",
  headers: {
    "Content-type": "application/json"
  }
});

export { regulus_api, seguranca };