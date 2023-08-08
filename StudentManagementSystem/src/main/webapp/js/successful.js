window.onload = function () {
    var firstBox = document.getElementById("firstBox");
    var checkboxes = document.getElementsByName("checkbox");
    var unCheckSelected = document.getElementById("unCheckSelected");

    // 封装的选择函数
    function check() {
        checkboxes.forEach(checkbox => {
            checkbox.checked = firstBox.checked;
        })
    }

    // 取消选中
    unCheckSelected.onclick = function () {
        if (!firstBox.checked) {
            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    checkbox.checked = false;
                }
            })
        } else {
            firstBox.checked = false;
            check();
        }
    }

    // 使复选框下的选择和全选按钮保持一致
    firstBox.onclick = function() {
        check();
    }

    // 为每个checkbox属性，绑定单击事件
    checkboxes.forEach(checkbox => {
        checkbox.onclick = function () {
            var count = checkboxes.length;
            var checkedCount = 0;

            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    checkedCount++;
                }
            })

            firstBox.checked = checkedCount === count;
        }
    })
}
