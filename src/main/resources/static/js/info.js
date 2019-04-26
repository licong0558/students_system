function checkchinese(str){
    var reg=/^[u4E00-u9FA5]+$/;
    debugger;
    if(reg.test(str)) {
        alert("姓名必须为汉字");
        return false;
    }
    //alert("here");
    return true;
}
function checkAdd(){
    var same=true;
    debugger;
    same&=document.getElementById("name").innerText==document.add_student.name.value;
    same&=document.getElementById("remark").innerText==document.add_student.remark.value;
    same&=document.getElementById("chinese").innerText==document.add_student.chinese.value;
    same&=document.getElementById("math").innerText==document.add_student.math.value;
    same&=document.getElementById("english").innerText==document.add_student.english.value;
    var sex=(document.getElementById("sex").innerText=="男")?0:1;
    same&=sex==document.add_student.sex.value;
    if(same){
        alert("学生信息无变化，不需更新");
        return false;
    }
    if(document.add_student.sex)
        return checkchinese(document.add_student.name.value);
}

window.onload=function () {
    var radioObj=document.add_student.sex;
    var sex=(document.getElementById("sex").innerText=="男")?0:1;
    radioObj[sex].checked=true;
}
