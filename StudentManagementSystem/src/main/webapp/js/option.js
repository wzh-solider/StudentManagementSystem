// 枚举对象
const Grade = {
    ONE_GRADE: "一年级",
    TWO_GRADE: "二年级",
    THREE_GRADE: "三年级",
    FOUR_GRADE: "四年级",
    FIVE_GRADE: "五年级",
    SIX_GRADE: "六年级",
    SEVEN_GRADE: "七年级"
}

window.onload = function() {

    const grades = document.getElementById("grade");

    const options = [
        {text: Grade.ONE_GRADE},
        {text: Grade.TWO_GRADE},
        {text: Grade.THREE_GRADE},
        {text: Grade.FOUR_GRADE},
        {text: Grade.FIVE_GRADE},
        {text: Grade.SIX_GRADE},
        {text: Grade.SEVEN_GRADE}
    ]

    options.forEach(option => {
        opt = document.createElement('option');
        opt.text = option.text;
        
        grades.appendChild(opt);
    })
}