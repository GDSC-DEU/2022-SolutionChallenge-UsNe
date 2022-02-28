import axios from "axios";

const url = "http://34.64.99.131:8080/api"

function registerUser(userData) {
  
  return axios.post(`${url}/signup`, userData);
}

export { registerUser };