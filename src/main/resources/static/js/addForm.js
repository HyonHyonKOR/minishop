'use strict';

const addMemBtn = document.querySelector(".btns.btns--addMember");
const memberAddForm = document.querySelector(".signin__form");

    memberAddForm.addEventListener('input', (e) => {
        const memberId = document.querySelector("#memberId").value;
        const memberPw = document.querySelector("#memberPw").value;
        const memberPw2 = document.querySelector("#memberPw2").value;
        const memberName = document.querySelector("#memberName").value;
        const memberEmail = document.querySelector("#memberEmail").value;
        const memberHp = document.querySelector("#memberHp").value;
        const memberAddress1 = document.querySelector("#memberAddress1").value;
        const memberAddress2 = document.querySelector("#memberAddress2").value;

        if (memberId && memberPw && memberPw2 && memberName && memberEmail && memberHp && memberAddress1 && memberAddress2) {
            addMemBtn.style.backgroundColor = "#70a995";
        }
        else{
            addMemBtn.style.backgroundColor = "#70a9956b";
        }
    });

