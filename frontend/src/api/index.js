import axios from "axios";

const url = "http://34.64.99.131:8080/api"

function registerUser(userData) {
  return axios.post(`${url}/user/signup`, userData, { withCredentials: true });
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
function deleteConsumption(consumptionIndex) {
  return axios.delete(`${url}/consumptions/` + consumptionIndex,  { withCredentials: true });
}
function postGoals(userData) {
  return axios.post(`${url}/consumptionGoals`, userData, { withCredentials: true });
}
function getGoals() {
  return axios.get(`${url}/consumptionGoals`, { withCredentials: true });
}
function getSearch(searchitems) {
  return axios.get(`${url}/consumptions/search?` + searchitems , { withCredentials: true });
}
function postLogout(userData) {
  return axios.post(`${url}/logout`, userData, { withCredentials: true });
}
function getGoalCalc() {
  return axios.get(`${url}/consumptionGoals/calc`, { withCredentials: true });
}
function putGoals(userData) {
  return axios.put(`${url}/consumptionGoals`,userData, { withCredentials: true });
}
function postNewGroup(userData) {
  return axios.post(`${url}/groups`, userData, { withCredentials: true });
}
function getMyGroup() {
  return axios.get(`${url}/groups`, { withCredentials: true });
}
function deleteGroup(groupIndex) {
  return axios.delete(`${url}/groups/` + groupIndex,  { withCredentials: true });
}

export { registerUser, loginUser, postConsumption, getConsumptions, deleteConsumption, postGoals, getGoals, getSearch, postLogout, getGoalCalc, putGoals, postNewGroup, getMyGroup, deleteGroup };