<template>
   <div>
     <div class="search">
      <h4>search</h4>
      <label class="searchitem">
        <button type="button" value="All" @click="$emit('all')">All</button>
      </label> <br>
      <label class="searchitem">
        <input type="radio" name="useType" value="FOOD" v-model="checkUseType">
        <span>식비</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="TRAFFIC" v-model="checkUseType">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="CLOTHES" v-model="checkUseType">
        <span>의류비</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="EDUCATION" v-model="checkUseType">
        <span>교육비</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="BEAUTY" v-model="checkUseType">
        <span>뷰티</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="LIFE" v-model="checkUseType">
        <span>생활비</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="CULTURE" v-model="checkUseType">
        <span>문화활동</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="useType" value="MEDICALTREATMENT" v-model="checkUseType">
        <span>병원비</span>
      </label> <br>
      <label class="searchitem">
        <input type="radio" name="payType" value="CARD" v-model="checkPayType">
        <span>카드</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="payType" value="CASH" v-model="checkPayType">
        <span>현금</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="payType" value="ACCOUNTTRANSFER" v-model="checkPayType">
        <span>계좌이체</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="payType" value="GIFTCARD" v-model="checkPayType">
        <span>기프트카드</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="payType" value="ETC" v-model="checkPayType">
        <span>기타</span>
      </label> <br>
      <label class="searchitem">
        <input type="radio" name="dwType" value="DEPOSIT" v-model="checkDwType">
        <span>수입</span>
      </label>
      <label class="searchitem">
        <input type="radio" name="dwType" value="WITHDRAW" v-model="checkDwType">
        <span>지출</span>
      </label> <br>
      <button type="button" @click="searchButton">검색</button>
     </div>
    </div>
</template>

<script>

export default {
  methods: {
    searchButton() {
      this.$emit('getSearching', {
        searchUseType: this.checkUseType,
        searchPayType: this.checkPayType,
        searchDwType: this.checkDwType,
      })
    }
  },
}
</script>
<style scoped>
  button {
    width: 80px;
    padding: 4px;
    margin: 5px;
    border-radius: 35px;
    border: none;
    color: black;
    font-size: 15px;
  }
  .search {
    text-align: center;
  }
  .searchitem input[type="radio"] {
      display: none;
  }
  .searchitem input[type="radio"] + span {
    display: inline-block;
    padding: 4px 10px 2px;
    margin: 5px;
    border: 1px solid #dfdfdf;
    border-radius: 35px;
    background-color: #ffffff;
    text-align: center;
    font-size: 15px
  }
 
  .searchitem input[type="radio"]:checked + span {
    background-color: #113a6b;
    border: 1px solid #113a6b;
    color: #ffffff;
  }
  .searchitem input[type="radio"]:hover + span {
    background-color: #113a6b;
    border: 1px solid #113a6b;
    color: #ffffff;
  }
</style>