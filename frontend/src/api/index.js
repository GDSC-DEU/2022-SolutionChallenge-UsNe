import axios from "axios";

const url = "http://34.64.99.131:8080/api"

function registerUser(userData) {
  return axios.post(`${url}/signup`, userData, { withCredentials: true });
}
function loginUser(userData) {
  return axios.post(`${url}/login`, userData, { withCredentials: true });
}
function postConsumption(userData) {
  return axios.post(`${url}/consumptions`, userData, { withCredentials: true });
} 
function getConsumptions() {
  return axios.get(`${url}/consumptions`,  { withCredentials: true });
}

export { registerUser, loginUser, postConsumption, getConsumptions };