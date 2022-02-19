<template>
  <div>
    <h2>usne</h2>
    <button id="new" @click.stop="onNew">New</button>
    <button id="delete">Delete</button>
    <table id="accountBook">
      <thead>
        <tr>
          <th>Date</th>
          <th>Description</th>
          <th>tag</th>
          <th>Amount</th>
          <th>Total</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="list in lists" :key="list.key">
          <td>{{ list.date }}</td>
          <td>{{ list.description }}</td>
          <td>{{ Object.values(list.tag)?.join(", ") }}</td>
          <td>{{ list.amount }}</td>
          <td>{{ list.total }}</td>
        </tr> 
      </tbody>
    </table>

    <h2>replit</h2>
    <div class="main">
      <div class="title">
        Goal
      </div>
      <div class="subtitle">
        한 달 예산 <br><input class="subtitle-cost"> 원
      <button class="button-set">
      설정
      </button>
      </div>
    <div class="account"> 
     <p>식비<input class="account-cost"> 
        문화<input class="account-cost"></p>
     <p>생활<input class="account-cost">
        의류<input class="account-cost"></p> 
     <p>쇼핑<input class="account-cost">  
        미용<input class="account-cost"></p> 
     <p>금융<input class="account-cost">   
        의료<input class="account-cost"></p>     
      </div>
      <button class="button-input">Input</button>
      <button class="button-cancel">cancel</button>
    </div>
    <Modal 
      v-if = "showNewModal"
      @close="closeNewModal"
      @insert="inputUpdate"
    />
  </div>
</template>

<script>
import Modal from "@/components/newModal.vue";
export default {
  components: {
    Modal
  },
  methods: {
    onNew() {
      this.showNewModal = true;
    },
    closeNewModal() {
      this.showNewModal = false;
    },
    inputUpdate(data) {
      console.log(data)
      this.lists.push({
        date: data.date,
        description: data.description,
        tag: {
          useTag: data.tag.useTag,
          toolTag: data.tag.toolTag,
          inoutTag: data.tag.inoutTag
        },
        amount: data.amount,
        // total: data.countTotal(inout, money) 함수실행
      })
      console.log(this.lists);
      this.date = ""
      this.description = ""
      this.tag = []
      this.amount = ""
      this.total = ""
      this.closeNewModal()
    }
    // countTotal(inout, money) {
    //   if(this.tag = "out")
    // }
  },
  data() {
    return {
      showNewModal: false,
      lists: [],
    };
  }
}
</script>

<style>
.main {
        text-align: center;
        width: 800px;
        margin: 0 auto;
        font-family: inherit;
        font-size: inherit;
        line-height: inherit;
      }
      .title {
        text-align: center;
        font-size: 2rem;
        font-weight: bold;
        margin-top: 60px;
      }

      subtitle {
        text-align: center;
        font-size: 1rem;
        font-weight: bold;
        margin-top: 30px;
      }   

      account {
        text-align: center;
        margin-top: 100px;
      }
     
      #button-set, #button-input, #button-cancel {
        width: 55px;
        padding: 4px;
        margin: 5px;
        border-radius: 35px;
        border: none;
        color: white;
        position: relative;
        top: -5px;
        left: 68%;  
      }
        
      #button-set {
        color: black
      }
      #button-input {
       background-color: rgb(100, 170, 235);
      }
     #button-cancel {
        background-color: rgb(255, 160, 160);
     }
     
  * {
    font-family:serif; 
  }
  h2 {
    color: rgb(46, 46, 139);
  }
  #new, #delete {
    width: 55px;
    padding: 4px;
    margin: 5px;
    border-radius: 35px;
    border: none;
    color: white;
    position: relative;
    top: -5px;
    left: 68%;
    
  }
  #new {
    background-color: rgb(255, 160, 160);
  }
  #delete {
    background-color: rgb(100, 170, 235);
  }
  table {
    width: 55%;
    margin: auto;
    border-top: solid 2px black;
    border-collapse: collapse;
    text-align: center;
  }
  th, td {
    height: 20px;
    border-bottom: solid 1px black;
    border-left: solid 1px black;
    padding: 5px;
    font-size: 15px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
  th {
    border-bottom: solid 2px black;
  }
  input {
    margin: 10px;
  }
</style>