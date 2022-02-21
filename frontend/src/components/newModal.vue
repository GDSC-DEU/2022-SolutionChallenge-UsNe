<template>
    <div>
        <div class="modalBackground">
        <div class="modalBox">
            <div>
            <div>
                <h1>Add</h1>
                <div v-show="hasError" id="error">
                    모든 문항을 입력해주세요!
                </div>
            </div>
            <div>
                <div>
                    소비 내용 <br>
                    <hr>
                    <input type="text" v-model="description" id="description">
                    <br><br>
                </div>
                <div>
                    소비 용도 <br>
                    <hr>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="식비">
                        <span>식비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="교통비">
                        <span>교통비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="생활비">
                        <span>생활비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="문화활동">
                        <span>문화활동</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="용돈">
                        <span>용돈</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="월급">
                        <span>월급</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="장학금">
                        <span>장학금</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useTag" name="useTag" value="기타">
                        <span>기타</span>
                    </label>
                    <br><br>
                </div>
                <div>
                    사용 수단 <br>
                    <hr>
                    <label class="inputTag">
                        <input type="radio" v-model="toolTag" name="toolTag" value="카드">
                        <span>카드</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="toolTag" name="toolTag" value="현금" >
                        <span>현금</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="toolTag" name="toolTag" value="계좌이체">
                        <span>계좌이체</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="toolTag" name="toolTag" value="상품권">
                        <span>상품권</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="toolTag" name="toolTag" value="기타">
                        <span>기타</span>
                    </label>
                    <br><br>
                </div>
                <div>
                    수입/지출 <br>
                    <hr>
                    <label class="inputTag">
                        <input type="radio" v-model="inoutTag" name="inoutTag" value="수입">
                        <span>수입</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="inoutTag" name="inoutTag" value="지출">
                        <span>지출</span>
                    </label>
                    <br><br>
                </div>
                <div>
                    금액 <br>
                    <hr>
                    <input type="number" v-model="amount" id="money"> 원
                    <br><br>
                </div>
                <div>
                    날짜 <br>
                    <hr>
                    <input type="date" v-model="date" id="date">
                    <br><br>
                </div>
                <div class="end">
                    <div class="footer">
                        <button type="button" @click="onSubmit">input</button>
                        <button type="button" @click="$emit('close')">close</button>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
    methods: {
        onSubmit() {
            if(this.description === undefined || 
            this.useTag === undefined || 
            this.toolTag === undefined ||
            this.inoutTag === undefined ||
            this.amount === undefined ||
            this.date === undefined) 
            { 
                this.hasError = true;
            }
            else{
                this.$emit('insert', {
                    date: this.date,
                    description: this.description,
                    tag: {
                        useTag: this.useTag,
                        toolTag:this.toolTag,
                        inoutTag: this.inoutTag 
                    },
                    amount: this.amount,
                })
                this.hasError = false;
            }
        }
    },
    data() {
        return {
            hasError: false
        }
    }
}
</script>

<style scoped>
    #error {
        color: red;
        font-size: 12px;
        text-align: center;
    }
    input[type="number"]::-webkit-outer-spin-button,
    input[type="number"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    .inputMoneyDate {
        margin: 50px 50px 30px;
        text-align: left;
    }
    #money {
        width: 130px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
    }
    #description {
        width: 200px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
    }
    #date {
        width: 180px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
        padding: 3px 10px 2px;
        font-size: 15px;
    }
    .end {
        width: 380px;
        height: auto;
    }
    .footer {
        position: absolute;
        right: 15px;
        bottom: 15px;
    }
    h1 {
        text-align: center;
    }
    .modalBackground {
        width: 100%;
        height: 100%;
        position: fixed;
        top: 0;
        left: 0;
        background-color: rgba(0, 0, 0, 0.5);
    }
    .modalBox {
        width: 380px;
        height: 700px;
        padding: 20px;
        border-radius: 10px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
    }
    button {
        width: 70px;
        padding: 4px;
        margin: 5px;
        border-radius: 35px;
        border: none;
        color: black;
    }
    button:hover {
        color: white;
        background-color: #5a5a5a;
    }

    .inputTag input[type="radio"] {
        display: none;
    }
 
    .inputTag input[type="radio"] + span {
        display: inline-block;
        padding: 4px 10px 2px;
        margin: 5px;
        border: 1px solid #dfdfdf;
        border-radius: 35px;
        background-color: #ffffff;
        text-align: center;
        font-size: 15px
    }
 
    .inputTag input[type="radio"]:checked + span {
        background-color: #113a6b;
        border: 1px solid #113a6b;
        color: #ffffff;
    }
    .inputTag input[type="radio"]:hover + span {
        background-color: #113a6b;
        border: 1px solid #113a6b;
        color: #ffffff;
    }
</style>