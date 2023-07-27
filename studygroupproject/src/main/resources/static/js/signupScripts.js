/**
* 비밀번호가 두 개로 인식하기 떄문에 필요한 input 값만 보내기 위함
*/
function submitSelectedInputs(event) {
    event.preventDefault();

    const form = document.getElementById("myForm");
    const selectedInputs = ['Email', 'Password', 'Nickname']; // 선택한 input 요소들의 id 속성 값 배열


    let formData = new FormData(); // FormData 객체 생성

    for (let i = 0; i < selectedInputs.length; i++) {
        const inputId = selectedInputs[i];
        const inputElement = form.querySelector('#' + inputId);

        if (inputElement) {
            formData.append(inputId, inputElement.value); // 선택한 input 요소들을 폼 데이터에 추가
        }
    }

    // 폼 데이터 전송 또는 처리
    // AJAX 요청을 사용하여 서버로 폼 데이터 전송
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "signup-callback", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                $('#myModal').modal('show')
            } else {
                // 요청 실패
                $('#myModal').modal('hide')
            }
        }
    };
    xhr.send(formData);
}

/**
 * 모든 입력 값의 유효성과 비밀번호의 재확인 중복 검사 후 회원가입
 * @returns {boolean}
 */
function checkAllInputValue(event) {
    event.preventDefault();

    let EmailValid = validateEmail();
    let PasswordValid = validatePassword();
    let NicknameValid = validateNickname();
    let PasswordCheck = checkCurrentPasswordMatch();
    let Email = document.getElementById("Email");
    let Nickname = document.getElementById("Nickname");

    if (EmailValid && PasswordValid && NicknameValid && PasswordCheck) {
        if (Email.readOnly && Nickname.readOnly) {
            submitSelectedInputs(event);
        } else {
            alert("중복 검사를 해주세요!");
        }
    } else {
        alert("모든 입력을 다시 확인해 주세요");
    }
}

/**
 * 이메일 중복 검사
 */
function checkEmail() {
    if(validateEmail()){
        const Email = document.getElementById("Email");

        let xhr = new XMLHttpRequest();
        xhr.open("GET", "/email/duplicate-check?email=" + Email.value, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    Email.readOnly = confirm("사용 가능한 이메일입니다! 사용하시겠습니까?");
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

/**
 * 이메일 유효성 검사
 * @returns {boolean}
 */
function validateEmail() {
    const emailInput = document.getElementById("Email");

    let email = emailInput.value;
    if (!email.includes("@")) {
        alert("이메일 형식이 맞지 않습니다.")
        return false;
    }
    return true;
}

/**
 * 닉네임 중복 검사
 */
function checkNickname() {
    if(validateNickname()){
        const Nickname = document.getElementById("Nickname");

        let xhr = new XMLHttpRequest();
        xhr.open("GET", "/nickname/duplicate-check?nickname=" + Nickname.value, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    Nickname.readOnly = confirm("사용 가능한 닉네임입니다! 사용하시겠습니까?");
                } else {
                    alert("이미 존재하는 닉네임입니다. 다시 변경해주세요");
                    Nickname.readOnly = false;
                }
            }
        };
        xhr.send();
        event.preventDefault();
    }
}

/**
 * 닉네임 유효성 검사
 * @returns {boolean}
 */
function validateNickname() {
    // 닉네임 유효성 검사 로직을 구현하세요.
    // 닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.
    const regex = /^[가-힣a-zA-Z0-9]{2,10}$/;

    const nicknameInput = document.getElementById("Nickname");

    let nickname = nicknameInput.value;
    // 닉네임 유효성 검사
    if (!regex.test(nickname)) {
        alert("닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.")
        return false;
    }
    return true;
}

/**
 * 비밀번호 재 확인
 */
function checkCurrentPasswordMatch(){
    let pw = document.getElementById("Password");
    let modal_pass = document.getElementById("R-Password");
    let message = document.getElementById("current-password-match");

    if(pw.value === modal_pass.value){
        message.style.color = "green";
        message.innerHTML = "Match!";
        return true;
    }
    else {
        message.style.color = "red";
        message.innerHTML = "Not Match!";
        return false;
    }
}

/**
 * 비밀번호 유효성 검사
 * @returns {boolean}
 */
function validatePassword() {
    const passwordInput = document.getElementById("Password");
    const password = passwordInput.value;

    // 비밀번호 유효성 검사 정규식
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;

    if (!regex.test(password)) {
        alert("비밀번호는 8~16자리 수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.");
        return false;
    }

    return true;
}
function checkAuthCode() {
    const authCode = document.getElementById("authCode");

    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/auth-check?authCode=" + authCode.value, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                alert("이메일 인증에 성공하였습니다!");
                window.location.href = '/login';
            } else {
                alert("인증에 실패하였습니다. 다시 확인해주세요!");
            }
        }
    };
    xhr.send();
    event.preventDefault()
}