import axios from "axios";

function registerUser(userData) {
  const url = "http://34.64.99.131:8080/api/signup";
  return axios.post(url, userData);
}

export { registerUser };