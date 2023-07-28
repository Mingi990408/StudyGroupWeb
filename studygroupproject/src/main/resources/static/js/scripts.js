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
        ModalTitle.textContent = "Create Recruitment";
        ModalNoticeBody.style.display = "block";
        ModalGroupBody.style.display = "none";
    }else if(ModalSelect === "2"){
        ModalTitle.textContent = "Create Study Group";
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

function LocationRadioChange() {
    const OnlineRadio = document.getElementById("OnlineRadio");
    const OfflineRadio = document.getElementById("OffLineRadio");
    const AllRadio = document.getElementById("AllRadio");
    const Location = document.getElementById("Location");

    if (OnlineRadio.checked) {
        Location.style.display = "none";
    }else if (OfflineRadio.checked || AllRadio.checked) {
        Location.style.display = "block";
    }
}

function CreateRecruitment() {
    event.preventDefault()

    const form = document.getElementById("createForm");
    const selectedInputs = ['rTitle', 'rFile', 'rContents'];
    const OnlineRadio = document.getElementById("OnlineRadio");
    const OfflineRadio = document.getElementById("OffLineRadio");
    const AllRadio = document.getElementById("AllRadio");
    const tagDiv = document.getElementById("Tags")
    let Tags = []

    let formData = new FormData(); // FormData 객체 생성

    for (let i = 0; i < selectedInputs.length; i++) {
        const inputId = selectedInputs[i];
        const inputElement = form.querySelector('#' + inputId);

        if (inputElement) {
            formData.append(inputId, inputElement.value); // 선택한 input 요소들을 폼 데이터에 추가
        }
    }

    if (OnlineRadio.checked) {
        formData.append("Type", "Online")
    }else if (OfflineRadio.checked) {
        formData.append("Type", "Offline")
    }else if (AllRadio.checked) {
        formData.append("Type", "All")
    }

    const divChildTags = tagDiv.childNodes;
    for (const tag of divChildTags) {
        if (tag.tagName === "B") {
            Tags.push(tag.textContent);
        }
    }
    formData.append("rTag", Tags);


    // 폼 데이터 전송 또는 처리
    // AJAX 요청을 사용하여 서버로 폼 데이터 전송
    const xhr = new XMLHttpRequest();
    xhr.open("post", "recruitment", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                alert("새 글을 작성했습니다!")
                location.reload()
            } else {

            }
        }
    };
    xhr.send(formData);
}

function CreateStudyGroup() {
    event.preventDefault()

    const form = document.getElementById("createForm");
    const OpenRadio = document.getElementById("OpenRadio");
    const DisOpenRadio = document.getElementById("DisOpenRadio");
    const selectedInputs = ['sgTitle', 'sgIntroduce', 'sgContents'];
    let formData = new FormData(); // FormData 객체 생성

    for (let i = 0; i < selectedInputs.length; i++) {
        const inputId = selectedInputs[i];
        const inputElement = form.querySelector('#' + inputId);

        if (inputElement) {
            formData.append(inputId, inputElement.value); // 선택한 input 요소들을 폼 데이터에 추가
        }
    }
    if (OpenRadio.checked) {
        formData.append("Type", "Open")
    }else if (DisOpenRadio.checked) {
        formData.append("Type", "Close")
        formData.append("Password", form.querySelector('#' + 'RadioPassword'))
    }

    // 폼 데이터 전송 또는 처리
    // AJAX 요청을 사용하여 서버로 폼 데이터 전송
    const xhr = new XMLHttpRequest();
    xhr.open("post", "study-group", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {

            } else {

            }
        }
    };
    xhr.send(formData);

};
function checkKeyPress(event) {
    if (event.key === ' ') {
        const inputElement = document.getElementById('rTag');
        const word = inputElement.value.trim();

        if (word) {
            const displayContainer = document.getElementById('Tags');
            const boldElement = document.createElement('b');
            boldElement.textContent = word;
            displayContainer.appendChild(boldElement);
            displayContainer.appendChild(document.createTextNode(' ')); // 스페이스 추가

            // 입력값 초기화
            inputElement.value = '';
        }
    }
}