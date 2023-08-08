const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

// JavaScript

// 获取表单和结果div
const form = document.getElementById('signup-form');
const result = document.getElementById('result');

// 绑定提交事件
form.addEventListener('submit', handleSubmit);

function handleSubmit(e) {

    e.preventDefault();

    // 获取表单数据
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    // AJAX提交
    fetch('/api/signup', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(data => {

            if (data.code === 0) {
                // 成功,显示结果
                result.innerText = 'Signup successful!';

            } else {
                // 失败,显示错误
                result.innerText = data.message;
            }

        });

}