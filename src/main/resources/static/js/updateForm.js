'use strict';

const updateMemBtn = document.querySelector(".btns--updateMember");
const memberUpdateForm = document.querySelector(".update__form");

memberUpdateForm.addEventListener('input', (e) => {
    const memberPw = document.querySelector("#memberPw").value;
    const memberPw2 = document.querySelector("#memberPw2").value;

    if (memberPw && memberPw2) {
        updateMemBtn.style.backgroundColor = "#70a995";
    }
    else{
        updateMemBtn.style.backgroundColor = "#70a9956b";
    }
});


document.addEventListener("DOMContentLoaded", e => {
    const successMessageElement = document.getElementById('successMessage');
    const successMessage = successMessageElement.getAttribute('data-success-message');

    if (successMessage) {
        Swal.fire({
            icon: 'success',
            title: `<span style=font-size:1rem> ${successMessage} </span>`,
            iconColor:'#70a995',
            width:'25rem',
            height:'12rem',
        });
    }
});