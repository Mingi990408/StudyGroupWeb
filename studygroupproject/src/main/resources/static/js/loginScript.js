function validateForm(event) {
    const username = document.getElementById("Email").value;
    const password = document.getElementById("Password").value;


    if (username === "" || password === "") {
        event.preventDefault(); // Prevent form submission
        alert("이메일과 비밀번호를 입력해주세요");
        return false;
    }

    return true;
}