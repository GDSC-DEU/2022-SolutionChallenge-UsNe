<template>
  <div>
    <form @submit.prevent="submitSignup" class="signupform">
      <div class="signupgrid">
        <h2 id="signuphead">회원가입</h2>
        <label for="userId"> 회원 ID : </label>
        <div>
          <input type="text" id="userId" v-model="userId"/>
        </div>
        <label for="userPassword"> 비밀번호 : </label>
        <div>
          <input type="password" id="userPassword" v-model="userPassword"/>
        </div>
        <label for="userName"> 이름 : </label>
        <div>
          <input type="text" id="userName" v-model="userName"/>
        </div>
        <label for="userPhoneNumber"> 전화번호 : </label>
        <div>
          <input type="text" id="userPhoneNumber" v-model="userPhoneNumber"/>
        </div>
        <label for="userBirth"> 생년월일 : </label>
        <div>
          <input type="date" id="userBirth" v-model="userBirth"/>
        </div>
        <div class="signupbutton">
          <input type="submit" value="Sign Up" id="signupbutton" @click="submitSignup">
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import { registerUser } from "@/api/index";
export default {
  data() {
    return {
      userId: "",
      userPassword: "",
      userName: "",
      userPhoneNumber: "",
      userBirth: "",
    };
  },
  methods: {
    async submitSignup() {
      const userData = {
        userId: this.userId,
        userPassword: this.userPassword,
        userName: this.userName,
        userPhoneNumber: this.userPhoneNumber,
        userBirth: this.userBirth,
      };
      const { data } = await registerUser(userData);
      console.log(data)
      this.initForm();
    },
    initForm() {
      this.userId = "";
      this.userPassword = "";
      this.userName = "";
      this.userPhoneNumber = "";
      this.userBirth = "";
    }
  },
}
</script>

<style scoped>
  .signupgrid {
    display: grid;
    grid-template-columns: 42% 58%;
    grid-template-rows: 70px 50px 50px 50px 50px 50px 80px;
    text-align: center;
    align-items: center;
  }
  .signupbutton {
    grid-column: 1/3;
  }
  #signupbutton {
    width: 115px;
    height: 45px;
    border: none;
    background-color: #6b6b6b;
    color: white;
    border-radius: 64px;
    font-size: 15px;
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5)
  }
  #signupbutton:hover {
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5) inset;
  }
  .signupgrid > div,  .signupgrid > label {
    line-height: 50px;
  }
  div > input {
    border: none;
    border-radius: 2px;
    height: 16px;
    padding: 5px;
  }
  #signuphead {
    grid-column: 1/3;
    text-align: center;
  }
  .signupform {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 350px;
    height: auto;
    padding: 15px;
    border-radius: 43px;
    background-color: rgb(232, 232, 232);
    box-shadow:0 5px 10px rgba(0, 0, 0, 0.5)
  }
</style>