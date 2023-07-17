/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

/**
 * 비밀번호 유효성 검사
 * @returns {boolean}
 */
function validatePassword(event) {
    event.preventDefault()
    const passwordInput = document.getElementById("modal_new_pass");
    const passwordInputCheck = document.getElementById("modal_new_pass_check");
    const password = passwordInput.value;
    const passwordCheck = passwordInputCheck.value;
    // 비밀번호 유효성 검사 정규식
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;

    if (!regex.test(password) && !regex.test(passwordCheck)) {
        alert("비밀번호는 8~16자리 수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.");
        return false;
    }

    return true;
}
/**
 * 비밀번호 변경
 */
function submitNewPassword(event) {
    if (validatePassword(event)){
        const modalNewPass = document.getElementById("modal_new_pass");

        let xhr = new XMLHttpRequest();
        xhr.open("GET", "/change/pw?newPassword=" + modalNewPass.value, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    alert("비밀번호가 변경되었습니다!");
                } else {
                    alert("이미 존재하는 이메일입니다. 다시 변경해주세요");
                    Email.readOnly = false;
                }
            }
        };
        xhr.send();
        event.preventDefault();
    }
}
function redirectToUrl(url) {
    window.location.href = url;
}
function checkCurrentPasswordMatch(){
    let pw = document.getElementById("pw");
    let modal_pass = document.getElementById("modal_pass").value;
    let message = document.getElementById("current-password-match");

    console.log(pw);
    if(pw.textContent === modal_pass){
        message.style.color = "green";
        message.innerHTML = "Passwords match!";
        return true;
    }
    else {
        message.style.color = "red";
        message.innerHTML = "Passwords do not match!";
        return false;
    }
}
function checkPasswordMatch(){
    let modal_new_pass = document.getElementById("modal_new_pass").value;
    let modal_new_pass_check = document.getElementById("modal_new_pass_check").value;
    let message = document.getElementById("password-match");
    let pw = document.getElementById("pw");

    if(modal_new_pass === modal_new_pass_check && pw.textContent !== modal_new_pass){
        message.style.color = "green";
        message.innerHTML = "Passwords match!";
        return true;
    }else if(pw.textContent === modal_new_pass){
        message.style.color = "red";
        message.innerHTML = "Past Password match";
        return false;
    } else {
        message.style.color = "red";
        message.innerHTML = "Passwords do not match!";
        return false;
    }
}
function CreateModalBodyChange(){
    let ModalSelect = document.getElementById("modal-select").value;
    let ModalNoticeBody = document.getElementById("modal-recruitment-body");
    let ModalGroupBody = document.getElementById("modal-group-body");
    const ModalTitle = document.getElementById("NewNoticeTitle");
    if(ModalSelect === "1"){
        ModalTitle.textContent = "Create Notice";
        ModalNoticeBody.style.display = "block";
        ModalGroupBody.style.display = "none";
    }else if(ModalSelect === "2"){
        ModalTitle.textContent = "Create Group";
        ModalNoticeBody.style.display = "none";
        ModalGroupBody.style.display = "block";
    }
}

function handleRadioChange(){
    const OpenRadio = document.getElementById("OpenRadio");
    const DisOpenRadio = document.getElementById("DisOpenRadio");
    const RadioPassword = document.getElementById("RadioPassword");
    if (OpenRadio.checked) {
        RadioPassword.style.display = "none";
    }else if (DisOpenRadio.checked) {
        RadioPassword.style.display = "block";
    }
}
